//import org.junit.jupiter.api.Test;
import org.junit.Test;

import static junit.framework.TestCase.assertSame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
//import static org.junit.jupiter.api.Assertions.*;

public class transicionSensiblizadasTest {
    Constantes constantes;
    Monitor monitor;
    Matriz marcadoTemporal;

    @Test
    public void testSensibilizadasPositivo(){

        constantes= new Constantes();
        monitor=new Monitor(constantes);

        int transiciones[] = {0,1,3};

        for(int i=0; i<3;i++) {

                System.out.println("voy a mostrar vector sensibilizados");
                monitor.petri.getVectorSensibilizadas().imprimir();
                System.out.println("voy a intentar disparar con " + transiciones[i]);
                assertEquals(1,monitor.petri.getVectorSensibilizadas().getMatriz()[0][transiciones[i]] );
                marcadoTemporal=monitor.getPetri().marcadoActual();
            try {
                monitor.getPetri().disparar(transiciones[i]);
            } catch (RdPException e) {
                e.printStackTrace();
            }
                monitor.mutex.release();

                monitor.getPetri().marcadoActual().imprimir();
                assertNotSame(marcadoTemporal,monitor.getPetri().marcadoActual());




        }


    }

    @Test
    public void testSensibilizadasNegativo(){
        constantes= new Constantes();
        monitor=new Monitor(constantes);
        Matriz vectorSensibilizadasOriginal;

        int transiciones[] = {4,9,12};

        for(int i=0; i<3;i++) {


            System.out.println("voy a mostrar vector sensibilizados");
            monitor.petri.getVectorSensibilizadas().imprimir();
            System.out.println("voy a intentar disparar con " + transiciones[i]);
            assertEquals(0,monitor.petri.getVectorSensibilizadas().getMatriz()[0][transiciones[i]] );
            marcadoTemporal=monitor.getPetri().marcadoActual();
            try {
                monitor.getPetri().disparar(transiciones[i]);
            } catch (RdPException e) {
                e.printStackTrace();
            }
            monitor.petri.getVectorSensibilizadas().imprimir();
            monitor.mutex.release();
            assertSame(marcadoTemporal, monitor.getPetri().marcadoActual());

        }
    }

}
