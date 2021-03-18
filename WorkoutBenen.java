import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

public class WorkoutBenen {
    public static void main(String[] args) throws Exception {

        NAO nao = new NAO();
        //Fysieke robots : hostname = "padrick.robot.hva-robots.nl" port = 9559
        nao.connect("localhost",9559);

        int reps = 12;
        nao.Stand();
        nao.Talk("Welkom bij deze workout, we beginnen met steeds drie stappen naar voren te doen en drie naar achter zoals dit");
        Thread.sleep(1500);
        nao.Walk(0.1f,0f,0f);
        Thread.sleep(500);
        nao.Walk(-0.1f,0f,0f);
        Thread.sleep(1000);
        nao.Talk("Dit herhalen we twaalf keer");
        Thread.sleep(2000);
        nao.Talk("Daar gaan we");
        for (int i = 0; i < reps; i++) {
            nao.Walk(0.1f,0f,0f);
            Thread.sleep(500);
            nao.Walk(-0.1f,0f,0f);
        }
        nao.Talk("En stop maar met lopen");
        Thread.sleep(1000);
        nao.Talk("Om het moeilijker te maken gaan we nu na elke drie stappen een squat beweging maken");
        Thread.sleep(1000);
        nao.Talk("Een squat beweging ziet er zo uit");
        Thread.sleep(1000);
        nao.Squat(1);
        Thread.sleep(1000);
        nao.Talk("Uiteindelijk komt de oefening er zo uit te zien");
        Thread.sleep(1000);
        nao.Talk("Eerst drie stappen naar voren");
        nao.Walk(0.1f,0f,0f);
        Thread.sleep(500);
        nao.Talk("Dan een squat");
        nao.Squat(1);
        nao.Talk("Drie stappen naar achter");
        nao.Walk(-0.1f,0f,0f);
        Thread.sleep(500);
        nao.Talk("Dan weer een squat");
        nao.Squat(1);
        Thread.sleep(1000);
        nao.Talk("Dit herhalen we weer twaalf keer");
        nao.Talk("Daar gaan we weer");
        Thread.sleep(1000);
        for (int i = 0; i < reps ; i++) {
            nao.Walk(0.1f,0f,0f);
            Thread.sleep(500);
            nao.Squat(1);
            nao.Walk(-0.1f,0f,0f);
            Thread.sleep(500);
            nao.Squat(1);
            Thread.sleep(1000);
        }
        nao.Talk("En blijf maar weer op je plek staan");
        Thread.sleep(1500);
        nao.Talk("We gaan nu hetzelfde weer doen alleen stappen we deze keer opzij in plaats van naar voren");
        Thread.sleep(1000);
        nao.Talk("Dit komt er nu zo uit te zien");
        Thread.sleep(1500);
        nao.Talk("drie stappen naar rechts");
        nao.Walk(0f,0.1f,0f);
        Thread.sleep(1000);
        nao.Talk("Dan een squat");
        nao.Squat(1);
        Thread.sleep(1000);
        nao.Talk("Drie stappen naar links");
        nao.Walk(0f,-0.1f,0f);
        Thread.sleep(1000);
        nao.Talk("En dan weer een squat");
        nao.Squat(1);
        Thread.sleep(1000);
        nao.Talk("Ook dit herhalen we twaalf keer");
        Thread.sleep(1000);
        nao.Talk("Daar gaan we");
        for (int i = 0; i < reps; i++) {
            nao.Walk(0f,0.1f,0f);
            Thread.sleep(1000);
            nao.Squat(1);
            Thread.sleep(1000);
            nao.Walk(0f,-0.1f,0f);
            Thread.sleep(1000);
            nao.Squat(1);
            Thread.sleep(1000);
        }
        nao.Talk("Voor de laatste oefening hebben jullie een stoel nodig");
        Thread.sleep(1000);
        nao.Talk("Het idee is dat jullie allemaal steeds gaan zitten op de stoel");
        nao.Crouch();
        Thread.sleep(1000);
        nao.Talk("En daarna weer op staan met jullie armen vooruit");
        nao.StandZero();
        Thread.sleep(1000);
        nao.Talk("Dit herhalen we ook weer twaalf keer");
        Thread.sleep(1000);
        nao.Talk("Daar gaan we weer");
        for (int i = 0; i < reps; i++) {
            Thread.sleep(1000);
            nao.Crouch();
            Thread.sleep(1500);
            nao.StandZero();
        }
        nao.Talk("Dit was het en dankjewel voor het actief meedoen met deze workout en tot de volgende keer");

    }
}
