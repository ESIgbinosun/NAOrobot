package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import org.eclipse.paho.client.mqttv3.MqttClient;

public class WorkoutActivity extends AppCompatActivity {

    //make mqtt client
    MqttClient client;
    Mqtt mqtt = new Mqtt(client);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_workout);
        mqtt.makeClient();
        try {
            Thread.sleep(3000);
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


    //function to start the leg workout
    public void WORKOUT1(View v){
        mqtt.publishMSG("langef5","benenoefening");
    }
    //function to start the arm workout
    public void WORKOUT2(View v) { mqtt.publishMSG("langef5","armenoefening"); }
    //function to start a test workout
    public void WORKOUT3(View v) { mqtt.publishMSG("langef5","oplevering"); }
}