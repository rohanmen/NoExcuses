package noexcuses.venkat.noexcuses;

/**
 * Created by josephromero on 5/9/15.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;





public class ChangePreferences extends Activity {

    private String ActiveUser = "empty";




          //Number of pages we have for this activity


    //Information from the other pages
    String name_text;
    String age_text;
    String curweight_text;
    String tarweight_text;
    String length;
    long exerciseSelection_long;
    long intensity;
    long partner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pref);
        Intent intent = getIntent();
        ActiveUser = intent.getStringExtra("username"); //if it's a string you stored.


        Button submitButton = (Button)findViewById(R.id.okbutton);

        submitButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                EditText user_targetWeight = (EditText) findViewById(R.id.targetWeightField);
                Spinner user_targetExercise = (Spinner) findViewById(R.id.exerciseMode);
                Spinner user_Intensity = (Spinner) findViewById(R.id.intensity_spinner);
                Spinner workout_Partner = (Spinner) findViewById(R.id.partner_spinner);
                EditText workout_length = (EditText) findViewById(R.id.time_text);

                name_text=GlobalDefinitions.currentUser.getName();
                age_text= GlobalDefinitions.currentUser.getAge();
                curweight_text= GlobalDefinitions.currentUser.getCurrentWeight();
                tarweight_text=user_targetWeight.getText().toString();
                exerciseSelection_long=user_targetExercise.getSelectedItemId();
                intensity = user_Intensity.getSelectedItemId();
                partner = workout_Partner.getSelectedItemId();
                length = workout_length.getText().toString();

                StoreInformation();


            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_information_req, menu);
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

    private void StoreInformation(){
        //Get handles to all the items with data
        //Name textfield


        //Create the UserInformation Object with all the  information
        GlobalDefinitions.currentUser = new FitnessUserInformation(name_text, age_text, curweight_text, tarweight_text, exerciseSelection_long, partner, intensity, length);

        Information informationStore = new FitnessUserInformation(name_text, age_text, curweight_text, tarweight_text, exerciseSelection_long, partner, intensity, length);

        writeToFile(informationStore);

        finish();

        //Intent newIntent2 = (new Intent(ChangePreferences.this, LoggedInScreen.class));
        //newIntent2.putExtra("username", ActiveUser); //User Account parameters
        //ChangePreferences.this.startActivity(newIntent2);


    }

    /* READ/WRITE DRIVERS */
    private void writeToFile(Information data) {
        try {

            File yourFile = new File(getApplicationContext().getFilesDir().getPath().toString() + "/" + ActiveUser + "/UserInformation.txt");
            yourFile.mkdirs();
            if(!yourFile.exists()) {
                yourFile.createNewFile();
            }
            else{
                yourFile.delete();
                yourFile.createNewFile();
            }

            //OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(getApplicationContext().getFilesDir().getPath().toString() + "/appPasswords.txt", Context.MODE_PRIVATE));
            FileOutputStream f_out = new
                    FileOutputStream(yourFile);

            // Write object with ObjectOutputStream
            ObjectOutputStream obj_out = new
                    ObjectOutputStream (f_out);

            // Write object out to disk
            obj_out.writeObject(data);

        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }

    }

    /*END READ/WRITE DRIVERS*/


}

