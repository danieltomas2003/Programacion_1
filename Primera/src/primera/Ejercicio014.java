package primera;
//Declaracion y manipulacion de vectores
public class Ejercicio014 
{
    public static void main(String arg[])
    {
        int datos [] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for(int i = 0; i < datos.length; i++)
            System.out.printf("datos [%d] = %d \n", i, datos[i]);
        System.out.println();
        for(int i = 0; i < datos.length; i++)
            datos[i] *= 2;
        for(int i = 0; i < datos.length; i++)
            System.out.printf("datos [%d] = %d \n", i, datos[i]);
    }
}
