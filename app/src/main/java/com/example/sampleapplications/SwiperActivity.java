package com.example.sampleapplications;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SwiperActivity extends AppCompatActivity {

    private ImageView swipeButton;
    private TextView swipeText;
    private float initialX;
    private float dX;
    private boolean isSwiped;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_acitivity);

        swipeButton = findViewById(R.id.swipeButton);
        swipeText = findViewById(R.id.swipeText);
        View swipeButtonBackground = findViewById(R.id.swipeButtonBackground);

        swipeButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = swipeButton.getX();
                        dX = swipeButton.getX() - event.getRawX();
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        float newX = event.getRawX() + dX;

                        // Constrain the swipe button within the bounds of the background
                        if (newX > initialX && newX + swipeButton.getWidth() < swipeButtonBackground.getWidth()) {
                            swipeButton.setX(newX);
                        }
                        return true;

                    case MotionEvent.ACTION_UP:
                        // Check if swipe is successful (button moved at least 70% of the way)
                        if (swipeButton.getX() > swipeButtonBackground.getWidth() * 0.7) {
                            // Do something on successful swipe
                            swipeText.setText("Confirmed");
                            isSwiped = true;
                            if (isSwiped) {
                                Intent intent1 = new Intent(SwiperActivity.this, MainActivity.class);
                                startActivity(intent1);
                            } else {
                                Toast.makeText(SwiperActivity.this, "Swipe till End to get Main Activity.", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            // Reset position if not fully swiped
                            swipeButton.animate().x(initialX).setDuration(200).start();
                        }
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Reset swipe button position and text when the activity resumes
        swipeButton.setX(initialX);
        swipeText.setText("Swipe to Login");
    }
}

