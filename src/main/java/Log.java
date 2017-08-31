/**
 * Created by Fabrizio_p on 30/08/2017.
 */
import java.io.*;

public class Log {
    private File marcados;
    private File registro;
    private String direccionMarcado;
    private String direccionRegistro;
    private BufferedReader br;
    private PrintWriter pw;
    private BufferedWriter bw;

    public Log(String marcados,String registro){
        this.direccionMarcado = marcados;
        this.direccionRegistro = registro;
        this.marcados = new File(marcados);
        this.registro = new File(registro);

    }
    public void leer(){

        try{
         // String file = "file://" ;
         // String direccion =  "C:\\Users\\Fabrito\\Desktop\\Materias\\ProgramacionConcurrente\\Tp final\\src\\texto.txt";

          //System.out.println("---------");
          FileReader fr = new FileReader(this.marcados);
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
    public void escribir(String linea,File destino){
        try{
            FileWriter fw = new FileWriter(destino,true);
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
    public File getMarcados(){
        return this.marcados;
    }
    public File getRegistro(){
        return this.registro;
    }

    public  void limpiar(){
        if(this.marcados.exists())
        this.marcados.delete();
        this.marcados=new File(direccionMarcado);
        if(this.registro.exists())
            this.registro.delete();
        this.registro=new File(direccionRegistro);
    }
}
