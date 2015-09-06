/* Created by Venkat on March 25, 2015 */

package noexcuses.venkat.noexcuses;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * A login screen that offers login via email/password.
 */
public class NoExcusesPortal extends Activity implements LoaderCallbacks<Cursor> {

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    /*private static final String[] DUMMY_CREDENTIALS = new String[]{
            "appLogIn@app.com:LogIn"
    };*/

    ArrayList<String> accounts;
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    private AnimationDrawable bG; // background

    private String encryptionKey = "12345678901234561234567890123456";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_excuses_portal);

        // LEFTOVER BACKGROUND STUFF MIGHT NEED IT
        //ImageView backgroundImage = (ImageView) findViewById(R.id.background_animation);
        //backgroundImage.setBackgroundResource(R.drawable.background_noeportal);
        //bG = (AnimationDrawable) backgroundImage.getBackground();


        //Set up the accounts
        accounts = readFromFile();   //Load the previous accounts

        if(!accounts.contains("admin@noe.com:noelogin")){
            accounts.add("admin@noe.com:noelogin");
            //Create the admin account
        }
        Iterator runner = accounts.iterator();
        while(runner.hasNext()){
            if(runner.next().equals("")){
                runner.remove();
            }
        }
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        populateAutoComplete();

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);

        //Set the application context
        GlobalDefinitions.currentApplicationContext = getApplicationContext();
    }

    private void populateAutoComplete() {
        getLoaderManager().initLoader(0, null, this);
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    public void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;


        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    public void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this,
                // Retrieve data rows for the device user's 'profile' contact.
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> emails = new ArrayList<String>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }

        addEmailsToAutoComplete(emails);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }


    private void addEmailsToAutoComplete(List<String> emailAddressCollection) {
        //Create adapter to tell the AutoCompleteTextView what to show in its dropdown list.
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(NoExcusesPortal.this,
                        android.R.layout.simple_dropdown_item_1line, emailAddressCollection);

        mEmailView.setAdapter(adapter);
    }



    /* READ/WRITE DRIVERS */
    private void writeToFile(ArrayList<String> data) {
        try {
            File yourFile = new File(getApplicationContext().getFilesDir().getPath().toString() + "/appPasswords.txt");
            File yourEnc = new File(getApplicationContext().getFilesDir().getPath().toString() + "/appPasswords2.txt");
            if(!yourFile.exists()) {
                yourFile.createNewFile();
            }
            else{
                yourFile.delete();
                yourFile.createNewFile();
            }

            //OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(getApplicationContext().getFilesDir().getPath().toString() + "/appPasswords.txt", Context.MODE_PRIVATE));
            PrintWriter writer = new PrintWriter(yourFile, "UTF-8");
            Iterator it = data.iterator();
            while(it.hasNext()){
                writer.println(it.next() + "\n");
            }
            writer.close();

            NoExcuseEncryptionDriver.encrypt(encryptionKey, yourFile, yourFile);
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
        catch(Exception g){
            Log.d("Encryption", "Encryption Failed" + g.toString());
        }
    }


    private ArrayList<String> readFromFile() {



        String ret = "";
        ArrayList<String> insideList = new ArrayList<String>();


        try {
            File yourFile = new File(getApplicationContext().getFilesDir().getPath().toString() + "/appPasswords.txt");
            if(!yourFile.exists()) {
                yourFile.createNewFile();
            }
            else{
                try {
                    NoExcuseEncryptionDriver.decrypt(encryptionKey, yourFile, yourFile);
                }
                catch(Exception e){
                    Log.d("Decryption", "Decryption failed");
                }
            }

            InputStream inputStream = new FileInputStream(getApplicationContext().getFilesDir().getPath().toString() + "/appPasswords.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                    insideList.add(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return insideList;
    }

    /*END READ/WRITE DRIVERS*/


    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;
        private boolean successLog = false;
        private String message="Empty";
        private boolean newAccount = false;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service. (Do we need it???)

            Log.d("ASYNC", "RUNNING IN BACKGROUND");

            for (String credential : accounts) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {

                    // Account exists, return true if the password matches.
                    if(pieces[1].equals(mPassword)){
                        //Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_SHORT);

                        Log.d("SUCCESS", "Logged in!");

                        writeToFile(accounts);

                        message = "Logged in successfully as "+mEmail+"!";

                        successLog= true;
                        return true;
                    }

                    else{
                        message = "Incorrect password!";
                        Log.d("ACCOUNT", "Account exists, but wrong password!");
                        publishProgress();
                        return false;
                    }


                }
            }

            // TODO: register the new account here.
            //Account not found here:
            StringBuilder newStr = new StringBuilder();
            newStr.append(mEmail);
            newStr.append(":");
            newStr.append(mPassword);
            accounts.add(newStr.toString());
            writeToFile(accounts);
            Log.d("ACCOUNT", "Account does not exist, created a new account");
            successLog = true;
            Log.d("DATA", accounts.toString());
            message = "New account created!";
            newAccount = true;
            publishProgress();

            //REMOVE THIS LATER!

            return true;
        }
        @Override
        protected void onProgressUpdate(Void... params){

            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);

        }
        @Override
        protected void onPostExecute(final Boolean success) {
            /*mAuthTask = null;
            showProgress(false);

            if (success) {
                finish();
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }*/

            TextView tex2 = (TextView)findViewById(R.id.textView3);
            if(successLog) {
                tex2.setText("Loading your information...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            else{
                tex2.setText("Please try again...");
            }
            try {
                Thread.sleep(1000);
            }
            catch(Exception e){

            }
            if(newAccount) {
                Intent newIntent = (new Intent(NoExcusesPortal.this, FitnessInformationRequisition.class));
                newIntent.putExtra("username", mEmail); //User Account parameters
                newIntent.putExtra("password", mPassword);
                newIntent.putExtra("encryptionKey", encryptionKey);

                NoExcusesPortal.this.startActivity(newIntent);
            }
            if(successLog && !newAccount){
                Intent newIntent2 = (new Intent(NoExcusesPortal.this, LoggedInScreen.class));
                newIntent2.putExtra("username", mEmail); //User Account parameters
                NoExcusesPortal.this.startActivity(newIntent2);
            }
            if(!successLog && !newAccount){
                Intent newIntent2 = (new Intent(NoExcusesPortal.this, NoExcusesPortal.class));

                NoExcusesPortal.this.startActivity(newIntent2);
            }



            //Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG);
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
}



