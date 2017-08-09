import java.util.List;
import java.util.ArrayList;
public class Monitor{

  private static boolean disponible;
  private static Monitor UniqueInstance;
  private static List<Hilo> colaDeHilos;

  private Monitor(){
    Monitor.disponible = true;
    //colaDeHilos = new ArrayList<Hilo>;
  }

  public static Monitor getUniqueInstance(){
    Monitor monitor;
    if(Monitor.UniqueInstance==null){
      monitor = new Monitor();
    }
    else{
      monitor = Monitor.UniqueInstance;

    }
    return monitor;
  }

  public synchronized void dispararTransicion(Hilo hilo,int segundos){
    try{
      System.out.println("Monitor siendo usado por "+ hilo.getNombre());
      hilo.sleep(segundos*1000);
      System.out.println("Monitor deja de ser usado por "+ hilo.getNombre());

    }
    catch(Exception e){

    }
  }


}
