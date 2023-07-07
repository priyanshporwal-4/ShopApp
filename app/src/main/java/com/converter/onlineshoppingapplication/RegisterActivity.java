package com.converter.onlineshoppingapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.converter.onlineshoppingapplication.databinding.ActivityRegisterBinding;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        databaseHelper = new DatabaseHelper(this);
        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.registerName.getText().toString();
                String email = binding.registerEmail.getText().toString();
                String password = binding.registerPass.getText().toString();
                String confirmPassword = binding.regConfirmPass.getText().toString();
                if (email.equals("") || password.equals("") || confirmPassword.equals("") || name.equals(""))
                    Toast.makeText(RegisterActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                else {
                    if (password.equals(confirmPassword)) {
                        Boolean checkUserEmail = databaseHelper.checkEmail(email);
                        if (checkUserEmail == false) {
                            Boolean insert = databaseHelper.insertData(email, password);
                            if (insert == true) {
                                Toast.makeText(RegisterActivity.this, "Signup Successfully!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                intent.putExtra("name", name);
                                startActivity(intent);
                            } else {
                                Toast.makeText(RegisterActivity.this, "Signup Failed!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RegisterActivity.this, "User already exists! Please login", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegisterActivity.this, "Invalid Password!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        binding.loginRrdirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}