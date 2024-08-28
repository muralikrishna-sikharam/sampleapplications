package com.example.sampleapplications;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Margh_Profile extends AppCompatActivity {
    TextView tv_LoginUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_margh_profile);
        tv_LoginUserName = findViewById(R.id.tv_LoginUserName);
        tv_LoginUserName.setText("Muralikrishna");
    }
}