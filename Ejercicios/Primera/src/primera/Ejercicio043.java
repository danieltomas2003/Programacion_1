package primera;

public class Ejercicio043 
{
    public static void main(String arg[]) 
    {
        int vector[] = {25, 2, 73, 81, 16, 4, 33};
        int aux;
        for(int k = vector.length; k > 1; k--)
            for(int i = 1; i < vector.length; i++)
            {
                for(int j = i; j > 0; j--)
                    if(vector[i] < vector[i - 1])
                    {
                        aux = vector[i];
                        vector[i] = vector[i - 1];
                        vector[i - 1] = aux;
                    }
            }
        for(int i = 0; i < vector.length; i++)
        System.out.print(vector[i] + " ");
    }
}