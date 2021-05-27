import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.*;

import java.sql.Time;
import java.util.Collections;

public class NAO {
    private String naam;
    private Application application;

    public void verbind(String hostname, int port){
        String robotUrl = "tcp://" + hostname + ":" + port;
        // Create a new application
        this.application = new Application(new String[]{}, robotUrl);
        // Start your application
        application.start();
    }

    //staan
    public void staan1() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("StandInit",1.0f);
    }

    //zitten
    public void zitten() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("Sit",1.0f);
    }

    //relaxed zitten
    public void relaxedZitten() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("SitRelax",1.0f);
    }

    //op de buik liggen
    public void buikLiggen() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("LyingBelly",1.0f);
    }

    //hurkend zitten
    public void hurken() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("Crouch",1.0f);
    }

    //op de rug liggen
    public void rugLiggen() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("LyingBack",1.0f);
    }

    //staan
    public void staan() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("Stand",1.0f);
    }

    //staan
    public void staan2() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("StandZero",1.0f);
    }

    //praten
    public void praten(String tekst) throws Exception {
        // Create an ALTextToSpeech object and link it to your current session
        ALTextToSpeech tts = new ALTextToSpeech(this.application.session());
        // Make your robot say something
        tts.say(tekst);
    }

    public void neutraal() throws Exception{
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderRoll",0,0.3f);
        alMotion.setAngles("RShoulderRoll",0,0.3f);
        alMotion.setAngles("RShoulderPitch",0,0.3f);
        alMotion.setAngles("LShoulderPitch",0,0.3f);

    }

    public void armenOmlaagRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderRoll",0,0.3f);
        alMotion.setAngles("RShoulderRoll",0,0.3f);
    }

    public void armenNaarBeneden() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderPitch",0,0.3f);
        alMotion.setAngles("RShoulderPitch",0,0.3f);
    }
    public void armenOmhoog() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderPitch",-1,0.3f);
        alMotion.setAngles("RShoulderPitch",-1,0.3f);
    }

    public void linkerArmOmhoog() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderPitch", -1, 0.3f);
    }

    public void rechterArmOmhoog() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RShoulderPitch", -1, 0.3f);
    }

    public void armenNaarVoren() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderPitch", 0, 0.3f);
        alMotion.setAngles("RShoulderPitch", 0, 0.3f);
    }

    public void rechterArmNaarVoren() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RShoulderPitch", 0, 0.3f);
    }

    public void linkerArmNaarVoren() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderPitch", 0, 0.3f);
    }

    public void rechterArmRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RShoulderRoll", -1.2, 0.3f);
    }


    public void linkerArmRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderRoll", 1.2, 0.3f);
    }

    public void armenRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RShoulderRoll", -1.2, 0.3f);
        alMotion.setAngles("LShoulderRoll", 1.2, 0.3f);
    }

    public void rechterElleboogRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RElbowRoll", 3, 0.3f);
    }

    public void linkerElleboogRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LElbowRoll", 3, 0.3f);
    }

    public void EllebogenRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RElbowRoll", 3, 0.3f);
        alMotion.setAngles("LElbowRoll", 3, 0.3f);
    }

    public void rechterHeupDraai() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RHipRoll", -1, 0.3f);
    }

    public void lopen(float x, float y, float theta) throws Exception{
        ALMotion alMotion = new ALMotion(this.application.session());

        alMotion.walkTo(x,y,theta);

        alMotion.killWalk();
    }

    public void bothLegs1(int reps) throws Exception {
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

    public void oefening(int reps) throws Exception {
        for (int i = 0; i < reps; i++) {

            lopen(0.1f, 0f, 0f);
            Thread.sleep(1000);
            bothLegs1(1);
            Thread.sleep(1000);

            lopen(-0.1f, 0f, 0f);
            Thread.sleep(1000);
            bothLegs1(1);
            Thread.sleep(1000);

            lopen(0f, 0.1f, 0f);
            Thread.sleep(1000);
            bothLegs1(1);
            Thread.sleep(1000);

            lopen(0f, -0.1f, 0f);
            Thread.sleep(1000);
            bothLegs1(1);
        }

        Thread.sleep(1500);
        zitten();
    }
}