/*
 * Controller code Nao robot
 *
 * Author: Diego Brandjes
 * Class: IT101
 * Date: 09-03-2021
 * Edit Date:  13-05-2021
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class main extends BaseFunctions {


    // Change hostname when using a physical robot.
    // "padrick.robot.hva-robots.nl"
    public static final String DATEFORMAT = "dd-MM-yyyy HH:mm:ss";
    public static final String HOSTNAME = "localhost";
    public static final int PORT = 9559;



    public static void main(String[] args) throws Exception {

        // Function for getting the current date and time.
        SimpleDateFormat format = new SimpleDateFormat(DATEFORMAT);
        Date date = new Date();

        // Calling classes, used for MQTT functions & NAO functions.
        mqtt mqtt = new mqtt();
        BaseFunctions baseFunctions = new BaseFunctions();

        //  Keeps trying to start connection with the NAO robot/Software.
        while (true) {
            try {
                baseFunctions.connect(HOSTNAME, PORT);
                Thread.sleep(2000);
                break;
            } catch (Exception e) {
                System.out.println("Connection to NAO could not be made, Trying again in 5 seconds.");
                Thread.sleep(5000);
            }
        }
        // Only shows when the connection with NAO has been made.
        System.out.println("\nConnection has been made!\n" + "The current date is: " + format.format(date));


        // Endless loop checking for input from received messages Mqtt.java.
        while (true) {

            // Speak function directly from app, text to speech on NAO.
            String input = mqtt.readMsg().toLowerCase();
            String username = "";
            if (input.startsWith("speak")) {

                char array[] = input.toCharArray();
                char leeg[] = new char[array.length];

                for (int i = 5; i < array.length; i++) {
                    leeg[i] = array[i];
                }

                String iets = String.valueOf(leeg);
                System.out.println(iets);
                baseFunctions.speak(iets);
                Thread.sleep(1000);
                input = "";
            }

            // Getting username, MQTT is put into a string minus
            // the topic value put before the message.
            if (input.startsWith("user")){

                char array[] = input.toCharArray();
                char leeg[] = new char[array.length];

                for (int i = 4; i < array.length; i++) {
                    leeg[i] = array[i];
                }

                String iets = String.valueOf(leeg);
                username = iets;
                baseFunctions.speak("Hallo " + username);
                Thread.sleep(1000);
            }

            // Main switch case, uses input from MQTT server to start tasks.
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
                    baseFunctions.legWorkout(1, username);
                    System.out.println("Benen workout uitgevoerd.");
                    break;

                /*
                 * Be sure to add the filepaths to the songs uploaded on the robot
                 * if this isn't done there is a chance the controller code might crash
                 * because it can't find the file.
                 */

                case "songa":
                    //Change filepath when using a physical robot!
                    baseFunctions.sitRelaxed();
                    baseFunctions.play("C:\\Users\\Caprisun\\AppData\\Local\\Temp\\Untitledv86UUJY\\wavw.wav");
                    System.out.println("Play uitgevoerd.");
                    break;

                case "songb":
                    //Change filepath when using a physical robot!
                    baseFunctions.sitRelaxed();
                    baseFunctions.play("song2");
                    System.out.println("Play2 uitgevoerd.");
                    break;

                case "songc":
                    //Change filepath when using a physical robot!
                    baseFunctions.sitRelaxed();
                    baseFunctions.play("song3");
                    System.out.println("Play3 uitgevoerd.");
                    break;

                case "pause":
                    //Currently not working because of MultiThread issues. Song will stop
                    //when the song is finished.
                    baseFunctions.stopPlaying(1);
                    break;

               /*
                * Weather, You can issue a city here, it currently is hardcoded in to
                * make it easier but it is possible to use different cities
                * if they are supported by the API used.
                */

                case "amsterdam":
                    baseFunctions.jsonObject("Amsterdam");
                    break;

                case "maastricht":
                    baseFunctions.jsonObject("Maastricht");
                    break;

                default:

            }
        }
    }
}


