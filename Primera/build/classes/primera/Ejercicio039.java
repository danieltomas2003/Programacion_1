package primera;

public class Ejercicio039 
{
    public static void main(String arg[]) 
    {
        int tabla[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int acum = 0;
        int otro = tabla.length - 1;
        for(int i = 0; i < tabla.length; i++)
        {
            acum = tabla[i][i];
            tabla[i][i] = tabla[i][tabla.length - 1 - i];
            tabla[i][tabla.length - 1 - i] = acum;
        }
        for(int i = 0; i < tabla.length; i++)
        {
            System.out.print("{ ");
            for(int j = 0; j < tabla[i].length; j++)
                System.out.print(tabla[i][j] + " ");
            System.out.println("}");
        }
    }
}
