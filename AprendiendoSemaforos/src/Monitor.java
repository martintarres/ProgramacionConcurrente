import java.util.concurrent.Semaphore;

public class Monitor {

    private Semaphore mutex;

    public Monitor(){
        mutex= new Semaphore(1,true);

    }

    public synchronized void entrar() throws InterruptedException {

        System.out.println("el hilo " + Thread.currentThread() + " solicita llave");


        if (mutex.availablePermits()!= 0) {
            mutex.tryAcquire();
            System.out.println("el hilo " + Thread.currentThread() + " se lleva la llave");
            //Thread.sleep(5000);
            // wait();
            haceralgo();
             mutex.release();
            System.out.println("el hilo " + Thread.currentThread() + " devolvi la llave");
            notifyAll();
            wait();

        }
    else {
            //mutex.availablePermits()== 0)
            System.out.println(Thread.currentThread() + " me quede sin llave");
            //Thread.sleep(3000);
            wait();
        }
    }


    public void haceralgo(){
        System.out.println("El hilo " + Thread.currentThread() + " esta en el metodo hacer algo");
        try {
          // Thread.sleep(5000);
          // notifyAll();
            wait(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
