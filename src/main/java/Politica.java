import java.util.List;

/**
 * Created by YepezHinostroza on 31/8/2017.
 */
public abstract class Politica {

    public Politica(){

    }

    public abstract Hilo getHilo(List<Hilo> lista);
}
