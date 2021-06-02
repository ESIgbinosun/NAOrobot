package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

import org.eclipse.paho.client.mqttv3.MqttClient;

public class MainActivity extends AppCompatActivity {

    //make mqtt client
    MqttClient client;
    Mqtt mqtt = new Mqtt(client);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    //function to go to the about us activity
    public void ABOUTUSPAGE(View v){
        Intent aboutus = new Intent(this, AboutusActivity.class);
        startActivity(aboutus);
    }

    //function to go to the workout activity
    public void WORKOUTPAGE(View v){
        Intent workout = new Intent(this, WorkoutActivity.class);
        startActivity(workout);
        mqtt.publishMSG("langef5","workoutpage");
    }

    //function to go to the conversation activity
    public void CONVERSATIONPAGE(View v){
        Intent conversation = new Intent(this, ConversationActivity.class);
        startActivity(conversation);
        mqtt.publishMSG("langef5","newspage");
    }

    //function to go to the song activity
    public void SONGPAGE(View v){
        Intent singasong = new Intent(this, SingasongActivity.class);
        startActivity(singasong);
        mqtt.publishMSG("langef5","songpage");
    }
}