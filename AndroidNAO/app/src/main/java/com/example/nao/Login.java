/**
 * Login page view
 *
 * Date   17-04-2021
 * Date edited 25-05-2021
 * Author Diego Brandjes
 * FINAL
 */

package com.example.nao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.eclipse.paho.client.mqttv3.MqttClient;

public class Login extends AppCompatActivity {



    MqttClient client;
    Mqtt mqtt = new Mqtt(client);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mqtt.makeClient();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
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

    public void nameSafe (View v){

        Button a = findViewById(R.id.button6);
        EditText usernameEditText = (EditText) findViewById(R.id.naam);
        String usernaam = usernameEditText.getText().toString();
        if (usernaam.matches("")) {
            Toast.makeText(this, "You did not enter a username", Toast.LENGTH_SHORT).show();
            return;
        }else if (usernaam.matches("^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$")) {
            a.setText("Thank you!");
        }else {
            Toast.makeText(this, "Please enter a normal username", Toast.LENGTH_SHORT).show();
            return;
        }

        a.postDelayed(new Runnable() {
            @Override
            public void run() {}
        },3000);

        Intent i = new Intent(this, Home.class);
        i.putExtra("KEY", usernaam);
        mqtt.publishMSG("user"+ usernaam);

        startActivity(i);
    }
}