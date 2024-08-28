package com.example.sampleapplications;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSON_Parsing extends AppCompatActivity {
    public static final String JSON_STRING = "{\"employee\":{\"name\":\"Murali\",\"salary\":60000}}";
    TextView textViewResult1, textView1, textViewHeading, textViewJSON;
    EditText et_Input;
    Button buttonResult, buttonParseJSON;
    String strJson = "{ \"Employee\" :[{\"id\":\"1\",\"name\":\"murali krishna\",\"salary\":\"50000\"},{\"id\":\"2\",\"name\":\"leela\",\"salary\":\"60000\"}] }";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_parsing);
        updateXML();
        buttonParseJSON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 /* try{
            JSONObject emp=(new JSONObject(JSON_STRING)).getJSONObject("employee");
            String empname=emp.getString("name");
            int empsalary=emp.getInt("salary");

            String str="Employee Name:"+empname+"\n"+"Employee Salary:"+empsalary;
            textView1.setText(str);

        }catch (Exception e) {e.printStackTrace();}*/


                String data = "";
                try {
                    // Create the root JSONObject from the JSON string.
                    JSONObject jsonRootObject = new JSONObject(strJson);

                    //Get the instance of JSONArray that contains JSONObjects
                    JSONArray jsonArray = jsonRootObject.optJSONArray("Employee");

                    //Iterate the jsonArray and print the info of JSONObjects
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);

                        int id = Integer.parseInt(jsonObject.optString("id"));
                        String name = jsonObject.optString("name");
                        float salary = Float.parseFloat(jsonObject.optString("salary"));

                        data += "Node" + i + " : \n id= " + id + " \n Name= " + name + " \n Salary= " + salary + " \n ";
                    }
                    textView1.setText(data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_Input.getText().toString().equals("")) {
                    Message.message(getApplicationContext(), "Number Field is empty. Enter Any Number ");
                } else {
                    //String reversal code :::::

                    String str = "";
                    String str_Reverse = "";
                    str = et_Input.getText().toString();
                    for (int i = 0; i < str.length(); i++) {
                        str_Reverse += str.charAt(str.length() - 1 - i);
                    }
                    textViewResult1.setText(str_Reverse);

                    //String reversal code end:::::

                    // reversal of interger and returning array of ints and appending the all to string and display
                 /*
                    int[] data = AndroidUtils.stringToReversedIntArray(et_Input.getText().toString());
                    String str = "";
                    for(int i=0;i<data.length;i++){
                        str+=data[i];
                    }
                   // textViewResult1.setText(""+str);
                    textViewResult1.setText(AndroidUtils.getQuotedString(str));*/
                }

            }
        });


    }

    private void updateXML() {
        textView1 = (TextView) findViewById(R.id.textView1);
        textViewHeading = (TextView) findViewById(R.id.textViewHeading);
        textViewResult1 = (TextView) findViewById(R.id.textViewResult1);
        textViewJSON = (TextView) findViewById(R.id.textViewJSON);
        et_Input = (EditText) findViewById(R.id.editTextInput);
        buttonResult = (Button) findViewById(R.id.buttonResult);
        buttonParseJSON = (Button) findViewById(R.id.buttonParseJSON);
        textViewHeading.setText(getIntent().getStringExtra("getHeading"));
        textViewJSON.setText(strJson);
    }

}
