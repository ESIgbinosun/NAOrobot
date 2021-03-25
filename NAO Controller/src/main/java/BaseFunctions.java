import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;


public class BaseFunctions {

    public Application application;


    //Connect via input.
    public void connect(String hostname, int port) {

        String robotUrl = "tcp://" + hostname + ":" + port;
        // Create a new application
        this.application = new Application(new String[]{}, robotUrl);
        // Start your application
        application.start();
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
}

