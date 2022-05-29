package primera;
//Mostrar por pantalla el mayor valor de un vector.
public class Ejercicio015 
{
    public static void main(String arg[])
    {
        int datos[] = { 6, 2, 3, 4, 5};
        int mayor = datos[0];
        int posicion = 0;
        for(int i = 0; i < datos.length; i++)
        {
            if(mayor < datos[i])
            {
                mayor = datos[i];
                posicion = i + 1;
            }
        }        
        System.out.println("el mayor es " + mayor + " y esta en la posicion " + posicion + " del vector");
        
    }
}
