package nathan.sizebook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Main extends AppCompatActivity {

    private static final String FILENAME = "file.sav";
    private ArrayList<Person> personList;
    private ArrayAdapter<Person> adapter;
    private ListView oldpersonList;
    public static final int CONFIRM = 1;
    public static final int DELETE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        oldpersonList = (ListView) findViewById(R.id.oldpersonList);
    }

    public void newEntry(View view) {
        Intent intent = new Intent(this, GetData.class);
        startActivityForResult(intent, 1);
    }

    public void seeData(View view) {

        ListView viewList = (ListView) view.getParent();

        int position = viewList.getPositionForView(view);
        Person person = personList.get(position);

        Intent intent = new Intent(this, ViewPerson.class);
        intent.putExtra("pos", position);
        intent.putExtra("selected", person);
        startActivityForResult(intent, 2);
    }

    @Override
    protected void onStart() {
        super.onStart();

        loadFromFile();

        adapter = new ArrayAdapter<Person>(this,
                R.layout.list_person, R.id.list, personList);

        oldpersonList.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {
            if (resultCode == CONFIRM) {
                Bundle b = data.getExtras();

                Person person = (Person) b.getSerializable("data");

                personList.add(person);
                adapter.notifyDataSetChanged();

                saveInFile();
            }
        }
        if (requestCode == 2) {
            if (resultCode == CONFIRM) {
                Bundle b = data.getExtras();

                Person person = (Person) b.getSerializable("data");
                int position = (int) b.getSerializable("pos");

                personList.set(position, person);
                adapter.notifyDataSetChanged();

                saveInFile();
            }
            if (resultCode == DELETE) {
                Bundle b = data.getExtras();

                int position = (int) b.getSerializable("pos");

                personList.remove(position);
                adapter.notifyDataSetChanged();

                saveInFile();
            }
        }
    }

    private void loadFromFile() {
        try {
            FileInputStream fis = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));

            Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<Person>>(){}.getType();
            personList = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            personList = new ArrayList<Person>();
            // TODO Handle the Exception later
        }
    }

    private void saveInFile() {
        try {
            FileOutputStream fos = openFileOutput(FILENAME,
                    Context.MODE_PRIVATE);
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

            Gson gson = new Gson();
            gson.toJson(personList, out);
            out.flush();

            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Handle the Exception later
            throw new RuntimeException();
        } catch (IOException e) {
            // TODO Handle the Exception later
            throw new RuntimeException();
        }
    }

}