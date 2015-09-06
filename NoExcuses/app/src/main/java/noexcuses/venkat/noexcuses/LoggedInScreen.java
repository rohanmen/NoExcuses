package noexcuses.venkat.noexcuses;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

import noexcuses.venkat.noexcuses.Workouts.*;


public class LoggedInScreen extends Activity {
    private String ActiveUser = "empty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in_screen);
        Intent intent = getIntent();
        ActiveUser = intent.getStringExtra("username"); //if it's a string you stored.
        GlobalDefinitions.activeUserName = ActiveUser;
        GlobalDefinitions.activeUserPass = intent.getStringExtra("password");

        final FitnessUserInformation dataUser = readFile();
        GlobalDefinitions.currentUser = dataUser;
        TextView usernameView = (TextView) findViewById(R.id.userNameView);
        usernameView.setText("Currently Logged In As: "+ActiveUser);
        TextView name = (TextView) findViewById(R.id.textView11);
        name.setText("Welcome back, "+ dataUser.getName() +"! We're delighted to see you!");

        ImageView backgroundImage = (ImageView) findViewById(R.id.gym_pic);
        backgroundImage.setBackgroundResource(R.drawable.gym);


        //going to workoutdisplay when button is pressed
        Button workoutButton = (Button) findViewById(R.id.button2);
       workoutButton.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               FitnessUserRoutine userRoutine = new FitnessUserRoutine(getApplicationContext(), GlobalDefinitions.currentUser);
               Workout userWorkout = userRoutine.getWorkout();
               GlobalDefinitions.fitnessUser = userRoutine;
               GlobalDefinitions.currentWorkout = userWorkout;
               Intent intent = new Intent(LoggedInScreen.this, WorkoutDisplay.class);
               startActivity(intent);
            }
       });

        Button liftButton = (Button) findViewById(R.id.liftButton);
        liftButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LoggedInScreen.this, WorkoutTracker.class);
                intent.putExtra("User", GlobalDefinitions.activeUserName);
                startActivity(intent);
            }
        });

        Button fitnessPortalButton = (Button) findViewById(R.id.button);
        fitnessPortalButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LoggedInScreen.this, FitnessPortal.class);
                intent.putExtra("User", GlobalDefinitions.activeUserName);
                startActivity(intent);
            }
        });

        Button prefButton = (Button) findViewById(R.id.changeInfo);
        prefButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(LoggedInScreen.this, ChangePreferences.class);
                intent.putExtra("User", GlobalDefinitions.activeUserName);
                startActivity(intent);
            }
        });

        Switch logOutSwitch = (Switch) findViewById(R.id.logoutsw);
        logOutSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent newIntent2 = (new Intent(LoggedInScreen.this, NoExcusesPortal.class));
                //LoggedInScreen.this.startActivity(newIntent2);
                //Intent loginIntent = LoginActivity.getIntent(context);
                TaskStackBuilder.create(getApplicationContext()).addNextIntentWithParentStack(newIntent2).startActivities();

            }
        });

        //createNotification();
        createAlarm();
    }
    public FitnessUserInformation readFile(){
        File yourFile = new File(getApplicationContext().getFilesDir().getPath().toString() + "/" + ActiveUser + "/UserInformation.txt");
        try {
            FileInputStream f_in = new
                    FileInputStream(yourFile);

            ObjectInputStream obj_in =
                    new ObjectInputStream (f_in);


            Object obj = obj_in.readObject();

            if (obj instanceof FitnessUserInformation)
            {
                // Cast object to a Vector
                FitnessUserInformation vec = (FitnessUserInformation) obj;
                return vec;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_logged_in_screen, menu);
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

    public void createNotification()
    {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setContentTitle("Workout Time!")
                        .setContentText("Hey its time to workout!")
                        .setSmallIcon(R.drawable.images)
                        .setWhen(System.currentTimeMillis() + (1000 * 10)) ;
// Creates an explicit intent for an Activity in your app
        Intent resultIntent = new Intent(this, NoExcusesPortal.class);

// The stack builder object will contain an artificial back stack for the
// started Activity.
// This ensures that navigating backward from the Activity leads out of
// your application to the Home screen.
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
// Adds the back stack for the Intent (but not the Intent itself)
        stackBuilder.addParentStack(NoExcusesPortal.class);
// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.
        mNotificationManager.notify(0, mBuilder.build());
        Log.v("LogInScreen", "notification created");
    }

    public void createAlarm()
    {
        AlarmManager alarmMgr;
        PendingIntent alarmIntent;

        Intent intent = new Intent(this, AlarmReciever.class);
        alarmIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);

        // Set the alarm
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, 9);
        calendar.set(Calendar.MINUTE, 0);


        alarmMgr.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);
        Log.v("Logged in", "alarmSet");
    }
}
