import com.aldebaran.qi.CallError;

public class Multithread2 extends NAO implements Runnable{
    private Thread t;
    private final String threadName;

    public Multithread2( String name) {
        this.threadName = name;

    }

    public void run() {
        try {
            Squat(5);
        } catch (Exception e) {
            e.printStackTrace();
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
