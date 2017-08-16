import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main (String[] args){

        Constantes constantes= new Constantes();
        Monitor monitor= new Monitor(constantes);



        List<Integer> l1= new ArrayList<Integer>();
        List<Integer> l2= new ArrayList<Integer>();
        List<Integer> l3= new ArrayList<Integer>();

        l1.add(constantes.t21);
        l1.add(constantes.t22);


        l2.add(constantes.t23);
        l2.add(constantes.t24);


        Hilo h1 = new Hilo("Hilo 1",l1, monitor);
        Hilo h2 = new Hilo("Hilo 2",l2, monitor);
        Hilo h3 = new Hilo("Hilo 3",l3, monitor);

        h1.start();
        h2.start();
        h3.start();



    }
}
