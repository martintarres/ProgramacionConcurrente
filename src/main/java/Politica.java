import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by YepezHinostroza on 31/8/2017.
 */
public abstract class Politica {
    protected Map<Integer,Hilo> mapa;
    protected List<Integer> abc,acb,bac,bca,cba,cab;
    protected ListasDeDisparos listasDeDisparos;
    public int PiezaA;
    public int PiezaB;
    public int PiezaC;


    public Politica(Map<Integer,Hilo> mapa, ListasDeDisparos listasDeDisparos){

        this.mapa = mapa;
        this.PiezaA=0;
        this.PiezaB=0;
        this.PiezaC=0;
        this.listasDeDisparos = listasDeDisparos;
        cab = new ArrayList<>(listasDeDisparos.l9);
        cab.addAll(listasDeDisparos.l8);
        cab.addAll(listasDeDisparos.l1);
        cab.addAll(listasDeDisparos.l3);
        cab.addAll(listasDeDisparos.l4);
        cab.addAll(listasDeDisparos.l6);
        cab.addAll(listasDeDisparos.l7);

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
