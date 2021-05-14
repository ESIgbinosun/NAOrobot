import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;

public class MyThread extends Thread {

        NAO nao;

        public void run(){


            try {
                nao.SquatStefano(20);



                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Thread #1 is finished");


        }


}


