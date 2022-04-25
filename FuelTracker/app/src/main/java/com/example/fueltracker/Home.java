package com.example.fueltracker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    ListView listView;
    FirebaseAuth auth;

    private Button Adder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        final ArrayList<Station> stationList = new ArrayList<>();
        listView = findViewById(R.id.ListView);
        StationListAdapter adapter = new StationListAdapter(this, R.layout.activity_custom_list_view, stationList);
        listView.setAdapter(adapter);
        auth = FirebaseAuth.getInstance();
        DatabaseReference ref = FirebaseDatabase.getInstance("https://fuel-tracker-1b220-default-rtdb.europe-west1.firebasedatabase.app").getReference().child("Stations");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                stationList.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    stationList.add(snapshot.getValue(Station.class));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Adder = findViewById(R.id.Adder);
        Adder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                finish();
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
