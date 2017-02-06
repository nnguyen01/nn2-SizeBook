package nathan.sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class GetData extends AppCompatActivity {
    EditText userNameText;
    EditText userDateText;
    EditText userNeckText;
    EditText userBustText;
    EditText userChestText;
    EditText userWaistText;
    EditText userHipText;
    EditText userInseamText;
    EditText userCommentText;
    Person person;

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

    public void confirmButton(View view) {
        String Name = userNameText.getText().toString();
        String Date = userDateText.getText().toString();
        float Neck = Float.valueOf(userNeckText.getText().toString());
        float Bust = Float.valueOf(userBustText.getText().toString());
        float Chest = Float.valueOf(userChestText.getText().toString());
        float Waist = Float.valueOf(userWaistText.getText().toString());
        float Hip = Float.valueOf(userHipText.getText().toString());
        float Inseam = Float.valueOf(userInseamText.getText().toString());
        String Comments = userCommentText.getText().toString();

        person = new Person(Name, Date, Neck, Bust, Waist, Chest, Hip, Inseam, Comments);
        Intent resultIntent = new Intent();
        resultIntent.putExtra("data", person);
        setResult(1, resultIntent);
        finish();
    }
}
