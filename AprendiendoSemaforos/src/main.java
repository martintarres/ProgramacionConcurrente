public class main {

    public static void main(String[] args){

  //      Semaforo semaforo= new Semaforo();

        Monitor monitor = new Monitor();

        Hilo h1 = new Hilo(monitor);
        Hilo h2 = new Hilo(monitor);
      //  Hilo h3 = new Hilo(semaforo);
       // Hilo h4 = new Hilo(semaforo);
        //Hilo h5 = new Hilo(semaforo);

        h1.start();
        h2.start();
//        h3.start();
  //      h4.start();
    //    h5.start();

    }
}
