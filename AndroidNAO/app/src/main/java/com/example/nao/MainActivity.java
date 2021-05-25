/**
 * Start page view
 *
 * Date   17-04-2021
 * Date edited 25-05-2021
 * Author Diego Brandjes
 */

package com.example.nao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button a = findViewById(R.id.button);
        ProgressBar b = findViewById(R.id.progressBar2);
        a.setVisibility(View.INVISIBLE);

        a.postDelayed(new Runnable() {
            @Override
            public void run() {
                a.setVisibility(View.VISIBLE);
                b.setVisibility(View.INVISIBLE);
            }
        },1000);
    }

    // Fullscreen
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }
    public void launchHome(View v) {

        //removed Login intent for usability with elderly.
        Intent i = new Intent(this, Home.class);
        startActivity(i);
    }
}
