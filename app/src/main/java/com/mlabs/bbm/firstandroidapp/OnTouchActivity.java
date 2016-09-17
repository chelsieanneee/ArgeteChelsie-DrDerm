package com.mlabs.bbm.firstandroidapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by androidstudio on 03/09/16.
 */
public class OnTouchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_touch);

        final ImageView imgView = (ImageView) findViewById(R.id.imageView3);
        final String TAG = OnTouchActivity.class.getSimpleName();

        imgView.setOnTouchListener(new View.OnTouchListener() {
            float initialX, initialY, finalX, finalY;

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int event = motionEvent.getAction();
                switch (event) {
                    case MotionEvent.ACTION_DOWN:
                        initialX = motionEvent.getX();
                        initialY = motionEvent.getY();
                        Toast.makeText(getApplicationContext(), "value of X : " + initialX + "value of Y : " + initialY, Toast.LENGTH_SHORT).show();
                        return true;
                    case MotionEvent.ACTION_UP:
                        finalX = motionEvent.getX();
                        finalY = motionEvent.getY();
                        if (finalX > initialX) {
                            Toast.makeText(getApplicationContext(), "SWIPED RIGHT", Toast.LENGTH_SHORT).show();
                        }
                        if (finalX < initialX) {
                            Toast.makeText(getApplicationContext(), "SWIPED LEFT", Toast.LENGTH_SHORT).show();

                        }
                        if (finalY > initialY) {
                            Toast.makeText(getApplicationContext(), "SWIPED DOWN", Toast.LENGTH_SHORT).show();
                        }
                        if (finalX > initialX) {
                            Toast.makeText(getApplicationContext(), "SWIPED UP", Toast.LENGTH_SHORT).show();
                        }
                        return true;
                }
                        return true;
            }
        });
    }
}
