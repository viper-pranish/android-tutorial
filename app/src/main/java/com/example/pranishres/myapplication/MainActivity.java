package com.example.pranishres.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

// for gestures
/*
import android.support.v7.app.ActionBarActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
*/

// for fragments
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import com.example.pranishres.myapplication.model.Flower;
import com.example.pranishres.myapplication.parsers.FlowerJSONParser;
import com.example.pranishres.myapplication.parsers.FlowerXMLParser;

import java.util.ArrayList;
import java.util.List;

import layout.FragmentOne;
import layout.FragmentTwo;

/**
 * The application will load onCreate() method first when it gets executed. There are lots of
 * examples used here. All the examples use different activity layout so you will have to
 * uncomment the particular method in the onCrete() method to run the desired activity
 */

public class MainActivity extends AppCompatActivity {

    String MY_TAG = "custom message";

    private EditText password;
    private Button button;


    // Radio button example variables
    private static RadioGroup radioGroup;
    private static Button buttonSubmit;
    private static RadioButton radioButton;

    // login
    int attempt_counter = 5;

    // imageview example
    int current_image_index;

    // gestures example
    private TextView gestureTextView;
    private GestureDetectorCompat gestureDetectorCompat;

    // MultiThreading example for REST API
    private TextView textView_asyncTask;
    private ProgressBar progressBar;
    List<MyTask> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/*
        // The Simple Hello World Activity
        setContentView(R.layout.activity_main);
*/

/*
        // Activity which takes two numbers from user and adds it
        setContentView(R.layout.basic_calculator);
*/

        // Using password field and show password to the user
 /*       setContentView(R.layout.show_password);
        // calling this method will register a button click event
        addListenerOnButton();
*/

  /*
        // Check box basics
            setContentView(R.layout.checkbox);
        // calling this method will register a button click event
            addListenerForCheckbox();
*/

 /*
        // Radio button basics
        setContentView(R.layout.radio_button);
        // calling this method will register a button click event
        addListenerForRadioButton();
*/

   /*
        // Rating basics
        setContentView(R.layout.rating_bar_basics);
        addListernerForRating();
        addListenerForRatingButtonClick();
*/

/*
        // Alert dialog
        setContentView(R.layout.alert_dialog);
        addListenerForAlertDialog();
*/

/*
        // Start new activity using intent
        setContentView(R.layout.activity_first);
        launchNewActivity();
*/

/*
        // Digital and Chronometer clock
        setContentView(R.layout.analog_and_digital_clock);
        toggleClock();
*/

/*
        // User login
        setContentView(R.layout.activity_login);
*/

/*
        // Using image view example and toggle between multiple images
        setContentView(R.layout.image_view);
*/

/*
        // Gestures (touch gestures)
        setContentView(R.layout.gestures);
        gestureTextView = (TextView) findViewById(R.id.textView_gesture);
        gestureDetectorCompat = new GestureDetectorCompat(this,this);
        gestureDetectorCompat.setOnDoubleTapListener(this);
*/

/*
        // Fragments example
        setContentView(R.layout.fragments);
*/

        /******* Basic Async Example **********/

        setContentView(R.layout.async_task);
        textView_asyncTask = (TextView) findViewById(R.id.textView_asyncTask);
        // enables vertical scrolling
        textView_asyncTask.setMovementMethod(new ScrollingMovementMethod());

        progressBar = (ProgressBar) findViewById(R.id.progressBar_asyncTask);
        // progress bar should be only visible the thread runs
        progressBar.setVisibility(View.INVISIBLE);

        tasks = new ArrayList<>();

        // Printing Logs
        Log.i(MY_TAG, "onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(MY_TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(MY_TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(MY_TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(MY_TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(MY_TAG, "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(MY_TAG, "onRestart()");
    }

