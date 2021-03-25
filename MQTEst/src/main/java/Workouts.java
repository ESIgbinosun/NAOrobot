import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;

public class Workouts extends BaseFunctions {


    //March, needs an int for the amount of repetitions.
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

    //Arm workout
    public void armWorkout(int rep) throws Exception {

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
}
