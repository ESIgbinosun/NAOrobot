public class Main {

    public static void main(String[] args) throws Exception {
        NAO nao = new NAO();
        nao.verbind("localhost", 9559);
        Mqtt mqtt = new Mqtt();
        Thread.sleep(2000);


        while (true)
        {
            //Thread.sleep(3000);
//            switch (mqtt.readMsg()){
//                case "oefening":
//                    nao.oefening(3);
//                    break;
//
//            }
        }

    }

}
