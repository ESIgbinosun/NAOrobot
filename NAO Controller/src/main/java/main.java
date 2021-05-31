/*
 * Controller code Nao robot
 *
 * Author: Diego Brandjes
 * Class: IT101
 * Date: 09-03-2021
 * Edit Date:  30-05-2021
 */

//FINAL

import java.text.SimpleDateFormat;
import java.util.Date;

public class main extends BaseFunctions {

    // Change hostname when using a physical robot.
    // "padrick.robot.hva-robots.nl"
    public static final String HOSTNAME = "192.168.137.242"; // use IP from laptop/robot connection or localhost when using the Choreograph software.
    public static final int PORT = 9559;

    public static final String DATEFORMAT = "dd-MM-yyyy HH:mm:ss";
    public static final String SONGA = "/home/nao/wav/langef5_1621336125.mp3";
    public static final String SONGB = "/home/nao/wav/langef5_1621335608.mp3";
    public static final String SONGC = "/home/nao/wav/langef5_1621336146.mp3";

    public static BaseFunctions baseFunctions = new BaseFunctions();


    public static void onMessage(String message) throws Exception {

        // Prints the received MQTT message into the console.
        System.out.println(message);

        // Main switch case, uses input from MQTT server to start tasks.
        switch (message.toLowerCase()) {

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
                baseFunctions.legWorkout(2);
                System.out.println("Benen workout uitgevoerd.");
                break;

            /*
             * Be sure to add the correct filepath to the songs uploaded on the robot
             * if this isn't done there is a chance the controller code might crash
             * because it can't find the file. This is done by changing the Final strings.
             */

            case "songa":
                //Change filepath when using a physical robot!
                baseFunctions.singerPose();
                baseFunctions.play(SONGA);
                System.out.println("Play uitgevoerd. Met de vlam in de pijp");
                baseFunctions.stand();
                break;

            case "songb":
                //Change filepath when using a physical robot!
                baseFunctions.sitRelaxed();
                baseFunctions.play(SONGB);
                System.out.println("Play2 uitgevoerd. Een eigen huis");
                baseFunctions.stand();
                break;

            case "songc":
                //Change filepath when using a physical robot!
                baseFunctions.sitRelaxed();
                baseFunctions.play(SONGC);
                System.out.println("Play3 uitgevoerd. Stiekem Gedanst");
                baseFunctions.stand();
                break;

//              //Currently not working because of MultiThread issues. Song will stop
//              //when the song is finished.
//                case "pause":
//
//                    baseFunctions.stopPlaying(1);
//                    break;

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


    public static void main(String[] args) throws Exception {

        // Function for getting the current date and time.
        SimpleDateFormat format = new SimpleDateFormat(DATEFORMAT);
        Date date = new Date();

        // Calling classes, used for MQTT functions & NAO functions. Don't remove, this keeps the main running.
        mqtt mqtt = new mqtt();

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

    }
}


