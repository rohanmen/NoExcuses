package noexcuses.venkat.noexcuses.Workouts;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

import noexcuses.venkat.noexcuses.R;
import noexcuses.venkat.noexcuses.*;

public class QuickWorkoutDisplay extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_workout_display);
        QuickWorkoutList quickList = new QuickWorkoutList();
        TextView name = (TextView) findViewById(R.id.textView1);
        name.setText("Quick Workout: ");
        TextView workoutText = (TextView) findViewById(R.id.textView2);
        final WorkoutChunk chunk = getQuickWorkout(quickList);
        workoutText.setText(chunk.getWorkoutText());

        workoutText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //
                // GO to some activity to display muscle types based on the workout??
                // CHANGE THIS TO GO TO THE MUSCLE GROUP PAGE OR WHATEVER
                Intent intent = new Intent(QuickWorkoutDisplay.this, BodyPartDisplay.class);
                intent.putExtra("Quick", chunk.getQuickWorkout());
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quick_workout_display, menu);
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

    public WorkoutChunk getQuickWorkout(QuickWorkoutList quickList) {
        WorkoutChunk chunk = new WorkoutChunk();
        StringBuilder text = new StringBuilder();
        Random rand = new Random();
        int randInt = rand.nextInt(quickList.getQuickWorkouts().size());
        int m_i = 1; //for movements
        QuickWorkout randQuick = quickList.getQuickWorkouts().get(randInt);
        chunk.setQuickWorkout(randQuick);
        text.append("Workout Name: " + randQuick.getName() + "\n");
        text.append("Length of Workout: " + randQuick.getLength() + " Minutes\n");
        text.append("Click to see what body parts will be worked out each movement!");
        for (Movement m : randQuick.getMovements()) {
            text.append("\n \nMovement " + m_i + ": " + m.getName() + "\n");
            text.append(m.getAmount() + " Rep(s) / " + m.getTimes() + " Time(s)\n");
            m_i++;
        }
        chunk.setWorkoutText(text.toString());
        return chunk;
    }
}
