import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Colas {

    public ArrayList <Thread> listaHilos;


    public Colas () {
        listaHilos= new ArrayList <Thread>();
    }


    public void encolar(Thread aEncolar){
        System.out.println("encole el hilo " + aEncolar.getName());
        listaHilos.add(aEncolar);

    }


    public List <Thread> quienesEstan(){
        int i=0;
        i= listaHilos.size();
        List <Thread> listaQuienesEstan = new ArrayList <Thread>();
        for (int j=0; j<i; j++){
            listaQuienesEstan.add(listaHilos.get(j));
            System.out.println("Estos son los hilos que devuelvo: " + listaHilos.get(j).getName());
            //System.out.println("Voy a mostrar lo que encolo");
        }
        return listaQuienesEstan;
    }

    public Thread desencolar(){
        int i=0;
        i=listaHilos.size();
        Thread hiloADevolver;
        //System.out.println("Muestro el elemento 0 " + listaHilos.get(0).getName());
        //System.out.println("lo borro");
        hiloADevolver= listaHilos.get(0);
        listaHilos.remove(0);
        //System.out.println("Muestro el elemento 0 " + listaHilos.get(0).getName()); // En java al usar remove se mueven solos de lugar
        //System.out.println("Muestro el hilo que voy a devolver " + hiloADevolver.getName() );
        return hiloADevolver;
    }

    public static void main(String[] args){

        Thread h1= new Thread();
        Thread h2 = new Thread();

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


