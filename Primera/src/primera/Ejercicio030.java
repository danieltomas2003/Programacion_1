package primera;
//mostrar kilos vendidos y precio
public class Ejercicio030 
{
    public static void main(String arg[])
    {
        int tabla[][] = {{34, 11, 30, 20}, {50, 70, 25, 10}, {30, 10, 45, 50}};
        String productos[] = {"Naranjas", "Peras", "Melones"};
        double precio[] = {3.50, 4.99, 8.50};
        int suma = 0;
        double total = 0;
        for(int i = 0; i < tabla.length; i++)
        {
            for(int j = 0; j < tabla[i].length; j++)
                    suma += tabla[i][j];
            System.out.printf("Esta semana se han vendido %d kilos de %s y se han obtenido %.2f euros.\n", suma, productos[i], precio[i]*suma);
            total += precio[i]*suma;
            suma = 0;
        }
        System.out.printf("En total se han obtenido unos ingresos de %.2f euros \n", total);
    }
}
//numero en coma flotante= %. (numero de decimales)f
