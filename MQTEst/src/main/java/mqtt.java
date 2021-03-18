/*
 * Receiving end MQTT server
 *
 * Author: Diego Brandjes
 * Class: IT101
 * Date: 09-03-2021
 */

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;


public class mqtt {

    MqttClient client;
    private static final String CONNECTION_URL = "tcp://mqtt.hva-robots.nl:1883";
    private static final String SUBSCRIPTION = "brandjd1";
    private static final String USERNAME = "brandjd1";
    private static final String PASSWORD = "qVlPNohG5wWSUwfBi9Xz";
    MemoryPersistence persistence = new MemoryPersistence();

    String msg = "";

    mqtt() {

        try {
            // Client ID moet bij iedere client uniek zijn.
            client = new MqttClient(CONNECTION_URL, "ReceivingNAO", persistence);

            MqttConnectOptions connOpts = setUpConnectionOptions(USERNAME, PASSWORD);
            client.connect(connOpts);

            client.setCallback(new MqttCallback() {
                public void connectionLost(Throwable cause) {
                }

                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    msg = message.toString();
                    System.out.println(message.toString());
                }

                public void deliveryComplete(IMqttDeliveryToken token) {
                }
            });

            client.subscribe(SUBSCRIPTION, 1);
//            client.publish(SUBSCRIPTION, "sdf".getBytes(), 0, false);
        } catch (MqttException e) {
            System.out.println("Error");
        }
    }

    public String readMsg() {
        String test = msg;
        msg = "";
        return test;
    }

    private static MqttConnectOptions setUpConnectionOptions(String username, String password) {
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        connOpts.setUserName(username);
        connOpts.setPassword(password.toCharArray());
        return connOpts;
    }

    public void publish(String input) {

        String msg = input;
        try {
            client.publish(SUBSCRIPTION, msg.getBytes(), 0, false);
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }
}
