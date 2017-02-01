package nathan.sizebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }


    public void newEntry(View view) {
        Intent intent = new Intent(this, EnterData.class);
        startActivity(intent);
    }

}