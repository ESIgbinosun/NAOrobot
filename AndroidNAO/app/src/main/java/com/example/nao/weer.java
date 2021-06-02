/**
 * Weer page view
 *
 * Date   17-04-2021
 * Date edited 14-05-2021
 * Author Diego Brandjes
 * FINAL
 */

//FINAL

package com.example.nao;

import androidx.appcompat.app.AppCompatActivity;
import org.eclipse.paho.client.mqttv3.MqttClient;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class weer extends AppCompatActivity {


    MqttClient client;
    Mqtt mqtt = new Mqtt(client);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mqtt.makeClient();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weer);

    }
    // Enables Fullscreen
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

    /**
     * Sends a string via MQTT, this string is used for an API
     * on the receiving side.
     */
    public void amsterdam (View v) throws Exception {
        mqtt.publishMSG("amsterdam");
    }

    public void maastricht (View v) throws Exception {
        mqtt.publishMSG("maastricht");
    }
}
