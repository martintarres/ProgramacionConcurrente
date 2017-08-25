/**
 * Created by YepezHinostroza on 25/8/2017.
 */

import org.jsoup.Jsoup;

import javax.swing.text.html.HTMLDocument;
import java.awt.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


public class Lector {
    private URL urlob;
    private StringBuffer html;
    private StringBuffer textoPlano;
    public Lector(String direccion){

        //SOLO GUARDA EN EL STRINGBUFFER HTML
        try {
            //direccion= "file:C:\\Users\\alexa\\Desktop\\PC\\ProgramacionConcurrente\\archivo.html";
            String linea=null;

            urlob = new URL(direccion);
            InputStreamReader rea = new InputStreamReader(urlob.openStream());
            BufferedReader br= new BufferedReader(rea);
            html = new StringBuffer();
            textoPlano = new StringBuffer();
            while((linea= br.readLine()) != null){
                html.append(linea);
                html.append("\n");
            }


        }
        catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public StringBuffer getHtml(){
        return this.html;

    }
    public StringBuffer getTextoPlano(){
        convertir();
        return this.textoPlano;
    }
    public void convertir(){

        // CONVIERTE EN TEXTO PLANO LO QUE ESTE EN EL STRINGBUFFER HTML
        try {


            String linea;
            StringReader rea = new StringReader(this.getHtml().toString());
            BufferedReader br= new BufferedReader(rea);
            //this.textoPlano = new StringBuffer();
            //int contadorLineas =0;
            //int contadorSaltos =0;


            while((linea=br.readLine()) != null) {
                 this.textoPlano.append(Jsoup.parse(linea).text());
                 this.textoPlano.append("\n");
            }
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public StringBuffer cortar(String desde , String hasta){
        // DEL TEXTO PLANO SOLO GUARDA LO QUE ESTE ENTRE LOS DOS STRING SIN INCLUIRLOS
        try {


            String linea;
            StringReader rea = new StringReader(this.getTextoPlano().toString());
            BufferedReader br= new BufferedReader(rea);
            StringBuffer pedazo = new StringBuffer();

            boolean copiando = false;

            while((linea= br.readLine()) != null) {

                if(!copiando&&linea.contains(desde)){
                    copiando=true;
                    continue;
                }

                if(linea.contains(hasta)){
                    break;
                }
                if(copiando){
                    if(linea.trim().equals("")){

                    }
                    else{
                        pedazo.append(linea);
                        pedazo.append("\n");
                    }

                }



            }
            return pedazo;

        }
        catch (MalformedURLException e){
            e.printStackTrace();
            return null;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }


    }
}
