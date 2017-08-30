import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PInvariantes {
    Constantes constantes = new Constantes();
    Monitor monitor = new Monitor(constantes);
    List<Integer> l1= new ArrayList<Integer>();

    @Test
    public void hola() {

        //l1.add(constantes.arregloT.get(0));
      //  l1.add(constantes.arregloT.get(1));
      //  Hilo h1 = new Hilo("Hilo 1",l1, monitor);
      //  monitor.mapeo(h1);


        for(int i=0;i<constantes.arregloT.size();i++){
            monitor.dispararTransicion(constantes.arregloT.get(i));
        }



        /*System.out.println(monitor.getPetri().listaPI.get(0).getplazas());
        System.out.println("Voy a mostrar lo que suma");
        System.out.println(monitor.getPetri().listaPI.get(0).cantidadTokens(monitor.getPetri().marcadoActual()));
        System.out.println("Voy a mostrar lo que deberia dar");
        System.out.println(monitor.getPetri().listaPI.get(5).getConstante());*/

    }
}
