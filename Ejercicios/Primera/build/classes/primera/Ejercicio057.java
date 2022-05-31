package primera;
//multiplicar por 5 los valores menores a 10 kilos
public class Ejercicio057 
{
    public static void main(String arg[])
    {
        int kilos[][] = {{20, 3, 25, 40, 6, 17}, {35, 9, 10, 27, 5}};
        int multiplicador = 5;
        multiplicar(kilos, multiplicador);
        for(int i = 0; i < kilos.length; i++)
        {
            for(int j = 0; j < kilos[i].length; j++)
                System.out.print(kilos[i][j] + " ");
            System.out.println();
        }
    }
    public static void multiplicar(int k[][], int m)
    {
        for(int i = 0; i < k.length; i++)
            for(int j = 0; j < k[i].length; j++)
                if(k[i][j] <= 10)
                    k[i][j] *= m;
    }
}
