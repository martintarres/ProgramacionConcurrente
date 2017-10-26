import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by YepezHinostroza on 3/9/2017.
 */
public class TInvarianteTest {
    private Constantes constante;
    private Monitor monitor;
    private ListasDeDisparos listas;

    @Before
    public void Inicializacion(){
        // CADA VEZ QUE CORRA UN TEST LO RECONSTRUYO POR LAS DUDAS
        constante =  new Constantes();

        monitor = new Monitor(constante);
        listas = new ListasDeDisparos();



    }
    @Test
    public void Test1(){


        // CONCATENO LAS LISTAS DE LOS HILOS
        // CUIDADO QUE SE MODIFICAN LAS LISTAS ORIGINALES

        listas.l3.addAll(listas.l4);
        listas.l3.addAll(listas.l5);
        listas.l3.addAll(listas.l7);

        try{
            for (Integer i :
                    listas.l3) {
                monitor.getPetri().disparar(i);

            }
            assertTrue(monitor.getPetri().marcadoInicial().esIgual(monitor.getPetri().marcadoActual()));

        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }

    }
    @Test
    public void Test2(){


        // CONCATENO LAS LISTAS DE LOS HILOS
        // CUIDADO QUE SE MODIFICAN LAS LISTAS ORIGINALES

        listas.l3.addAll(listas.l6);
        listas.l3.addAll(listas.l7);

        try{
            for (Integer i :
                    listas.l3) {
                monitor.getPetri().disparar(i);

            }
            assertTrue(monitor.getPetri().marcadoInicial().esIgual(monitor.getPetri().marcadoActual()));

        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }

    }
    @Test
    public void Test3(){


        // CONCATENO LAS LISTAS DE LOS HILOS
        // CUIDADO QUE SE MODIFICAN LAS LISTAS ORIGINALES

        listas.l1.addAll(listas.l2);

        try{
            for (Integer i :
                    listas.l1) {
                monitor.getPetri().disparar(i);

            }
            assertTrue(monitor.getPetri().marcadoInicial().esIgual(monitor.getPetri().marcadoActual()));

        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }

    }
    @Test
    public void Test4(){


        // CONCATENO LAS LISTAS DE LOS HILOS
        // CUIDADO QUE SE MODIFICAN LAS LISTAS ORIGINALES

        listas.l9.addAll(listas.l8);

        try{
            for (Integer i :
                    listas.l9) {
                monitor.getPetri().disparar(i);

            }
            assertTrue(monitor.getPetri().marcadoInicial().esIgual(monitor.getPetri().marcadoActual()));

        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }

    }
}
