
public class Main {

    public static void main(String[] args) throws Exception {
        NAO nao = new NAO();

        nao.connect("localhost", 9559);

        nao.Stand();
//        nao.Talk("Welkom bij deze workout. De oefening van " +
//                "vandaag gaat als volgt. We lopen naar voren, achter, links en rechts." +
//                " en doen een squat tussendoor");
//        Thread.sleep(500);
//        nao.Talk("Zo ziet een squad er uit");
        nao.birdFlying(10);


//        Thread.sleep(1000);
//        nao.SquatStefano(10);
//        Thread.sleep(1000);

//        for (int i = 0; i < 1; i++) {
//            nao.Talk("We gaan naar voren");
//            nao.Walk(0.1f, 0f, 0f);
//            Thread.sleep(1000);
//            nao.Talk("Doe een squat");
//            Thread.sleep(500);
//            nao.SquatStefano(1);
//            Thread.sleep(1000);
//            nao.Talk("En weer naar achter");
//            nao.Walk(-0.1f, 0f, 0f);
//            Thread.sleep(1000);
//            nao.Talk("Doe een squat");
//            nao.SquatStefano(1);
//            Thread.sleep(1000);
//            nao.Talk("En weer naar links");
//            nao.Walk(0f, 0.1f, 0f);
//            Thread.sleep(1000);
//            nao.Talk("Doe een squat");
//            nao.SquatStefano(1);
//            Thread.sleep(1000);
//            nao.Talk("En weer naar rechts");
//            nao.Walk(0f, -0.1f, 0f);
//            Thread.sleep(1000);
//            nao.Talk("Doe een squat");
//            nao.SquatStefano(1);
//        }




    }
    }



