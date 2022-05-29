package primera;
//comparar Strings, funcion CompareTo()
public class Ejercicio077 
{
    public static void main(String arg[])
    {
        String nombres[] = {"Pepe", "Juan", "Maria", "Antonio", "Luis", "Miguel"};
        String aux;
        int x=0;
        for(int j=0; j<nombres.length-1; j++)
            for(int i = nombres.length-1; i > j; i--)
            {
                x = nombres[i].compareTo(nombres[i-1]);
                if(x<0)
                {
                    aux = nombres[i];
                    nombres[i] = nombres[i-1];
                    nombres[i-1] = aux;
                }


            }
        for(int i = 0; i < nombres.length; i++)
            System.out.print(nombres[i] + " ");
    }
}
