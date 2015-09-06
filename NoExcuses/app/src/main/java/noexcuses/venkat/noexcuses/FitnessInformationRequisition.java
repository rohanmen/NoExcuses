package noexcuses.venkat.noexcuses;

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


public class FitnessInformationRequisition extends Activity {

    private String ActiveUser = "empty";
    private String password = "empty";
    private String encryptionKey = "";  //Would fail if the key is not updated by previous Intent

    private int pageNumber = 1;

    private final int ACTIVITY_PAGENUMBERS = 2;         //Number of pages we have for this activity


    //Information from the other pages
    String name_text;
    String age_text;
    String curweight_text;
    String tarweight_text;
    long exerciseSelection_long;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_req);
        Intent intent = getIntent();
        ActiveUser = intent.getStringExtra("username"); //if it's a string you stored.
        password = intent.getStringExtra("password");
        encryptionKey = intent.getStringExtra("encryptionKey");

        Button informationAcquireButton = (Button) findViewById(R.id.okbutton);

        informationAcquireButton.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    EditText user_Name = (EditText) findViewById(R.id.nameField);
                    EditText user_Age = (EditText) findViewById(R.id.ageField);
                    EditText user_currentWeight = (EditText) findViewById(R.id.curWeightField);
                    EditText user_targetWeight = (EditText) findViewById(R.id.targetWeightField);
                    Spinner user_targetExercise = (Spinner) findViewById(R.id.exerciseMode);

                    name_text=user_Name.getText().toString();
                    age_text=user_Age.getText().toString();
                    curweight_text= user_currentWeight.getText().toString();
                    tarweight_text=user_targetWeight.getText().toString();
                    exerciseSelection_long=user_targetExercise.getSelectedItemId();

                    setContentView(R.layout.activity_information_req1);
                    Button submitButton = (Button)findViewById(R.id.submitbutton);
                    submitButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            StoreInformation();
                        }
                    });
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

        Spinner user_Intensity = (Spinner) findViewById(R.id.intensity_spinner);
        Spinner workout_Partner = (Spinner) findViewById(R.id.partner_spinner);
        EditText workout_length = (EditText) findViewById(R.id.time_text);
        //Create the UserInformation Object with all the  information
        Information informationStore = new FitnessUserInformation(name_text, age_text, curweight_text, tarweight_text, exerciseSelection_long, workout_Partner.getSelectedItemId(), user_Intensity.getSelectedItemId(), workout_length.getText().toString());

        writeToFile(informationStore);

        Intent newIntent2 = (new Intent(FitnessInformationRequisition.this, LoggedInScreen.class));
        newIntent2.putExtra("username", ActiveUser); //User Account parameters
        FitnessInformationRequisition.this.startActivity(newIntent2);


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
        catch(Exception g){
            Log.d("Encryption", "Encryption Failed" + g.toString());
        }
    }

    /*END READ/WRITE DRIVERS*/


}
