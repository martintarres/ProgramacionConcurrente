import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

import static org.junit.Assert.assertEquals;


public class PInvariantesTest {
    Constantes constantes;
    Monitor monitor;
    List fin;





    @Test
    public void prin() {

        //List<String> fin= new ArrayList <String>();
        //this.fin=fin;

        constantes = new Constantes();
        monitor = new Monitor(constantes);

        int disparo=-1;    /// es valor con el que voy a pedir dispare (estaria bueno ponerle un nunero aleatorio)

        for (int ii = 0; ii < 5000; ii++) {
            System.out.println("voy a pedir transiciones sensibilizadas");
            monitor.petri.vectorSensibilizadas.imprimir();

            disparo++;
            if(disparo== 20){
                disparo=0;
            }
            monitor.dispararTransicion(disparo);
            monitor.mutex.release();


            asd();
            System.out.println("voy a mostrar marcado actual");

            monitor.petri.marcadoActual().imprimir();

            System.out.println("voy a mostrar p invariantes");
            monitor.petri.getMInvariantes().imprimir();

            System.out.println("voy a multiplicar ");


            List <String> prodInterno = new ArrayList <String>();
            int[][] pamatriz = new int[1][monitor.petri.getMInvariantes().getN()];
            //System.out.println(pamatriz[0].length);
            for (int i = 0; i < monitor.petri.getMInvariantes().getM(); i++) {
                for (int j = 0; j < monitor.petri.getMInvariantes().getN(); j++) {
                    //System.out.print(monitor.petri.getMInvariantes().getMatriz()[i][j]);
                    pamatriz[0][j] = monitor.petri.getMInvariantes().getMatriz()[i][j];
                }
                //System.out.println("");


                Matriz matriz = null;
                try {
                    matriz = new Matriz(pamatriz);
                } catch (MatrizException e) {
                    e.printStackTrace();
                }

                int resultado = 0;

                for (int g = 0; g < monitor.petri.getMInvariantes().getN(); g++) {
                    int multiplicacion = 0;
                    multiplicacion = monitor.petri.marcadoActual().getMatriz()[g][0] * matriz.getMatriz()[0][g];
                    resultado = resultado + multiplicacion;

                    // si descomentan esto van a ver como lo hace


                    /*

                    System.out.println("voy a mostrar resultado para cada producto interno de marcadoActual " + monitor.petri.marcadoActual().getMatriz()[g][0] + " * columna " + g + " de fila " +i );
                    System.out.println("                                                                    "  + monitor.petri.marcadoActual().getMatriz()[g][0]+ " * " +   matriz.getMatriz()[0][g] + " = "  + multiplicacion);

                    */

                }

                prodInterno.add(Integer.toString(resultado));
            }


            System.out.println("voy a mostrar lista de resultado");
            System.out.println(prodInterno);

            System.out.println("Voy a mostrar lista de resultado de ecuaciones");
            System.out.println(fin);


            assertEquals(prodInterno, fin);

            /* for(int i=0; i<monitor.petri.getMInvariantes().getN();i++) {
                System.out.print(monitor.petri.getMInvariantes().getMatriz()[0][i]);
            }*/

        }
    }


    public void asd() {
        URL urlob;
        StringBuffer html;
        StringBuffer textoPlano;
        fin=new ArrayList <String>();

        String file = "file:///";
        String path = null;
        StringBuffer a = new StringBuffer();
        try {
            path = (new File(".")).getCanonicalPath();
            //System.out.println("Ruta actual ");
            //System.out.println(file + path);
            String archivo = "/analisisInvariante.html";


            String linea = null;
            urlob = new URL(file + path + archivo);
            InputStreamReader rea = new InputStreamReader(urlob.openStream());
            BufferedReader br = new BufferedReader(rea);
            html = new StringBuffer();
            textoPlano = new StringBuffer();
            while ((linea = br.readLine()) != null) {
                html.append(linea);


            }

            // System.out.println(html);


            //  Lector lector = new Lector(file+path+archivo);
            // lector.convertir();


            //   System.out.println(lector.getHtml());

            List <String> hola = new ArrayList <String>();
            hola = cortar("P-Invariant equations", "Analysis time:", html);


            // System.out.print(a);
            for (int i = 0; i < hola.size(); i++) {
                // System.out.println(hola.get(i));
                //   System.out.println( hola.get(i).codePointAt(4));
                StringBuffer q = new StringBuffer(hola.get(i));
                //  System.out.println(q.length());
                for (int j = 0; j < q.length(); j++) {
                    if (q.charAt(j) == '=') {
                        q.delete(0, j + 2);


                    }
                }
                for (int j = 0; j < q.length(); j++) {

                    if (q.charAt(j) == '<') {
                        q.delete(j, q.length());
                        fin.add(q.toString());
                    }
                }
                //   q.delete(0,15);


            }

            fin.remove(fin.size() - 1);        // aca resto estos dos porque en la lista me agrega los lugares
            fin.remove(fin.size() - 1);        // del <br> que son dos al final, entonces lo saco

           // System.out.println("esta es la lista con los numeros despues del igual");
           // System.out.println(fin);  /// ESTA RECIEN ES LA LISTA QUE TIENE LOS NUMEROS DESPUES DEL IGUAL.

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public List cortar(String desde , String hasta, StringBuffer textoplano ){
        // DEL TEXTO PLANO SOLO GUARDA LO QUE ESTE ENTRE LOS DOS STRING SIN INCLUIRLOS
        List <String> listasdas = new ArrayList <String>();

          //  System.out.println(textoplano.toString());
       // System.out.println(textoplano.length());
        for(int i=0; i<textoplano.length();i++){

            if(textoplano.charAt(i) == '<' ){
                textoplano.insert(i+4, "\n");

            }
            //System.out.print(textoplano.charAt(i));
        }

           // System.out.print(textoplano.toString());


        String linea;
        StringReader rea = new StringReader(textoplano.toString());
        BufferedReader br = new BufferedReader(rea);
        StringBuffer pedazo = new StringBuffer();

        List<String> ASD= new ArrayList <String>();

        boolean copiando = false;
        try {
            while((linea= br.readLine()) != null) {

                if(!copiando&&linea.contains(desde)){
                    copiando=true;
                    continue;
                }

                if(linea.contains(hasta)){
                    break;
                }
                if(copiando){
                    pedazo.append(linea);
                    pedazo.append("\n");
                    ASD.add(linea);

                }





            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println("ASD" + ASD.get(1));


            return ASD;



    }
}

