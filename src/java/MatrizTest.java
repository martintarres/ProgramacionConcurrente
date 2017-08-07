import java.util.ArrayList;
import java.util.List;

public class MatrizTest{

  public static void main(String[] args){
    try{
      //int[][] array = new int [3][4];
      int[][] array = { {1,2,3,4},{1,2,3,4},{1,2,3,4},{1,2,3,4}};
      Matriz matriz = new Matriz(array);
      matriz.imprimir();
      Matriz sumatoria = Matriz.suma(matriz,matriz);
      sumatoria.imprimir();
      Matriz multiplicacion = Matriz.multiplicacion(matriz, matriz);
      multiplicacion.imprimir();
      Matriz escalada = Matriz.porEscalar(matriz,9);
      escalada.imprimir();
      Matriz columna0 = Matriz.obtenerColumna(matriz,3);
      columna0.imprimir();
      Matriz fila0 = Matriz.obtenerFila(matriz,0);
      fila0.imprimir();

    }
    catch(Exception e){
      System.out.println(e.getMessage());
    }
  }

}
