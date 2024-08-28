package com.example.sampleapplications;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class CallNumber extends AppCompatActivity implements View.OnClickListener {
    EditText et_ResultNumber;
    Button but_Result_Plus, but_Reset;
    TextView tv_No1, tv_No2, tv_Result_WrongAnswer, tv_Result_CorrectAnswer, tv_Total_AnsweredQuestions;
    int countCorrect = 0, countWrong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_number);
        //Getting the edittext and button instance
        et_ResultNumber = (EditText) findViewById(R.id.et_ResultNumber);
        tv_No1 = (TextView) findViewById(R.id.tv_Number1);
        tv_No2 = (TextView) findViewById(R.id.tv_Number2);
        tv_Result_CorrectAnswer = (TextView) findViewById(R.id.tv_Result_CorrectAnswer);
        tv_Result_WrongAnswer = (TextView) findViewById(R.id.tv_Result_WrongAnswer);
        tv_Total_AnsweredQuestions = (TextView) findViewById(R.id.tv_Total_AnsweredQuestions);
        but_Result_Plus = (Button) findViewById(R.id.but_Result_Plus);
        but_Reset = (Button) findViewById(R.id.but_Reset);
        fun_SetRandomNumbers();
        but_Reset.setOnClickListener(this);
        but_Result_Plus.setOnClickListener(this);

        //Performing action on button click
    /*    but_Result_Plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {



            }

        });
        but_Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {


            }

        });*/

    }

    private boolean calculateResult() {
        boolean result = Integer.parseInt(tv_No1.getText().toString()) * Integer.parseInt(tv_No2.getText().toString()) ==
                Integer.parseInt(et_ResultNumber.getText().toString());
        return result;
    }

    private void fun_SetRandomNumbers() {
        Random rand = new Random();
        int random1 = rand.nextInt(21);
        int random2 = rand.nextInt(21);

        if (random1 >= 10) {
            random2 = rand.nextInt(11);
        }
        if (random2 > 10) {
            tv_No1.setText(String.valueOf(random2));
            tv_No2.setText(String.valueOf(random1));
        } else {
            tv_No1.setText(String.valueOf(random1));
            tv_No2.setText(String.valueOf(random2));
        }


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.but_Result_Plus) {
            if (et_ResultNumber.getText().toString().equals("")) {
                Message.message(getApplicationContext(), "Enter Answer Field");
            } else {

                boolean b = calculateResult();
                if (b) {
                    countCorrect++;
                } else {
                    countWrong++;
                }
                tv_Result_CorrectAnswer.setText(String.valueOf(countCorrect));
                tv_Result_WrongAnswer.setText(String.valueOf(countWrong));
                tv_Total_AnsweredQuestions.setText(String.valueOf(Integer.parseInt(tv_Result_CorrectAnswer.getText().toString()) +
                        Integer.parseInt(tv_Result_WrongAnswer.getText().toString())));
                et_ResultNumber.setText("");
                fun_SetRandomNumbers();

            }
        }
        if (view.getId() == R.id.but_Reset) {

            countCorrect = 0;
            countWrong = 0;
            et_ResultNumber.setText("");
            tv_Result_CorrectAnswer.setText("");
            tv_Result_WrongAnswer.setText("");
            tv_Total_AnsweredQuestions.setText("");
            fun_SetRandomNumbers();
        }
    }
}