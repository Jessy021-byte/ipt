package com.example.newjessa;  // change to your actual package

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private Button logoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);  // your XML layout file name

        logoutBtn = findViewById(R.id.logoutBtn);

        logoutBtn.setOnClickListener(v -> {
            // Navigate back to LoginActivity (replace with your login activity class name)
            Intent intent = new Intent(HomeActivity.this, LoginActivity2.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            // This clears the back stack so user can't return to HomeActivity by pressing back button
            startActivity(intent);
            finish(); // finish current activity
        });
    }
}
