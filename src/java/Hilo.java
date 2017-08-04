public class Hilo extends Thread {

  private String nombre;
  private Monitor monitor;

  public Hilo(String nombre, Monitor monitor){
    this.nombre = nombre;
    this.monitor = monitor;
  }

  public String getNombre(){
    return this.nombre;
  }

  public void run(){
    System.out.println("Soy hilo "+ nombre);
    monitor.dispararTransicion(this,10);


  }


}
