package schedule;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import noexcuses.venkat.noexcuses.R;
import noexcuses.venkat.noexcuses.Workouts.QuickWorkoutDisplay;

/**
 * Created by rohanmenhdiratta on 4/18/15.
 */
public class SchedulePortal extends Fragment {

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //setContentView(R.layout.activity_schedule_portal);
//
//        initButtons();
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        //Log.i("Left", "onCreateView()");

        View view = inflater.inflate(R.layout.activity_schedule_portal, container, false);

        initButtons(view);

        return view;
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_information_req, menu);
//        return true;
//    }

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

    public void initButtons(View v)
    {
        Button setScheduleButton = (Button)v.findViewById(R.id.set_schedule);
        Button workOutButton = (Button)v.findViewById(R.id.work_out);
        Button seeWorkoutsButton = (Button)v.findViewById(R.id.see_workouts);

        setScheduleButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.v("Schedule Portal", "set Schedule listener added");
                setSchedule();
            }
        });

        workOutButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), QuickWorkoutDisplay.class);
                startActivity(intent);
            }
        });

        seeWorkoutsButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                viewAllWorkouts();

            }
        });
    }

    public void setSchedule()
    {
        Log.v("Schedule Portal", "starting intent");
        //start a schedule activity
        Intent intent = new Intent(getActivity(), ScheduleWeekActivity.class);
        startActivity(intent);

    }

    public void viewAllWorkouts()
    {
        Intent intent = new Intent(getActivity(), AllWorkoutsActivity.class);
        startActivity(intent);
    }
}
