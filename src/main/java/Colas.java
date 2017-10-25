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

}


