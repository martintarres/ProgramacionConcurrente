/**
 * Created by YepezHinostroza on 25/8/2017.
 */
public class LectorTest
{
    public static void main(String[] args){
        Lector lector = new Lector("file:C:\\Users\\alexa\\Desktop\\PC\\ProgramacionConcurrente\\archivo.html");
        //System.out.println(lector.getHtml());
        //System.out.println(lector.getTextoPlano());
        //lector.getTextoPlano();
        lector.convertir();
        System.out.println(lector.cortar("Forwards incidence matrix I+","Backwards incidence matrix I-"));

    }
}
