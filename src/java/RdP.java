import java.util.List;

public class RdP{
  private Matriz marcadoInicial;
  private Matriz marcadoActual;
  private Matriz incidencia;
  private Matriz incidenciaPrevia;
  private Matriz incidenciaPosterior;

  public RdP(Matriz marcadoInicial,Matriz incidenciaPrevia,Matriz incidenciaPosterior){
    try{
      //if (mInicial==null) throw
      this.marcadoInicial = marcadoInicial;
      this.marcadoActual = marcadoInicial;
      this.incidenciaPrevia = incidenciaPrevia;
      this.incidenciaPosterior = incidenciaPosterior;
      this.incidencia = Matriz.suma(this.incidenciaPosterior,Matriz.porEscalar(this.incidenciaPrevia,-1));


    }
    catch(Exception e){
    //  throw e;
    }

  }
  public Matriz getIncidencia(){
    return this.incidencia;
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
  public void disparar(int x) throws RdPException{
    try{
      if(x<0||x>this.incidencia.getMatriz()[0].length){
        throw new RdPException("Transicion no valida.");
      }
      this.marcadoActual = Matriz.suma(this.marcadoActual,Matriz.obtenerColumna(this.incidencia,x));
    }
    catch(Exception e)
    {
      throw new RdPException(e.getMessage());
    }

  }


}
