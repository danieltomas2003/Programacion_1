package primera;
//Media de valores de un vector
public class Ejercicio019 
{
    public static void main(String arg[])
    {
     int datos[] = {3, 6, 1, 9, 8};
     int total = 0;
        for(int i = 0; i < datos.length; i++)
            total += datos[i];
        System.out.println(" la media de los valores del vector es: " + total/(datos.length));
    }
}
