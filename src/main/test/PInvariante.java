import org.junit.Test;

public class PInvariante {
    Constantes constantes = new Constantes();
    Monitor monitor = new Monitor(constantes);


    @Test
    public void hola() {

        System.out.println("Ahora voy a mostrar el marcado inicial");
        monitor.getPetri().marcadoInicial().imprimir();
        System.out.println("Ahora voy a mostrar el marcado actual");
        monitor.getPetri().marcadoActual().imprimir();
        System.out.println("ahora voy a mostrar el vector que tiene los nombres de los PInvariantes");

        for (int i = 0; i < constantes.inci2; i++) {
            System.out.println(constantes.arregloMP.get(i));
        }

       // monitor.petri.crearListaInvariantes();
    }
}



