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
  private List <Hilo> Vs;  // Lista de hilos sensibilizados (Vendria a ser senzibilizadas())
  private List <Hilo> Vc;  // Lista de hilos encolados porque sus transiciones no estaban sensibilizadas
  private List <Hilo> estaEnAmbas;  // Lista de hilos que estan en las dos listas de arriba
  private Colas colas;
  private int m;
  private Hilo hiloDesencolado;

  public Monitor(Constantes constantes) {

    mutex = new Semaphore(1, true);
    k=true;
    //constantes = new Constantes();
    petri = new RdP(constantes.marcadoInicial, constantes.incidenciaPrevia, constantes.incidenciaPosterior);
    listaHilos= new ArrayList <Hilo>();
    mapa = new HashMap<Integer,Hilo>();
    Vs= new ArrayList <Hilo>();
    Vc= new ArrayList <Hilo>();
    estaEnAmbas= new ArrayList <Hilo>();
    colas=new Colas();
    m=0;
  }

  public void dispararTransicion(int transicion)  {

    System.out.println("el hilo " + Thread.currentThread() + " solicita disparar " + transicion);
    as(transicion);
    System.out.println("volvi");

  }


  public synchronized void as(int transicion) {

    if(mutex.availablePermits() !=0) {

      System.out.println("entre a available " + Thread.currentThread());

      try {

        mutex.acquire();   // Pido el mutex
        k=true;

        while(k==true){     // Si k es true

          k=petri.disparar(transicion);   // Disparo la transicion

          if(k==true){

            System.out.println("voy a mostrar hilos sensiblizados " + getHilosSensibilizados());

            Vs=getHilosSensibilizados();    // armo la lista de hilos sensibilizados

            //System.out.println("Voy a preguntar quienes estan en la cola");
            // colas.encolar((Hilo) Hilo.currentThread());
            // System.out.println(colas.quienesEstan());

            Vc=colas.quienesEstan();      // armo la lista de hilos encolados sensibilizados

            if(Vc.isEmpty()){
              m=0;
            }
            else{
              m=1;
            }

            System.out.println("soy m " + m );

          /*Esto es para ver si hay algun hilo que este en las dos listas */

            for(Hilo j : Vc) {
              for (Hilo i : Vs) {
                if (j.equals(i)) {
                  m++;
                  estaEnAmbas.add(i);
                  System.out.println("el hilo " + i.getName()+ " esta en ambas colas");
                }
              }
            }

            if(m != 0){                 /// vamos a hacer la parte del m

              //aca deberiamos ver en las politicas

              hiloDesencolado=colas.desencolar();
              System.out.println("desecole el hilo " + hiloDesencolado.getName());
              notify();

              //aca apararece un relase() hacia colas que no sabemos que es

            }else{

              k=false;
            }

          }

          mutex.release();
          //System.out.println("voy a llamar a encolar con " + Thread.currentThread());
          colas.encolar((Hilo) Thread.currentThread());
          notifyAll();
          wait();



        }





      } catch (Exception e) {
    System.err.println("dtrdrt");
      }

    }

  /*  //es necesario el if si solo entra uno??
    if (mutex.availablePermits() != 0) {

      try {

        mutex.acquire();

        k=true;

        while(k){
          System.out.println("El hilo " + Thread.currentThread() + " trata de disparar la transicion");
          System.out.println("voy a mostrar hilos sensiblizados " + getHilosSensibilizados());
          k = petri.disparar(transicion);
          System.out.println("primero");
          System.out.println("voy a mostrar hilos sensiblizados " + getHilosSensibilizados());
          k = petri.disparar(transicion);
          System.out.println("segundo");
          System.out.println("voy a mostrar hilos sensiblizados " + getHilosSensibilizados());
          k = petri.disparar(transicion);
          System.out.println("tercero");
          System.out.println("voy a mostrar hilos sensiblizados " + getHilosSensibilizados());
          k = petri.disparar(transicion);
          k = petri.disparar(transicion);
          k = petri.disparar(transicion);
          System.out.println("cuarto");
          System.out.println("voy a mostrar hilos sensiblizados " + getHilosSensibilizados());


          if(k){
            //List<Hilo> hilosSensibilizados = getHilosSensibilizados();
          // bloque Alt k == true


          }
          else{
            mutex.release();

            // Encolar y dormir el hilo actual
          }

           // petri.Sensibilizadas(petri.getIncidenciaPrevia(),petri.marcadoActual()).imprimir();
           // System.out.println(petri.sensibilizadas());
        }
*/
     /*/////////////////////////////////////////////////////////////////////////////////////////////
        wait(5000);
        notifyAll();
        System.out.println("el hilo " + Thread.currentThread() + " devuelvo la  llave");
        mutex.release();
    //////////////////////////////////////////////////////////////////////////////////////////////*/
      /*  notifyAll();
      } catch (Exception e) {

      }


    } else {


      try {
      //  System.out.println("el hilo " + Thread.currentThread() + " se queda sin llave");
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }*/
  }

  public void setHilos(Hilo hilo){
      listaHilos.add(hilo);
  }



  public List<Hilo> getHilosSensibilizados(){
    List<Hilo> lista = new ArrayList<Hilo>();
    int [][] array = petri.getVectorSensibilizadas().getMatriz();
    for(int i=0;i<petri.getVectorSensibilizadas().getN();i++){
      if(array[0][i]!=0){
        if(mapa.containsKey(i)&&!lista.contains(mapa.get(i))){
          lista.add(mapa.get(i));
        }
      }
    }
    return lista;
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
      System.out.println("Transicion " + i + " correspondiente al hilo  "+ this.mapa.get(i));
    }
  }


}
