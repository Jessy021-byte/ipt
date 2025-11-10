package com.example.newjessa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity2 extends AppCompatActivity {

    private Button loginBtn;
    private EditText usernameInput, passwordInput;
    private TextView signupText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        loginBtn = findViewById(R.id.login_btn);
        usernameInput = findViewById(R.id.username_input);
        passwordInput = findViewById(R.id.password_input);
        signupText = findViewById(R.id.button);  // This is your "Don't have an account? SIGN UP" TextView

        // Pre-fill if data is passed from RegisterActivity
        String preUsername = getIntent().getStringExtra("username");
        String prePassword = getIntent().getStringExtra("password");
        if (preUsername != null) usernameInput.setText(preUsername);
        if (prePassword != null) passwordInput.setText(prePassword);

        // Handle login button click
        loginBtn.setOnClickListener(v -> {
            String username = usernameInput.getText().toString().trim();
            String password = passwordInput.getText().toString();

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity2.this, "Please enter email and password", Toast.LENGTH_SHORT).show();
                return;
            }

            if (isValidCredentials(username, password)) {
                Intent intent = new Intent(LoginActivity2.this, HomeActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LoginActivity2.this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        });

        // Handle signup text click to navigate to RegisterActivity
        signupText.setOnClickListener(v -> {
            Intent intent = new Intent(LoginActivity2.this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Clear username and password fields whenever activity resumes (like coming back from register)
        usernameInput.setText("");
        passwordInput.setText("");
    }

    private boolean isValidCredentials(String username, String password) {
        SharedPreferences sharedPref = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        String savedUsername = sharedPref.getString("username", "");
        String savedPassword = sharedPref.getString("password", "");

        return username.equals(savedUsername) && password.equals(savedPassword);
    }
}
