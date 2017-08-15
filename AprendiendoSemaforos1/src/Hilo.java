import java.util.concurrent.Semaphore;

public class Hilo extends Thread {

    Semaforo semaforo;
    String name;
    boolean puedoEntrar;
    Monitor monitor;


        public Hilo(Monitor monitor){
            this.monitor=monitor;

           // puedoEntrar= true;
        }

    @Override
    public void run() {


        while (true) {

                    monitor.entrar();

        }
            //e.printStackTrace();
                  // System.err.println(Thread.currentThread() + " estoy dormido");





            //    System.out.println("me quede sin llave " + Thread.currentThread());
         /* try{
            while(disponible() ) {


                    System.out.println("hilo " + Thread.currentThread() + " pidio la llave");
                    System.out.println(Thread.currentThread() + "consiguio la llave " + semaforo.cuantosDisponibles());
                    semaforo.pidoLlave();
            }
              wait();
          }


         catch (Exception e) {
                System.err.println("asd");
           // e.printStackTrace();
        }*/
        }
   // }

    public boolean disponible(){
            if(semaforo.cuantosDisponibles() != 0){
               return true;
                // puedoEntrar = true;
            }else{
                //puedoEntrar=false;
                return false;
            }
            //return puedoEntrar;
    }
}



