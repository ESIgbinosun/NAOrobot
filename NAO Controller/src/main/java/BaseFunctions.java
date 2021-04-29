/*
 * Controller base functions Nao robot
 *
 * Author: Diego Brandjes
 * Class: IT101
 * Date: 09-03-2021
 * Edit Date:  29-04-2021
 */


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

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            //Getting the response code
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

                //Using the JSON simple library parse the string into a json object
                JSONParser parse = new JSONParser();
                JSONObject data_obj = (JSONObject) parse.parse(inline);


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
            alAudioPlayer.playFile(ID);
        } catch (Exception e) {
        }
        Thread.sleep(1000);
    }

    // kill music
    public void stopPlaying(Integer ID) throws Exception {
        ALAudioPlayer alAudioPlayer = new ALAudioPlayer(this.application.session());
        alAudioPlayer.pause(ID);
    }

    // camera
//    public void camera() throws Exception {
//        ALVideoDevice videoDevice = new ALVideoDevice(this.application.session());
//        String videoName = videoDevice.subscribeCamera("cameraFront", 0, 2, 11,5);
//
//        Mat img = new Mat(new size(640, 480), CV_8UC3);
//
//        while (true) {
//
//            List<Object> videoObject = (List<Object>)videoDevice.getImagesRemote(videoName);
//
//            ByteBuffer imgData = (ByteBuffer) videoObject.get(6);
//            byte[] data = new byte[imgData.capacity()];
//
//            ((ByteBuffer)imgData.duplicate().clear()).get(data);
//            img.put(0,0, data);
//
//            videoDevice.releaseImage(videoName);
//            HighGui.imshow("Image", img);
//            HighGui.waitkey(1);
//
//        }
//    }


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

    //Leg workout
    public void legWorkout(int rep) throws Exception {
        speak("Welkom bij deze workout, we beginnen met rustig lopen op onze plaats");
        Thread.sleep(3000);
        march(20);
        speak("En stop maar met lopen");
        Thread.sleep(3000);
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
        speak("Nu gaan we weer lekker even lopen op de plaats");
        Thread.sleep(1000);
        march(20);
        Thread.sleep(1000);
        speak("Nu doen we de squat oefening op onze plaats zoals dit");
        Thread.sleep(1000);
        squat(1);
        speak("Dit herhalen we tien keer");
        Thread.sleep(2000);
        squat(10);
        Thread.sleep(2000);
        speak("Goed gedaan en dit alles herhalen we nog twee keer");
        Thread.sleep(1000);
        speak("We beginnen weer met rustig lopen op de plaats");
        Thread.sleep(2000);
        march(20);
        Thread.sleep(1000);
        speak("En we nemen weer drie stappen vooruit en daarna gaan we weer een squat doen");
        speak("dit gaan we " + rep + " keer herhalen");

        Thread.sleep(2000);

        for (int j = 0; j < rep; j++) {
            Thread.sleep(1000);
            walk(0.1f, 0f, 0f);
            Thread.sleep(2000);
            squat(1);
            Thread.sleep(500);
            walk(-0.1f, 0f, 0f);
        }

        Thread.sleep(2000);
        speak("En we gaan weer rustig lopen op de plaats");
        Thread.sleep(1000);
        march(20);
        Thread.sleep(1000);
        speak("Nu doen we de squat oefening weer tien keer op onze plaats");
        Thread.sleep(2000);
        squat(10);
        Thread.sleep(1000);
        speak("Iedereen is lekker bezig, we herhalen dit nog een laatste keer, neem eerst maar 10 seconden rust");
        Thread.sleep(10000);
        speak("En begin maar weer met marcheren op de plaats");
        Thread.sleep(20);
        Thread.sleep(1000);
        speak("En we gaan weer drie stappen vooruit nemen, waarna we weer in de squatpositie gaan");
        Thread.sleep(1000);
        speak("Dit herhalen we weer " + rep + " keer");

        Thread.sleep(2000);

        for (int k = 0; k < rep; k++) {
            Thread.sleep(1000);
            walk(0.1f, 0f, 0f);
            Thread.sleep(2000);
            squat(1);
            Thread.sleep(500);
            walk(-0.1f, 0f, 0f);
        }
        Thread.sleep(2000);
        speak("En we gaan weer op de plaats lopen");
        Thread.sleep(1000);
        march(20);
        Thread.sleep(1000);
        speak("En we eindigen weer met tien maal de squat oefening op je plaats");
        Thread.sleep(2000);
        squat(10);
        Thread.sleep(2000);
        speak("Dankjewel voor het actief meedoen met deze workout en tot de volgende keer");
    }

    //March
    public void march(int reps) throws Exception {

        for (int i = 0; i < reps; i++) {

            ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
            ALMotion alMotion = new ALMotion(this.application.session());
            alMotion.setAngles("RHipPitch", -1.5, 0.5f);
            alMotion.setAngles("RKneePitch", 1.7, 0.5f);
            alMotion.setAngles("LShoulderPitch", 0.5, 0.6f);
            alMotion.setAngles("RShoulderPitch", 2, 0.6f);


            robotPosture.goToPosture("StandInit", 0.5f);

            alMotion.setAngles("LHipPitch", -1.5, 0.5f);
            alMotion.setAngles("LKneePitch", 1.7, 0.5f);
            alMotion.setAngles("RShoulderPitch", 0.5, 0.6f);
            alMotion.setAngles("LShoulderPitch", 2, 0.6f);


            robotPosture.goToPosture("StandInit", 0.5f);
        }
    }

    //Squat
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
        alRobotPosture.goToPosture("Stand", 1.0f);
    }

}

