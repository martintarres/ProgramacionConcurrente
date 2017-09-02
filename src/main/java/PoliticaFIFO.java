import java.util.List;

/**
 * Created by YepezHinostroza on 1/9/2017.
 */
public class PoliticaFIFO extends Politica {

    public PoliticaFIFO(List<Hilo> lista){
        super(lista);
    }
    public Hilo getHilo(List<Hilo> lista){
        return lista.get(0);
    }
}
