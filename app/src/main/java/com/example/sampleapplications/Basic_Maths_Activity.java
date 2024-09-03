package com.example.sampleapplications;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Random;

public class Basic_Maths_Activity extends AppCompatActivity implements View.OnClickListener {
    final int min = 20;
    final int max = 80;
    TextView tv_display, tv_Number1, tv_Number2, tv_TotalResult_Positive, tv_TotalResult_Negative, tv_Result;
    Button but_Positive, but_Negative, but_Reclerview;
    RecyclerView rv_RecyclerView;
    int positiveResult = 0, negativeResult = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_maths);
        updateXML();
    }

    private void updateXML() {
        tv_display = findViewById(R.id.tv_nextDisplay);
        tv_Number1 = findViewById(R.id.tv_Number1);
        tv_Number2 = findViewById(R.id.tv_Number2);
        tv_TotalResult_Positive = findViewById(R.id.tv_TotalResult_Positive);
        tv_TotalResult_Negative = findViewById(R.id.tv_TotalResult_Negative);
        tv_Result = findViewById(R.id.tv_Result);
        but_Negative = findViewById(R.id.but_result_negative);
        but_Positive = findViewById(R.id.but_result_positive);
        but_Reclerview = findViewById(R.id.but_Reclerview);
        but_Positive = findViewById(R.id.but_result_positive);
        rv_RecyclerView = findViewById(R.id.rv_RecyclerView);
        but_Positive.setOnClickListener(this);
        but_Negative.setOnClickListener(this);
        but_Reclerview.setOnClickListener(this);
        String str_Intent = getIntent().getStringExtra("getName");
        tv_display.setText(str_Intent);
//        getResultFromRandomNumbers();
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.but_result_positive) {
            getResultFromRandomNumbers();
            positiveResult++;
            tv_TotalResult_Positive.setText(String.valueOf(positiveResult));
        }
        if (v.getId() == R.id.but_result_negative) {
            getResultFromRandomNumbers();
            negativeResult++;
            tv_TotalResult_Negative.setText(String.valueOf(negativeResult));
        }
        if (v.getId() == R.id.but_Reclerview) {
            rv_RecyclerView.setLayoutManager(new LinearLayoutManager(this));
            int size = 100;
            String[] abc = new String[size];
            for (int i = 0; i < size; i++) {
                abc[i] = String.valueOf(i);
            }
            rv_RecyclerView.setAdapter(new ProgrammingAdapter(abc));
        }
    }

    private void getResultFromRandomNumbers() {
        final int random1 = new Random().nextInt((max - min) + 1) + min;
        final int random2 = new Random().nextInt((max - min) + 1) + min;
        tv_Number1.setText(String.valueOf(random1));
        tv_Number2.setText(String.valueOf(random2));
        tv_Result.setText(String.valueOf(Integer.parseInt(tv_Number1.getText().toString()) + Integer.parseInt(tv_Number2.getText().toString())));
    }
}