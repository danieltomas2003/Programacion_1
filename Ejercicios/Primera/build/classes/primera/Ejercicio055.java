package primera;

public class Ejercicio055 
{
    public static void main(String arg[])
    {
        int kilos[][] = {{20, 30, 25, 40, 12, 17}, {35, 20, 10, 27, 15}};
        double precios[] = {3.50, 2.35};
        double ventas[][] = multiplicar(kilos, precios);
        for(int i = 0; i < kilos.length; i++)
        {
            for(int j = 0; j < kilos[i].length; j++)
                System.out.printf("%.2f - ", ventas[i][j]);
            System.out.println();
        }
        System.out.println();
        System.out.println();
        double ventas2[][] = new double[kilos.length][kilos[0].length];
        multiplicar2(kilos, precios, ventas2);
        for(int i = 0; i < kilos.length; i++)
        {
            for(int j = 0; j < kilos[i].length; j++)
                System.out.printf("%.2f - ", ventas2[i][j]);
            System.out.println();
        }
    }
    public static double[][] multiplicar(int k[][], double mult[])
    {
        double v[][] = new double[k.length][k[0].length];
        for(int i = 0; i < v.length; i++)
            for(int j = 0; j < k[i].length; j++)
                v[i][j] = k[i][j] * mult[i];
        return v;
    }
    public static void multiplicar2(int k[][] ,double p[], double v[][])
    {
        for(int i = 0; i < v.length; i++)
            for(int j = 0; j < k[i].length; j++)
                v[i][j] = k[i][j] * p[i];
    }
}
