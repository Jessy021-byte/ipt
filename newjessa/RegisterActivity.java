package com.example.newjessa;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText phoneInput, emailInput, passwordInput, rePasswordInput;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        // Initialize views
        phoneInput = findViewById(R.id.editTextNumberSigned);
        emailInput = findViewById(R.id.editTextTextEmailAddress);
        passwordInput = findViewById(R.id.editTextTextPassword);
        rePasswordInput = findViewById(R.id.editTextTextEmailAddress2);
        signUpButton = findViewById(R.id.signUpButton);

        signUpButton.setOnClickListener(v -> {
            String phone = phoneInput.getText().toString().trim();
            String email = emailInput.getText().toString().trim();
            String password = passwordInput.getText().toString();
            String rePassword = rePasswordInput.getText().toString();

            if (phone.isEmpty() || email.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(rePassword)) {
                Toast.makeText(RegisterActivity.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            // Save email and password to SharedPreferences
            SharedPreferences sharedPref = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("username", email);    // Save email as username
            editor.putString("password", password);
            editor.apply();

            Toast.makeText(RegisterActivity.this, "Signup successful!", Toast.LENGTH_SHORT).show();

            // Pass email and password to LoginActivity2 to pre-fill login fields
            Intent intent = new Intent(RegisterActivity.this, LoginActivity2.class);
            intent.putExtra("username", email);
            intent.putExtra("password", password);
            startActivity(intent);
            finish();
        });
    }
}
