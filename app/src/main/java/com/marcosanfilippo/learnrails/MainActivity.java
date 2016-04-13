package com.marcosanfilippo.learnrails;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
    * Global variables
    */
    TextView tv;
    Button prevB, nextB;
    CheckBox checkBox;
    ImageView image;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        * Initialize each view to have dynamic changes during MainActivity's life cycle
        * through Java Code
        */
        tv = (TextView) findViewById(R.id.textView);
        tv.setMovementMethod(new ScrollingMovementMethod());
        prevB = (Button) findViewById(R.id.previous);
        nextB = (Button) findViewById(R.id.next);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        image = (ImageView) findViewById(R.id.imageView);
        i = 0; //i helps to show each sections of lesson

        //initial configuration
        showHint();
        tv.setText(R.string._1);
        image.setImageResource(R.drawable.rails_1);

    }

    /*
    * This method shows appropriate lesson using the global variable i after matching the
    * appropriate switch case only if the if statement allows it.
    * Here is not needed to have checkButton control because user goes back in lesson navigation
    */

    public void previous(View v) {
        if (i >= 0) {
            checkBox.setVisibility(View.VISIBLE);
            checkBox.setChecked(false); //uncheck, to re-check for each lesson
            if (i != 0) i--; //to avoid to go into a bad state
            else Toast.makeText(this, R.string.go, Toast.LENGTH_SHORT).show();
            switch (i) {
                case 0:
                    tv.setText(R.string._1);
                    image.setImageResource(R.drawable.rails_1);
                    tv.scrollTo(0, 0); //scroll to top entire TextView when changed
                    break;
                case 1:
                    tv.setText(R.string._2);
                    image.setImageResource(R.drawable.rails_2);
                    tv.scrollTo(0, 0);
                    break;
                case 2:
                    tv.setText(R.string._3);
                    image.setImageResource(R.drawable.rails_3);
                    tv.scrollTo(0, 0);
                    break;
                case 3:
                    tv.setText(R.string._4);
                    image.setImageResource(R.drawable.rails_4);
                    tv.scrollTo(0, 0);
                    break;
            }
        }
    }

    /*
    * This method shows appropriate lesson using the global variable i after matching the
    * appropriate switch case only if the if statement allows it.
    * Here there's the checkButton control; all are similar to previous() method
    */

    public void next(View v) {
        if (i < 5 && checkBox.isChecked()) {
            if (i < 4) i++; //to avoid to go into a bad state
            switch (i) {
                case 1:
                    tv.setText(R.string._2);
                    image.setImageResource(R.drawable.rails_2);
                    tv.scrollTo(0, 0);
                    break;
                case 2:
                    tv.setText(R.string._3);
                    image.setImageResource(R.drawable.rails_3);
                    tv.scrollTo(0, 0);
                    break;
                case 3:
                    tv.setText(R.string._4);
                    image.setImageResource(R.drawable.rails_4);
                    tv.scrollTo(0, 0);
                    break;
                case 4:
                    tv.setText(R.string._5);
                    image.setImageResource(R.drawable.rails_5);
                    tv.scrollTo(0, 0);
                    checkBox.setVisibility(View.INVISIBLE);
                    break;
            }
        }
        if (!checkBox.isChecked() && i < 4) {
            showWarning();
            //show AlertDialog (method definition below)
        }
        /*
        the uncheck method (below) is in different position instead of previous() method, otherwise
        showWarning() method is called even if user hasn't clicked the nextButton!
        */
        checkBox.setChecked(false); //uncheck, to re-check for each lesson


        if (i == 4) {
            //displayed in the last lesson
            Toast.makeText(this, R.string.thanks, Toast.LENGTH_LONG).show();
        }
    }

    /*
    * This method is called when user click on moreOnLine Button
    * */
    public void moreOnLine(View v) {
        switch (i) {
            case 0:
                onlineSearch("Ruby on Rails");
                break;
            case 1:
                onlineSearch("Ruby on Rails Gem");
                break;
            case 2:
                onlineSearch("MVC");
                break;
            case 3:
                onlineSearch("Ruby on Rails Most Famous Web Apps");
                break;
            case 4:
                onlineSearch("Ruby on Rails Creator");
                break;
        }
    }
    /*
    * This method is called by the moreOnLine() method, for online search
    */
    private void onlineSearch(String s) {
        String url = "http://www.google.it/search?q=" + s;
        Intent i = new Intent("android.intent.action.VIEW");
        i.setData(Uri.parse(url));
        startActivity(i);

    }

    private void showHint() {
        //suggest to user to scroll TextView if needed
        Toast.makeText(this, R.string.hints, Toast.LENGTH_LONG).show();
    }

    /*
    * This method suggest to check the CheckButton and only if user understood the current lesson.
    */
    private void showWarning() {
        new AlertDialog.Builder(this)
                .setTitle(R.string.wait)
                .setMessage(R.string.suggest)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // no action needed here
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
