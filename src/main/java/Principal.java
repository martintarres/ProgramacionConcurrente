import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main (String[] args){

        Constantes constantes= new Constantes();

        Monitor monitor= new Monitor(constantes);
        System.out.println("Marcado Actual: ");
        // SOLO LA TRANSPONGO PARA QUE SE IMPRIMI EN UNA LINEA
        monitor.getPetri().marcadoActual().transpuesta().imprimir();
        System.out.println("Matriz Incidencia: ");
        monitor.getPetri().getIncidencia().imprimir();
        System.out.println("Matriz P Invariantes: ");
        monitor.getPetri().getMInvariantes().imprimir();

        List<Integer> l1= new ArrayList<Integer>();
        List<Integer> l2= new ArrayList<Integer>();
        List<Integer> l3= new ArrayList<Integer>();
        List<Integer> l4= new ArrayList<Integer>();
        List<Integer> l5= new ArrayList<Integer>();
        List<Integer> l6= new ArrayList<Integer>();
        List<Integer> l7= new ArrayList<Integer>();
        List<Integer> l8= new ArrayList<Integer>();
        List<Integer> l9= new ArrayList<Integer>();


        l1.add(10);
        l1.add(11);


        l2.add(12);
        l2.add(13);

/*

        l1.add(constantes.arregloT.get(0));
        l1.add(constantes.arregloT.get(1));

        l1.add(constantes.arregloT.get(2));
        l1.add(constantes.arregloT.get(3));

        l2.add(constantes.arregloT.get(12));
*/
      //  l2.add(constantes.arregloT.get(13));


        /*l3.add(constantes.t10);


        l4.add(constantes.t11);


        l5.add(constantes.t13);
        l5.add(constantes.t15);
        l5.add(constantes.t17);

        l6.add(constantes.t12);
        l6.add(constantes.t14);
        l6.add(constantes.t16);
        l6.add(constantes.t18);

        l7.add(constantes.t19);

        l8.add(constantes.t35);
        l8.add(constantes.t36);

        l9.add(constantes.t31);
        l9.add(constantes.t32);
        l9.add(constantes.t33);
        l9.add(constantes.t34);
*/

        Hilo h1 = new Hilo("Hilo 1",l1, monitor);
        Hilo h2 = new Hilo("Hilo 2",l2, monitor);

     /*   Hilo h3 = new Hilo("Hilo 3",l3, monitor);
        Hilo h4 = new Hilo("Hilo 4",l4, monitor);
        Hilo h5 = new Hilo("Hilo 5",l5, monitor);
        Hilo h6 = new Hilo("Hilo 6",l6, monitor);
        Hilo h7 = new Hilo("Hilo 7",l7, monitor);
        Hilo h8 = new Hilo("Hilo 8",l8, monitor);
        Hilo h9 = new Hilo("Hilo 9",l9, monitor);
*/

        monitor.mapeo(h1);
        monitor.mapeo(h2);
/*
        monitor.mapeo(h3);
        monitor.mapeo(h4);
        monitor.mapeo(h5);
        monitor.mapeo(h6);
        monitor.mapeo(h7);
        monitor.mapeo(h8);
        monitor.mapeo(h9);

       // monitor.showMapa();
*/


        h1.start();
        h2.start();
/*

        h3.start();
        h4.start();
        h5.start();
        h6.start();
        h7.start();
        h8.start();
        h9.start();
*/


    }
}
