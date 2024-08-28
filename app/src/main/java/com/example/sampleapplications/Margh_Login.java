package com.example.sampleapplications;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Margh_Login extends AppCompatActivity {

    Button but_login;
    EditText et_email, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_margh_login);
        but_login = findViewById(R.id.but_Login);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        but_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_email.getText().toString().equals("") || et_password.getText().toString().equals("")) {
                    Toast.makeText(Margh_Login.this, "Email or password should not be empty.", Toast.LENGTH_SHORT).show();
                } else {
                    if (et_email.getText().toString().equals("murali@gmail.com") && et_password.getText().toString().equals("murali")) {
                        Intent intent = new Intent(Margh_Login.this, Margh_Home.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Margh_Login.this, "Email / password entered or not correct.", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}