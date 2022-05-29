package primera;
//Division entera mediante restas
public class Ejercicio013 
{
    public static void main(String arg[])
    {
        int dividendo, divisor, aux, acum;
        dividendo = 7;
        divisor = 2;
        acum = 0;
        aux=dividendo;
        while(aux >= divisor)
        {
            aux -= divisor;
            acum++;
        }
        System.out.printf("el resultado de %d / %d es %d", dividendo, divisor, acum);
    }
}
