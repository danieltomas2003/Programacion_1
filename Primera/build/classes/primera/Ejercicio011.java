package primera;
// Multiplicacion por sumas
public class Ejercicio011 
{
    public static void main(String arg[])
    {
        int num = 7;
        int mult = 3;
        int acum = 0;
        for(int cont = 1; cont <=mult; cont++)
            acum += num;
        System.out.println(num + " por " + mult + " es: " + acum);
    }
}
