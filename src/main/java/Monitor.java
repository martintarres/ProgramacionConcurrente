import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.Semaphore;

public class Monitor{

  private Semaphore mutex;
  private boolean k;
  private RdP petri;
  private List<Hilo> listaHilos;
  private Map<Integer,Hilo> mapa;
  //private Constantes constantes;

  public Monitor(Constantes constantes) {

    mutex = new Semaphore(1, true);
    k=true;
    //constantes = new Constantes();
    petri = new RdP(constantes.marcadoInicial, constantes.incidenciaPrevia, constantes.incidenciaPosterior);
    listaHilos= new ArrayList <Hilo>();
    mapa = new HashMap<Integer,Hilo>();
  }

  public void dispararTransicion(int transicion)  {

    System.out.println("el hilo " + Thread.currentThread() + " solicita disparar " + transicion);
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
          getHilos();
          saber();
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
      //  System.out.println("el hilo " + Thread.currentThread() + " se queda sin llave");
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }
  }

  public void setHilos(Hilo hilo){
      listaHilos.add(hilo);
  }

  public void getHilos(){

    System.out.println("voy a mostrar todos los hilos del programa");
    for(Hilo t : listaHilos){
       // System.out.println("soy hilo " + t.getNombre());
        System.out.println("soy transiciones del hilo " + t.getNombre()+ t.getTransiciones());
    }
  }

  public void saber(){
    System.out.println("soy saber");
      petri.getVectorSensibilizadas().imprimir();

  }
  public void mapeo(Hilo hilo){
    for(Integer i: hilo.getTransiciones()){
      this.mapa.put(i,hilo);
    }
  }
  public void showMapa(){
    System.out.println("Mapa de Transiciones e Hilos");
    for(Integer i : this.mapa.keySet())
    {
      System.out.println("Transicion " + i + " correspondiente al hilo  "+ this.mapa.get(i).getNombre());
    }
  }


}
