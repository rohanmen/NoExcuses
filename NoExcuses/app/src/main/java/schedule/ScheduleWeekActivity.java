package schedule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import noexcuses.venkat.noexcuses.R;

/**
 * Created by rohanmenhdiratta on 4/20/15.
 */
public class ScheduleWeekActivity extends Activity {

    Button[] buttons;
    Context _context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_week);

        _context = this;

        initUI();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_information_req, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    public void initUI()
    {
        //get ScrollView
        ScrollView myScrollView = (ScrollView)findViewById(R.id.week_scroll);

        //create LinearLayout
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

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
        final String[] daysOfWeek = Util.getDaysOfWeek();
        buttons = new Button[daysOfWeek.length];

        for (int i = 0; i < buttons.length; i++) {
            Button button = new Button(this);
            Drawable d = getResources().getDrawable(R.drawable.noexcuses_buttons);
            button.setBackground(d);
            button.setText(daysOfWeek[i]);
            button.setId(i);

            button.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = v.getId();
                    Intent intent = new Intent(_context, DailyScheduleActivity.class);
                    intent.putExtra("DAY", daysOfWeek[id]);
                    startActivity(intent);
                }
            });

            buttons[i] = button;
        }
    }
}
