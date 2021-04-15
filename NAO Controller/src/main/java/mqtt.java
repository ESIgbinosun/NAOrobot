/*
 * Receiving end MQTT server
 *
 * Author: Diego Brandjes
 * Class: IT101
 * Date: 09-03-2021
 * Edit Date:  15-04-2021
 */

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class mqtt {

    // Starting client & assigning values to passwords and usernames.
    MqttClient client;
    private static final String CONNECTION_URL = "tcp://mqtt.hva-robots.nl:1883";
    private static final String SUBSCRIPTION = "brandjd1";
    private static final String USERNAME = "brandjd1";
    private static final String PASSWORD = "qVlPNohG5wWSUwfBi9Xz";
    MemoryPersistence persistence = new MemoryPersistence();
    String msg = "";

    // Connecting to server
    mqtt() {

        try {
            // Client ID needs to be unique for every instance.
            client = new MqttClient(CONNECTION_URL, "ReceivingNAO", persistence);

            MqttConnectOptions connOpts = setUpConnectionOptions(USERNAME, PASSWORD);
            client.connect(connOpts);

            client.setCallback(new MqttCallback() {
                public void connectionLost(Throwable cause) {
                }

                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    msg = message.toString();
                    // Shows incoming messages in console.
                    System.out.println(message.toString());
                }

                public void deliveryComplete(IMqttDeliveryToken token) {
                }
            });

            client.subscribe(SUBSCRIPTION, 1);
        } catch (MqttException e) {
            System.out.println("Error at Connection MQTT");
        }
    }

    private static MqttConnectOptions setUpConnectionOptions(String username, String password) {
        MqttConnectOptions connOpts = new MqttConnectOptions();
        connOpts.setCleanSession(true);
        connOpts.setUserName(username);
        connOpts.setPassword(password.toCharArray());
        return connOpts;
    }

    // Received messages will be put in a string, the string will be cleared to
    // prevent reoccurring messages.
    public String readMsg() {
        String test = msg;
        msg = "";
        return test;
    }

    // Unused publish code, use this for sending logs or info to the server.
    public void publish(String input) {

        String msg = input;
        try {
            client.publish(SUBSCRIPTION, msg.getBytes(), 0, false);
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }
}
