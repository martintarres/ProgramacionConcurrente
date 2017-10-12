import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by YepezHinostroza on 11/10/2017.
 */
public class PoliticaRandom extends Politica{

    public PoliticaRandom(Map<Integer,Hilo> mapa){
        super(mapa);
    }

    public Integer getLock(Matriz VectorAnd){
        List<Integer> lista = new ArrayList<Integer>();
        for (int i = 0; i < VectorAnd.getN(); i++) {
            if(VectorAnd.getMatriz()[0][i]!=0){
                lista.add(i);
            }

        }
        int  entero =  lista.get((int)(Math.random()*lista.size()));
        return getInteger(entero);


    }

}
