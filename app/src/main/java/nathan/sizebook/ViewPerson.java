package nathan.sizebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * The same as GetData in which it opens up a menu where
 * the user can input data values. However, unlike GetData,
 * it pre-populates the data with the values of the person
 * that was clicked on.
 */
public class ViewPerson extends AppCompatActivity{

    EditText editName;
    EditText editDate;
    EditText editNeck;
    EditText editBust;
    EditText editChest;
    EditText editWaist;
    EditText editHip;
    EditText editInseam;
    EditText editComment;

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
        String date = person.getDate();
        editDate.setText(date);

        editNeck = (EditText) findViewById(R.id.edit_Neck);
        float neck = person.getNeck();
        editNeck.setText(String.valueOf(neck));

        editBust = (EditText) findViewById(R.id.edit_Bust);
        float bust = person.getBust();
        editBust.setText(String.valueOf(bust));

        editChest = (EditText) findViewById(R.id.edit_Chest);
        float chest = person.getChest();
        editChest.setText(String.valueOf(chest));

        editWaist = (EditText) findViewById(R.id.edit_Waist);
        float waist = person.getWaist();
        editWaist.setText(String.valueOf(waist));

        editHip = (EditText) findViewById(R.id.edit_Hip);
        float hip = person.getHip();
        editHip.setText(String.valueOf(hip));

        editInseam = (EditText) findViewById(R.id.edit_Inseam);
        float inseam = person.getInseam();
        editInseam.setText(String.valueOf(inseam));

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
        boolean flag;
        flag = false;
        String Name = editName.getText().toString();
        String Date = editDate.getText().toString();

        System.out.println(Name);

        // Instantiates all values so that
        // person object is valid
        float Bust = 0;
        float Neck = 0;
        float Chest = 0;
        float Waist = 0;
        float Hip = 0;
        float Inseam = 0;

        try { Neck = Float.valueOf(editNeck.getText().toString()); }
        catch (NumberFormatException e) {
            if (editNeck.getText().toString().isEmpty()) {}
            else {flag = true;}
        };

        try { Bust = Float.valueOf(editBust.getText().toString()); }
        catch (NumberFormatException e) {
            if (editBust.getText().toString().isEmpty()) {}
            else {flag = true;}
        };

        try { Chest = Float.valueOf(editChest.getText().toString()); }
        catch (NumberFormatException e) {
            if (editChest.getText().toString().isEmpty()) {}
            else {flag = true;}
        };

        try { Waist = Float.valueOf(editWaist.getText().toString()); }
        catch (NumberFormatException e) {
            if (editWaist.getText().toString().isEmpty()) {}
            else {flag = true;}
        };

        try { Hip = Float.valueOf(editHip.getText().toString()); }
        catch (NumberFormatException e) {
            if (editHip.getText().toString().isEmpty()) {}
            else {flag = true;}
        };

        try { Inseam = Float.valueOf(editInseam.getText().toString()); }
        catch (NumberFormatException e) {
            if (editInseam.getText().toString().isEmpty()) {}
            else {flag = true;}
        };

        String Comments = editComment.getText().toString();

        if (Name.isEmpty()) {
            TextView textview = (TextView) findViewById(R.id.invalid);
            textview.setText("Invalid Name");
            return;
        }
        else if (flag) {
            TextView textview = (TextView) findViewById(R.id.invalid);
            textview.setText("Invalid Entry");
            return;
        }
        else {
            Person person = new Person(Name, Date, Neck, Bust, Waist, Chest, Hip, Inseam, Comments);
            Intent resultIntent = new Intent();
            resultIntent.putExtra("data", person);

            int position = (int) b.getSerializable("pos");

            resultIntent.putExtra("pos", position);
            setResult(2, resultIntent);
            finish();
        }
    }
}
