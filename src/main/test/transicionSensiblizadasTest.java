import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class transicionSensiblizadasTest {
    Constantes constantes;
    Monitor monitor;

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
                monitor.dispararTransicion(transiciones[i]);
                monitor.petri.getVectorSensibilizadas().imprimir();
                monitor.mutex.release();
                assertEquals(0,monitor.petri.getVectorSensibilizadas().getMatriz()[0][transiciones[i]] );



        }


    }

    @Test
    public void testSensibilizadasNegativo(){
        constantes= new Constantes();
        monitor=new Monitor(constantes);
        Matriz vectorSensibilizadasOriginal;

        int transiciones[] = {4,9,12};

        for(int i=0; i<3;i++) {

            vectorSensibilizadasOriginal=monitor.petri.getVectorSensibilizadas();
            System.out.println("voy a mostrar vector sensibilizados");
            monitor.petri.getVectorSensibilizadas().imprimir();
            System.out.println("voy a intentar disparar con " + transiciones[i]);
            assertEquals(0,monitor.petri.getVectorSensibilizadas().getMatriz()[0][transiciones[i]] );
            monitor.dispararTransicion(transiciones[i]);
            monitor.petri.getVectorSensibilizadas().imprimir();
            monitor.mutex.release();
            assertEquals(0,monitor.petri.getVectorSensibilizadas().getMatriz()[0][transiciones[i]] );

            assertSame(vectorSensibilizadasOriginal,monitor.petri.getVectorSensibilizadas());

        }
    }

}
