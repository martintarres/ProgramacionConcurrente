public class Constantes{
  public final int m1,m2,m3,m4,p10,p11,p12,p13,p14,p15,p16,p17,p18,p20,p21,p22,p23,p30,p31,p32,p33,p34,p35,r1,r2,r3,s1,s2;
  public final int t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t21,t22,t23,t24,t31,t32,t33,t34,t35,t36;


  public  Matriz incidenciaPrevia;
  public  Matriz incidenciaPosterior;
  public  Matriz marcadoInicial;
  // por que no declare cuanto valia las plazas y las transiciones y armaba de una la mtraiz
  public Constantes(){

    t10=0;
    t11=1;
    t12=2;
    t13=3;
    t14=4;
    t15=5;
    t16=6;
    t17=7;
    t18=8;
    t19=9;
    t21=10;
    t22=11;
    t23=12;
    t24=13;
    t31=14;
    t32=15;
    t33=16;
    t34=17;
    t35=18;
    t36=19;


    m1=0;
    m2=1;
    m3=2;
    m4=3;
    p10=4;
    p11=5;
    p12=6;
    p13=7;
    p14=8;
    p15=9;
    p16=10;
    p17=11;
    p18=12;
    p20=13;
    p21=14;
    p22=15;
    p23=16;
    p30=17;
    p31=18;
    p32=19;
    p33=20;
    p34=21;
    p35=22;
    r1=23;
    r2=24;
    r3=25;
    s1=26;
    s2=27;

    try{


      int[][] previa = {{0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//m1
                        {0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0},//m2
                        {0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},//m3
                        {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0},//m4
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//p10
                        {0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//p11
                        {0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//p12
                        {0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//p13
                        {0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},//p14
                        {0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0},//p15
                        {0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},//p16
                        {0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0},//p17
                        {0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},//p18
                        {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},//p20
                        {0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0},//p21
                        {0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0},//p22
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0},//p23
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0},//p30
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0},//p31
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0},//p32
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0},//p33
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},//p34
                        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},//p35
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},//r1
                        {0,0,0,1,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0},//r2
                        {0,0,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,0,0},//r3
                        {0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0},//s1
                        {0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0}};//s2
      this.incidenciaPrevia = new Matriz(previa);


      int[][] posterior = new int[28][20];
      posterior[m1][t13]=1;
      posterior[m2][t17]=1;
      posterior[m2][t23]=1;
      posterior[m3][t14]=1;
      posterior[m3][t35]=1;
      posterior[m4][t18]=1;
      posterior[m4][t33]=1;
      posterior[p10][t19]=1;
      posterior[p11][t10]=1;
      posterior[p12][t11]=1;
      posterior[p13][t12]=1;
      posterior[p14][t13]=1;
      posterior[p15][t14]=1;
      posterior[p16][t15]=1;
      posterior[p17][t16]=1;
      posterior[p18][t17]=1;
      posterior[p18][t18]=1;
      posterior[p20][t24]=1;
      posterior[p21][t21]=1;
      posterior[p22][t22]=1;
      posterior[p23][t23]=1;
      posterior[p30][t36]=1;
      posterior[p31][t31]=1;
      posterior[p32][t32]=1;
      posterior[p33][t33]=1;
      posterior[p34][t34]=1;
      posterior[p35][t35]=1;
      posterior[r1][t11]=1;
      posterior[r1][t12]=1;
      posterior[r1][t36]=1;
      posterior[r2][t15]=1;
      posterior[r2][t16]=1;
      posterior[r2][t22]=1;
      posterior[r2][t24]=1;
      posterior[r2][t34]=1;
      posterior[r3][t19]=1;
      posterior[r3][t32]=1;
      posterior[s1][t17]=1;
      posterior[s1][t23]=1;
      posterior[s2][t18]=1;
      posterior[s2][t35]=1;

      this.incidenciaPosterior = new Matriz(posterior);

      int[][] inicial = new int [28][1];
      inicial[m1][0]=1;
      inicial[m2][0]=1;
      inicial[m3][0]=1;
      inicial[m4][0]=1;
      inicial[p10][0]=10;
      inicial[p20][0]=10;
      inicial[p30][0]=10;
      inicial[r1][0]=1;
      inicial[r2][0]=1;
      inicial[r3][0]=1;
      inicial[s1][0]=1;
      inicial[s2][0]=1;

      this.marcadoInicial = new Matriz(inicial);




    }
    catch(Exception e){
      System.out.println("No se ha podido inicializar.");
    }
  }

}
