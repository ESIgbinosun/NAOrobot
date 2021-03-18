/*
 * Controller code Nao bot
 *
 * Author: Diego Brandjes
 * Class: IT101
 * Date: 09-03-2021
 */

public class main {
    public static void main(String[] args) throws Exception {

        mqtt mqtt = new mqtt();
        NAO nao = new NAO();

        nao.connect("localhost",9559);
        Thread.sleep(3000);


        while (true) {

            switch (mqtt.readMsg().toLowerCase()){

                case "testmsg":
                    System.out.println("Working!");

                    break;

                case "oefeningarmen":
                    nao.oefeningArmen(4);
                    System.out.println("Oefening uitgevoerd.");

                    break;

                case "walk":
                    nao.lopen(1f,0f,0f);
                    System.out.println("Walk uitgevoerd.");
                    break;

                case "layonback":
                    nao.layOnBack();
                    System.out.println("LayOnBack uitgevoerd.");

                    break;

                case "stand":
                    nao.stand();
                    System.out.println("Stand uitgevoerd.");

                    break;
                case "benenworkout":
                    nao.benenWorkout(5);
                    System.out.println("Benen Workout uitgevoerd.");

                    break;


                default:
            }
        }
    }
}


