import java.util.List;

public class Hilo extends Thread {

  private String nombre;
  private Monitor monitor;
  private List<Integer> enteros;
  private Object lock;

  public Hilo(String nombre, List <Integer> enteros, Monitor monitor){
    this.nombre = nombre;
    this.monitor = monitor;
    this.enteros=enteros;
    lock = new Object();
  }

  public String getNombre(){
    return this.nombre;
  }

  public void run(){
    try{
      while(true){
        for(Integer i : enteros)
        {
          monitor.dispararTransicion(i.intValue());
        }

      }

    }catch(Exception e){
      System.err.println(e.getMessage());
    }
   // System.out.println("Soy hilo "+ nombre);


  }

  public List<Integer> getTransiciones(){
      return enteros;
  }
  public Object getLock(){
    return this.lock;
  }


}
