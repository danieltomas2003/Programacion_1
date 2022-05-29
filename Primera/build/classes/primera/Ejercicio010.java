package primera;
// Factorial de un numero
public class Ejercicio010 
{
    public static void main(String arg[])
    {
        int num = 4;
        int fact = 1;
        for(int cont = num; cont > 1; cont--)
            fact *= cont;
        System.out.println("El factorial de " + num + " es: " + fact);

        int numero = 5;
        int acum = 1;
        for(int cont = 1; cont <= num; cont++)
            acum *= cont;
        System.out.println("El factorial de " + numero + " es: " + acum);
    }
}
    