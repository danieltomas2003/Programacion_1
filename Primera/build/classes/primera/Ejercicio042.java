package primera;
//ordenar vectores por el metodo de seleccion directa
public class Ejercicio042 
{
   public static void main(String arg[]) 
    {
        int vector[] = {25, 2, 73, 81, 16, 4, 33};
        int aux;
        for(int j = 0; j < vector.length - 1; j++)
        {
            int posmin = j;
            for(int i = j; i < vector.length; i++)
                if(vector[i] < vector[posmin])
                    posmin = i;
            aux = vector[posmin];
            vector[posmin] = vector[j];
            vector[j] = aux;
        }
        for(int i = 0; i < vector.length; i++)
        System.out.print(vector[i] + " ");
    }
}