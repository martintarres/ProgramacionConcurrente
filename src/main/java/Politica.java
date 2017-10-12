import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by YepezHinostroza on 31/8/2017.
 */
public abstract class Politica {
    protected Map<Integer,Hilo> mapa;

    public Politica(Map<Integer,Hilo> mapa){

        this.mapa = mapa;

    }

    public abstract Integer getLock(Matriz VectorAnd);

    public Integer getInteger(int entero){
        for (Integer i: mapa.keySet()) {
            if (i.intValue()==entero){
                return i;
            }
        }
        //Deberpia tirar una excepción por si falla, pero me la soba a estas alturas
        return null;
    }
}
