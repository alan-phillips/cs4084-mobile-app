package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button loginBtn;
    private TextView toRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginbtn);
        toRegister = findViewById(R.id.to_register);

        //admin and admin

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (username.getText().toString().equals("admin") && password.getText().toString().equals("admin")) {
                    //correct
                    Toast.makeText(MainActivity.this, "Login Successful!!!", Toast.LENGTH_SHORT).show();
                } else
                    //incorrect
                    Toast.makeText(MainActivity.this, "Login Failed!!!", Toast.LENGTH_SHORT).show();
            }
        });

        toRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "HOWYA", Toast.LENGTH_SHORT).show();
            }
        });


    }

}