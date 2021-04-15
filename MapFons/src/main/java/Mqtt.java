import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Mqtt {

    MqttClient client;
    private static final String CONNECTION_URL = "tcp://mqtt.hva-robots.nl:1883";
    private static final String SUBSCRIPTION = "langef5";
    private static final String USERNAME = "langef5";
    private static final String PASSWORD = "QJq4Ey2M7kCLYTWkOlG6";
    MemoryPersistence persistence = new MemoryPersistence();

    String msg = "";

    Mqtt() {

        try {
            client = new MqttClient(CONNECTION_URL, "testingMyMQTT", persistence);

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
            client.publish(SUBSCRIPTION, "sdf".getBytes(), 0, false);
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

    public void publish() {
        String msg = "Hello";
        try {
            client.publish(SUBSCRIPTION, msg.getBytes(), 0, false);
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }
}
