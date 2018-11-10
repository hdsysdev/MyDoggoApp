package com.hdstudios.mydoggo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.R.layout;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayAdapter<String> adapter;

    public ArrayAdapter<String> getAdapter() {
        return adapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent myIntent = new Intent(MainActivity.this, AddDoggoActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });
        Doggo doggo = new Doggo("Polo", "Poodle");
        Doggo doggo1 = new Doggo("Porthos", "Bulldog");
        ListView doggoList = (ListView) findViewById(R.id.doggoList);
        Gson gson = new Gson();
        ArrayList<String> doggoArray = new ArrayList<>();
        final SharedPreferences sharedPreferences = getSharedPreferences("Dooggos", MODE_PRIVATE);
        doggoArray.add(doggo.getName());
        doggoArray.add(doggo1.getName());
        String restoredDoggo = sharedPreferences.getString("doggo", null);
        if (restoredDoggo != null){
            Doggo tempDoggo = gson.fromJson(restoredDoggo, Doggo.class);
            doggoArray.add(tempDoggo.getName());
        }
        adapter = new ArrayAdapter<String>(this, layout.simple_list_item_1, doggoArray);
        doggoList.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
