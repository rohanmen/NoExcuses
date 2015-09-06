package noexcuses.venkat.noexcuses;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.nhaarman.listviewanimations.appearance.simple.AlphaInAnimationAdapter;
import com.nhaarman.listviewanimations.appearance.simple.SwingBottomInAnimationAdapter;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;
import com.nhaarman.listviewanimations.itemmanipulation.dragdrop.TouchViewDraggableManager;
import com.nhaarman.listviewanimations.itemmanipulation.swipedismiss.OnDismissCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import noexcuses.venkat.noexcuses.DatabaseSchema.WorkoutDatabaseEntry;


public class WorkoutTracker extends Activity {

    private ArrayList<Integer> indexValues;
    private ArrayAdapter listViewAdapter;
    private SwingBottomInAnimationAdapter animationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_tracker);
        populateListView();


    }

    public void populateListView() {

        final List<WorkoutDatabaseEntry> activeEntryList = WorkoutDatabaseEntry.listAll(WorkoutDatabaseEntry.class);

        ArrayList<String> listNames = new ArrayList<String>();
        ArrayList<Integer> indexList = new ArrayList<Integer>();
        int indexK= 0;
        for (WorkoutDatabaseEntry k : activeEntryList) {

            if (k.userName.equals(GlobalDefinitions.activeUserName)) {
                listNames.add(k.getName());
                indexList.add(indexK);
            }
            indexK++;
         }
        indexValues = indexList;
        //Build Adapter
        final ArrayAdapter<String> viewAdapter = new ArrayAdapter<String>(this, R.layout.workouttracker_element,
                R.id.testView, listNames); //new ArrayAdapter<String>(getApplicationContext(), R.layout.workouttracker_element, listNames);

        animationAdapter = new SwingBottomInAnimationAdapter(viewAdapter);
        //ListView workoutView = (ListView) findViewById(R.id.workTrack);
        DynamicListView workoutView = (DynamicListView) findViewById(R.id.workTrack);
        animationAdapter.setAbsListView(workoutView);

        workoutView.setAdapter(animationAdapter);

       listViewAdapter = viewAdapter;
        workoutView.enableSwipeToDismiss(
                new OnDismissCallback() {
                    @Override
                    public void onDismiss(@NonNull final ViewGroup listView, @NonNull final int[] reverseSortedPositions) {
                        for (int position : reverseSortedPositions) {
                            viewAdapter.remove(viewAdapter.getItem(position));

                            activeEntryList.get(indexValues.get(position)).delete();
                            indexValues.remove(position);
                        }
                    }
                }
        );


        //workoutView.setAdapter(viewAdapter);
        registerOnClick();



    }

    public void registerOnClick() {
        Log.d("D", "Registered!");
        ListView workoutView = (ListView) findViewById(R.id.workTrack);
        workoutView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, final int position, long id) {
                Log.d("D", "Clicked!");

                final Dialog newDialog = new Dialog(WorkoutTracker.this);
                TextView infoLabel = new TextView(WorkoutTracker.this);
                infoLabel.setText("Please Enter Your New Workout Weight:");

                final LayoutInflater factory = getLayoutInflater();

                final View textEntryView = factory.inflate(R.layout.dialog_layout, null);

                EditText newView = (EditText) textEntryView.findViewById(R.id.newWeight100);



                Button submitButton = (Button) textEntryView.findViewById(R.id.submitbutt);


                TextView clickedButton = (TextView)((LinearLayout) viewClicked).getChildAt(1);
                newDialog.setTitle(clickedButton.getText());

                newDialog.setContentView(R.layout.one_rep_max_layout);

                newDialog.show();
                submitButton = (Button)newDialog.findViewById(R.id.submitbutton100);
                EditText newViewIt = (EditText) newDialog.findViewById(R.id.newWeight100);
                newViewIt.setHint("Weight");
                EditText newView1000 = (EditText)newDialog.findViewById(R.id.newName100);
                newView1000.setHint("Reps");
                submitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText newView100 = (EditText) newDialog.findViewById(R.id.newName100);
                        EditText newViewIt = (EditText) newDialog.findViewById(R.id.newWeight100);
                        if (!newViewIt.getText().toString().equals("") && !newView100.getText().toString().equals("")) {
                            Integer weightLifted = Integer.valueOf(newViewIt.getText().toString());
                            Integer repsMoved = Integer.valueOf(newView100.getText().toString());

                            Double oneRepMax = (double)weightLifted * (1 + ((double)repsMoved / 30));

                            List<WorkoutDatabaseEntry> activeEntryList = WorkoutDatabaseEntry.listAll(WorkoutDatabaseEntry.class);


                            ArrayList<Integer> indexList = new ArrayList<Integer>();
                            int indexK = 0;
                            for (WorkoutDatabaseEntry k : activeEntryList) {

                                if (k.userName.equals(GlobalDefinitions.activeUserName)) {
                                    indexList.add(indexK);
                                }
                                indexK++;
                            }
                            indexValues = indexList;
                            int newPos = indexValues.get(position);
                            WorkoutDatabaseEntry activeEntry = activeEntryList.get(newPos);


                            activeEntry.newWeight(new Integer(oneRepMax.intValue()));
                            Toast.makeText(getApplicationContext(), "New Weight: " + oneRepMax.intValue(), Toast.LENGTH_SHORT).show();
                            activeEntry.save();
                        } else {
                            Toast.makeText(getApplicationContext(), "No entry was recorded.", Toast.LENGTH_SHORT).show();
                        }
                        newDialog.dismiss();
                    }
                });

                Toast.makeText(getApplicationContext(), clickedButton.getText(), Toast.LENGTH_SHORT).show();

            }

        });
        workoutView.setLongClickable(true);
        workoutView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View viewClicked, int position, long id) {
               /* Log.d("D", "Clicked!");
                Dialog newDialog = new Dialog(WorkoutTracker.this);
                GraphView newView = new GraphView(WorkoutTracker.this);
                TextView clickedButton = (TextView) viewClicked;
                newDialog.setTitle(clickedButton.getText());
                newDialog.setContentView(newView);

                LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                        new DataPoint(0, 1),
                        new DataPoint(1, 5),
                        new DataPoint(2, 3),
                        new DataPoint(3, 2),
                        new DataPoint(4, 6)
                });
                newView.addSeries(series);
                newDialog.show();

                Toast.makeText(getApplicationContext(), clickedButton.getText(), Toast.LENGTH_SHORT).show();
                return true;*/

                Log.d("D", "Clicked!");
                Dialog newDialog = new Dialog(WorkoutTracker.this);
                GraphView newView = new GraphView(WorkoutTracker.this);
                TextView clickedButton = (TextView)((LinearLayout) viewClicked).getChildAt(1);
                newDialog.setTitle(clickedButton.getText());
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(-1, -2);
                TextView newTextView = new TextView(getApplicationContext());


                newDialog.setContentView(newView);

                LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();

                ArrayList<DataPoint> tepList = new ArrayList<DataPoint>();

                List<WorkoutDatabaseEntry> activeEntryList = WorkoutDatabaseEntry.listAll(WorkoutDatabaseEntry.class);
                newTextView.setText("Latest Weight: "+ activeEntryList.get(activeEntryList.size()-1).getCurrentWeight());
                ViewGroup.LayoutParams params2 = new ViewGroup.LayoutParams(-1, -1);
                //newDialog.addContentView(newTextView, params2);
                ArrayList<Integer> indexList = new ArrayList<Integer>();
                int indexK= 0;
                for (WorkoutDatabaseEntry k : activeEntryList) {

                    if (k.userName.equals(GlobalDefinitions.activeUserName)) {
                        indexList.add(indexK);
                    }
                    indexK++;
                }
                indexValues = indexList;
                int newPos = indexValues.get(position);
                WorkoutDatabaseEntry activeEntry = activeEntryList.get(newPos); //WorkoutDatabaseEntry.findById(WorkoutDatabaseEntry.class, (long)position+1);

                int[] activeHistory = activeEntry.getWeightHistory();
                DataPoint[] dataList = new DataPoint[activeHistory.length];
                Log.d("ITEMS", Arrays.toString(activeHistory));
                for(int indexFor = 0; indexFor<activeHistory.length; indexFor++){
                    dataList[indexFor]=(new DataPoint(indexFor, (int)activeHistory[indexFor]));
                }
                Log.d("DATAPOINTS: ", activeHistory.toString());
                series = new LineGraphSeries<DataPoint>(dataList);


                newView.addSeries(series);
                newDialog.show();

                Toast.makeText(getApplicationContext(), clickedButton.getText(), Toast.LENGTH_SHORT).show();
                return true;

            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_workout_tracker, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.newwork) {

            final Dialog newWorkoutDialog = new Dialog(WorkoutTracker.this);
            TextView infoLabel = new TextView(WorkoutTracker.this);
            infoLabel.setText("Please enter the name of your new workout:");
            final LayoutInflater factory = getLayoutInflater();
            final View textEntryView = factory.inflate(R.layout.dialog_layout, null);
            EditText newView = (EditText) textEntryView.findViewById(R.id.newWeight50);

            final String txt2 = newView.getText().toString();
            newWorkoutDialog.setTitle("New Workout");

            newWorkoutDialog.setContentView(R.layout.dialog_layout);
            newWorkoutDialog.show();
            EditText newViewIt = (EditText) newWorkoutDialog.findViewById(R.id.newWeight50);
            newViewIt.setHint("Enter Your Workout Name!");
            newViewIt.setInputType(InputType.TYPE_CLASS_TEXT);
            final Button newWorkoutButton = (Button)newWorkoutDialog.findViewById(R.id.submitbutt);

            newWorkoutButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EditText newViewIt = (EditText) newWorkoutDialog.findViewById(R.id.newWeight50);

                    if (!newViewIt.getText().toString().equals("")) {
                        WorkoutDatabaseEntry newEntry = new WorkoutDatabaseEntry(newViewIt.getText().toString(), 0, GlobalDefinitions.activeUserName);
                        newEntry.save();
                        listViewAdapter.add(newEntry.getName());
                        populateListView();


                    } else {
                        Toast.makeText(getApplicationContext(), "No entry was recorded.", Toast.LENGTH_SHORT).show();
                    }
                    newWorkoutDialog.dismiss();
                }
            });

            listViewAdapter.notifyDataSetChanged();
            animationAdapter = new SwingBottomInAnimationAdapter(listViewAdapter);
            //ListView workoutView = (ListView) findViewById(R.id.workTrack);
            DynamicListView workoutView = (DynamicListView) findViewById(R.id.workTrack);
            animationAdapter.setAbsListView(workoutView);
            return true;
        }
        listViewAdapter.notifyDataSetChanged();

        return super.onOptionsItemSelected(item);
    }


}
