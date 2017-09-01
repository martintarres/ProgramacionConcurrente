import java.util.List;

/**
 * Created by YepezHinostroza on 31/8/2017.
 */
public class PoliticaRandom extends Politica{

    public Hilo getHilo(List<Hilo> lista){
        for (Hilo h :
                lista) {
            if (h.getNombre().equals("Hilo 8")) {
                return h;
            }
        }
        return lista.get((int) Math.random()*lista.size());
    }
}
