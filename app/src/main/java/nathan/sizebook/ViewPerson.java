package nathan.sizebook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

/**
 * Created by nathan on 05/02/17.
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_data);

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

    public void confirmButton(View view) {

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        String Name = editName.getText().toString();
        String Date = editDate.getText().toString();
        float Neck = Float.valueOf(editNeck.getText().toString());
        float Bust = Float.valueOf(editBust.getText().toString());
        float Chest = Float.valueOf(editChest.getText().toString());
        float Waist = Float.valueOf(editWaist.getText().toString());
        float Hip = Float.valueOf(editHip.getText().toString());
        float Inseam = Float.valueOf(editInseam.getText().toString());
        String Comments = editComment.getText().toString();

        Person person = new Person(Name, Date, Neck, Bust, Waist, Chest, Hip, Inseam, Comments);
        Intent resultIntent = new Intent();
        resultIntent.putExtra("data", person);

        int position = (int) b.getSerializable("pos");

        resultIntent.putExtra("pos", position);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }
}
