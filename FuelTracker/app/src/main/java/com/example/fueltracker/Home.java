package com.example.fueltracker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;

public class Home extends AppCompatActivity {
    String stationList[] = {"Circle K", "Topaz", "Applegreen", "Maxol"};
    ListView listView;
    FirebaseAuth auth;

    private Button Adder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        listView = (ListView) findViewById(R.id.ListView);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), stationList);
        listView.setAdapter(customBaseAdapter);
        auth = FirebaseAuth.getInstance();

        Adder = findViewById(R.id.Adder);
        Adder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Home.this, "Adding the station...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Home.this, AddStation.class));
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.homemenubar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.openmap:
                Toast.makeText(this, "Trying to open Map", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Home.this, MapActivity.class));
                return true;

            case R.id.logout:
                Toast.makeText(this, "Trying to Log Out", Toast.LENGTH_SHORT).show();
                auth.signOut();
                startActivity(new Intent(Home.this, MainActivity.class));
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
