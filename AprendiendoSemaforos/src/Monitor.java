import java.util.concurrent.Semaphore;

public class Monitor {

    private Semaphore mutex;

    public Monitor(){
        mutex= new Semaphore(1,true);

    }

    public synchronized void entrar() throws InterruptedException {

        System.out.println("el hilo " + Thread.currentThread() + " solicita llave");


        while (mutex.availablePermits()!= 0) {
            mutex.acquire();
            System.out.println("el hilo " + Thread.currentThread() + " se lleva la llave");
            //Thread.sleep(5000);
            // wait();
            haceralgo();
             mutex.release();
            System.out.println("el hilo " + Thread.currentThread() + " devolvi la llave");
            notifyAll();
        }

        //mutex.availablePermits()== 0)
            System.out.println(Thread.currentThread() + " me quede sin llave");
             //Thread.sleep(3000);
             wait();

    }


    public void haceralgo(){
        System.out.println("El hilo " + Thread.currentThread() + " esta en el metodo hacer algo");
        try {
           Thread.sleep(5000);
          // notifyAll();
           // wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
