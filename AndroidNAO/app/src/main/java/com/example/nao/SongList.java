/**
 * Song list page view
 *
 * Date   17-04-2021
 * Date edited 14-05-2021
 * Author Diego Brandjes
 * FINAL
 */

package com.example.nao;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ToggleButton;

import org.eclipse.paho.client.mqttv3.MqttClient;

public class SongList extends AppCompatActivity {

    MqttClient client;
    Mqtt mqtt = new Mqtt(client);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mqtt.makeClient();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_list);


        ToggleButton a = findViewById(R.id.toggleButton);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (a.isChecked()){
                    mqtt.publishMSG("songa");
                }else {
                    mqtt.publishMSG("pause");
                }
            }
        });

        ToggleButton b = findViewById(R.id.toggleButton4);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (b.isChecked()){
                    mqtt.publishMSG("songb");
                }else {
                    mqtt.publishMSG("pause");
                }
            }
        });

        ToggleButton c = findViewById(R.id.toggleButton5);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (c.isChecked()){
                    mqtt.publishMSG("songc");
                }else {
                    mqtt.publishMSG("pause");
                }
            }
        });
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

    public void back (View v) throws Exception {
        Intent i = new Intent(this, Home.class);
        startActivity(i);
    }
}