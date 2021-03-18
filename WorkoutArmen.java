import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

public class WorkoutArmen {
    public static void main(String[] args) throws Exception {

        NAO nao = new NAO();
        //Fysieke robots : hostname = "padrick.robot.hva-robots.nl" port = 9559
        nao.connect("localhost",9559);


        int aantalkeerArmen = 3;
        nao.Stand();
        nao.Talk("Welkom bij deze workout, eerst gaan we de armen wat opwarmen");

            nao.Talk("Pak allemaal de gewichtjes die jullie hebben gekregen");
            nao.Stand();
            Thread.sleep(3000);
            nao.Talk("Doe nu beide armen op zij en houdt ze omhoog voor tien seconden");
            nao.ArmsRoll();
            Thread.sleep(10000);
            nao.Talk("Laat beide armen rustig omlaag zakken");
            nao.Stand();
            Thread.sleep(3000);
            nao.Talk("Je mag nu beide armen naar voren steken en daar weer houden voor tien seconden");
            nao.ArmsForward();
            Thread.sleep(10000);
            nao.Talk("Laat beide armen maar weer rustig omlaag zakken");
            nao.Stand();
            Thread.sleep(3000);
            nao.Talk("En breng beide armen nu helemaal omhoog boven je hoofd, weer tien seconden");
            nao.ArmsUp();
            Thread.sleep(10000);
            nao.Talk("En laat je armen maar rusten");
            Thread.sleep(3000);
            nao.ArmsDown();
            nao.Talk("Nu gaan we de armen vijftien keer in de rondte draaien met beide armen");
            Thread.sleep(2000);
            nao.ArmExercise(15);
            nao.Talk("Laat de armen langzaam naar beneden en rust maar even op je plaats");
            Thread.sleep(5000);
            nao.Talk("Als laatste gaan we de armen voor ons uit steken en een vliegbeweging maken zoals dit");
            Thread.sleep(2000);
            nao.armExerciseOpen();
            Thread.sleep(2000);
            nao.armExerciseClose();
            Thread.sleep(2000);
            nao.armExerciseOpen();
            Thread.sleep(2000);
            nao.Stand();
            nao.Talk("Dit gaan we nu twaalf keer herhalen");
            Thread.sleep(4000);
            int reps = 12;
            for (int i = 0; i < reps; i++) {
                nao.armExerciseOpen();
                Thread.sleep(2000);
                nao.armExerciseClose();
                Thread.sleep(2000);
                nao.armExerciseOpen();
            }
            nao.Stand();
            Thread.sleep(30000);

        nao.Talk("Oke we beginnen weer met de armen omhoog te houden voor tien seconden");
        nao.ArmsRoll();
        Thread.sleep(10000);
        nao.Talk("Laat beide armen maar weer rustig omlaag zakken");
        Thread.sleep(1000);
        nao.Stand();
        Thread.sleep(3000);
        nao.Talk("Je mag nu beide armen naar voren steken en daar weer houden voor tien seconden");
        nao.ArmsForward();
        Thread.sleep(10000);
        nao.Talk("Laat beide armen maar weer rustig omlaag zakken");
        nao.Stand();
        Thread.sleep(3000);
        nao.Talk("En breng beide armen nu weer helemaal omhoog boven je hoofd voor tien seconden");
        nao.ArmsUp();
        Thread.sleep(10000);
        nao.Talk("En laat je armen maar rusten");
        Thread.sleep(3000);
        nao.ArmsDown();
        nao.Talk("Nu gaan we de armen vijftien keer in de rondte draaien met beide armen");
        Thread.sleep(2000);
        nao.ArmExercise(15);
        nao.Talk("Laat de armen langzaam naar beneden en rust maar even op je plaats");
        Thread.sleep(5000);
        nao.Talk("Als laatste gaan we weer dearmen voor ons uit steken en een vliegbeweging maken");
        nao.Stand();
        nao.Talk("Dit gaan we twaalf keer herhalen");
        Thread.sleep(4000);

        for (int i = 0; i < reps; i++) {
            nao.armExerciseOpen();
            Thread.sleep(2000);
            nao.armExerciseClose();
            Thread.sleep(2000);
            nao.armExerciseOpen();
        }
        nao.Stand();
        nao.Talk("Neem maar 30 seconde rust en dit gaan we nog een keer herhalen");
        Thread.sleep(30000);
        nao.Talk("Doe nu beide armen maar weer op zij en houdt ze omhoog voor tien seconden");
        nao.ArmsRoll();
        Thread.sleep(10000);
        nao.Talk("Doe je Armen direct naar voren en houd ze daar weer voor tien seconden");
        nao.StandZero();
        nao.ArmsForward();
        Thread.sleep(10000);
        nao.Talk("Doe beide armen omlaag en en daarna meteen weer omhoog zoals dit");
        nao.Stand();
        nao.ArmsUp();
        Thread.sleep(1000);
        nao.Talk("Dit herhalen we twaalf keer vrij snel achter elkaar");
        Thread.sleep(1500);
        nao.Talk("Daar gaan we");
        for (int i = 0; i <reps ; i++) {
         nao.Stand();
         Thread.sleep(1000);
         nao.ArmsUp();
         Thread.sleep(1000);
        }
        Thread.sleep(10000);
        nao.Talk("En laat je armen maar rusten");
        Thread.sleep(3000);
        nao.Stand();
        nao.Talk("Nu gaan we weer vijftien keer in de rondte draaien met beide armen");
        Thread.sleep(1500);
        nao.ArmExercise(15);
        nao.Talk("Laat de armen langzaam naar beneden en rust maar even op je plaats");
        Thread.sleep(5000);
        nao.Talk("Als laatste gaan we weer de armen voor ons uit steken en een vliegbeweging maken");
        Thread.sleep(500);
        nao.Talk("Dit gaan we weer twaalf keer herhalen");
        Thread.sleep(4000);
        for (int i = 0; i < reps; i++) {
            nao.armExerciseOpen();
            Thread.sleep(2000);
            nao.armExerciseClose();
            Thread.sleep(2000);
            nao.armExerciseOpen();
        }
        nao.Stand();
        nao.Talk("Dit was de workout, bedankt voor de aandacht");
    }
}
