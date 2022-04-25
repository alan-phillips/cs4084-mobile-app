package com.example.fueltracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddStation extends AppCompatActivity {

    private Button saveStation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_station);

        saveStation = findViewById(R.id.saveStation);

        saveStation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddStation.this, "Adding the station...", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AddStation.this, Home.class));
                finish();
            }
        });

    }
}