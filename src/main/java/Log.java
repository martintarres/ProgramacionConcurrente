/**
 * Created by Fabrizio_p on 30/08/2017.
 */
import java.io.*;

public class Log {
    private File archivoOrigen;
    private File archivoDestino;
    private String origen;
    private String destino;
    private String texto;
    private BufferedReader br;
    private PrintWriter pw;
    private BufferedWriter bw;

    public Log(String archivo){
        this.origen = origen;
        this.destino = destino;
        this.archivoOrigen = new File(archivo);
        this.archivoDestino = new File(archivo);
        //this.archivoOrigen = new File("C:\\Users\\alexa\\Desktop\\Concu\\ProgramacionConcurrente\\marcados.txt");
        //this.archivoDestino = new File("C:\\Users\\alexa\\Desktop\\Concu\\ProgramacionConcurrente\\marcados.txt");

    }
    public void leer(){

        try{
         // String file = "file://" ;
         // String direccion =  "C:\\Users\\Fabrito\\Desktop\\Materias\\ProgramacionConcurrente\\Tp final\\src\\texto.txt";

          //System.out.println("---------");
          FileReader fr = new FileReader(this.archivoOrigen);
          br = new BufferedReader(fr);
          String linea;
            while((linea=br.readLine())!=null)
                System.out.println(linea);
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            try{
                br.close();
            }
            catch(Exception e){

            }

        }
    }
    public void escribir(String linea){
        try{
            FileWriter fw = new FileWriter(archivoDestino,true);
            //fw.write(linea);

            //pw = new PrintWriter(fw);
            //pw.println(linea);
            bw = new BufferedWriter(fw);
            bw.write(linea);
            bw.newLine();
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
        finally {
            try{
                bw.close();
                //pw.close();
            }
            catch(Exception e){

            }

        }


    }
}
