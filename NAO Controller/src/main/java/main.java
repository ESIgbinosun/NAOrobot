/*
 * Controller code Nao robot
 *
 * Author: Diego Brandjes
 * Class: IT101
 * Date: 09-03-2021
 */

public class main {

    public static void main(String[] args) throws Exception {

        // Calling classes, used for MQTT functions & NAO functions.
        mqtt mqtt = new mqtt();
        BaseFunctions baseFunctions = new BaseFunctions();
        Workouts workouts = new Workouts();

        //  ONE TIME ONLY, connectiong to NAO.
        try {
            // Change hostname when using a physical robot.
            baseFunctions.connect("localhost", 9559);
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Connection to NAO could not be made, to try again restart the code.");
        }

        // Endless loop checking for input from received messages Mqtt.
        while (true) {

            switch (mqtt.readMsg().toLowerCase()) {

                // testMsg, used for checking connection.
                case "testmsg":
                    System.out.println("Working!");

                    break;

                case "oefeningarmen":
                    workouts.armWorkout(4);
                    System.out.println("Armen workout uitgevoerd.");

                    break;

                case "walk":
                    baseFunctions.walk(1f, 0f, 0f);
                    System.out.println("Walk uitgevoerd.");
                    break;

                case "layonback":
                    baseFunctions.layOnBack();
                    System.out.println("LayOnBack uitgevoerd.");

                    break;

                case "stand":
                    baseFunctions.stand();
                    System.out.println("Stand uitgevoerd.");

                    break;

                case "benenworkout":
                    workouts.legWorkout(5);
                    System.out.println("Benen workout uitgevoerd.");

                    break;

                default:
            }
        }
    }
}


