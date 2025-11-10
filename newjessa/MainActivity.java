package com.example.newjessa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button loginbtn, getstartedbtn, appleBtn, googleBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);  // Make sure this matches your XML filename

        loginbtn = findViewById(R.id.loginbtn);
        getstartedbtn = findViewById(R.id.getstartedbtn);
        appleBtn = findViewById(R.id.appleBtn);
        googleBtn = findViewById(R.id.googleBtn);

        View.OnClickListener goToLogin = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LoginActivity2.class);
                startActivity(intent);
            }
        };

        // Set the same click listener for all buttons
        loginbtn.setOnClickListener(goToLogin);
        getstartedbtn.setOnClickListener(goToLogin);
        appleBtn.setOnClickListener(goToLogin);
        googleBtn.setOnClickListener(goToLogin);
    }
}
