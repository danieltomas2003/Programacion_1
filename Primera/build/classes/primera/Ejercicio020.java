package primera;
//Mover las variables de un vector una posicion a la izquierda
public class Ejercicio020 
{
    public static void main(String arg[])
    {
        int datos[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int aux = datos[0];
        int i;
        for(i = 0; i < datos.length - 1; i++)
        {
            datos[i] = datos[i + 1];
        }
        datos[i] = aux;
        System.out.print("los valores del vector cambiado son: ");
        for(i = 0; i < datos.length ; i++)
            System.out.printf("%d, ", datos[i]);
    }
}
