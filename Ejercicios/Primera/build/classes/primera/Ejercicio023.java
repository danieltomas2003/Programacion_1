package primera;
//Mover los valores del vector hasta la posicion original
public class Ejercicio023 
{
    public static void main(String arg[])
    {
        int datos[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i;
        for(int j = datos.length ; j > 0; j--)
        {
            int aux = datos[datos.length - 1];
            for(i = datos.length - 1; i > 0; i--)
            {
                datos[i] = datos[i - 1];
            }
            datos[i] = aux;
            System.out.print("los valores del vector cambiado son: ");
            for(i = 0; i < datos.length ; i++)
                System.out.printf("%d ; ", datos[i]);
            System.out.println();
        }
    }
}
