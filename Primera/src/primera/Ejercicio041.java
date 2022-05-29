package primera;
//ordenar vectores por el metodo de la burbuja
public class Ejercicio041 
{
   public static void main(String arg[]) 
    {
        int vector[] = {25, 2, 73, 81, 16, 4, 33};
        int aux = 0;
        for(int j = 0; j < vector.length - 1; j++)
        {
            for(int i = vector.length - 1; i > j; i--)
            {
                    aux = vector[i - 1];
                    if(vector[i] <= vector[i - 1])
                    {
                        vector[i - 1] = vector[i];
                        vector[i] = aux;
                    }
            }
        }
        for(int i = 0; i < vector.length; i++)
        System.out.print(vector[i] + " ");
    } 
}
