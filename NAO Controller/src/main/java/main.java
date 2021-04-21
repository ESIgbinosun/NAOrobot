/*
 * Controller code Nao robot
 *
 * Author: Diego Brandjes
 * Class: IT101
 * Date: 09-03-2021
 * Edit Date:  17-04-2021
 */

public class main {


    public static void main(String[] args) throws Exception {

        // Calling classes, used for MQTT functions & NAO functions.
        mqtt mqtt = new mqtt();
        BaseFunctions baseFunctions = new BaseFunctions();

        while (true) {
            //  ONE TIME ONLY, connectiong to NAO.
            try {
                // Change hostname when using a physical robot.
                // "padrick.robot.hva-robots.nl"
                baseFunctions.connect("localhost", 9559);
                Thread.sleep(2000);
                break;
            } catch (Exception e) {
                System.out.println("Connection to NAO could not be made, Trying again in 5 seconds.");
                Thread.sleep(5000);
            }
        }

        // Endless loop checking for input from received messages Mqtt.java.
        while (true) {

            // Speak function directly from app, text to speech on NAO.
            String input = mqtt.readMsg().toLowerCase();
            if (input.startsWith("speak")) {

                char array[] = input.toCharArray();
                char leeg[] = new char[array.length];

                for (int i = 5; i < array.length; i++) {
                    leeg[i] = array[i];
                }

                String iets = String.valueOf(leeg);
                System.out.println(iets);
                baseFunctions.speak(iets);
                input = "";
            }

            switch (mqtt.readMsg().toLowerCase()) {

                // testMsg, used for checking connection.
                case "testmsg":
                    System.out.println("Working!");
                    baseFunctions.test();
                    break;

                case "oefeningarmen":

                    baseFunctions.armWorkout(4);
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
                    baseFunctions.legWorkout(5);
                    System.out.println("Benen workout uitgevoerd.");
                    break;

                /*
                 * Be sure to add the filepaths to the songs uploaded on the robot
                 * if this isn't done there is a chance the controller code might crash
                 * because it can't find the file.
                 */
                case "songa":
                    //Change filepath when using a physical robot!
                    try {
                        baseFunctions.play("C:\\Users\\Caprisun\\AppData\\Local\\Temp\\Untitledv86UUJY\\wavw.wav");
                        System.out.println("Play uitgevoerd.");
                    } finally {
                    }
                    break;

                case "songb":
                    //Change filepath when using a physical robot!
                    try {
                        baseFunctions.play("song2");
                        System.out.println("Play2 uitgevoerd.");
                    } finally {
                    }
                    break;

                case "songc":
                    //Change filepath when using a physical robot!
                    try {
                        baseFunctions.play("song3");
                        System.out.println("Play3 uitgevoerd.");
                    } finally {
                    }
                    break;

                case "pause":
                    baseFunctions.stopPlaying(1);
                    break;


                default:
            }
        }
    }
}


