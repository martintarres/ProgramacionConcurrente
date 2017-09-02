import java.util.ArrayList;
import java.util.List;

/**
 * Created by YepezHinostroza on 31/8/2017.
 */
public abstract class Politica {
    protected List<Hilo> A;
    protected List<Hilo> B;
    protected List<Hilo> C;

    public Politica(List<Hilo> lista){

        this.A = new ArrayList<Hilo>();
        this.B = new ArrayList<Hilo>();
        this.C = new ArrayList<Hilo>();

        for (Hilo h :
                lista) {
            if(h.getNombre().equals("Hilo 8")||h.getNombre().equals("Hilo 9")){
                C.add(h);
            }
            else{
                if(h.getNombre().equals("Hilo 1")||h.getNombre().equals("Hilo 2")){
                    B.add(h);
                }
                else{A.add(h);}
            }
        }

    }

    public abstract Hilo getHilo(List<Hilo> lista);
}
