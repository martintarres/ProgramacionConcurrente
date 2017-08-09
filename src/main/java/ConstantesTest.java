public class ConstantesTest{
  public static void main(String[] args) {
    try{
      Constantes cons = new Constantes();
      System.out.println("Matriz de Incidencia Previa : " );
      cons.incidenciaPrevia.imprimir();
      System.out.println("Matriz de Incidencia Posterior : " );
      cons.incidenciaPosterior.imprimir();
      System.out.println("Matriz de Incidencia : " );
      Matriz.suma(cons.incidenciaPosterior,Matriz.porEscalar(cons.incidenciaPrevia,-1)).imprimir();
      System.out.println("Marcado Inicial : " );
      cons.marcadoInicial.imprimir();
      RdP petri = new RdP(cons.marcadoInicial,cons.incidenciaPrevia,cons.incidenciaPosterior);
      petri.Sensibilizadas(petri.getIncidenciaPrevia(),petri.marcadoActual()).imprimir();


    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }

  }
}
