package primera;
//Venta de kilos de frutas
public class Ejercicio029
{
    public static void main(String arg[])
    {
        int tabla[][] = {{34, 11, 30, 20}, {50, 70, 25, 10}, {30, 10, 45, 50}};
        String productos[] = {"Naranjas", "Peras", "Melones"};
        int suma = 0;
        for(int i = 0; i < tabla.length; i++)
        {
            for(int j = 0; j < tabla[i].length; j++)
                suma += tabla[i][j];
            System.out.printf("Esta semana se han vendido %d kilos de %s.\n", suma, productos[i]);
            suma = 0;
        }
    }
}
