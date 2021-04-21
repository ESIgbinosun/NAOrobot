import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALNavigation;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

import java.security.AlgorithmConstraints;

public class NAO {
    private String naam;
    private Application application;

    public void connect(String hostname, int port) {
        String robotUrl = "tcp://" + hostname + ":" + port;
        // Create a new application
        this.application = new Application(new String[]{}, robotUrl);
        // Start your application
        application.start();
    }


    public void StandInit() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("StandInit", 1.0f);
    }

    public void Sit() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("Sit", 1.0f);
    }

    public void SitRelax() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("SitRelax", 1.0f);
    }

    public void LyingBelly() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("LyingBelly", 1.0f);
    }

    public void Crouch() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("Crouch", 1.0f);
    }

    public void Squat(int reps) throws Exception {

        for (int i = 0; i < reps; i++) {

            ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
            robotPosture.goToPosture("StandZero", 1.0f);
            ALMotion alMotion = new ALMotion(this.application.session());
            robotPosture.goToPosture("Crouch", 1.0f);
            alMotion.setAngles("LShoulderPitch", 0, 0.3f);
            alMotion.setAngles("RShoulderPitch", 0, 0.3f);
        }
        ALRobotPosture alRobotPosture = new ALRobotPosture(this.application.session());
        alRobotPosture.goToPosture("StandZero", 1.0f);
    }

    public void LyingBack() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("LyingBack", 1.0f);
    }

    public void Stand() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("Stand", 1.0f);
    }

    public void StandZero() throws Exception {
        ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
        robotPosture.goToPosture("StandZero", 1.0f);
    }

    public void Talk(String tekst) throws Exception {
        // Create an ALTextToSpeech object and link it to your current session
        ALTextToSpeech tts = new ALTextToSpeech(this.application.session());
        // Make your robot say something
        tts.say(tekst);
    }

    public void ShouldersRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderRoll", 0, 0.3f);
        alMotion.setAngles("RShoulderRoll", 0, 0.3f);
    }

    public void ArmsDown() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderPitch", 1.5, 0.3f);
        alMotion.setAngles("RShoulderPitch", 1.5, 0.3f);
    }

    public void ArmsUp() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderPitch", -1, 0.3f);
        alMotion.setAngles("RShoulderPitch", -1, 0.3f);
    }

    public void LShoulderPitch() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderPitch", -1, 0.3f);
    }

    public void RShoulderPitch() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RShoulderPitch", -1, 0.3f);
    }

    public void ArmsForward() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderPitch", 0, 0.3f);
        alMotion.setAngles("RShoulderPitch", 0, 0.3f);
    }

    public void RightArmForward() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RShoulderPitch", 0, 0.3f);
    }

    public void LeftArmForward() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderPitch", 0, 0.3f);
    }

    public void RShoulderRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RShoulderRoll", -1.2, 0.3f);
    }

    public void LShoulderRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LShoulderRoll", 1.2, 0.3f);
    }

    public void ArmsRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RShoulderRoll", -1.2, 0.3f);
        alMotion.setAngles("LShoulderRoll", 1.2, 0.3f);
    }

    public void RElbowRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RElbowRoll", 3, 0.3f);
    }

    public void LElbowRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("LElbowRoll", 3, 0.3f);
    }

    public void ElbowRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RElbowRoll", 3, 0.3f);
        alMotion.setAngles("LElbowRoll", 3, 0.3f);
    }

    public void RHipRoll() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RHipRoll", -1, 0.3f);
    }

    public void ArmExercise(int rep) throws Exception {

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

        alMotion.setAngles("LShoulderRoll", -2.3, 0.2f);
        alMotion.setAngles("RShoulderRoll", 2.3, 0.2f);
        Thread.sleep(1000);

        Stand();
    }

    public void Walk(float x, float y, float theta) throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());

        alMotion.walkTo(x, y, theta);

        alMotion.killWalk();
    }

    public void SquatStefano(int reps) throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());


        for (int i = 0; i < reps; i++) {
            alMotion.setAngles("RShoulderPitch", -0.01, 0.2f);
            alMotion.setAngles("LShoulderPitch", -0.01, 0.2f);
            alMotion.setAngles("LElbowRoll", -0.02, 0.2f);
            alMotion.setAngles("RElbowRoll", -0.02, 0.2f);
            alMotion.setAngles("LShoulderRoll", 0.02, 0.2f);
            alMotion.setAngles("RShoulderRoll", 0.02, 0.2f);
            alMotion.setAngles("LElbowYaw", 0.02, 0.2f);
            alMotion.setAngles("RElbowYaw", 0.02, 0.2f);

            alMotion.setAngles("RHipYawPitch", -0.05, 0.1f);
            alMotion.setAngles("LHipYawPitch", -0.05, 0.1f);


            alMotion.setAngles("RKneePitch", 1.9, 0.2f);
            alMotion.setAngles("LKneePitch", 1.9, 0.2f);
            alMotion.setAngles("LHipPitch", -0.8, 0.1f);
            alMotion.setAngles("RHipPitch", -0.8, 0.1f);
            alMotion.setAngles("RAnklePitch", -1.0, 0.1f);
            alMotion.setAngles("LAnklePitch", -1.0, 0.1f);
            Thread.sleep(2000);
            ALRobotPosture robotPosture = new ALRobotPosture(this.application.session());
            robotPosture.goToPosture("StandInit", 0.3f);
        }
    }

    public void armExerciseOpen() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RShoulderPitch", -0.01, 0.2f);
        alMotion.setAngles("LShoulderPitch", -0.01, 0.2f);
        //alMotion.setAngles("LElbowRoll", 0.02, 0.2f);
        //alMotion.setAngles("RElbowRoll", 0.02, 0.2f);
        alMotion.setAngles("LShoulderRoll", 0.8, 0.3f);
        alMotion.setAngles("RShoulderRoll", -0.8, 0.3f);
        alMotion.setAngles("LElbowRoll", 0.02, 0.3f);
        alMotion.setAngles("RElbowRoll", 0.02, 0.3f);
        alMotion.setAngles("LElbowYaw", -1.5, 0.2f);
        alMotion.setAngles("RElbowYaw", 1.5, 0.2f);

    }

    public void armExerciseClose() throws Exception {
        ALMotion alMotion = new ALMotion(this.application.session());
        alMotion.setAngles("RShoulderPitch", -0.01, 0.2f);
        alMotion.setAngles("LShoulderPitch", -0.01, 0.2f);
        //alMotion.setAngles("LElbowRoll", 0.02, 0.2f);
        //alMotion.setAngles("RElbowRoll", 0.02, 0.2f);
        alMotion.setAngles("LShoulderRoll", 0.03, 0.3f);
        alMotion.setAngles("RShoulderRoll", -0.03, 0.3f);
        alMotion.setAngles("LElbowRoll", -0.02, 0.3f);
        alMotion.setAngles("RElbowRoll", -0.02, 0.3f);
        alMotion.setAngles("LElbowYaw", -1.5, 0.2f);
        alMotion.setAngles("RElbowYaw", 1.5, 0.2f);

    }

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
    public void birdFlying(int reps)throws Exception{
        ALMotion alMotion = new ALMotion(this.application.session());
        ALRobotPosture alRobotPosture = new ALRobotPosture(this.application.session());
        for (int i = 0; i <reps ; i++) {


            alMotion.setAngles("LShoulderRoll", -2, 0.6f);
            alMotion.setAngles("RShoulderRoll", 2, 0.6f);
            alMotion.setAngles("LElbowRoll", 2, 0.6f);
            alMotion.setAngles("RElbowRoll", -2, 0.6f);
            alMotion.setAngles("LWristYaw", 0.15, 0.6f);
            alMotion.setAngles("RWristYaw", -0.15, 0.6f);
            alRobotPosture.goToPosture("Crouch", 0.9f);
            alRobotPosture.goToPosture("StandInit", 0.9f);
            alMotion.setAngles("LShoulderRoll", -2, 0.6f);
            alMotion.setAngles("RShoulderRoll", 2, 0.6f);
            alMotion.setAngles("LElbowRoll", 2, 0.6f);
            alMotion.setAngles("RElbowRoll", -2, 0.6f);
            alMotion.setAngles("LWristYaw", 0.15, 0.6f);
            alMotion.setAngles("RWristYaw", -0.15, 0.6f);
            alMotion.setAngles("LShoulderPitch", -1.5, 0.4f);
            alMotion.setAngles("RShoulderPitch", -1.5, 0.4f);
            Thread.sleep(2000);
            alMotion.setAngles("LShoulderPitch", 1, 0.4f);
            alMotion.setAngles("RShoulderPitch", 1, 0.4f);

        }

    }
    
}