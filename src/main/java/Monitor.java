import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Monitor{
  CountDownLatch contador;
  private Semaforo mutex;
  //private Semaphore mutex;
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
  //private List<Object>

  public Monitor(Constantes constantes) {
    contador = new CountDownLatch(2);
    //mutex = new Semaphore(1, true);
    mutex = new Semaforo(1,true);
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
    try{


      System.out.println(Thread.currentThread() + " solicita disparar " + transicion);
      //contador.countDown();
      //contador.await();

      //for(Hilo h : mapa.values()){
        //System.out.println( Thread.currentThread()+ " ---- " + h + " esta : " + h.getState());
      //}
      as(transicion);
      System.out.println( Thread.currentThread() + " volvio de  disparar " + transicion);

    }
    catch(Exception e ){
      System.err.println(e.getMessage());

    }



  }




  public   void as(int transicion) {
    // NO SÉ SI ERA NECESARIO EL SYNCHRONIZED, EL MUTEX MISMO MANEJA LA SINCRONIZACION
    //synchronized (mutex) {


      try {


        System.out.println("El hilo " + Thread.currentThread() + " pide  el mutex");

        mutex.acquire();   // Pido el mutex
        // MANDO A DORMIR UN RATO AL HIJO DE PUTA PORQUE EL SCHEDULER DE JAVA NO CORRE EL OTRO

          Thread.currentThread().sleep(1000);
          System.out.println("El hilo " + Thread.currentThread() + " se lleva  el mutex");
          System.out.println("Threads  esperando por  el mutex  " +  mutex.getQueue());
          System.out.println("Estado de los Hilos: ");

          //ACÀ SI SE VA A MOSTAR QUE EL OTRO FORRO SE BLOQUEO AL LLAMAR AL MUTEX
          for (Hilo h : mapa.values()) {
              System.out.println(h + " esta : " + h.getState());
          }



        k = true;

        while (k == true) {     // Si k es true
            //Thread.currentThread().sleep(500);
            k = petri.disparar(transicion);   // Disparo la transicion

          if (k == true) {
            /*System.out.println("Estado de los Thread: ");
            for (Hilo h : mapa.values()) {
              System.out.println(h + " esta : " + h.getState());
            }*/

            Vs = getHilosSensibilizados();    // armo la lista de hilos sensibilizados
            for(Hilo h : Vs){
              System.out.println("Hilos sensibilizados : " + h);
            }
            //Vc = mutex.getQueue();      // armo la lista de hilos encolados sensibilizados

            System.out.println("Hilos encolados : "+ Vc);
            estaEnAmbas.clear();
            estaEnAmbas = and();
            System.out.println("Hilos que estan en ambas "+ estaEnAmbas);

            // ACA DEBERIA HABER UNA POLITICA PARA CAMBIAR EL ORDEN DE LA LISTA DEL MUTEX

            if (estaEnAmbas.size()!=0) {
              //aca deberiamos ver en las politicas
                //Que recoja el primero encolado


                synchronized(estaEnAmbas.get(0).getLock()){
                    Hilo desencolado = estaEnAmbas.get(0);

                    Vc.remove(desencolado);

                    //k=false;
                    //Vc.add((Hilo) Thread.currentThread());

                    desencolado.getLock().notify();
                    break;
                    //((Hilo) Thread.currentThread()).getLock().wait();
                    //break;

                    //Vc.add((Hilo)Thread.currentThread());

                }
                //estaEnAmbas.get(0).getLock().notify();


              //Vc.remove((Hilo)Thread.currentThread());

              //mutex.release();

            } else {

              k = false;
            }

          } else {
            System.out.println(Thread.currentThread() + " devuelve el mutex");

              Vc.add((Hilo) Thread.currentThread());
              System.out.println("Hilos encolados: " + Vc);
              mutex.release();
              //Thread.currentThread().sleep(100);

            //LO MANDO A DORMIR CON SU PROPIO OBJECT
              synchronized(((Hilo) Thread.currentThread()).getLock()){
                  ((Hilo) Thread.currentThread()).getLock().wait();

              }
            /*if(mutex.availablePermits()==1){
                mutex.acquire(2);
            }
            else{
                mutex.acquire();
            }*/
          }


        }
        System.out.println(Thread.currentThread() + "sale del Monitor");
        if(k){
          System.out.println("Sale sin devolver mutex");

        }
        else{
          System.out.println("Sale devolviendo mutex");
          mutex.release();
        }


      } catch (Exception e) {
        System.err.println(e.getMessage() + "laralara");
      }
    //}
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
  public List<Hilo> and(){
    List<Hilo> and = new ArrayList<Hilo>();
    try{
      for(Hilo s : Vs){
        for(Hilo c : Vc){
          if(s.equals(c)&&!(and.contains(s))){
            and.add(s);

          }
        }
      }
      return and;

    }
    catch(Exception e){
      return  new ArrayList<Hilo>();
    }
  }


}
