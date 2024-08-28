package com.example.sampleapplications;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class GSON_Activity extends AppCompatActivity {
    private static final String URL = "https://api.github.com/users";
    RecyclerView recyclerView_Image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        recyclerView_Image = (RecyclerView) findViewById(R.id.rv_RecyclerView_Image);
        recyclerView_Image.setLayoutManager(new LinearLayoutManager(this));
        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                VolleyDO[] users = gson.fromJson(response, VolleyDO[].class);
                recyclerView_Image.setAdapter(new GitHubAdapter(GSON_Activity.this, users));
                Log.d("Code", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(GSON_Activity.this, "Error Response:" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }
}