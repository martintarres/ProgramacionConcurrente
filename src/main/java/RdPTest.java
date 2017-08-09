public class RdPTest{
  public static void main(String[] args)
  {
    try{
      int[][] incPos = {{0,0,0},
                        {0,0,0},
                        {0,0,1},
                        {1,1,0}};


      int[][] incPre = {{1,0,0},
                        {0,1,0},
                        {0,0,0},
                        {0,0,1}};

      int[][] inicial = {{1},
                          {1},
                          {0},
                          {0}};
      //Matriz inicial= new Matriz(mInicial);
      //inicial.imprimir();
      RdP petri = new RdP(new Matriz(inicial), new Matriz(incPre), new Matriz(incPos));
      System.out.println("Marcados: ");
      petri.marcadoInicial().imprimir();
      petri.disparar(0);
      petri.marcadoActual().imprimir();
      petri.disparar(1);
      petri.marcadoActual().imprimir();
      petri.disparar(2);
      petri.marcadoActual().imprimir();
      petri.disparar(2);
      petri.marcadoActual().imprimir();
      //petri.getIncidencia().imprimir();


    }
    catch(Exception e){
      System.out.println(e.getMessage());

    }

  }
}
