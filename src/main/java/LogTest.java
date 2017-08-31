/**
 * Created by Fabrizio_p on 30/08/2017.
 */
public class LogTest {
    public static void main(String[] args){
        Log logo = new Log("C:\\Users\\alexa\\Desktop\\Concu\\ProgramacionConcurrente\\marcados.txt");
        //log.leer();
        logo.escribir("hola");
        logo.escribir("1");
        logo.escribir("2");
        logo.escribir("3");
        logo.escribir("chau");
        logo.leer();

    }

}
