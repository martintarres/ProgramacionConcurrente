import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

public class ConstantesTest {

    int inci1=0;
    int inci2=0;
    int TotalPInva=0;
    public Vector<Integer> arregloT = new Vector <Integer>();
    public String[] nombreTransiciones;
    public Vector <Integer> arregloMP = new Vector <Integer>();
    public String[][] Posterior;
    public Matriz incidenciaPosterior;
    String[][] tablaPrevia;
    Lector lector;
    Lector lector1;
    public Matriz incidenciaPrevia;
    public Matriz marcadoInicial;
    String[][] PInvariantes;
    List<Integer> lista;
    public Matriz PInvariante;
    Log log;

    @Before
    public void  cargaValores() {

        try {
            String file = "file:///";
            String path = (new File(".")).getCanonicalPath();
            //System.out.println("Ruta actual ");
            //System.out.println(file+path);
            String archivo = "/archivo.html";
            String invariantes = "/analisisInvariante.html";
            //System.out.println(file+path+archivo);
            inci1 = 0;  // Para calcular numero de filas de las matrices
            inci2 = -1; // Para calcular numero de columnas de lsa matrices

            TotalPInva = -1;  // Para calcular el numero de filas de la matriz de P invariantes


            lector = new Lector(file + path + archivo);
            lector1 = new Lector(file + path + invariantes);
            lector.convertir();
            lector1.convertir();

            Posterior = lector.getTabla(lector.cortar("Forwards incidence matrix I+", "Backwards incidence matrix I-"));
            for (int i = 0; i < 1; i++) {
                for (int j = 0; j < lector.cantidadColumnas(lector.cortar("Forwards incidence matrix I+", "Backwards incidence matrix I-")); j++) {
                    if (Posterior[i][j].contains("T")) {
                        // System.out.println(Posterior[i][j]);
                        arregloT.add(inci1);
                        //System.out.println("Voy a mostrar mi vector arregloT " + arregloT.elementAt(inci1));
                        inci1++;


                    }

                }
            }
          //  System.out.println("Nombres de las transiciones");
            nombreTransiciones = new String[Posterior[0].length-1];
            for(int i=0;i<nombreTransiciones.length;i++){
                nombreTransiciones[i]=Posterior[0][i+1];
            }
           /* for(String  i: nombreTransiciones){
                System.out.print(i+" ");
            }*/
            //System.out.println();
//
            // String[][] tablaPosterior = lector.getTabla(lector.cortar("Forwards incidence matrix I+","Backwards incidence matrix I-"));
            for (int i = 0; i < lector.cantidadFilas(lector.cortar("Forwards incidence matrix I+", "Backwards incidence matrix I-")); i++) {
                for (int j = 0; j < 1; j++) {
                    // System.out.println(tablaPevia[i][j]);
                    if (inci2 != -1) {
                        arregloMP.add(inci2);
                        //System.out.println("Voy a mostrar mi vector arregloMP " + arregloMP.elementAt(inci2));
                    }

                    inci2++;
                }
                // System.out.println("\n");

            }

           lista = new ArrayList<Integer>();


            PInvariantes= lector1.getTabla(lector1.cortar("P-Invariants","P-Invariant equations"));

            for (int i = 0; i < lector1.cantidadFilas(lector1.cortar("P-Invariants", "P-Invariant equations")); i++) {
                for(int j=0; j< 1;j++){

                    TotalPInva++;
                }


            }


        } catch (Exception e) {

        }

    }

    @Test
    public void cargarMatrizIncidenciaPosterior(){
        int[][] posterior = new int[inci2][inci1];

        //System.out.println("voy a mostrar matriz de incidendia posterior");
        //String f = "";
        String ruta= new File("").getAbsolutePath();
        ruta = ruta.concat("/test/Matriz Incidencia Posterior");

        log= new Log(ruta,ruta);

        for (int i = 0; i < inci2 + 1; i++) {
            for (int j = 0; j < inci1 + 1; j++) {

                if (esNumero(Posterior[i][j])) {

                    //  System.out.print(tablaPosterior[i][j]);
                    log.escribir(Posterior[i][j] + " ", new File(ruta));
                    posterior[i - 1][j - 1] = Integer.parseInt(Posterior[i][j]);
                    // System.out.print(Integer.parseInt(Posterior[i][j]));

                }

            }
            //System.out.println("\n");
            log.escribir("\n", new File(ruta));
        }

        try {
            this.incidenciaPosterior = new Matriz(posterior);
        } catch (MatrizException e) {
            e.printStackTrace();
        }


        //incidenciaPosterior.imprimir();

    }

