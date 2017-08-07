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

      RdP petri = new RdP(null, new Matriz(incPre), new Matriz(incPos));
      petri.getIncidencia().imprimir();


    }
    catch(Exception e){

    }

  }
}
