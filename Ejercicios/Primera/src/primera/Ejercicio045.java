package primera;

public class Ejercicio045 
{
    public static void main(String arg[])
    {
         int vector1[] = {24, 45, 65, 12, 7, 123, 16, 50};
         System.out.printf("El maximo del primer vector es: %d", maximo(vector1));
    }
    public static int maximo(int v1[])
    {
        int posmax = 0;
        for(int i = 0; i < v1.length; i++)
            if(v1[i] > v1[posmax])
                posmax = i;
        return v1[posmax];
    }
}
