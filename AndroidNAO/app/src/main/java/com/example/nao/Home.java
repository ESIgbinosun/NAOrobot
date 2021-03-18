/**
 * Homepage view
 *
 * Date   25-02-2021
 * Author Diego Brandjes
 */

package com.example.nao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.eclipse.paho.client.mqttv3.MqttClient;

import java.util.Observable;

public class Home extends AppCompatActivity {

    MqttClient client;
    Mqtt mqtt = new Mqtt(client);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mqtt.makeClient();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Bundle extra = getIntent().getExtras();
        if(extra != null){
            String usernaam = extra.getString("KEY");
            TextView welkom = findViewById(R.id.showNaam);
            String upperString = usernaam.substring(0, 1).toUpperCase() + usernaam.substring(1).toLowerCase();

            welkom.setText("Hallo " + upperString);
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


    public void connect (View v) throws Exception {
        mqtt.publishMSG("connect");
    }

    public void oefeningArmen (View v) throws Exception {
        mqtt.publishMSG("oefeningarmen");
    }

    public void testMsg (View v) throws Exception {
        mqtt.publishMSG("testmsg");
    }

    public void layOnBack (View v) throws Exception {
        mqtt.publishMSG("layonback");
    }

    public void oefeningBenen (View v) throws Exception {
        mqtt.publishMSG("benenworkout");
    }

    public void stand (View v) throws Exception {
        mqtt.publishMSG("stand");
    }
}