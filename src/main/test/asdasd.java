import org.jsoup.Jsoup;
import org.junit.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class asdasd {
    Constantes constantes;
    Monitor monitor;

    @Test
    public void asd() {
        URL urlob;
        StringBuffer html;
        StringBuffer textoPlano;


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

            List<String> hola = new ArrayList <String>();
            hola= cortar("P-Invariant equations" , "Analysis time:" , html);

            List<String> fin= new ArrayList <String>();
          // System.out.print(a);
            for(int i=0; i<hola.size(); i++) {
               // System.out.println(hola.get(i));
             //   System.out.println( hola.get(i).codePointAt(4));
                StringBuffer q= new StringBuffer(hola.get(i));
              //  System.out.println(q.length());
                for(int j=0; j<q.length(); j++) {
                    if (q.charAt(j) == '=') {
                        q.delete(0, j + 2);


                    }
                }
                for(int j=0; j<q.length(); j++){

                    if(q.charAt(j)=='<'){
                        q.delete(j, q.length());
                        fin.add(q.toString());
                    }
                }
             //   q.delete(0,15);


            }

            fin.remove(fin.size()-1);
            fin.remove(fin.size()-1);

            System.out.println("esta es la lista con los numeros despues del igual");
            System.out.println(fin);  /// ESTA RECIEN ES LA LISTA QUE TIENE LOS NUMEROS DESPUES DEL IGUAL.




            constantes= new Constantes();
            monitor=new Monitor(constantes);

            System.out.println("voy a mostrar marcado actual");
            monitor.petri.marcadoActual().imprimir();

            System.out.println("voy a mostrar p invariantes");
            monitor.petri.getMInvariantes().imprimir();

            System.out.println("voy a multiplicar ");



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

