package primera;

public class Ejercicio090 
{
    public static void main(String arg[])
    {
        int n=5;
        System.out.println(factorial(n));
    }
    public static int factorial(int a)
    {
        if(a==1)
            return 1;
        else
            return a*factorial(a-1);
    }
}
