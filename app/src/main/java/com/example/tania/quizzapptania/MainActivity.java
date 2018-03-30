package com.example.tania.quizzapptania;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

/**import com.example.android.managementquizz.R;*/

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int total_count = 0;
    String answerRadioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView myImage = (ImageView) findViewById(R.id.management_quizz);
        myImage.setAlpha(20);
        //value: [0-255]. Where 0 is fully transparent and 255 is fully opaque.
    }


    /**
     * This method displays what happens, when the radio buttons are clicked.
     */
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_yes:
                if (checked)
                    // This answer is right
                    answerRadioButton = "This is correct. The 10h rule applies to all employees by law.";
                total_count = total_count + 1;
                break;
            case R.id.radio_no:
                if (checked)
                    // This answer is wrong
                    answerRadioButton = "Wrong, the 10h rule applies to all employees by law.";
                break;
        }

    }


    /**
     * This method compiles the answer for the feedback question of the quizz
     * depending on the right answers and collects them in String textFeedback.
     */

    public void submitOrder(View view) {
        boolean hasanswer = false;
        String textFeedback1 = "";
        String textFeedback2 = "";
        String textFeedback3 = "";
        String textFeedback = "you must specify an answer first";
        String textGig1 = "";
        String textGig2 = "";
        String textGig3 = "";
        String textGig = "you must specify an answer first";
        String textGoal1 = "";
        String textGoal2 = "";
        String textGoal3 = "";
        String textGoal = "you must specify an answer first";
        String summaryText = "";

        /** is the first box checked? i.e. feedback is used for criticism */
        CheckBox checkBoxFeedback = (CheckBox) findViewById(R.id.checkbox_criticism);
        hasanswer = checkBoxFeedback.isChecked();
        String str = String.valueOf(hasanswer);

        if (hasanswer) {
            textFeedback1 = " \nIf feedback is only used to criticise, it will not be asked for.";

        }


        /** is the second box checked? i.e. feedback is given upon request */
        checkBoxFeedback = findViewById(R.id.checkbox_request);
        hasanswer = checkBoxFeedback.isChecked();
        str = String.valueOf(hasanswer);

        if (hasanswer) {
            textFeedback2 = " \nThe person asking for feedback can also specify the area they would like to be given feedback in.";
            total_count = total_count + 1;
        }


        /** is the third box checked? i.e. feedback is non-judgemental */
        checkBoxFeedback = findViewById(R.id.checkbox_judgmental);
        hasanswer = checkBoxFeedback.isChecked();
        str = String.valueOf(hasanswer);
        Log.i("judgemental hasanswer", str);
        if (hasanswer) {
            textFeedback3 = " \nFeedback is best, when it only describes and does not evaluate.";
            total_count = total_count + 1;
        }

        textFeedback = textFeedback1 + textFeedback2 + textFeedback3;


/** now for gig economy */
        /** is the first box checked? i.e. right answer */
        checkBoxFeedback = (CheckBox) findViewById(R.id.checkbox_right_answer);
        hasanswer = checkBoxFeedback.isChecked();
        str = String.valueOf(hasanswer);

        if (hasanswer) {
            textGig1 = " \nYes Gig Economy refers to the way jobs will be assigned in future.";
            total_count = total_count + 1;

        }


        /** is the second box checked? i.e. gadgets */
        checkBoxFeedback = findViewById(R.id.checkbox_gadgets);
        hasanswer = checkBoxFeedback.isChecked();
        str = String.valueOf(hasanswer);
        Log.i("request hasanswer", str);
        if (hasanswer) {
            textGig2 = " \nSorry, Gig Economy has nothing to do with gimmicks.";

        }


        /** is the third box checked? i.e. freelance */
        checkBoxFeedback = findViewById(R.id.checkbox_freelance_artist);
        hasanswer = checkBoxFeedback.isChecked();
        str = String.valueOf(hasanswer);
        Log.i("judgemental hasanswer", str);
        if (hasanswer) {
            textGig3 = " \nSorry, gigs are not to be confused with Gig Economy.";

        }

        textGig = textGig1 + textGig2 + textGig3;




/** now for goals  */
        /** is the first box checked? i.e. right answer */
        checkBoxFeedback = (CheckBox) findViewById(R.id.checkbox_the_right_answer);
        hasanswer = checkBoxFeedback.isChecked();
        str = String.valueOf(hasanswer);

        if (hasanswer) {
            textGoal1 = " \nYes the staff's goals are naturally a subgroup of the managers' goals.";
            total_count = total_count + 1;

        }


        /** is the second box checked? i.e. gadgets */
        checkBoxFeedback = findViewById(R.id.checkbox_vague);
        hasanswer = checkBoxFeedback.isChecked();
        str = String.valueOf(hasanswer);
        Log.i("request hasanswer", str);
        if (hasanswer) {
            textGoal2 = " \nTry to find goals, that are measurable.";

        }


        /** is the third box checked? i.e. freelance */
        checkBoxFeedback = findViewById(R.id.checkbox_no_goals);
        hasanswer = checkBoxFeedback.isChecked();
        str = String.valueOf(hasanswer);
        Log.i("judgemental hasanswer", str);
        if (hasanswer) {
            textGoal3 = " \n Have you considered leading by objectives?";

        }

        textGoal = textGoal1 + textGoal2 + textGoal3;










        summaryText = "Thank you for completing the quiz. \n" + textFeedback + "\n" + answerRadioButton + "\n" + textGig + textGoal + "\n you have reached " + total_count + "of 5 points";
        Log.v("Total printout is", summaryText);
        displayMessage(summaryText);


        return;
    }





    /**
     * This method displays the outcome of quiz on the screen.
     */
    private void displayMessage(String message) {
        TextView OrderSummaryTextView = (TextView) findViewById(R.id.ordersummary_text_view);
        OrderSummaryTextView.setText(message);
    }


}
