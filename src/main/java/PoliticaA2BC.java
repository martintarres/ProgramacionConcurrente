import java.util.List;

/**
 * Created by YepezHinostroza on 31/8/2017.
 */
public class PoliticaA2BC extends Politica{

    public PoliticaA2BC(List<Hilo> lista){
        super(lista);
    }
    /*
    Politica sin el else y con el for
    //  Politica     A  2B  C    =   0.9     0.3   0.5
    //  Politica    3A  2B  C    =

    Politica con el else y sin el for
    //  Primera    0.9     0.5
    //  Segunda



    */
    public Hilo getHilo(List<Hilo> lista){
        /*for (Hilo h :
                lista) {
            if (h.getNombre().equals("Hilo 8") || h.getNombre().equals("Hilo 9")) {
                return h;
            }
        }*/
        for (Hilo h :
                lista) {
            if ((h.getNombre().equals("Hilo 1") || h.getNombre().equals("Hilo 2"))&&Math.random()<0.35) {
                return h;
            }
        }
        return lista.get(0);

    }
}

/*
// Con hilo 9 con una transicion del 8
for (Hilo h:
                lista) {
            if((h.getNombre().equals("Hilo 8")||h.getNombre().equals("Hilo 9"))&&Math.random()<0.9){
                return h;
            }
        }
        for (Hilo h:
                lista) {
            if((h.getNombre().equals("Hilo 3"))&&Math.random()<1){
                return h;
            }
        }


*/

//Otra
/*
for (Hilo h:
                lista) {
            if((h.getNombre().equals("Hilo 8")||h.getNombre().equals("Hilo 9"))&&Math.random()<1){
                return h;
            }
        }
        for (Hilo h:
                lista) {
            if((h.getNombre().equals("Hilo 6"))&&Math.random()<0.2){
                return h;
            }
        }
*/
/*
for (Hilo h:
                lista) {
            if((h.getNombre().equals("Hilo 8")||h.getNombre().equals("Hilo 9"))&&Math.random()<0.95){
                return h;
            }

        }

        for (Hilo h:
                lista) {
            if((h.getNombre().equals("Hilo 1")||h.getNombre().equals("Hilo 2"))&&Math.random()<0.5){
                return h;
            }
        }
        for (Hilo h:
                lista) {
            if((h.getNombre().equals("Hilo 3")||h.getNombre().equals("Hilo 4")||h.getNombre().equals("Hilo 5")
                    ||h.getNombre().equals("Hilo 6")||h.getNombre().equals("Hilo 7"))&&Math.random()<0.27){
                return h;
            }

        }



*/
/*
while(true){
            if(h.getNombre().equals("Hilo 9")){
                if(Math.random()<0.2)
                    return h;
            }
            if(h.getNombre().equals("Hilo 8")){
                if(Math.random()<0.2)
                    return h;
            }
            if(h.getNombre().equals("Hilo 7")){
                if(Math.random()<0.9)
                    return h;
            }
            if(h.getNombre().equals("Hilo 6")){
                if(Math.random()<0.9)
                    return h;
            }
            if(h.getNombre().equals("Hilo 5")){
                if(Math.random()<0.9)
                    return h;
            }
            if(h.getNombre().equals("Hilo 4")){
                if(Math.random()<0.9)
                    return h;
            }
            if(h.getNombre().equals("Hilo 3")){
                if(Math.random()<0.9)
                    return h;
            }
            if(h.getNombre().equals("Hilo 2")){
                if(Math.random()<0.2)
                    return h;
            }
            if(h.getNombre().equals("Hilo 1")){
                if(Math.random()<0.2)
                    return h;
            }
            h = lista.get((int) Math.random()*lista.size());
        }
 */