package primera;

public class Ejercicio048 
{
    public static void main(String arg[]) 
    {
        int vector[] = {25, 2, 73, 81, 16, 4, 33};
        ordenar(vector);
        for(int i = 0; i < vector.length; i++)
            System.out.print(vector[i] + " ");
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
