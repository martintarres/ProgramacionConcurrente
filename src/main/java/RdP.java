import java.util.List;

public class RdP{
  private Matriz marcadoInicial;
  private Matriz marcadoActual;
  private Matriz incidencia;
  private Matriz incidenciaPrevia;
  private Matriz incidenciaPosterior;
  private Matriz vectorSensibilizadas;

  public RdP(Matriz marcadoInicial,Matriz incidenciaPrevia,Matriz incidenciaPosterior){
    try{
      //if (mInicial==null) throw
      this.marcadoInicial = marcadoInicial;
      this.marcadoActual = marcadoInicial;
      this.incidenciaPrevia = incidenciaPrevia;
      this.incidenciaPosterior = incidenciaPosterior;
      this.incidencia = Matriz.suma(this.incidenciaPosterior,Matriz.porEscalar(this.incidenciaPrevia,-1));
      this.vectorSensibilizadas = Sensibilizadas(incidenciaPrevia, marcadoInicial);
      System.out.println ("transiciones iniciales");
      vectorSensibilizadas.imprimir();

    }
    catch(Exception e){
    //  throw e;
    }

  }
  public Matriz getIncidencia(){
    return this.incidencia;
  }
  public Matriz getIncidenciaPrevia(){
    return this.incidenciaPrevia;
  }

  public List<Integer> sensibilizadas(){
    return null;
  }
  public Matriz marcadoInicial(){
    return this.marcadoInicial;
  }
  public Matriz marcadoActual(){
    return this.marcadoActual;
  }


  public boolean disparar(int x) throws RdPException{
    try{
      if(x<0||x>this.incidencia.getMatriz()[0].length){
        throw new RdPException("Transicion no valida.");
      }
      if(this.vectorSensibilizadas.getMatriz()[x]!=0){
        this.marcadoActual = Matriz.suma(this.marcadoActual,Matriz.obtenerColumna(this.incidencia,x));
        vectorSensibilizadas = Sensibilizadas(this.incidenciaPrevia,this.marcadoActual);
        vectorSensibilizadas.imprimir();
        return true;
      }
      else{
        return false;
      }

    }

    catch(Exception e)
    {
      throw new RdPException(e.getMessage());
    }

  }
  public static Matriz Sensibilizadas(Matriz ip, Matriz marcado) throws RdPException{
    try{
      if(marcado.getM()!=ip.getM()){
        throw new RdPException("Matrices de distinto tamaño");
      }
      int [][] prev = ip.getMatriz();
      int [][] marc = marcado.getMatriz();
      int [][] sensibilizadas = new int [1][ip.getN()]  ;
      for(int i=0; i < ip.getN(); i++){
        int j =0;
        boolean sensible = true;
        while((j<ip.getM())&& sensible){
          if(prev[j][i]>marc[j][0]){
            sensible = false;
            sensibilizadas [0][i] = 0;
          }
          j = j+1;
          if ((j == ip.getM()-1) && sensible){
            sensibilizadas[0][i]=1;
          }
        }

        }

        return new Matriz(sensibilizadas);
    }
    catch(Exception e){
      throw new RdPException("No se ha podido obtener las transiciones disponibles");
    }


  }

  public Matriz getVectorSensibilizadas(){
    return vectorSensibilizadas;
    //return null;
  }

//Algunas noches, soy facil, uoooo uooooo

}
