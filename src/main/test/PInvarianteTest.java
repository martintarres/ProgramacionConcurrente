import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;


// CADA VEZ QUE SE CREA UN MONITOR SE RESETEA EL REGISTRO Y LOS MARCADOS

//PERO YO YA CARGUÉ EN LA LISTA DE MARCADOS LO QUE ESTABA ASÍ QUE SOY INIMPUTABLE, HERMANO

/**
 * Created by YepezHinostroza on 31/8/2017.
 */
public class PInvarianteTest {
    @Test
    public void HistorialMarcados  () throws Exception{

        Log lector = new Log("C:\\Users\\alexa\\Desktop\\CONCURRENTE\\ProgramacionConcurrente\\marcados.txt",
                "\"C:\\\\Users\\\\alexa\\\\Desktop\\\\CONCURRENTE\\\\ProgramacionConcurrente\\\\registroVacio.txt\"");
        // creo una lista de as lineas
        List<String> Lineas = lector.leerLineas();
        System.out.println("Cantidad de Marcados a testear : " + Lineas.size());
        //Creo una lista de matrices
        List<Matriz> Marcados = new ArrayList<Matriz>();
        for(String linea : Lineas){
            //Por cada linea creo una matriz y le agrego a la lista de Marcados
            Marcados.add(lector.getMarcado(linea));

        }
        Constantes constantes = new Constantes();
        ListasDeDisparos listas = new ListasDeDisparos();

        Monitor monitor = new Monitor(constantes,listas);
        for (int i = 0; i < Marcados.size(); i++) {
            if(!monitor.getPetri().verificarMarcado(Marcados.get(i)))
            throw new Exception("Marcado inválido en línea : " +i);
        }


        //System.out.print(" Rsultado de la primera " +  monitor.getPetri().verificarMarcado(Marcados.get(0)));


        

    }
}
