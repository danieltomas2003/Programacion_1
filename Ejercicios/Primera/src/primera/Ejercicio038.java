package primera;
//invertir filas por colunmas sin tabla auxiliar
public class Ejercicio038 
{
    public static void main(String arg[])
    {
        int tabla[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int acum = 0;
        int diagonal = 0;
        for(int i = 0; i < tabla.length/2; i++)
        {
            for(int j = diagonal; j < tabla[i].length; j++)
            {
                acum = tabla[j][i];
                tabla[j][i] = tabla[i][j];
                tabla[i][j] = acum;
            }
            diagonal += 1;
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