    @Test
    public void cargarMatrizIncidenciaPrevia() {
        int[][] previa = new int[inci2][inci1];

        String ruta1= new File("").getAbsolutePath();
        ruta1 = ruta1.concat("/test/Matriz Incidencia Previa");
        log= new Log(ruta1,ruta1);

        tablaPrevia = lector.getTabla(lector.cortar("Backwards incidence matrix I-", "Combined incidence matrix I"));
        for (int i = 0; i < inci2 + 1; i++) {
            for (int j = 0; j < inci1 + 1; j++) {
                if (esNumero(tablaPrevia[i][j])) {

                    log.escribir(tablaPrevia[i][j] + " ", new File(ruta1));
                    previa[i - 1][j - 1] = Integer.parseInt(tablaPrevia[i][j]);
                }
            }
            log.escribir("\n", new File(ruta1));

        }
        try {
            this.incidenciaPrevia = new Matriz(previa);
        } catch (MatrizException e) {
            e.printStackTrace();
        }

        //incidenciaPrevia.imprimir();

    }

    @Test
    public void cargaMarcadoInicial(){
        int[][] incial = new int[inci2][1];
        String ruta2= new File("").getAbsolutePath();
        ruta2 = ruta2.concat("/test/Marcado Inicial");
        log= new Log(ruta2,ruta2);

        String[][] tablaInicial = lector.getTabla(lector.cortar("Marking", "Current"));
        for (int i = 0; i < lector.cantidadFilas(lector.cortar("Marking", "Current")); i++) {
            for (int j = 0; j < inci2 + 1; j++) {

                if (esNumero(tablaInicial[i][j])) {
                    log.escribir(tablaInicial[i][j] + " ", new File(ruta2));
                    incial[j - 1][i - 1] = Integer.parseInt(tablaInicial[i][j]);

                }

            }
            //log.escribir("\n", new File(ruta2));
        }

        try {
            this.marcadoInicial = new Matriz(incial);
        } catch (MatrizException e) {
            e.printStackTrace();
        }

        //marcadoInicial.imprimir();

    }

    @Test
    public void cargaPInvariantes(){
        int[][] copia = new int[TotalPInva][inci2];

        String ruta3= new File("").getAbsolutePath();
        ruta3 = ruta3.concat("/test/Matriz P Invariantes");
        log= new Log(ruta3,ruta3);
        int contadorr = 0;
        for (int i = 0; i < TotalPInva+1; i++) {      // aca hago TotalPInva+1 porque aun no saque las letras.
            //  System.out.println("soy i " + i);         //  entonces tengo una fila mas
            for (int j = 0; j < inci2+1 ; j++) {
                //   System.out.println("soy j " + j);
                //   System.out.println();
                if (esNumero(PInvariantes[i][j])) {



                    lista.add(Integer.parseInt(PInvariantes[i][j]));
                    // hola.add(Integer.parseInt(tumama[i][j]));
                    //System.out.print(PInvariantes[i][j]);
                   ;
                }
            }

        }

        for (int i = 0; i < TotalPInva; i++) {

            for (int j = 0; j < inci2; j++) {

                copia[i][j] = lista.get(0);
                log.escribir(copia[i][j] + " ", new File(ruta3));

                lista.remove(0);


            }
            log.escribir("\n", new File(ruta3));
        }

        try {
            this.PInvariante= new Matriz(copia);
        } catch (MatrizException e) {
            e.printStackTrace();
        }

       //  PInvariante.imprimir();

    }




    public static Boolean esNumero(String nume) {

        try {
            Integer.parseInt(nume);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    }