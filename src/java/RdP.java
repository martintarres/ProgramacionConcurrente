public class RdP{
  private Matriz marcadoInicial;
  private Matriz marcadoActual;
  private Matriz incidencia;
  private Matriz incidenciaPrevia;
  private Matriz incidenciaPosterior;

  public RdP(Matriz marcadoInicial,Matriz incidenciaPrevia,Matriz incidenciaPosterior){
    try{
      this.marcadoInicial = marcadoInicial;
      this.marcadoActual = marcadoActual;
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


}
