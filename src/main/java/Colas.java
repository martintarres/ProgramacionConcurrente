import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Colas {

    public ArrayList <Hilo> listaHilos;


    public Colas () {
        listaHilos= new ArrayList <Hilo>();
    }


    public  void encolar(Hilo aEncolar){
        //System.out.println("me llego " + aEncolar );
        System.out.println("Encolando " + aEncolar);
        listaHilos.add(aEncolar);
       /* try {
           aEncolar.wait();
        } catch (Exception e) {
            System.out.println("el hilo " + Thread.currentThread() + "esta vivo " + Thread.currentThread().isAlive());
            System.err.println("entre al catch de encolar");
            //e.printStackTrace();
        }*/

    }


    public List <Hilo> quienesEstan(){
        int i=0;
        i= listaHilos.size();
        List <Hilo> listaQuienesEstan = new ArrayList <Hilo>();
        for (int j=0; j<i; j++){
            listaQuienesEstan.add(listaHilos.get(j));
            System.out.println("Estos son los hilos que estan en la cola: " + listaHilos.get(j).getName());
            //System.out.println("Voy a mostrar lo que encolo");
        }
        return listaQuienesEstan;
    }

    public Hilo desencolar(){
        int i=0;
        i=listaHilos.size();
        Hilo hiloADevolver;
        //System.out.println("Muestro el elemento 0 " + listaHilos.get(0).getName());
        //System.out.println("lo borro");
        hiloADevolver= listaHilos.get(0);
        listaHilos.remove(0);
        //System.out.println("Muestro el elemento 0 " + listaHilos.get(0).getName()); // En java al usar remove se mueven solos de lugar
        //System.out.println("Muestro el hilo que voy a devolver " + hiloADevolver.getName() );
        return hiloADevolver;
    }

    public static void main(String[] args){

        Constantes constantes= new Constantes();
        Monitor monitor= new Monitor(constantes);

        List<Integer> l1= new ArrayList<Integer>();
        List<Integer> l2= new ArrayList<Integer>();

        l1.add(constantes.t21);
        l1.add(constantes.t22);


        l2.add(constantes.t23);
        l2.add(constantes.t24);

        Hilo h1 = new Hilo("Hilo 1",l1, monitor);
        Hilo h2 = new Hilo("Hilo 2",l2, monitor);

        h1.setName("hilo 1");
        h2.setName("hilo 2");

        System.out.println("Cree los hilos y le puse nombre");

        Colas colas= new Colas();

        System.out.println("voy a encolar ");

        colas.encolar(h1);
        colas.encolar(h2);


        System.out.println("Voy a mostrar la lista con los hilos que tengo");
        System.out.println(colas.quienesEstan());


        System.out.println("Voy a desencolar ");
        System.out.println("Me llega el hilo " + colas.desencolar().getName() );

        System.out.println("Muestro la nueva cola (Sin el hilo que saque) " + colas.quienesEstan());

    }

}


