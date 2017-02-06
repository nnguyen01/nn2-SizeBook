package nathan.sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * When the user pressed the *plus* button
 * this class is utilized to get the data
 * the user has inputted.
 */
public class GetData extends AppCompatActivity {
    private EditText userNameText;
    private EditText userDateText;
    private EditText userNeckText;
    private EditText userBustText;
    private EditText userChestText;
    private EditText userWaistText;
    private EditText userHipText;
    private EditText userInseamText;
    private EditText userCommentText;
    Person person;

    /**
     * Sets up the variables with casting to editText
     * to ensure that there are no data input violations.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data);
        userNameText = (EditText) findViewById(R.id.edit_Name);
        userDateText = (EditText) findViewById(R.id.edit_Date);
        userNeckText = (EditText) findViewById(R.id.edit_Neck);
        userBustText = (EditText) findViewById(R.id.edit_Bust);
        userChestText = (EditText) findViewById(R.id.edit_Chest);
        userWaistText = (EditText) findViewById(R.id.edit_Waist);
        userHipText = (EditText) findViewById(R.id.edit_Hip);
        userInseamText = (EditText) findViewById(R.id.edit_Inseam);
        userCommentText = (EditText) findViewById(R.id.edit_Comment);
    }

    /**
     * Makes a person object and passes the object to main.
     * Sets the result code to 1 so that onActivityResult knows
     * it was successful.
     * @param view
     */
    public void confirmButton(View view) {
        boolean flag = false;

        String Name = userNameText.getText().toString();
        String userDate = userDateText.getText().toString();

        // Instantiates all values so that
        // person object is valid
        float Bust = 0;
        float Neck = 0;
        float Chest = 0;
        float Waist = 0;
        float Hip = 0;
        float Inseam = 0;

        try { Neck = Float.valueOf(userNeckText.getText().toString()); }
        catch (NumberFormatException e) {
            if (userNeckText.getText().toString().isEmpty()) {}
            else {flag = true;}
        };

        try { Bust = Float.valueOf(userBustText.getText().toString()); }
        catch (NumberFormatException e) {
            if (userBustText.getText().toString().isEmpty()) {}
            else {flag = true;}
        };

        try { Chest = Float.valueOf(userChestText.getText().toString()); }
        catch (NumberFormatException e) {
            if (userChestText.getText().toString().isEmpty()) {}
            else {flag = true;}
        };

        try { Waist = Float.valueOf(userWaistText.getText().toString()); }
        catch (NumberFormatException e) {
            if (userWaistText.getText().toString().isEmpty()) {}
            else {flag = true;}
        };

        try { Hip = Float.valueOf(userHipText.getText().toString()); }
        catch (NumberFormatException e) {
            if (userHipText.getText().toString().isEmpty()) {}
            else { flag = true; }
        };

        try { Inseam = Float.valueOf(userInseamText.getText().toString()); }
        catch (NumberFormatException e) {
            if (userInseamText.getText().toString().isEmpty()) {}
            else {flag = true;}
        };

        String Comments = userCommentText.getText().toString();

        if (Name.isEmpty()) {
            System.out.println("1");
            TextView textview = (TextView) findViewById(R.id.invalid);
            textview.setText("Invalid Name");
            return;
        }
        else if (!userDate.isEmpty()) {
            System.out.println("2");
            SimpleDateFormat check = new SimpleDateFormat("yyyy-MM-dd");
            check.setLenient(false);

            try {
                Date date = check.parse(userDate);
                person = new Person(Name, userDate, Neck, Bust, Waist, Chest, Hip, Inseam, Comments);
                Intent resultIntent = new Intent();
                resultIntent.putExtra("data", person);
                setResult(2, resultIntent);
                finish();
            } catch (ParseException e) {
                e.printStackTrace();
                TextView textview = (TextView) findViewById(R.id.invalid);
                textview.setText("Invalid Date");
            }
        }

        else if (flag) {
            System.out.println("3");
            TextView textview = (TextView) findViewById(R.id.invalid);
            textview.setText("Invalid Entry");
            return;
        }
        else {
            person = new Person(Name, userDate, Neck, Bust, Waist, Chest, Hip, Inseam, Comments);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("data", person);
            setResult(2, resultIntent);
            finish();
        }
    }
}
