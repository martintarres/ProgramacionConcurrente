import java.util.ArrayList;
import java.util.List;

public class MatrizTest{

  public static void main(String[] args){
    try{
      //int[][] array = new int [3][4];
      int[][] array = { {1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
      Matriz matriz = new Matriz(array);
      System.out.println("Matriz A : ");
      matriz.imprimir();
      System.out.println("\n Matriz A+A : ");

      Matriz sumatoria = Matriz.suma(matriz,matriz);
      sumatoria.imprimir();
      System.out.println("\n Matriz AxA : ");

      Matriz multiplicacion = Matriz.multiplicacion(matriz, matriz);
      multiplicacion.imprimir();
      System.out.println("\n Matriz Ax-9 : ");

      Matriz escalada = Matriz.porEscalar(matriz,-9);
      escalada.imprimir();
      System.out.println("\n Columna A[3] : ");

      Matriz columna0 = Matriz.obtenerColumna(matriz,3);
      columna0.imprimir();
      System.out.println("\n Fila A[0] : ");

      Matriz fila0 = Matriz.obtenerFila(matriz,0);
      fila0.imprimir();

    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }

}
