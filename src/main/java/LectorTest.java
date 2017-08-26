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
        System.out.println("--------------------------------------------------------------------------------------------");
        //StringBuffer incidenciapPosterior = lector.cortar("Forwards incidence matrix I+","Backwards incidence matrix I-");
        //System.out.println(incidenciapPosterior);
        //System.out.println("--------------------------------------------------------------------------------------------");
        //System.out.println("Cantidad de Filas :" + lector.cantidadFilas(lector.cortar("Forwards incidence matrix I+","Backwards incidence matrix I-")));
        //System.out.println("Cantidad de Columnas :" + lector.cantidadColumnas(lector.cortar("Forwards incidence matrix I+","Backwards incidence matrix I-")));

        /*StringBuffer incidenciapPrevia = lector.cortar("Backwards incidence matrix I-","Combined incidence matrix I");
        System.out.println(incidenciapPrevia);
        System.out.println("--------------------------------------------------------------------------------------------");
        StringBuffer marcado = lector.cortar("Marking","Enabled transitions");
        System.out.println(marcado);
        System.out.println("--------------------------------------------------------------------------------------------");
        */
        String[][] tablaPosterior = lector.getTabla(lector.cortar("Forwards incidence matrix I+","Backwards incidence matrix I-"));
        for (int i = 0; i < lector.cantidadFilas(lector.cortar("Forwards incidence matrix I+","Backwards incidence matrix I-")); i++) {
            for (int j = 0; j <lector.cantidadColumnas(lector.cortar("Forwards incidence matrix I+","Backwards incidence matrix I-")) ; j++) {
                System.out.print(tablaPosterior[i][j]);
            }
            System.out.println("\n");

        }
        String[][] tablaPrevia = lector.getTabla(lector.cortar("Backwards incidence matrix I-","Combined incidence matrix I"));
        for (int i = 0; i < lector.cantidadFilas(lector.cortar("Backwards incidence matrix I-","Combined incidence matrix I")); i++) {
            for (int j = 0; j <lector.cantidadColumnas(lector.cortar("Backwards incidence matrix I-","Combined incidence matrix I")) ; j++) {
                System.out.print(tablaPrevia[i][j]);
            }
            System.out.println("\n");

        }



    }
}
