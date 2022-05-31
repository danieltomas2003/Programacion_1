package primera;

public class Ejercicio056 
{
    public static void main(String arg[])
    {
        int kilos[][] = {{20, 30, 25, 40, 12, 17}, {35, 20, 10, 27, 15}};
        double precios[] = {3.50, 2.35};
        String productos[] = {"Peras", "Manzanas"};
        int total[] = total(kilos);
        for(int j = 0; j < kilos.length; j++)
                System.out.println(total[j] + " kilos de " + productos[j]);
    }
    public static int[] total(int k[][])
    {
        int suma[] = {0, 0};
        for(int i = 0; i < k.length; i++)
            for(int j = 0; j < k[i].length; j++)
                suma[i] += k[i][j];
        return suma;
    }
}
