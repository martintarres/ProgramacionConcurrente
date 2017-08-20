
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by YepezHinostroza on 19/8/2017.
 */
public class Semaforo extends Semaphore {
    public Semaforo(int permits,boolean fair){
        super(permits,fair);

    }
    public Semaforo(int permits){
        super(permits);
    }
    public List<Thread> getQueue(){
        List<Thread> cola = new ArrayList<Thread>(getQueuedThreads());
        return cola ;
    }
    public void encolar(Thread t){
        super.getQueuedThreads().add(t);

    }
}
