import org.jsoup.Jsoup;

import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class leerArchivo {



    public static void main(String [] args)  {
        URL urlob;
        String codigohtml;
        String codigocomun = null;

       // File file= new File("/home/martin/Documentos/ProgramacionConcurrente/archivo.html");

        try {
            //file:///D:/Documentos/Materias/Programacion%20Concurrente/Trabajo%20final/ProgramacionConcurrente/archivo.html
            urlob = new URL("file:///C:/Users/Fabrito/Desktop/Materias/ProgramacionConcurrente/TPfinal/ProgramacionConcurrente/archivo.html");
           // urlob = new URL("file:C:\\Users\\alexa\\Desktop\\PC\\ProgramacionConcurrente\\archivo.html");
            InputStreamReader rea = new InputStreamReader(urlob.openStream());
            BufferedReader br= new BufferedReader(rea);
            StringBuffer buffer1 = new StringBuffer();
            int contadorLineas =0;
            int contadorSaltos =0;
            boolean copiando = false;

            while((codigohtml= br.readLine()) != null&&contadorLineas<1000) {

                codigocomun = as(codigohtml);
                if(!copiando&&codigocomun.contains("Forwards incidence matrix I+")){
                    copiando=true;
                    continue;
                }

                if(codigocomun.contains("Backwards incidence matrix I-")){
                    break;
                }
                if(copiando){
                    if(codigocomun.trim().equals("")){
                        contadorSaltos++;
                    }
                    else{
                        buffer1.append(codigocomun);
                        buffer1.append("\n");
                    }

                    contadorLineas++;
                }



            }
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println(buffer1);
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.print("Lineas :" + contadorLineas + "      " + "Saltos :" +  contadorSaltos);




        }
        catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static String as(String html){
        return Jsoup.parse(html).text();
    }

    public static Boolean esNumero(String nume){

        try {
            Integer.parseInt(nume);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }

        }
    }

