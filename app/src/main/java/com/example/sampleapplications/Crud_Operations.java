package com.example.sampleapplications;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Crud_Operations extends AppCompatActivity {

    EditText Name, Pass, update_old, update_new, delete;
    DBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        Name = (EditText) findViewById(R.id.editName);
        Pass = (EditText) findViewById(R.id.editPass);
        update_old = (EditText) findViewById(R.id.editText3);
        update_new = (EditText) findViewById(R.id.editText5);
        delete = (EditText) findViewById(R.id.editText6);

        helper = new DBHelper(this);
    }

    public void addUser(View view) {
        String t1 = Name.getText().toString();
        String t2 = Pass.getText().toString();
        if (t1.isEmpty() || t2.isEmpty()) {
            Message.message(getApplicationContext(), "Enter Both Name and Password");
        } else {
            long id = helper.insertData(t1, t2);
            if (id <= 0) {
                Message.message(getApplicationContext(), "Insertion Unsuccessful");
            } else {
                Message.message(getApplicationContext(), "Insertion Successful");
            }
            Name.setText("");
            Pass.setText("");
        }
    }

    public void viewdata(View view) {
        String data = helper.getData();
        Message.message(this, data);
    }

    public void update(View view) {
        String u1 = update_old.getText().toString();
        String u2 = update_new.getText().toString();
        if (u1.isEmpty() || u2.isEmpty()) {
            Message.message(getApplicationContext(), "Enter Data");
        } else {
            int a = helper.updateName(u1, u2);
            if (a <= 0) {
                Message.message(getApplicationContext(), "Unsuccessful");
            } else {
                Message.message(getApplicationContext(), "Updated");
            }
            update_old.setText("");
            update_new.setText("");
        }

    }

    public void delete(View view) {
        String uname = delete.getText().toString();
        if (uname.isEmpty()) {
            Message.message(getApplicationContext(), "Enter Data");
        } else {
            int a = helper.delete(uname);
            if (a <= 0) {
                Message.message(getApplicationContext(), "Unsuccessful");
                delete.setText("");
            } else {
                Message.message(this, "DELETED");
                delete.setText("");
            }
        }
    }
}