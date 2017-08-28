/**
 * Created by YepezHinostroza on 25/8/2017.
 */
public class LectorTest
{
    public static void main(String[] args){
        Lector lector = new Lector("file:///C:/Users/Fabrito/Desktop/Materias/ProgramacionConcurrente/TPfinal/ProgramacionConcurrente/archivo.html");
        Lector lectorinv = new Lector("file:///C:/Users/Fabrito/Desktop/Materias/ProgramacionConcurrente/TPfinal/ProgramacionConcurrente/analisisInvariante.html");

        lector.convertir();
        System.out.println("--------------------------------------------------------------------------------------------");
        lectorinv.convertir();

        /*
        String[][] tablaPosterior =lector.tablaCorrida( lector.getTabla(lector.cortar("Forwards incidence matrix I+","Backwards incidence matrix I-")));
        for (int i = 0; i < lector.cantidadFilas(lector.cortar("Forwards incidence matrix I+","Backwards incidence matrix I-")); i++) {
            for (int j = 0; j <lector.cantidadColumnas(lector.cortar("Forwards incidence matrix I+","Backwards incidence matrix I-")) ; j++) {
                System.out.print(tablaPosterior[i][j]);
            }
            System.out.println("\n");

        }
        String[][] tablaPrevia = lector.tablaCorrida(lector.getTabla(lector.cortar("Backwards incidence matrix I-","Combined incidence matrix I")));
        for (int i = 0; i < lector.cantidadFilas(lector.cortar("Backwards incidence matrix I-","Combined incidence matrix I")); i++) {
            for (int j = 0; j <lector.cantidadColumnas(lector.cortar("Backwards incidence matrix I-","Combined incidence matrix I")) ; j++) {
                System.out.print(tablaPrevia[i][j]);
            }
            System.out.println("\n");

        }
        String[][] tablaMarcado = lector.tablaCorrida(lector.getTabla(lector.cortar("Marking","Enabled transitions")));
        for (int i = 0; i < lector.cantidadFilas(lector.cortar("Marking","Enabled transitions")); i++) {
            for (int j = 0; j <lector.cantidadColumnas(lector.cortar("Marking","Enabled transitions")) ; j++) {
                System.out.print(tablaMarcado[i][j]);
            }
            System.out.println("\n");

        }*/
        String[][] tablaPInvariantes =lector.getTablaInv(lectorinv.getTabla(lectorinv.cortar("P-Invariants","The net is covered by positive P-Invariants")));
        for (int i = 0; i < tablaPInvariantes.length; i++) {
            for (int j = 0; j <tablaPInvariantes[0].length; j++) {
                System.out.print(tablaPInvariantes[i][j]);

            }
            System.out.println("\n");


        }
        int [][] numero = lectorinv.convertirAEnteros(tablaPInvariantes,1,0);
        for (int i = 0; i < numero.length ; i++) {
            for (int j = 0; j < numero[0].length; j++) {
                System.out.print(numero[i][j]);
            }
            System.out.println();

        }
        try{
            Matriz invariantes = new Matriz(lectorinv.convertirAEnteros(tablaPInvariantes,1,0));
            invariantes.imprimir();
        }
        catch (Exception e){

        }
        //System.out.println(lectorinv.getTextoPlano());
    }

}
