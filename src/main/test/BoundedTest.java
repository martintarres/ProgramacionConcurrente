import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;
/**
 * Created by YepezHinostroza on 3/9/2017.
 */
public class BoundedTest {
    @Test
    public void Acotada(){
        Log lector = new Log("C:\\Users\\alexa\\Desktop\\Concu\\ProgramacionConcurrente\\marcados.txt",
                "\"C:\\\\Users\\\\alexa\\\\Desktop\\\\Concu\\\\ProgramacionConcurrente\\\\registroVacio.txt\"");
        // creo una lista de as lineas
        List<String> Lineas = lector.leerLineas();
        System.out.println("Cantidad de Marcados a testear : " + Lineas.size());
        //Creo una lista de matrices
        List<Matriz> Marcados = new ArrayList<Matriz>();
        for(String linea : Lineas){
            //Por cada linea creo una matriz y le agrego a la lista de Marcados
            Marcados.add(lector.getMarcado(linea));

        }
        for (int i = 0; i < Marcados.size(); i++) {
            int[][] arreglo = Marcados.get(i).getMatriz();
            int sumaTotal =0;
            for (int j = 0; j < arreglo.length; j++) {
                sumaTotal=sumaTotal+arreglo[j][0];

            }
            //Verifico que cada marcado producido esté acotad, o sea no supere el valor 40
            //System.out.println(" Suma de marcado "+ i + " = "+ sumaTotal);
            assertTrue("La suma de tokens en marcado["+i+"] no supera 40",sumaTotal<40);
        }
    }
}
