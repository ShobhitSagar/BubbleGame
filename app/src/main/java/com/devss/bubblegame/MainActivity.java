package com.devss.bubblegame;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

//

public class MainActivity extends AppCompatActivity {

    ImageView bubble;
    Handler handler = new Handler();
    int width, height, score = 0;
    TextView scoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        width = displayMetrics.widthPixels;
        height = displayMetrics.heightPixels;

        bubble = findViewById(R.id.bubble);
        scoreView = findViewById(R.id.score);

        bubble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score = score + 1;
            }
        });

        handler.post(mRunnable);

    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {

            int x = new Random().nextInt(width - 60);
            int y = new Random().nextInt(height - 80);

            bubble.setX(x);
            bubble.setY(y);

            scoreView.setText("Score : "+score);

            handler.postDelayed(this, 700-score);

        }
    };
}