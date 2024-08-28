package com.example.sampleapplications;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

public class ImageScroll extends AppCompatActivity {
    private static final String URL = "https://api.github.com/users";
    GridView coursesGV;
    VolleyDO[] users;
    ArrayList<CourseModel> courseModelArrayList = new ArrayList<CourseModel>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_scroll);
        coursesGV = findViewById(R.id.idGVcourses);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        String json = "";

        StringRequest request = new StringRequest(URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                users = gson.fromJson(response, VolleyDO[].class);
                //  recyclerView_Image.setAdapter(new GitHubAdapter(GSON_Activity.this,users));
                Log.d("Code", response);
                for (int i = 0; i < users.length - 1; i++) {
                    //courseModelArrayList.add(new CourseModel(users[i].getId().toString(), R.drawable.ic_home_foreground));
                    courseModelArrayList.add(new CourseModel(users[i].getId().toString(), users[i].getAvatarUrl()));
                }
                CourseGVAdapter adapter = new CourseGVAdapter(ImageScroll.this, courseModelArrayList);
                coursesGV.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                // Toast.makeText(GSON_Activity.this, "Error Response:" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);
      /*  try {
            JSONObject obj = new JSONObject(Arrays.toString(users));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }*/
      /*  for(int i=0;i<users.length;i++){
    //courseModelArrayList.clear();

}*/
      /*  GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();

        json = gson.toJson(users);
        try {
            JSONObject obj = new JSONObject(response);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }*/
      /*  for (int i = 0; i < users.length-1; i++) {
            courseModelArrayList.add(new CourseModel(users[i].getId().toString(), R.drawable.ic_home_foreground));

        }*/


/*        courseModelArrayList.add(new CourseModel("DSA", R.drawable.ic_home_foreground));
        courseModelArrayList.add(new CourseModel("JAVA", R.drawable.ic_home_foreground));
        courseModelArrayList.add(new CourseModel("C++", R.drawable.ic_home_foreground));
        courseModelArrayList.add(new CourseModel("Python", R.drawable.ic_home_foreground));
        courseModelArrayList.add(new CourseModel("Javascript", R.drawable.ic_home_foreground));
        courseModelArrayList.add(new CourseModel("DSA", R.drawable.ic_home_foreground));*/


    }
}