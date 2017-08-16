import java.util.List;

public class Hilo extends Thread {

  private String nombre;
  private Monitor monitor;
  private List<Integer> enteros;

  public Hilo(String nombre, List <Integer> enteros, Monitor monitor){
    this.nombre = nombre;
    this.monitor = monitor;
    this.enteros=enteros;
  }

  public String getNombre(){
    return this.nombre;
  }

  public void run(){
   // System.out.println("Soy hilo "+ nombre);
    for(Integer i : enteros)
    {
      monitor.dispararTransicion(i.intValue());
    }

  }

  public List<Integer> getTransiciones(){
      return enteros;
  }


}
