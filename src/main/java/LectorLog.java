import java.util.ArrayList;
import java.util.List;

/**
 * Created by YepezHinostroza on 30/8/2017.
 */
public class LectorLog {
    public static void main(String[] args){
        // SI ROCOJO ESTA LINEA DEL LOG, PUEDO ARMAR LA MATRIZ MARCADO ACTUAL
        List<Integer> enteros = new ArrayList<Integer>();
        String cadena = "   1   1   1   1  10   0   0   0   0   0   0   0   0  10   0   0   0  10   0   0   0   0   0   1   1   1   1   1";
        String[] partes = cadena.split(" ");
        for(String parte: partes){
            if(Constantes.esNumero(parte)){
                enteros.add(Integer.parseInt(parte));
            }
        }
        int[][] arreglo = new int[enteros.size()][1];
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i][0]=enteros.get(0);
            enteros.remove(0);

        }
        try{
            Matriz marcadoActual = new Matriz(arreglo);
            System.out.println("Matriz Marcado Actual: ");
            marcadoActual.transpuesta().imprimir();
        }catch(Exception e){

        }


    }
}
