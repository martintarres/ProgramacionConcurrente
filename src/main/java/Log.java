/**
 * Created by Fabrizio_p on 30/08/2017.
 */
import java.io.*;

public class Log {
    private File archivoOrigen;
    private String origen;
    private String destino;
    private String texto;

    public Log(String origen, String destino){
        this.origen = origen;
        this.destino = destino;

    }
    public void leer(){

        try{
         // String file = "file://" ;
         // String direccion =  "C:\\Users\\Fabrito\\Desktop\\Materias\\ProgramacionConcurrente\\Tp final\\src\\texto.txt";
          this.archivoOrigen = new File("/home/martin/Documentos/texto");
          System.out.println("---------");
          FileReader fr = new FileReader(this.archivoOrigen);
          BufferedReader br = new BufferedReader(fr);
          String linea;
            while((linea=br.readLine())!=null)
                System.out.println(linea);
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        finally {

        }
    }
    public void escribir(){

    }
}
