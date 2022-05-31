package primera;

public class Ejercicio093 
{
    public static void main(String arg[])
    {
        int n=15;
        int m=3;
        System.out.println("division " + n + "/" + m + " = " + dividir(n, m));
    }
    public static int dividir(int a, int b)
    {
        if(a<b)
            return 0;
        else
        {
            return dividir(a-b, b) + 1;
        }
            
    }
}
