package primera;
//calculo de variables matematicas
public class Ejercicio012 
{
    public static void main(String arg[])
    {
        int num = 10;
        int comb = 4;
        int acum = 1;
        for(int cont = num; cont > comb; cont--)
            acum *= cont;
        System.out.println("Las variaciones de " + num + " elementos cogidos de " + comb + " en " + comb + " son: " + acum);
        System.out.printf("Variaciones de %d tomados de %d en %d es %d", num, comb, comb, acum);
    }
}
