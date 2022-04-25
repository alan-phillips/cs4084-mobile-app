package com.example.fueltracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStation extends AppCompatActivity {

    private Button saveStation;
    private Button backButton;
    private EditText name;
    private EditText dieselPrice;
    private EditText petrolPrice;
    private DatabaseReference ref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_station);
        ref = FirebaseDatabase.getInstance("https://fuel-tracker-1b220-default-rtdb.europe-west1.firebasedatabase.app").getReference();

        saveStation = findViewById(R.id.saveStation);
        backButton = findViewById(R.id.backButton);
        name = findViewById(R.id.nameEntry);
        dieselPrice = findViewById(R.id.dieselEntry);
        petrolPrice = findViewById(R.id.petrolEntry);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddStation.this, Home.class));
                finish();
            }
        });

        saveStation.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                String txt_name = name.getText().toString();
                String txt_diesel = dieselPrice.getText().toString();
                String txt_petrol = petrolPrice.getText().toString();

                if(TextUtils.isEmpty(txt_name) || TextUtils.isEmpty(txt_diesel) || TextUtils.isEmpty(txt_petrol)){
                    Toast.makeText(AddStation.this, "Empty Input!", Toast.LENGTH_SHORT).show();
                }
                else {
                    double num_diesel = Double.parseDouble(txt_diesel);
                    double num_petrol = Double.parseDouble(txt_petrol);

                    DatabaseReference stationsRef = ref.child("Stations");
                    stationsRef.push().setValue(new Station(txt_name, num_diesel, num_petrol));

                    Toast.makeText(AddStation.this, "Added Station", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}