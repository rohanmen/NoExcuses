package noexcuses.venkat.noexcuses.Workouts;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import noexcuses.venkat.noexcuses.FitnessUserInformation;
import noexcuses.venkat.noexcuses.GlobalDefinitions;
import noexcuses.venkat.noexcuses.WorkoutTracker;
import schedule.Util;
import noexcuses.venkat.noexcuses.R;

public class WorkoutDisplay extends Activity {

    String _workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_display);
        //FitnessUserRoutine userRoutine = new FitnessUserRoutine(this, GlobalDefinitions.currentUser);
        //Workout userWorkout = userRoutine.getWorkout();
        FitnessUserRoutine userRoutine = GlobalDefinitions.fitnessUser;
        Workout userWorkout = GlobalDefinitions.currentWorkout;

        Button shareButton = (Button)findViewById(R.id.share_workout);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareWorkout();
            }
        });

        TextView name = (TextView) findViewById(R.id.textView1);
        name.setText("Current Workout: ");
        TextView workoutText = (TextView) findViewById(R.id.textView2);
        final WorkoutChunk chunk = getCompleteWorkout(userRoutine, userWorkout);
        if (userWorkout.getConcentration().equals("-1")) { //null workout then
            workoutText.setText("No Workout Available");
            shareButton.setEnabled(false);
        }
        else {
            //workoutText.setText(getCompleteWorkout(userRoutine, userWorkout));
            //_workout = getCompleteWorkout(userRoutine, userWorkout);
            workoutText.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    //
                    // GO to some activity to display muscle types based on the workout??
                    // CHANGE THIS TO GO TO THE MUSCLE GROUP PAGE OR WHATEVER
                    Intent intent = new Intent(WorkoutDisplay.this, WorkoutTracker.class);
                    startActivity(intent);
                }
            });
            workoutText.setText(chunk.getWorkoutText());
            _workout = chunk.getWorkoutText();
        }

        workoutText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //
                // GO to some activity to display muscle types based on the workout??
                // CHANGE THIS TO GO TO THE MUSCLE GROUP PAGE OR WHATEVER
                Intent intent = new Intent(WorkoutDisplay.this, BodyPartDisplay.class);
                intent.putExtra("Routine", chunk.getWorkout().getRoutine());
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_workout_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private WorkoutChunk getCompleteWorkout(FitnessUserRoutine userRoutine, Workout userWorkout) {
        WorkoutChunk chunk = new WorkoutChunk(); //HAS THE WORKOUT AND TEXT THAT GOES WITH IT
        chunk.setWorkout(userWorkout);
        int d_i = 0; //to get workout days
        int m_i = 1; //to get movements
        int dayNum;
        StringBuilder text = new StringBuilder();
        text.append("Workout Name: " + userWorkout.getName() + "\n");
        text.append("Length of Workout: " + userWorkout.getLength() + " Minutes\n");
        text.append("Click to see what body parts will be worked out each movement!");
        for (Day d : userWorkout.getRoutine().getDay()) {
            String workoutDay = userWorkout.getWorkoutDays().get(d_i);
            String workoutTime = userRoutine.getGreatestDayTimes().get(workoutDay);
            d.setType(workoutDay);
            d.setTimes(workoutTime);
            dayNum = d_i + 1;
            text.append("\n \nDay " + dayNum + ": " + workoutDay + " / Time: " + workoutTime + "\n");
            for (Movement m : d.getMovement()) {
                if (userWorkout.getName().equals("Swimming")) { //yards vs miles
                    text.append("Movement " + m_i + ": " + m.getName() + "\n");
                    text.append(m.getAmount() + " Yard(s) / " + m.getTimes() + " Time(s)\n");
                }
                else if (userWorkout.getName().equals("Running")) {
                    text.append("Movement " + m_i + ": " + m.getName() + "\n");
                    text.append(m.getAmount() + " Mile(s) / " + m.getTimes() + " Time(s)\n");
                }
                else if (userWorkout.getName().equals("Boxing")) {
                    text.append("Movement " + m_i + ": " + m.getName() + "\n");
                    text.append(m.getSets() + " Set(s) / " + m.getReps() + " Rep(s)\n");
                }
                else { //rest is just weight stuff
                    text.append("Movement " + m_i + ": " + m.getName() + "\n");
                    text.append(m.getSets() + " Set(s) / " + m.getReps() + " Rep(s) / " + m.getWeight() + " Pound(s)\n");
                }
                m_i++;
            }
            d_i++;
            m_i = 1; //reset movement to 1 as it's a new day
        }
        chunk.setWorkoutText(text.toString());
        return chunk;
    }

    public void shareWorkout()
    {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hey! Check Out This Amazing Workout");
        emailIntent.putExtra(Intent.EXTRA_TEXT   , _workout);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            //finish();
            //Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}
