import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALAudioPlayer;

public class Multithread extends Thread{
    private Thread t;
    private final String threadName;
    private final float volume;
    private final float pan;
    private final ALAudioPlayer alAudioPlayer;

    public Multithread( String name, float volume, float pan, ALAudioPlayer alAudioPlayer) {
        this.threadName = name;
        this.volume = volume;
        this.pan = pan;
        this.alAudioPlayer = alAudioPlayer;
    }

    public void run() {
        try {
            alAudioPlayer.playFile(threadName, volume, pan);
        } catch (CallError|InterruptedException callerror) {
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
