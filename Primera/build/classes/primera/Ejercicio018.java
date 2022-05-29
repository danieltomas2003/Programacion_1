package primera;
//Cambiar negativos a positivos y positivos por dos
public class Ejercicio018 
{
     public static void main(String arg[])
    {
        int datos[] = {-1, 2, 4, -8, 12, -123};
        for(int i = 0; i < datos.length; i++)
        {
            if (datos[i] > 0)
                datos[i] *= 2;
            else
                datos[i] *= -1;
        }
        for(int i = 0; i < datos.length; i++)
            System.out.print(datos[i] + " ");
    }
}
