package primera;
//Multiplicacion por suma con funciones recursivas
public class Ejercicio091 
{
    public static void main(String arg[])
    {
        int n=5;
        int m=4;
        System.out.println(multiplicar(n, m));
    }
    public static int multiplicar(int a, int m)
    {
        if(m==0)
            return 0;
        else
            return a + multiplicar(a, m-1);
            
    }
}
