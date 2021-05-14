import com.aldebaran.qi.helper.proxies.ALAudioPlayer;

public class Main {

    public static void main(String[] args) throws Exception {

        //create mqtt, NAO object and audioplayer
        Mqtt mqtt = new Mqtt();
        NAO nao = new NAO();

        //connect to the NAO robot, physical or virtual
        nao.verbind("localhost",9559);
        ALAudioPlayer alAudioPlayer = new ALAudioPlayer(NAO.getApplication().session());
        //Fysieke robots : hostname = "padrick.robot.hva-robots.nl" port = 9559
        Thread.sleep(5000);

        //create different thread objects
        Multithread t;
        Multithread t2;
        Multithread t3;
        Multithread t4;
        Multithread t5;



        //create a while loop so that the application can continue to receive mqtt messages from the android application
        while (true){
            int reps;


            try {
                //switch case to read to mqtt message which is sent from the android app
                switch (mqtt.readMsg().toLowerCase()) {
                    //welcomes you to the workoutpage
                    case "workoutpage":
                        nao.Talk("Welkom op de workout pagina, kies de workout die u wilt doen");
                        break;
                        //welcomes you to the newspage
                    case "newspage":
                        nao.Talk("Welkom op de nieuws pagina, kies voor het nieuws dat u wilt horen");
                        break;
                        //welcomes you to th esongpage
                    case "songpage":
                        nao.Talk("Welkom op de zang pagina, kies voor het lied dat u wilt horen");
                        break;
                        //this case lets NAO read out a news article
                    case "newsupdate":
                        System.out.println("NEWS UPDATE");
                        break;
                        //this case lets NAO read out the current weather in a place of choice
                    case "weatherupdate":
                        System.out.println("WEATHER UPDATE");
                        nao.jsonObject("Amsterdam");
                        break;
                        //this case plays audio and lets NAO move on "the beat"
                    case "muziek1":
                        System.out.println("MALLE BABBE");
                        nao.LyingBack();
                        t = new Multithread("C:\\Users\\fonsd\\Untitled\\malleBabbe.wav",0.3f,0f, alAudioPlayer);
                        t.run();
                        nao.Stand();
                        break;
                    //this case plays audio and lets NAO move on "the beat"
                    case "muziek2":
                        System.out.println("EEN EIGEN HUIS");
                        nao.Sit();
                        t2 = new Multithread("eeneigenhuisdirectory",0.3f,0f, alAudioPlayer);
                        t2.run();
                        nao.Stand();
                        break;
                    //this case plays audio and lets NAO move on "the beat"
                    case "muziek3":
                        System.out.println("STIEKEM GEDANST");
                        nao.LyingBelly();
                        t3 = new Multithread("stiekemgedanstdirectory",0.3f,0f, alAudioPlayer);
                        t3.run();
                        nao.Stand();
                        break;
                    //this case plays audio and lets NAO move on "the beat"
                    case "muziek4":
                        System.out.println("LAND VAN MAAS EN WAAL");
                        nao.Crouch();
                        t4 = new Multithread("landvanmaasenwaaldirectory",0.3f,0f, alAudioPlayer);
                        t4.run();
                        nao.Stand();
                        break;
                    //this case plays audio and lets NAO move on "the beat"
                    case "muziek5":
                        System.out.println("MET DE VLAM IN DE PIJP");
                        nao.ArmsForward();
                        t5 = new Multithread("metdevlamindepijpdirectory",0.3f,0f, alAudioPlayer);
                        t5.run();
                        nao.Stand();
                        break;
                        //this case lets NAO do an upper body workout +- 10 minutes long
                    case "armenoefening":
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
                        reps = 12;
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
                        for (int i = 0; i < reps; i++) {
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
                        break;
                        //this case lets NAO do a lower body workout +- 10 minutes
                    case "benenoefening":
                        reps = 12;
                        nao.Stand();
                        nao.Talk("Welkom bij deze workout, we beginnen met steeds drie stappen naar voren te doen en drie naar achter zoals dit");
                        Thread.sleep(1500);
                        nao.Walk(0.1f, 0f, 0f);
                        Thread.sleep(500);
                        nao.Walk(-0.1f, 0f, 0f);
                        Thread.sleep(1000);
                        nao.Talk("Dit herhalen we twaalf keer");
                        Thread.sleep(2000);
                        nao.Talk("Daar gaan we");
                        for (int i = 0; i < reps; i++) {
                            nao.Walk(0.1f, 0f, 0f);
                            Thread.sleep(500);
                            nao.Walk(-0.1f, 0f, 0f);
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
                        nao.Walk(0.1f, 0f, 0f);
                        Thread.sleep(500);
                        nao.Talk("Dan een squat");
                        nao.Squat(1);
                        nao.Talk("Drie stappen naar achter");
                        nao.Walk(-0.1f, 0f, 0f);
                        Thread.sleep(500);
                        nao.Talk("Dan weer een squat");
                        nao.Squat(1);
                        Thread.sleep(1000);
                        nao.Talk("Dit herhalen we weer twaalf keer");
                        nao.Talk("Daar gaan we weer");
                        Thread.sleep(1000);
                        for (int i = 0; i < reps; i++) {
                            nao.Walk(0.1f, 0f, 0f);
                            Thread.sleep(500);
                            nao.Squat(1);
                            nao.Walk(-0.1f, 0f, 0f);
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
                        nao.Walk(0f, 0.1f, 0f);
                        Thread.sleep(1000);
                        nao.Talk("Dan een squat");
                        nao.Squat(1);
                        Thread.sleep(1000);
                        nao.Talk("Drie stappen naar links");
                        nao.Walk(0f, -0.1f, 0f);
                        Thread.sleep(1000);
                        nao.Talk("En dan weer een squat");
                        nao.Squat(1);
                        Thread.sleep(1000);
                        nao.Talk("Ook dit herhalen we twaalf keer");
                        Thread.sleep(1000);
                        nao.Talk("Daar gaan we");
                        for (int i = 0; i < reps; i++) {
                            nao.Walk(0f, 0.1f, 0f);
                            Thread.sleep(1000);
                            nao.Squat(1);
                            Thread.sleep(1000);
                            nao.Walk(0f, -0.1f, 0f);
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
                        break;
                        //this is a test case for NAO to show a small workout, fill in the for loop how often you
                        //want NAO to do the showcase workout
                    case "mixedoefening":
                        System.out.println("WORKING");
                        for (int i = 0; i < 2; i++) {
                            nao.Squat(2);
                            Thread.sleep(3000);
                            nao.Walk(0f, 1f, 0f);
                            Thread.sleep(1000);
                            nao.Walk(0f, -1f, 0f);
                            Thread.sleep(3000);
                            nao.ArmExercise(3);
                            Thread.sleep(2000);
                            nao.armExerciseOpen();
                            Thread.sleep(1000);
                            nao.armExerciseClose();
                            Thread.sleep(1000);
                            nao.armExerciseOpen();
                            Thread.sleep(1000);
                            nao.armExerciseClose();
                            Thread.sleep(2000);
                        }
                        break;

                }
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
