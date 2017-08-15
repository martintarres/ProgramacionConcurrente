import java.util.concurrent.Semaphore;

public class Monitor {

    private Semaphore mutex;

    public Monitor() {
        mutex = new Semaphore(1, true);

    }

    public void entrar() {

        System.out.println("el hilo " + Thread.currentThread() + " solicita llave");
        as();
        System.out.println("volvi");
    }


    public synchronized void as() {
        if (mutex.availablePermits() != 0) {

            try {

                mutex.acquire();
                System.out.println("el hilo " + Thread.currentThread() + " se lleva la  llave");
                wait(5000);
                notifyAll();
                System.out.println("el hilo " + Thread.currentThread() + " devuelvo la  llave");
                mutex.release();

            } catch (InterruptedException e) {

            }


        } else {


            try {
                System.out.println("el hilo " + Thread.currentThread() + " se queda sin llave");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

