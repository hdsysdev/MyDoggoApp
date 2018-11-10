package com.hdstudios.mydoggo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import com.hdstudios.mydoggo.MainActivity;

import com.google.gson.Gson;

public class AddDoggoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_doggo);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final EditText nameEditText = (EditText) findViewById(R.id.nameEditText);
        final EditText breedEditText = (EditText) findViewById(R.id.breedEditText);

        final Gson gson = new Gson();
        final SharedPreferences.Editor sharedPreferences = getSharedPreferences("Dooggos", MODE_PRIVATE).edit();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Doggo tempDoggo = new Doggo(nameEditText.getText().toString(),
                        breedEditText.getText().toString());

                sharedPreferences.putString("doggo", gson.toJson(tempDoggo));
                sharedPreferences.apply();
                //TODO: Refresh list view to add new doggo
                MainActivity.adapter.notifyDataSetChanged();
            }
        });
    }

}
