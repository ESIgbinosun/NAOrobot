/*
 * Controller code Nao robot
 *
 * Author: Diego Brandjes
 * Class: IT101
 * Date: 09-03-2021
 */

import java.util.Scanner;

public class main {

    public static void main(String[] args) throws Exception {

        // Calling classes, used for MQTT functions & NAO functions.
        mqtt mqtt = new mqtt();
        NAO nao = new NAO();


        //  ONE TIME ONLY, connectiong to NAO.
        try {
            // Change hostname when using a physical robot.
            nao.connect("localhost", 9559);
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
                    nao.armWorkout(4);
                    System.out.println("Armen workout uitgevoerd.");

                    break;

                case "walk":
                    nao.walk(1f, 0f, 0f);
                    System.out.println("Walk uitgevoerd.");
                    break;

                case "layonback":
                    nao.layOnBack();
                    System.out.println("LayOnBack uitgevoerd.");

                    break;

                case "stand":
                    nao.stand();
                    System.out.println("Stand uitgevoerd.");

                    break;

                case "benenworkout":
                    nao.legWorkout(5);
                    System.out.println("Benen workout uitgevoerd.");

                    break;


                default:
            }
        }
    }
}


