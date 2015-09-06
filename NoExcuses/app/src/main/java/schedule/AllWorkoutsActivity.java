package schedule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.util.ArrayList;

import noexcuses.venkat.noexcuses.GlobalDefinitions;
import noexcuses.venkat.noexcuses.R;
import noexcuses.venkat.noexcuses.Workouts.FitnessUserRoutine;
import noexcuses.venkat.noexcuses.Workouts.Workout;
import noexcuses.venkat.noexcuses.Workouts.WorkoutDisplay;

/**
 * Created by rohanmenhdiratta on 4/27/15.
 */
public class AllWorkoutsActivity extends Activity{

    Context _context;
    Button buttons[];
    ArrayList<Workout> workouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_workouts);

        _context = this;

        initUI();

    }


    public void initUI()
    {
        //get ScrollView
        ScrollView myScrollView = (ScrollView)findViewById(R.id.workouts_scroll);

        //create LinearLayout
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //init buttons
        initButtons();

        //add Buttons
        for(int i = 0; i < buttons.length; i++)
        {
            Button button = buttons[i];
            button.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 100));
            linearLayout.addView(button);
        }

        // Add the LinearLayout element to the ScrollView
        myScrollView.addView(linearLayout);
    }

    public void initButtons()
    {
        FitnessUserRoutine fur = new FitnessUserRoutine(_context, GlobalDefinitions.currentUser);
        GlobalDefinitions.fitnessUser = fur;
        workouts = fur.getListOfWorkouts();

        if(workouts.isEmpty())
        {
            buttons = new Button[1];
            Button button = new Button(this);
            button.setText("No Workouts Available");
            button.setBackgroundColor(getResources().getColor(R.color.orange));
            button.setAlpha(64);
            button.setEnabled(false);
            buttons[0] = button;
        }
        else
        {
            buttons = new Button[workouts.size()];

            for(int i=0; i < buttons.length; i++)
            {
                Button button = new Button(this);
                Workout workout = workouts.get(i);

                button.setId(i);
                button.setText(Html.fromHtml("<b><big>" + workout.getName() + "</big></b>" + "<br />" +
                        "<small>" + workout.getConcentration() + "</small>" + "<br />"));
                button.setBackgroundColor(getResources().getColor(R.color.orange));
                button.setOnClickListener(new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        int id = v.getId();
                        showWorkoutInformation(id);

                    }
                });

                buttons[i] = button;
            }
        }
    }

    public void showWorkoutInformation(int id)
    {
        Intent intent = new Intent(this, WorkoutDisplay.class);
        intent.putExtra("sentFrom", "schedule");
        GlobalDefinitions.currentWorkout = workouts.get(id);
        startActivity(intent);

    }
}
