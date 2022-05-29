package primera;
//Ordenar los vectores de salarios.
public class Ejercicio049 
{
    public static void main(String arg[])
    {
        int salarios[][] = {{1000, 1200, 900, 1300, 1100}, {800, 1200, 500, 1300, 1000},{1000, 1100, 800, 500, 1400},{1000, 800, 900, 500, 600},{1000, 800, 2000, 1300, 3000}, {800, 1500, 1800, 1300, 900}};
        for(int i = 0; i < salarios.length; i++)
            ordenar(salarios[i]);
        for(int i = 0; i < salarios.length - 1; i++)
        {
            for(int j = 0; j < salarios[i].length; j++)
                System.out.print(salarios[i][j] + " ");
            System.out.println();
        }
    }
    
    public static void ordenar(int v[])
    {
        int aux = 0;
        for(int j = 0; j < v.length - 1; j++)
        {
            for(int i = v.length - 1; i > j; i--)
            {
                    aux = v[i - 1];
                    if(v[i] <= v[i - 1])
                    {
                        v[i - 1] = v[i];
                        v[i] = aux;
                    }
            }
        }
    }
}
