package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import org.eclipse.paho.client.mqttv3.MqttClient;

public class SingasongActivity extends AppCompatActivity {

    //make mqtt client
    MqttClient client;
    Mqtt mqtt = new Mqtt(client);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singasong);
        mqtt.makeClient();
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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

    public void BACK(View v){
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);
    }

    //function to send mqtt message for a song
    public void SONG1(View v){
        mqtt.publishMSG("langef5","muziek1");
    }
    //function to send mqtt message for a song
    public void SONG2(View v){
        mqtt.publishMSG("langef5","muziek2");
    }
    //function to send mqtt message for a song
    public void SONG3(View v){
        mqtt.publishMSG("langef5","muziek3");
    }
    //function to send mqtt message for a song
    public void SONG4(View v){
        mqtt.publishMSG("langef5","muziek4");
    }
    //function to send mqtt message for a song
    public void SONG5(View v){
        mqtt.publishMSG("langef5","muziek5");
    }

}