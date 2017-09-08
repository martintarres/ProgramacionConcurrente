import java.util.List;

public class Hilo extends Thread {

  private String nombre;
  private Monitor monitor;
  private List<Integer> enteros;
  private Object lock;
  private int contadorDisparos;

  public Hilo(String nombre, List <Integer> enteros, Monitor monitor){
    this.nombre = nombre;
    this.monitor = monitor;
    this.enteros=enteros;
    lock = new Object();
    this.contadorDisparos = 0;

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

  public  void incrementarContador(){
    this.contadorDisparos++;
  }
  public int getContadorDisparos(){
    return this.contadorDisparos;
  }
  public boolean verificarSecuenciaT(int disparada){
    /*
    // Verifica que la lista de enteros del hilo se ejecute en la secuencia fijada
    // @disparada  entero que representa la última trasición que se disparó de ese hilo
    // Usa el operador Resto para conocer qué posición de la lista de enteros se tuvo que disparar
     */
    return disparada==this.getTransiciones().get(this.contadorDisparos%this.getTransiciones().size());

  }


}
