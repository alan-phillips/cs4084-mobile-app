package com.example.myloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;

public class ForgotPassword extends AppCompatActivity {

    private EditText emailText;
    private Button ResetPwd;
    private TextView ReturnHome;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        emailText = (EditText) findViewById(R.id.editTextTextEmailAddress);
        ResetPwd = (Button) findViewById(R.id.ResetButton);
        ReturnHome = (TextView) findViewById(R.id.BackText);
        
        auth = FirebaseAuth.getInstance();

        ResetPwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });
        ReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ForgotPassword.this,MainActivity.class));
            }
        });

    }

    private void resetPassword(){
        String email = emailText.getText().toString().trim();
        if (email.isEmpty()){
            emailText.setError("Enter your email here.");
            emailText.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailText.setError("Enter a valid email.");
            emailText.requestFocus();
        }
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgotPassword.this, "Check your email", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(ForgotPassword.this,MainActivity.class));
                }
                else{
                    Toast.makeText(ForgotPassword.this,"Something went wrong, Please try again", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}