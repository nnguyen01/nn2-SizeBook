package nathan.sizebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The same as GetData in which it opens up a menu where
 * the user can input data values. However, unlike GetData,
 * it pre-populates the data with the values of the person
 * that was clicked on.
 */
public class ViewPerson extends AppCompatActivity{

    private EditText editName;
    private EditText editDate;
    private EditText editNeck;
    private EditText editBust;
    private EditText editChest;
    private EditText editWaist;
    private EditText editHip;
    private EditText editInseam;
    private EditText editComment;
    private Person person;

    /**
     * Gets the data from the person object which
     * the user clicked on and then populates each field
     * with respective data.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_data);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        Person person = (Person) b.getSerializable("selected");

        editName = (EditText) findViewById(R.id.edit_Name);
        String name = person.getName();
        editName.setText(name);

        editDate = (EditText) findViewById(R.id.edit_Date);
        String Date = person.getDate();
        editDate.setText(Date);

        editNeck = (EditText) findViewById(R.id.edit_Neck);
        float neck = person.getNeck();
        if (neck != 0) {
            editNeck.setText(String.format("%.1f", neck));
        }

        editBust = (EditText) findViewById(R.id.edit_Bust);
        float bust = person.getBust();
        if (bust != 0) {
            editBust.setText(String.format("%.1f", bust));
        }

        editChest = (EditText) findViewById(R.id.edit_Chest);
        float chest = person.getChest();
        if (chest != 0) {
            editChest.setText(String.format("%.1f", chest));
        }

        editWaist = (EditText) findViewById(R.id.edit_Waist);
        float waist = person.getWaist();
        if (waist != 0) {
            editWaist.setText(String.format("%.1f", waist));
        }

        editHip = (EditText) findViewById(R.id.edit_Hip);
        float hip = person.getHip();
        if (hip != 0) {
            editHip.setText(String.format("%.1f", hip));
        }

        editInseam = (EditText) findViewById(R.id.edit_Inseam);
        float inseam = person.getInseam();
        if (inseam != 0) {
            editInseam.setText(String.format("%.1f", inseam));
        }

        editComment = (EditText) findViewById(R.id.edit_Comment);
        String comment = person.getComments();
        editComment.setText(comment);
    }

    /**
     * Sets the resultCode to 0 which main interprets
     * as the user deleting one of the entries.
     * @param view
     */
    public void deleteButton(View view) {
        Intent intent = getIntent();
        Intent resultIntent = new Intent();
        Bundle b = intent.getExtras();

        int position = (int) b.getSerializable("pos");

        resultIntent.putExtra("pos", position);
        setResult(1, resultIntent);
        finish();
    }

    /**
     * Almost exactly the same as confirmButton in
     * GetData except this also returns the position of
     * the entry clicked on so that it can replace the data
     * without making a new entry.
     * @param view
     */
    public void confirmButton(View view) {

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        int flag = 0;
        boolean create = true;

        String userName = editName.getText().toString();
        String userDate = editDate.getText().toString();


        // Instantiates all values so that
        // person object is valid
        float userNeck = 0;
        float userBust = 0;
        float userChest = 0;
        float userWaist = 0;
        float userHip = 0;
        float userInseam = 0;

        try { userNeck = Float.valueOf(editNeck.getText().toString()); }
        catch (NumberFormatException e) {
            if (editNeck.getText().toString().isEmpty()) {}
            else {
                flag = 3;
                create = false;
            }
        };

        try { userBust = Float.valueOf(editBust.getText().toString()); }
        catch (NumberFormatException e) {
            if (editBust.getText().toString().isEmpty()) {}
            else {
                flag = 3;
                create = false;
            }
        };

        try { userChest = Float.valueOf(editChest.getText().toString()); }
        catch (NumberFormatException e) {
            if (editChest.getText().toString().isEmpty()) {}
            else {
                flag = 3;
                create = false;
            }
        };

        try { userWaist = Float.valueOf(editWaist.getText().toString()); }
        catch (NumberFormatException e) {
            if (editWaist.getText().toString().isEmpty()) {}
            else {
                flag = 3;
                create = false;
            }
        };

        try { userHip = Float.valueOf(editHip.getText().toString()); }
        catch (NumberFormatException e) {
            if (editHip.getText().toString().isEmpty()) {}
            else {
                flag = 3;
                create = false;
            }
        };

        try { userInseam = Float.valueOf(editInseam.getText().toString()); }
        catch (NumberFormatException e) {
            if (editInseam.getText().toString().isEmpty()) {}
            else {
                flag = 3;
                create = false;
            }
        };

        String Comments = editComment.getText().toString();

        if (userName.isEmpty()) {
            flag = 1;
            create = false;
        }
        else if (!userDate.isEmpty()) {
            SimpleDateFormat check = new SimpleDateFormat("yyyy-MM-dd");
            check.setLenient(false);

            try {
                Date date = check.parse(userDate);
            } catch (ParseException e) {
                e.printStackTrace();
                flag = 2;
                create = false;
            }
        }

        if (create) {
            person = new Person(userName, userDate, userNeck, userBust, userChest, userWaist, userHip, userInseam, Comments);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("data", person);

            int position = (int) b.getSerializable("pos");

            resultIntent.putExtra("pos", position);
            setResult(2, resultIntent);
            finish();
        }
        else {
            if (flag == 1) {
                TextView textview = (TextView) findViewById(R.id.invalid);
                textview.setText("Invalid Name");
            }
            else if (flag == 2) {
                TextView textview = (TextView) findViewById(R.id.invalid);
                textview.setText("Invalid Date");
            }
            else if (flag == 3) {
                TextView textview = (TextView) findViewById(R.id.invalid);
                textview.setText("Invalid Entry");
            }
        }
    }
}
