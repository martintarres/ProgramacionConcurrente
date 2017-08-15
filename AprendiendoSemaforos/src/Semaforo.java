import java.util.concurrent.Semaphore;

public class Semaforo {

    Semaphore semaforo;
    boolean disponible;

    public Semaforo(){

        semaforo= new Semaphore(1);
        disponible= true;
    }

    public int cuantosDisponibles(){

        return  semaforo.availablePermits();

    }

    public synchronized void  pidoLlave(){

        System.out.println("me quedan " + semaforo.availablePermits() + " llaves");
        try {
            disponible();
            if(disponible==true) {
                System.out.println("el hilo " + Thread.currentThread() + " pidio la llave");
                semaforo.acquire();
                System.out.println("me quedan " + semaforo.availablePermits() + " llaves");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void disponible (){
        if(semaforo.availablePermits()==0){
            disponible=true;
        }else{
            disponible=false;
        }

    }
}
