import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.sql.Time;
import java.util.Collections;

public class NAO extends Thread{
    private String naam;
    private static Application application;

    //get status of the application
    public static Application getApplication() {
        return application;
    }

    //connect function to connect with the NAO robot, fill in the hostname and the port
    public void verbind(String hostname, int port){
        String robotUrl = "tcp://" + hostname + ":" + port;
        // Create a new application
        this.application = new Application(new String[]{}, robotUrl);
        // Start your application
        application.start();
    }

    //function to let the NAO robot stand
    public void StandInit() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("StandInit",1.0f);
    }

    //function to let NAO robot sit down
    public void Sit() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("Sit",1.0f);
    }

    //function to let NAO robot sit down in a relaxed form
    public void SitRelax() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("SitRelax",1.0f);
    }

    //function to let the NAO robot lie down on his/her belly
    public void LyingBelly() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("LyingBelly",1.0f);
    }

    //function to legt the NAO robot crouch
    public void Crouch() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("Crouch",1.0f);
    }

    //function to let the NAO robot do a squat, fill in how many repetitions you want NAO to do
    public void Squat(int reps) throws Exception {

        for (int i = 0; i <reps ; i++) {

            ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
            robotPosture.goToPosture("StandZero", 1.0f);
            ALMotion alMotion = new ALMotion(this.application.session());
            robotPosture.goToPosture("Crouch",1.0f);
            alMotion.setAngles("LShoulderPitch", 0, 0.3f);
            alMotion.setAngles("RShoulderPitch", 0, 0.3f);
        }
        ALRobotPosture alRobotPosture = new ALRobotPosture(this.application.session());
        alRobotPosture.goToPosture("Stand",1.0f);
    }

    //function to let the NAO robot lie on his/her back
    public void LyingBack() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("LyingBack",1.0f);
    }

    //function to let the NAO robot stand
    public void Stand() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("Stand",1.0f);
    }

    //function to let the NAO robot stand with his/her arms in front of him/her
    public void StandZero() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("StandZero",1.0f);
    }

    //function to let the NAO robot speak a line of text, fill in the string that you want him/her to say
    public void Talk(String tekst) throws Exception {
        // Create an ALTextToSpeech object and link it to your current session
        ALTextToSpeech tts = new ALTextToSpeech(this.application.session());
        // Make your robot say something
        tts.say(tekst);
    }

    //function to position the NAO robot arms to the side
    public void ShouldersRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderRoll",0,0.3f);
        alMotion.setAngles("RShoulderRoll",0,0.3f);
    }

    //function to let the NAO robot put his/her arms down
    public void ArmsDown() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderPitch",1.5,0.3f);
        alMotion.setAngles("RShoulderPitch",1.5,0.3f);
    }

    //function to let the NAO robot lift his/her arms up in front of him/her
    public void ArmsUp() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderPitch",-1,0.3f);
        alMotion.setAngles("RShoulderPitch",-1,0.3f);
    }

    //function to let the NAO robot put the left arm down
    public void LShoulderPitch() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderPitch", -1, 0.3f);
    }

    //function to let the NAO robot put the right arm down
    public void RShoulderPitch() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RShoulderPitch", -1, 0.3f);
    }

    //function to let the NAO robot lift both arms up in front of him/her
    public void ArmsForward() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderPitch", 0, 0.3f);
        alMotion.setAngles("RShoulderPitch", 0, 0.3f);
    }

    //function to let the NAO robot lift the right arm up in front of him/her
    public void RightArmForward() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RShoulderPitch", 0, 0.3f);
    }

    //function to let the NAO robot lift the left arm up in front of him/her
    public void LeftArmForward() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderPitch", 0, 0.3f);
    }

    //function to let the NAO robot lift his/her right arm up to the side
    public void RShoulderRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RShoulderRoll", -1.2, 0.3f);
    }

    //function to let the NAO robot lift his/her left arm up to the side
    public void LShoulderRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderRoll", 1.2, 0.3f);
    }

    //function to let the NAO robot lift both of his/her arms up to the side
    public void ArmsRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RShoulderRoll", -1.2, 0.3f);
        alMotion.setAngles("LShoulderRoll", 1.2, 0.3f);
    }

    //function to let the NAO robot bend his/her right elbow
    public void RElbowRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RElbowRoll", 3, 0.3f);
    }

    //function to let the NAO robot bend his/her left elbow
    public void LElbowRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LElbowRoll", 3, 0.3f);
    }

    //function to let the NAO robot bend both of his/her elbows
    public void ElbowRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RElbowRoll", 3, 0.3f);
        alMotion.setAngles("LElbowRoll", 3, 0.3f);
    }

    //function to let the NAO robot bend his hips
    public void RHipRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RHipRoll", -1, 0.3f);
    }

    //function to let the NAO robot spin his arms around, fill in how many repetitions NAO needs to do
    public void ArmExercise(int rep)throws Exception {

        ALMotion alMotion = new ALMotion(this.application.session());

        for (int i = 0; i < rep; i++) {


            alMotion.setAngles("LShoulderRoll", -2.3,0.2f);
            alMotion.setAngles("RShoulderRoll", 2.3,0.2f);
            Thread.sleep(1000);

            alMotion.setAngles("LShoulderPitch", 1,0.2f);
            alMotion.setAngles("RShoulderPitch", 1,0.2f);
            Thread.sleep(1000);

            alMotion.setAngles("LShoulderRoll", 2.3,0.2f);
            alMotion.setAngles("RShoulderRoll", -2.3,0.2f);
            Thread.sleep(1000);


            alMotion.setAngles("LShoulderPitch", -1,0.2f);
            alMotion.setAngles("RShoulderPitch", -1,0.2f);
            Thread.sleep(1000);

        }

        alMotion.setAngles("LShoulderRoll", -2.3,0.2f);
        alMotion.setAngles("RShoulderRoll", 2.3,0.2f);
        Thread.sleep(1000);

        Stand();
    }

    //function to let the NAO robot walk in a certain direction
    public void Walk(float x, float y, float theta) throws Exception{
        ALMotion alMotion = new ALMotion(this.application.session());

        alMotion.walkTo(x,y,theta);

        alMotion.killWalk();
    }

    //another function for the NAO robot to do a squat, fill in how many repetitions you want him/her to do
    public void SquatStefano(int reps) throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());


        for (int i = 0; i < reps; i++) {
            alMotion.setAngles("RShoulderPitch",-0.01,0.2f);
            alMotion.setAngles("LShoulderPitch",-0.01,0.2f);
            alMotion.setAngles("LElbowRoll",-0.02,0.2f);
            alMotion.setAngles("RElbowRoll",-0.02,0.2f);
            alMotion.setAngles("LShoulderRoll",0.02,0.2f);
            alMotion.setAngles("RShoulderRoll",0.02,0.2f);
            alMotion.setAngles("LElbowYaw",0.02,0.2f);
            alMotion.setAngles("RElbowYaw",0.02,0.2f);

            alMotion.setAngles("RHipYawPitch",-0.05,0.1f);
            alMotion.setAngles("LHipYawPitch",-0.05,0.1f);


            alMotion.setAngles("RKneePitch", 1.9, 0.2f);
            alMotion.setAngles("LKneePitch", 1.9, 0.2f);
            alMotion.setAngles("LHipPitch", -1.0, 0.1f);
            alMotion.setAngles("RHipPitch", -1.0, 0.1f);
            alMotion.setAngles("RAnklePitch", -1.0, 0.1f);
            alMotion.setAngles("LAnklePitch", -1.0, 0.1f);
            Thread.sleep(2000);
            ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
            robotPosture.goToPosture("StandInit", 0.3f);
        }
    }

    //function to let the NAO robot open his/her arms and begin a pec fly
    public void armExerciseOpen() throws Exception{
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RShoulderPitch", -0.01, 0.2f);
        alMotion.setAngles("LShoulderPitch", -0.01, 0.2f);
        //alMotion.setAngles("LElbowRoll", 0.02, 0.2f);
        //alMotion.setAngles("RElbowRoll", 0.02, 0.2f);
        alMotion.setAngles("LShoulderRoll", 0.8, 0.3f);
        alMotion.setAngles("RShoulderRoll", -0.8, 0.3f);
        alMotion.setAngles("LElbowRoll",0.02,0.3f);
        alMotion.setAngles("RElbowRoll",0.02,0.3f);
        alMotion.setAngles("LElbowYaw", -1.5, 0.2f);
        alMotion.setAngles("RElbowYaw", 1.5, 0.2f);

    }

    //function to let the NAO robot close his/her arms to finish a pec fly
    public void armExerciseClose() throws Exception{
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RShoulderPitch", -0.01, 0.2f);
        alMotion.setAngles("LShoulderPitch", -0.01, 0.2f);
        //alMotion.setAngles("LElbowRoll", 0.02, 0.2f);
        //alMotion.setAngles("RElbowRoll", 0.02, 0.2f);
        alMotion.setAngles("LShoulderRoll", 0.03, 0.3f);
        alMotion.setAngles("RShoulderRoll", -0.03, 0.3f);
        alMotion.setAngles("LElbowRoll",-0.02,0.3f);
        alMotion.setAngles("RElbowRoll",-0.02,0.3f);
        alMotion.setAngles("LElbowYaw", -1.5, 0.2f);
        alMotion.setAngles("RElbowYaw", 1.5, 0.2f);

    }

    //function to let the NAO robot walk on its place, it does not work with a physical robot so do not try that
    public void WalkOnPlace(int reps) throws Exception {

        for (int i = 0; i < reps; i++) {


            ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
            ALMotion alMotion = new ALMotion(this.application.session());
            alMotion.setAngles("RHipPitch", -1.5, 0.7f);
            alMotion.setAngles("RKneePitch", 1.7, 0.7f);
            alMotion.setAngles("LShoulderPitch", 0.5, 0.8f);
            alMotion.setAngles("RShoulderPitch", 2, 0.8f);


            robotPosture.goToPosture("StandInit", 0.7f);

            alMotion.setAngles("LHipPitch", -1.5, 0.7f);
            alMotion.setAngles("LKneePitch", 1.7, 0.7f);
            alMotion.setAngles("RShoulderPitch", 0.5, 0.8f);
            alMotion.setAngles("LShoulderPitch", 2, 0.8f);


            robotPosture.goToPosture("StandInit", 0.5f);
        }
    }

    //function to let the NAO robot talk and walk at the same time
    public void TalkAndWalk(float x, float y, float theta, String tekst) throws Exception{
        ALMotion alMotion = new ALMotion(this.application.session());
        ALTextToSpeech alTextToSpeech = new ALTextToSpeech(this.application.session());
        alMotion.walkTo(x,y,theta);
        alTextToSpeech.say(tekst);
    }

    //function to let the NAO robot play music
    public void play(String ID) throws Exception {
        ALAudioPlayer alAudioPlayer = new ALAudioPlayer(this.application.session());
        try {
            alAudioPlayer.playFile(ID);
        } catch (Exception e) {
        }
        Thread.sleep(1000);
    }

    //function to let the NAO robot say the current weather in a city of coice, fill in what city you want
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
                Talk("Het is " + obj.get("temp") + " graden in " + stad);
                Talk("Het voelt als " + obj.get("feels_like") + " graden in " + stad);
            }

        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }

}
