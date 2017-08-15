import java.util.concurrent.Semaphore;
import java.util.Random;
public class Hilo extends Thread {

    Semaforo semaforo;
    String name;
    boolean puedoEntrar;
    Monitor monitor;
    Random random = new Random();

        public Hilo(Monitor monitor){
            this.monitor=monitor;
           // puedoEntrar= true;
        }

    @Override
    public void run() {

        while (true) {

            try {
                monitor.entrar();
                int valorEntero = Math.abs(random.nextInt(3));
                System.out.print(valorEntero);

                sleep(valorEntero *1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.err.println("entre al catch");
            }

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
    }

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



