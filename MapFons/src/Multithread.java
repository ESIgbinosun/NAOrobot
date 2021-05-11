import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.proxies.ALAudioPlayer;

public class Multithread extends Thread{
    //variabeles to use as parameters in the multithread function
    private Thread t;
    private final String threadName;
    private final float volume;
    private final float pan;
    private final ALAudioPlayer alAudioPlayer;

    //function to create a multithread
    public Multithread( String name, float volume, float pan, ALAudioPlayer alAudioPlayer) {
        this.threadName = name;
        this.volume = volume;
        this.pan = pan;
        this.alAudioPlayer = alAudioPlayer;
    }

    //function to run and play the audio file
    public void run() {
        try {
            alAudioPlayer.playFile(threadName, volume, pan);
        } catch (CallError|InterruptedException callerror) {
            callerror.printStackTrace();
        }
    }

    //function to start the thread
    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
