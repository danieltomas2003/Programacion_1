package primera;
//Tabla de eteros con los kilos vendidos a la semana. un vector de doubles con los precios
public class Ejercicio054 
{
    public static void main(String arg[])
    {
        double kilos[][] = {{20, 30, 25, 40, 12, 17}, {35, 20, 10, 27, 15}};
        double precios[] = {3.50, 2.35};
        multiplicar(kilos, precios);
        for(int i = 0; i < kilos.length; i++)
        {
            for(int j = 0; j < kilos[i].length; j++)
                System.out.printf("  %.2f - ", kilos[i][j]);
            System.out.println();
        }
    }
    public static void multiplicar(double v[][], double mult[])
    {
        for(int i = 0; i < v.length; i++)
            for(int j = 0; j < v[i].length; j++)
                v[i][j] *= mult[i];
    }
}
