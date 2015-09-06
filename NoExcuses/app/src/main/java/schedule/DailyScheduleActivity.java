package schedule;


import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import noexcuses.venkat.noexcuses.GlobalDefinitions;
import noexcuses.venkat.noexcuses.R;

/**
 * Created by rohanmenhdiratta on 4/10/15.
 */
public class DailyScheduleActivity extends Activity{

    Context _context;

    Button[] buttons;
    boolean[] freeTime;
    String[] timeSlots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dailyschedule);

        _context = this;

        init();
        initUI();
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_information_req, menu);
//        return true;
//    }

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

    public void init()
    {
        String day = getIntent().getExtras().getString("DAY");

        freeTime = Util.getScheduleFromDatabase(day, _context);

        timeSlots = Util.getTimeSlots();

        buttons = new Button[timeSlots.length];



    }

    public void initUI()
    {
        //get ScrollView
        ScrollView myScrollView = (ScrollView)findViewById(R.id.sched_sroll);

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

        Button saveButton = (Button)findViewById(R.id.sched_save);
        saveButton.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                saveSchedule(v);
            }
        });

    }


    public void initButtons()
    {
        for (int i = 0; i < buttons.length; i++)
        {
            Button button = new Button(this);
            if(freeTime[i] == true)
            {
                button.setBackgroundColor(getResources().getColor(R.color.red));
            }
            else if(freeTime[i] == false)
            {
                button.setBackgroundColor(getResources().getColor(R.color.green));
            }

            button.setText(timeSlots[i]);
            button.setId(i);

            button.setOnClickListener(new Button.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int id = v.getId();
                    Button button = buttons[id];

                    if(freeTime[id] == true) {
                        button.setBackgroundColor(getResources().getColor(R.color.green));
                    }
                    else
                    {
                        button.setBackgroundColor(getResources().getColor(R.color.red));
                    }
                    freeTime[id] = (!(freeTime[id]));
                }
            });

            buttons[i] = button;
        }
    }

    public void saveSchedule(View v)
    {
        String sched = "";
        for(int i = 0; i < freeTime.length; i++)
        {
            boolean b = freeTime[i];
            String s;
            if(b)
            {
                s = "1";
            }
            else
            {
                s = "0";
            }
            sched = sched + s;
        }
        Log.v("DailySched", sched);

        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd:MM:yyyy");
        String date = sdf.format(c.getTime());


        String key = getIntent().getExtras().getString("DAY");
        SharedPreferences sharedPref = this.getSharedPreferences(GlobalDefinitions.activeUserName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(key, sched);
        editor.commit();


        // Obtain a Realm instance
//        Realm realm = Realm.getInstance(this);


        //check if a the schedule for the day already exists
//        if(Util.scheduleExistsInDatabase(getIntent().getExtras().getString("DAY"), _context))
//        {
//            realm.beginTransaction();
//            //delete the older schedule
//            RealmQuery<Schedule> query = realm.where(Schedule.class);
//            RealmResults<Schedule> results = realm.where(Schedule.class).equalTo("day", getIntent().getExtras().getString("DAY")).findAll();
//            results.clear();
//            realm.commitTransaction();
//
//        }

        //realm = Realm.getInstance(this);
//        realm.beginTransaction();
//
//        Schedule schedule = realm.createObject(Schedule.class);
//        schedule.setTimeStamp(date);
//        schedule.setSchedule(sched);
//        schedule.setDay(getIntent().getExtras().getString("DAY"));
//
//        realm.commitTransaction();

        finish();
    }

    public void checkDatabase()
    {

    }

}
