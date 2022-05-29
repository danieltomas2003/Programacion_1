package primera;

public class Ejercicio050 
{
    public static void main(String arg[])
    {
      int num = 5;
      System.out.println("El facorial de " + num + " es " + factorial(num));
      int comb = 2;
      System.out.println("Las variaciones de " + num + " elementos cogidos de " + comb + " en " + comb + " son: " + factorial(num)/(factorial(num-comb)*factorial(comb)));
    }
    
    public static int factorial(int n)
    {
        int fact = 1;
        for(int cont = n; cont >= 1; cont--)
            fact *= cont; 
        return fact;
    }
}
