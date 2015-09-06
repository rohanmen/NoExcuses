package noexcuses.venkat.noexcuses.Workouts;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import noexcuses.venkat.noexcuses.R;

public class BodyPartDisplay extends Activity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_part_display);
        layout = (LinearLayout) findViewById(R.id.layout1);
        TextView text = (TextView) findViewById(R.id.textView1);
        Routine routine = (Routine) getIntent().getSerializableExtra("Routine");
        if (routine != null) {
            workoutLayout(routine);
        }
        else {
            QuickWorkout quickWorkout = (QuickWorkout) getIntent().getSerializableExtra("Quick");
            quickWorkoutLayout(quickWorkout);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_body_part_display, menu);
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

            /*
        TextView test = new TextView(getApplicationContext());
        test.setText("\nTest");
        test.setTextAppearance(getApplicationContext(), R.style.FontStyle);
        test.setTextSize(20);
        layout.addView(test);
        ImageView image = new ImageView(BodyPartDisplay.this);
        image.setBackgroundResource(R.drawable.back);
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity= Gravity.CENTER;
        image.setLayoutParams(layoutParams);
        layout.addView(image);
        */

    private void workoutLayout(Routine routine) {
        int day_i = 1;
        for (Day day : routine.getDay()) {
            TextView test = new TextView(getApplicationContext());
            test.setText("\nDay " + day_i);
            test.setTextAppearance(getApplicationContext(), R.style.FontStyle);
            test.setTextSize(20);
            layout.addView(test);
            for (Movement m : day.getMovement()) {
                test = new TextView(getApplicationContext());
                test.setText("\n" + m.getName());
                test.setTextAppearance(getApplicationContext(), R.style.FontStyle);
                test.setTextSize(15);
                layout.addView(test);
                putPic(m);
            }
            day_i++;
        }
    }

    private void quickWorkoutLayout(QuickWorkout quick) {
        for (Movement m : quick.getMovements()) {
            TextView test = new TextView(getApplicationContext());
            test.setText("\n" + m.getName());
            test.setTextAppearance(getApplicationContext(), R.style.FontStyle);
            test.setTextSize(15);
            layout.addView(test);
            putPic(m);
        }
    }

    private void putPic(Movement m) { //puts picture
        ImageView image = new ImageView(BodyPartDisplay.this);
        //DETERMINE WHAT TYPE OF PIC
        if (m.getMainMuscleGroup().name() == "LEGS") {
            image.setBackgroundResource(R.drawable.legs);
        }
        else if (m.getMainMuscleGroup().name() == "BICEPS") {
            image.setBackgroundResource(R.drawable.biceps);
        }
        else if (m.getMainMuscleGroup().name() == "TRICEPS") {
            image.setBackgroundResource(R.drawable.triceps);
        }
        else if (m.getMainMuscleGroup().name() == "CHEST") {
            image.setBackgroundResource(R.drawable.chest);
        }
        else if (m.getMainMuscleGroup().name() == "BACK") {
            image.setBackgroundResource(R.drawable.back);
        }
        else if (m.getMainMuscleGroup().name() == "CORE") {
            image.setBackgroundResource(R.drawable.core);
        }
        else {
            throw new NullPointerException(); //should be one of the six muscle groups
        }
        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity= Gravity.CENTER;
        image.setLayoutParams(layoutParams);
        layout.addView(image);
    }
}
