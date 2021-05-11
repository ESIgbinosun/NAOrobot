import com.aldebaran.qi.CallError;

public class Multithread2 extends Thread{
    private Thread t;
    private final String threadName;

    NAO nao = new NAO();
    public Multithread2( String name) {
        this.threadName = name;

    }

    public void run() {
        try {
            nao.Squat(5);
        } catch (Exception callerror) {
            callerror.printStackTrace();
        }
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
