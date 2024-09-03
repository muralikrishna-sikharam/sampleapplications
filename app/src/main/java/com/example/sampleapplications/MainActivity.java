package com.example.sampleapplications;

import android.content.Intent;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button but_SplitifyLogin, but_MarghLogin, but_JSON_Parsing, but_GSON, but_NotificationExample, button_Sprakles,
            but_PhonePayScanner, but_BatteryPercentage, but_TorchLight, button_OneDrive, but_Retrofit, but_CrudOperations, but_Basic_Maths_Activity, but_WhatsApp, but_Call, button_Video_View_Activity, button_image_View_Activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but_SplitifyLogin = findViewById(R.id.but_SplitifyLogin);
        but_MarghLogin = findViewById(R.id.but_MarghLogin);
        but_GSON = findViewById(R.id.but_GSON);
        but_JSON_Parsing = findViewById(R.id.but_JSON_Parsing);
        but_NotificationExample = findViewById(R.id.but_NotificationExample);
        but_Retrofit = findViewById(R.id.but_Retrofit);
        but_CrudOperations = findViewById(R.id.but_CrudOperations);
        but_Basic_Maths_Activity = findViewById(R.id.but_Basic_Maths_Activity);
        but_Call = findViewById(R.id.but_Calculations);
        but_WhatsApp = findViewById(R.id.but_WhatsApp);
        button_Video_View_Activity = findViewById(R.id.button_Video_View_Activity);
        button_image_View_Activity = findViewById(R.id.button_image_View_Activity);
        button_Sprakles = findViewById(R.id.button_Sprakles);
        button_OneDrive = findViewById(R.id.button_OneDrive);
        but_TorchLight = findViewById(R.id.but_TorchLight);
        but_BatteryPercentage = findViewById(R.id.but_BatteryPercentage);
        but_PhonePayScanner = findViewById(R.id.but_PhonePayScanner);
        but_PhonePayScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, PhonePeScanner.class);
                startActivity(intent1);
            }
        });
        but_BatteryPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BatteryManager bm = (BatteryManager) getSystemService(BATTERY_SERVICE);
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    int percentage = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
                    Toast.makeText(MainActivity.this, "Battery Percentage is " + percentage + " %", Toast.LENGTH_SHORT).show();
                    //  text.setText("Battery Percentage is "+percentage+" %");
                } else {
                    Toast.makeText(MainActivity.this, "Need Android 5+ version to show battery percentage", Toast.LENGTH_SHORT).show();
                }
               /* Intent intent1 = new Intent(MainActivity.this, MainLoginFingerPrint.class);
                startActivity(intent1);*/
            }
        });
        but_TorchLight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, TorchLightActivity.class);
                startActivity(intent1);
            }
        });
        button_OneDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent intent1 = new Intent(MainActivity.this, OneDriveSort.class);
                Intent intent1 = new Intent(MainActivity.this, SwiperActivity.class);
                startActivity(intent1);
            }
        });
        button_Sprakles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Sparkles.class);
                startActivity(intent1);
            }
        });
        button_image_View_Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, ImageViewKotlin.class);
                startActivity(intent1);
            }
        });
        button_Video_View_Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, VideoViewActivity.class);
                startActivity(intent1);
            }
        });
        but_WhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                startActivity(intent1);
            }
        });
        but_Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, Basic_Calculations.class);
                startActivity(intent1);
            }
        });
       /* String appPackage="";
        if (isAppInstalled(ctx, "com.whatsapp.w4b")) {
            appPackage = "com.whatsapp.w4b";
            //do ...
        } else if (isAppInstalled(ctx, "com.whatsapp")) {
            appPackage = "com.whatsapp";
            //do ...
        } else {
            Toast.makeText(ctx, "whatsApp is not installed", Toast.LENGTH_LONG).show();
        }

        private boolean isAppInstalled(Context ctx, String packageName) {
            PackageManager pm = ctx.getPackageManager();
            boolean app_installed;
            try {
                pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
                app_installed = true;
            } catch (PackageManager.NameNotFoundException e) {
                app_installed = false;
            }
            return app_installed;
        }*/
        but_JSON_Parsing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, JSON_Parsing.class);
                startActivity(intent);
            }
        });
        but_CrudOperations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Crud_Operations.class);
                startActivity(intent);
            }
        });
        but_Basic_Maths_Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Basic_Maths_Activity.class);
                startActivity(intent);
            }
        });


        but_GSON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GSON_Activity.class);
                startActivity(intent);
            }
        });
        but_Retrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RetrofitExample.class);
                startActivity(intent);
            }
        });
        but_NotificationExample.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NotificationExample.class);
                startActivity(intent);
            }
        });
        but_SplitifyLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SplitifyLogin.class);
                startActivity(intent);
            }
        });
        but_MarghLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Margh_Login.class);
                startActivity(intent);
            }
        });
    }

    /* @Override
     protected void onStop() {
         super.onStop();
         Intent intent = new Intent(this, ToastService.class);
         startService(intent);
     }*/
    @Override
    public void onBackPressed() {
        // Display a toast message when the back button is pressed
        Toast.makeText(this, "Back button pressed", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
       /* Intent intent = new Intent(MainActivity.this, SwiperActivity.class);
        startActivity(intent);*/
    }

}