    /**
     * Layout name :- basic_calculator
     * Method Type :- Button click event
     * Purpose     :- Take the values for 2 numbers provided by the user and display the sum result.
     *
     * @param v
     */
    public void onButtonClick(View v) {

        Log.i(MY_TAG, " Button click event executed successfully ");

        // Getting the components with its id and then converting explicitly to its Class

        // Getting the edit text with its id. Then convert explicitly to EditText
        EditText e1 = (EditText) findViewById(R.id.editText_firstNumber);
        EditText e2 = (EditText) findViewById(R.id.editText_secondNumber);

        TextView t1 = (TextView) findViewById(R.id.txtView_ResultPrint);

        // Getting integer values from the text fields
        int number1 = Integer.parseInt(e1.getText().toString());
        int number2 = Integer.parseInt(e2.getText().toString());

        Log.i(MY_TAG, "The sum is : " + (number1 + number2));

        t1.setText(Integer.toString(number1 + number2));

    }

    /**
     * Layout name :- show_password
     * Method Type :- Call
     * Purpose     :- Handles button click event and displays the password entered by the user.
     */
    public void addListenerOnButton() {
        password = (EditText) findViewById(R.id.editText_Password_PwddField);
        button = (Button) findViewById(R.id.btn_ShowPassword);

        // Add button click event
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(
                                MainActivity.this, password.getText(), Toast.LENGTH_SHORT
                        ).show();
                    }
                }

        );
    }

    /**
     * Layout name  :- checkbox
     * Method Type  :- Call
     * Purpose      :- Displays the checked items
     */
    public void addListenerForCheckbox() {
        final CheckBox checkboxSwimming = (CheckBox) findViewById(R.id.checkBox_swimming);
        final CheckBox checkboxDancing = (CheckBox) findViewById(R.id.checkBox_dancing);
        final CheckBox checkboxSinging = (CheckBox) findViewById(R.id.checkBox_singing);
        final Button button_check = (Button) findViewById(R.id.button_submit);

        // Add button click event
        button_check.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // Append all the checkboxes in a String Buffer
                        StringBuffer result = new StringBuffer();
                        result.append("Swimming : ").append(checkboxSwimming.isChecked());
                        result.append(" Dancing : ").append(checkboxDancing.isChecked());
                        result.append(" Singing : ").append(checkboxSinging.isChecked());

                        Toast.makeText(
                                MainActivity.this, result.toString(), Toast.LENGTH_LONG
                        ).show();
                    }
                });

    }

    /**
     * Layout name :- radio_button
     * Method Type :- Call
     * Purpose     :- Display selected radio button value
     */
    public void addListenerForRadioButton() {

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
//        private final RadioButton = radioMale, radioFemale, radioOther ;
        buttonSubmit = (Button) findViewById(R.id.button_RadioSubmit);

        // Add button click event
        buttonSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int selectedId = radioGroup.getCheckedRadioButtonId();
                        radioButton = (RadioButton) findViewById(selectedId);
                        Toast.makeText(
                                MainActivity.this, radioButton.getText().toString(), Toast.LENGTH_SHORT
                        ).show();
                    }
                }
        );

    }

    /**
     * Layout name :- rating_bar_basics
     * Method type :- Call
     * Purpose     :- Take user rating and display the result
     */
    public void addListernerForRating() {
        final TextView ratingResult = (TextView) findViewById(R.id.textView_ratingResult);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        // Set the value of rating to the textview
                        ratingResult.setText(String.valueOf(rating));
                    }
                }
        );

    }

    /**
     * Layout name :- rating_bar_basics
     * Method type :- Call
     * Purpose     :- Take user rating and display the result on a button click event
     */
    public void addListenerForRatingButtonClick() {
        Button buttonSubmit = (Button) findViewById(R.id.button_ratingSubmit);
        final RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        buttonSubmit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, String.valueOf(ratingBar.getRating()), Toast.LENGTH_SHORT).show();
                    }
                }

        );
    }

    /**
     * Layour name :- alert_dialog
     * Method type :- Call
     * Purpose     :- Prompt user to confirm exit event
     */
    public void addListenerForAlertDialog() {
        Button buttonAlert = (Button) findViewById(R.id.button_alert);

        /* Setting click listener to button and then creating an alert dialog. Then setting listener
        events to the alert dialog box buttons*/

        // setting click listener to button
        buttonAlert.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // First create an alert dialog builder and then crete an alert dialog

                        // creting alert dialog builder
                        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(MainActivity.this);
                        System.out.println("Alert Dialog button click listener");
                        alertBuilder.setMessage("Do you really want to exit?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                        // exit the applciation. Doesn't terminate though. Runs the application in background.
                                        finish();
                                    }
                                })
                                .setNegativeButton("Sorry, No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        // close the dialog box
                                        dialogInterface.cancel();
                                    }
                                });

                        // creating alert dialog using alert dialog builder
                        AlertDialog alertDialog = alertBuilder.create();
                        alertDialog.setTitle("Confirmation");
                        alertDialog.show();
                    }
                }
        );
    }

    /**
     * Layout name :- activity_first
     * Method name :- Call
     * Purpose     :- Start new activity on button click event
     */
    public void launchNewActivity() {
        Button buttonCall = (Button) findViewById(R.id.button_FirstActivity);
        buttonCall.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(".SecondActivity");
                        startActivity(intent);
                    }
                }
        );
    }

    /**
     * Layout name :- analog_and_digital_clock
     * Method name :- Call
     * Purpose     :- Toggle between chronometer clock and text clock
     */
    public void toggleClock() {
        Button buttonAnaDigi = (Button) findViewById(R.id.button_anaDigi);
        final TextClock textClock = (TextClock) findViewById(R.id.textClock);
        final Chronometer chronometer = (Chronometer) findViewById(R.id.chronometer);

        buttonAnaDigi.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (textClock.getVisibility() == TextClock.GONE) {
                            textClock.setVisibility(TextClock.VISIBLE);
                            chronometer.setVisibility(Chronometer.GONE);
                        } else {
                            chronometer.setVisibility(Chronometer.VISIBLE);
                            textClock.setVisibility(TextClock.GONE);
                        }
                    }
                }
        );
    }

    /**
     * Layout name :- activity_login
     * Method name :- Button Click
     * Purpose     :- Catch button click event
     */
    public void checkLogin(View view) {
        EditText username = (EditText) findViewById(R.id.editText_loginUsername);
        EditText password = (EditText) findViewById(R.id.editText_loginPassword);
        TextView attempts = (TextView) findViewById(R.id.textView_loginAttemptsResult);

        // checking username and passwor combination
        if (username.getText().toString().equals("pranish") && password.getText().toString().equals("pranish")) {
            Toast.makeText(MainActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(".User");
            startActivity(intent);
        } else {
            Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
            attempt_counter--;
            attempts.setText(String.valueOf(attempt_counter));

            // checking if the remaining attempts is 0 and disabling the login button
            if (attempt_counter == 0) {
                buttonSubmit.setEnabled(false);
            }
        }
    }

    /**
     * Layout name :- image_view
     * Method name :- Button Click
     * Purpose     :- Toggle images
     */
    public void toggleImages(View view) {
        ImageView imageview = (ImageView) findViewById(R.id.imageView_toggleImage);
        int[] images = {R.mipmap.ic_launcher, R.mipmap.ic_launcher1, R.mipmap.ic_launcher2};
        current_image_index++;
        current_image_index = current_image_index % images.length;
        imageview.setImageResource(images[current_image_index]);
    }


    /***************** Implementation for Gestures examples **************/
    /* CODE HAS BEEN REMOVED. PULL IT FROM THE GIT COMMIT LOG */
    /*************** END OF  implementation for gestures example **********************/


    /***************  Fragments   ********************/

    /**
     * Layout name :- fragments
     * Method type :- button click event
     * Purpose     :- show transition between two fragments.
     * <p>
     * A basic example on fragment which will show transition between 2 fragments
     */
    public void changeFragment(View view) {

        Fragment fragment;

        if (view == findViewById(R.id.button_fragment1)) {
            fragment = new FragmentOne();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_fragmentPlace, fragment);
            fragmentTransaction.commit();
        }

        if (view == findViewById(R.id.button_fragment2)) {
            fragment = new FragmentTwo();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment_fragmentPlace, fragment);
            fragmentTransaction.commit();
        }
    }

    /***************  END OF Fragments   ********************/


    /*************** AsyncTask example   *******************/

    /**
     * Codes in this section are modified time to time. You will need to go to the appropriate state
     * to download the code. See the list of commits in the readme file or commit history and use
     * git checkout <Commit_Number>
     * command to go the required version of the code
     */

    /**
     * Each application has a single foreground thread and all the visual elements (activity) are on
     * the main thread. But that is again only a single thread which means only 1 thing can be
     * happening at a time.
     * When we need to do some tasks that need few seconds like for example a network request, we
     * need to make sure we are not blocking the main thread. If we use the same main thread then it
     * will freeze the user interface for a few second and might give a ANR error or Application Not Responding
     * error.
     * <p>
     * So We will need to run threads in the background. But there is another problem. Once we are in
     * the background thread, we cannot access the user interface which is in the main thread.
     * <p>
     * Something is required which will help to run tasks in background thread and also access the main thread
     * which will allow user to know what's happening.
     * <p>
     * To be able to work in background and to control the foreground, we work with a class called AsyncTask which is
     * unique to the android environment. The AsyncTask is designed to work with short time lasting not more than
     * 10 seconds.
     */

    /*AsyncTask<Method parameters type, parameter type for publishProgress() , Return Type>*/
    private class MyTask extends AsyncTask<String, String, String> {

        @Override
        // Runs before background tasks gets executed. The background task is doInBackground()
        // Has access to main thread
        protected void onPreExecute() {
             /* // For serial AsyncTask
                   progressBar.setVisibility(View.VISIBLE);
                     updateDisplay("Pre Execute");
             */


            /*In parallel Async Thread for managing the progress bar effect. If there are multiple
            * number of button click events, this will check whether any task is remaining or not.
            */
            if (tasks.size() == 0) {
                progressBar.setVisibility(View.VISIBLE);

            }
            tasks.add(this);
        }

        // Runs in the background
        // Doesn't have access to main thread
        @Override
        protected String doInBackground(String... params) {
            String content = HttpManager.getData(params[0],"feeduser" , "feedpassword");
            return content;
        }

        @Override
        protected void onProgressUpdate(String... values) {
//            updateDisplay(values[0]);

            //For serial AsyncTask
            // progressBar.setVisibility(View.VISIBLE);
        }

        /**
         * Runs after background task is completed. The background task is doInBackground().
         * Has access to main thread.
         * Notice that the onPostExecute() method takes String as a parameter which is the return type
         * of doInBackground.
         * doInBackground will return a value which is then directly passed on to onPostExecute()
         */
        @Override
        protected void onPostExecute(String result) {
            // Provide raw data to parseFeed() method and get the formatted data
            List<Flower> flowerList;
            flowerList = FlowerJSONParser.parseFeed(result);

            updateDisplay(flowerList);
            //  For serial Async Task
            // progressBar.setVisibility(View.INVISIBLE);

            tasks.remove(this);
            if (tasks.size() == 0) {
                progressBar.setVisibility(View.INVISIBLE);

            }
        }
    }

    public void doTask(View v) {
        if (isOnline()) {
            requestData("http://services.hanselandpetal.com/secure/flowers.json");
        } else {
            Toast.makeText(this, "Network is not available", Toast.LENGTH_LONG).show();
        }

    }

    private void requestData(String uri) {
        MyTask task = new MyTask();
        // This method will execute the Async task which will run in background.
        task.execute(uri);
    }

    /**
     * Append value in textview having id textView_asyncTask
     * @param flowerList Parsed data
     */

    private void updateDisplay(List<Flower> flowerList) {
        if (flowerList != null) {
            for (Flower flower : flowerList) {
                textView_asyncTask.append(" Flower name : " + flower.getName() + "\n");
            }
        }

    }

    /**
     * Check internet connectivity
     */
    public Boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        /*Check if connectivity manager is available and  internet connectivity is available or the deivce is trying to connect to the internet*/
        if (networkInfo != null && networkInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }

    }

    /*************** END OF AsyncTask example *******************/


}
