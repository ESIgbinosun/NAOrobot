/*
 * Controller base functions Nao robot
 *
 * Author: Diego Brandjes
 * Class: IT101
 * Date: 09-03-2021
 * Edit Date:  28-05-2021
 */

//FINAL

import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.*;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class BaseFunctions {

    public Application application;
    public ALRobotPosture.AsyncALRobotPosture async;
    public ALMotion.AsyncALMotion asyncALMotion;

    //Connect via input.
    public void connect(String hostname, int port) throws Exception {

        String robotUrl = "tcp://" + hostname + ":" + port;
        // Create a new application
        this.application = new Application(new String[]{}, robotUrl);
        // Start your application
        application.start();

        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        ALMotion alMotion = new ALMotion(this.application.session());

        this.async = robotPosture.async();
        asyncALMotion = alMotion.async();
    }

    public void jsonObject(String stad) throws IOException {

        try {

            // Specify API Url + city
            URL url = new URL("https://api.openweathermap.org/data/2.5/weather?appid=4c23483851e7e8992de00c00a866cdde&units=metric&q=" + stad);

            // GET request and connecting
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            // Getting the response code
            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responsecode);
            } else {

                String inline = "";
                Scanner scanner = new Scanner(url.openStream());

                //Write all the JSON data into a string using a scanner
                while (scanner.hasNext()) {
                    inline += scanner.nextLine();
                }
                scanner.close();

                // Using the JSON simple library parse the string into a json object
                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);


                // JSON Data being spoken from "main"
                JSONObject obj = (JSONObject) data_obj.get("main");
                speak("Het is " + obj.get("temp") + " graden in " + stad);
                speak("Het voelt als " + obj.get("feels_like") + " graden in " + stad);
            }

        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

    //sit
    public void sit() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("Sit", 1.0f);
    }

    //relaxed sit
    public void sitRelaxed() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("SitRelax", 1.0f);
    }

    //Lay down
    public void layDown() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("layDown", 1.0f);
    }

    //Crouch
    public void crouch() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("Crouch", 1.0f);
    }

    //Lay on back
    public void layOnBack() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("LyingBelly", 1.0f);
    }

    //StandZero
    public void standZero() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("StandZero", 1.0f);
    }

    //Stand1
    public void stand1() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("StandInit", 1.0f);
    }

    //Stand2
    public void stand() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("Stand", 1.0f);
    }

    //function to let the NAO stand in a singerpose
    public void singerPose() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());

        alMotion.setAngles("LElbowRoll", -1.8, 0.5f);
        alMotion.setAngles("LShoulderRoll", -1.0, 0.4f);
        alMotion.setAngles("LShoulderPitch", 0.8, 0.4f);
        alMotion.setAngles("LElbowYaw", 0, 0.4f);
        alMotion.setAngles("LWristYaw", -0.5, 0.4f);
        alMotion.setAngles("RShoulderRoll", 0, 0.4f);
        alMotion.setAngles("RShoulderPitch", -0.3, 0.4f);
        alMotion.setAngles("RWristYaw", 1.0, 0.4f);
    }

    //Speak
    public void speak(String tekst) throws Exception {

        // Create an ALTextToSpeech object and link it to your current session
        ALTextToSpeech tts = new ALTextToSpeech(this.application.session());
        // Make your robot say something
        tts.say(tekst);
    }

    public void test() throws Exception {
        ALTextToSpeech tts = new ALTextToSpeech(this.application.session());
        tts.say("Test");
    }

    //Walk
    public void walk(float x, float y, float z) throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());

        alMotion.walkTo(x, y, z);
        alMotion.killWalk();
    }

    //Kill, not in use.
    public void kill() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.killAll();
    }

    // play music
    public void play(String ID) throws Exception {
        ALAudioPlayer alAudioPlayer = new ALAudioPlayer(this.application.session());
        try {
            alAudioPlayer.playFile(ID, 0.4f,0f);
        } catch (Exception e) {
        }
        Thread.sleep(1000);
    }

    // kill music
    public void stopPlaying(Integer ID) throws Exception {
        ALAudioPlayer alAudioPlayer = new ALAudioPlayer(this.application.session());
        alAudioPlayer.pause(ID);
    }

    /* Workouts */

    //Arm workout
    public void armWorkout(int rep) throws Exception {

        stand();

        ALMotion alMotion = new ALMotion(this.application.session());

        for (int i = 0; i < rep; i++) {

            alMotion.setAngles("LShoulderRoll", -2.3, 0.2f);
            alMotion.setAngles("RShoulderRoll", 2.3, 0.2f);
            Thread.sleep(1000);

            alMotion.setAngles("LShoulderPitch", 1, 0.2f);
            alMotion.setAngles("RShoulderPitch", 1, 0.2f);
            Thread.sleep(1000);

            alMotion.setAngles("LShoulderRoll", 2.3, 0.2f);
            alMotion.setAngles("RShoulderRoll", -2.3, 0.2f);
            Thread.sleep(1000);

            alMotion.setAngles("LShoulderPitch", -1, 0.2f);
            alMotion.setAngles("RShoulderPitch", -1, 0.2f);
            Thread.sleep(1000);
        }

        alMotion.setAngles("LShoulderRoll", -2.3, 0.1f);
        alMotion.setAngles("RShoulderRoll", 2.3, 0.1f);
        Thread.sleep(1000);

        stand();
    }

    //Leg workout, this part makes the robot perform a task where it'll be
    // speaking out the movements, runtime 1.5 minutes.
    public void legWorkout(int rep) throws Exception {

        stand();
        speak("Welkom bij deze workout.");
        Thread.sleep(1000);
        speak("Nu gaan we drie stappen naar voren");
        Thread.sleep(1000);
        walk(0.1f, 0f, 0f);
        Thread.sleep(1000);
        speak("Hierna doen we een squat, wat er zo uit ziet");
        Thread.sleep(1000);
        squat(1);
        Thread.sleep(1000);
        speak("Na de squat stappen we weer terug naar de basispositie");
        Thread.sleep(1000);
        walk(-0.1f, 0f, 0f);
        Thread.sleep(2000);
        speak("Dit herhalen we " + rep + " keer");

        for (int i = 0; i < rep; i++) {
            Thread.sleep(1000);
            walk(0.1f, 0f, 0f);
            Thread.sleep(2000);
            squat(1);
            Thread.sleep(500);
            walk(-0.1f, 0f, 0f);
        }

        Thread.sleep(3000);
        speak("Nu doen we de squat oefening op onze plaats zoals dit");
        Thread.sleep(1000);
        squat(1);
        speak("Dit herhalen we 1 keer");
        Thread.sleep(2000);
        squat(1);
        Thread.sleep(2000);
        speak("Dankjewel voor het actief meedoen met deze workout en tot de volgende keer");
    }

    //Squat, this part makes the robot perform the task of squatting, here
    // you can also issue the amount if times it should be performed.
    public void squat(int reps) throws Exception {

        for (int i = 0; i < reps; i++) {

            ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
            robotPosture.goToPosture("StandZero", 1.0f);
            ALMotion alMotion = new ALMotion(this.application.session());
            robotPosture.goToPosture("Crouch", 1.0f);
            alMotion.setAngles("LShoulderPitch", 0, 0.3f);
            alMotion.setAngles("RShoulderPitch", 0, 0.3f);
        }
        ALRobotPosture alRobotPosture = new ALRobotPosture(this.application.session());
        alRobotPosture.goToPosture("Stand",1.0f);
    }
}

