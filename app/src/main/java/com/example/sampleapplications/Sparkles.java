package com.example.sampleapplications;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class Sparkles extends AppCompatActivity implements View.OnClickListener {
    String apiUrl = "https://richlabz.com/sparkles_app/api/servicesNames";
    ProgressDialog progressDialog;
    List<Sparkles_ServicesModel> servicesModelList = new ArrayList<>();
    TextView tv_text1, tv_text2, tv_text3, tv_text4, tv_text5, tv_text6;
    ImageView iv_Image1, iv_Image2, iv_Image3, iv_Image4, iv_Image5, iv_Image6;
    Bitmap bitMap1, bitMap2, bitMap3, bitMap4, bitMap5, bitMap6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sparkles);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.layout, new Sparkles_Home()).commit();
      /*  getData();// to pull the data from get method to load the data in schedule pickup
        updateUserInterface();// load the populated data*/
        //  updateXML();

    }

    private void updateXML() {
        tv_text1 = findViewById(R.id.tv_text1);
        tv_text2 = findViewById(R.id.tv_text2);
        tv_text3 = findViewById(R.id.tv_text3);
        tv_text4 = findViewById(R.id.tv_text4);
        tv_text5 = findViewById(R.id.tv_text5);
        tv_text6 = findViewById(R.id.tv_text6);

        iv_Image1 = findViewById(R.id.iv_pic1);
        iv_Image2 = findViewById(R.id.iv_pic2);
        iv_Image3 = findViewById(R.id.iv_pic3);
        iv_Image4 = findViewById(R.id.iv_pic4);
        iv_Image5 = findViewById(R.id.iv_pic5);
        iv_Image6 = findViewById(R.id.iv_pic6);
    }

    public void onClick(View v) {

        if (v.getId() == R.id.ll_Home) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.layout,
                            new Sparkles_Home()).commit();
        }
        if (v.getId() == R.id.ll_Schedule_PickUp) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.layout,
                            new Sparkles_Schedule_PickUp()).commit();
            getData();// to pull the data from get method to load the data in schedule pickup
            //updateUserInterface();// load the populated data
        }
        if (v.getId() == R.id.ll_RateList) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.layout,
                            new Sparkles_RateList()).commit();

        }
        if (v.getId() == R.id.ll_MyAccount) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.layout,
                            new Sparkles_MyAccount()).commit();
        }
        if (v.getId() == R.id.but_LoadDetails) {


        }

    }

    private void updateUserInterface() {
        if (servicesModelList.size() > 0) {

            updateXML();
            tv_text1.setText(servicesModelList.get(0).getService());
            tv_text2.setText(servicesModelList.get(1).getService());
            tv_text3.setText(servicesModelList.get(2).getService());
            tv_text4.setText(servicesModelList.get(3).getService());
            tv_text5.setText(servicesModelList.get(4).getService());
            tv_text6.setText(servicesModelList.get(5).getService());

            Glide.with(this).load(servicesModelList.get(0).getImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(iv_Image1);
            Glide.with(this).load(servicesModelList.get(1).getImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(iv_Image2);
            Glide.with(this).load(servicesModelList.get(2).getImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(iv_Image3);
            Glide.with(this).load(servicesModelList.get(3).getImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(iv_Image4);
            Glide.with(this).load(servicesModelList.get(4).getImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(iv_Image5);
            Glide.with(this).load(servicesModelList.get(5).getImage())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_background)
                    .into(iv_Image6);


        }


    }

    private void getData() {
        //Some url endpoint that you may have
        try {

            MyAsyncTasks myAsyncTasks = new MyAsyncTasks();
            myAsyncTasks.execute();
            updateUserInterface();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public class MyAsyncTasks extends AsyncTask<String, String, String> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // display a progress dialog for good user experiance
            progressDialog = new ProgressDialog(Sparkles.this);
            progressDialog.setMessage("Please Wait");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected String doInBackground(String... params) {

            // implement API in background and store the response in current variable
            String current = "";
            try {
                URL url;
                HttpURLConnection urlConnection = null;
                try {
                    url = new URL(apiUrl);

                    urlConnection = (HttpURLConnection) url
                            .openConnection();

                    InputStream in = urlConnection.getInputStream();

                    InputStreamReader isw = new InputStreamReader(in);

                    int data = isw.read();
                    while (data != -1) {
                        current += (char) data;
                        data = isw.read();
                        System.out.print(current);

                    }
                    // return the data to onPostExecute method
                    return current;

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
                return "Exception: " + e.getMessage();
            }
            return current;
        }

        @Override
        protected void onPostExecute(String s) {

            Log.d("data", s);

            progressDialog.dismiss();
            try {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    JSONArray servicesArray = jsonObject.getJSONArray("data");

                    for (int i = 0; i < servicesArray.length(); i++) {
                        JSONObject serviceObject = servicesArray.getJSONObject(i);
                        Sparkles_ServicesModel model = new Sparkles_ServicesModel();
                        model.setId(serviceObject.getString("id"));
                        model.setService(serviceObject.getString("service"));
                        model.setImage(serviceObject.getString("image"));
                        model.setPosition(serviceObject.getString("position"));
                        model.setAdded_on(serviceObject.getString("added_on"));
                        model.setStatus(serviceObject.getString("status"));
                        model.setAddedOn(serviceObject.getString("addedOn"));
                        servicesModelList.add(model);
                    }
                    updateUserInterface();

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }


        }

    }
}


