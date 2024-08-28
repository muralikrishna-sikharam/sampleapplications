package com.example.sampleapplications;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SplitifyLogin extends AppCompatActivity {
    Button but_Login_Splitify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splitify_login);
        but_Login_Splitify = findViewById(R.id.but_Login_Splitify);
        but_Login_Splitify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplitifyLogin.this, SplitifyHistoryPage.class);
                startActivity(intent);
            }
        });
    }
}