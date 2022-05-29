package primera;
//Valor maximo y minimo del vector y su respectiva posicion
public class Ejercicio016
{
    public static void main(String arg[])
    {
        int datos[] = { 7, 2, 3, 4, 5}, mayor, posicionmax, posicionmin, menor;
            
        mayor = datos[0];
        posicionmax = 1;
        posicionmin = 1;
        menor = datos[0];
            
        for(int i = 0; i < datos.length; i++)
        {
            if(mayor < datos[i])
            {
                mayor = datos[i];
                posicionmax += i;
            }
            
            if(menor > datos[i])
            {
                menor = datos[i];
                posicionmin += i;
            }
        }
        System.out.println("el valor maximo es " + mayor + " y esta en la posicion " + posicionmax + " del vector y el valor minimo es " + menor + " y esta en la posicion " + posicionmin);
    }
}
