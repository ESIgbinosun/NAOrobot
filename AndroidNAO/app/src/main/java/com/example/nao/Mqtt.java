/**
 * MQTT app
 *
 * Date   14-05-2021
 * Author Diego Brandjes
 * FINAL
 */

package com.example.nao;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("Registered")
public class Mqtt<IMessageCallback> extends AppCompatActivity {
    private static final String TAG = "s";
    MqttClient client;
    private static final String CONNECTION_URL = "tcp://mqtt.hva-robots.nl:1883";
    private static final String SUBSCRIPTION = "brandjd1";
    private static final String USERNAME = "brandjd1";
    private static final String PASSWORD = "qVlPNohG5wWSUwfBi9Xz";
    MemoryPersistence persistence = new MemoryPersistence();
    private List<IMessageCallback> mMessageCallbacksList = new ArrayList<>();
    Context context = this;
    boolean read = false;


    public Mqtt(MqttClient client) {
        this.client = client;
    }

    public void setRead(boolean read)
    {
        this.read = read;
    }
    public void makeClient(){
        try {
            client = new MqttClient(CONNECTION_URL, "AppNAO", persistence);

            MqttConnectOptions connOpts = setUpConnectionOptions(USERNAME, PASSWORD);
            client.connect(connOpts);

            client.subscribe(SUBSCRIPTION, 1);
            client.publish(SUBSCRIPTION, "Connection established".getBytes(), 0, false);

        } catch (MqttException e) {
            System.out.println(e);
            Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
        }

        client.setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable cause) {
                Log.i(TAG, "connection lost");
            }

            @Override
            public void messageArrived(String topic, MqttMessage message) throws Exception {
                Log.i(TAG, "topic: " + topic + ", msg: " + new String(message.getPayload()));
                Log.i(TAG, String.valueOf((new String(message.getPayload()) == "cont")));
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
                Log.i(TAG, "msg delivered");
            }
        });
    }

    public MqttClient getClient()
    {
        return client;
    }
    public static MqttConnectOptions setUpConnectionOptions(String username, String password) {
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        connOpts.setUserName(username);
        connOpts.setPassword(password.toCharArray());
        return connOpts;
    }

    public void publishMSG(String msg){
        try {
            client.publish(SUBSCRIPTION, msg.getBytes(), 0, false);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }


}
