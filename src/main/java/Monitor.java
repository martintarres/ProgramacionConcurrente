import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Monitor{

  private Semaphore mutex;
  private boolean k;
  private RdP petri;
  //private Constantes constantes;

  public Monitor(Constantes constantes) {

    mutex = new Semaphore(1, true);
    k=true;
    //constantes = new Constantes();
    petri = new RdP(constantes.marcadoInicial, constantes.incidenciaPrevia, constantes.incidenciaPosterior);

  }

  public void dispararTransicion(int transicion)  {

    System.out.println("el hilo " + Thread.currentThread() + " solicita disparar" + transicion);
    as(transicion);
    System.out.println("volvi");
  }


  public synchronized void as(int transicion) {
    if (mutex.availablePermits() != 0) {

      try {

        mutex.acquire();
        System.out.println("el hilo " + Thread.currentThread() + " disparo transicion");
        k=true;

        while(k){

            petri.disparar(transicion);
          System.out.println("Transiciones sensibilizadas");
           // petri.Sensibilizadas(petri.getIncidenciaPrevia(),petri.marcadoActual()).imprimir();
           // System.out.println(petri.sensibilizadas());
            wait();



        }

     /*/////////////////////////////////////////////////////////////////////////////////////////////
        wait(5000);
        notifyAll();
        System.out.println("el hilo " + Thread.currentThread() + " devuelvo la  llave");
        mutex.release();
    //////////////////////////////////////////////////////////////////////////////////////////////*/

      } catch (Exception e) {

      }


    } else {


      try {
        System.out.println("el hilo " + Thread.currentThread() + " se queda sin llave");
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }

}
