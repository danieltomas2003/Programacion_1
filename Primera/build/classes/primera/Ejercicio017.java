package primera;
//invertir el contenido de los elementos del vector
public class Ejercicio017 
{
    public static void main(String arg[])
    {
        int datos[] = {1, 2, 3, 4, 5, 6};
        int intercambio = 0;
        int j = datos.length - 1;
        for(int i = 0; i < (datos.length/2); i++)
        {
            intercambio = datos[i];
            datos[i] = datos[j];
            datos[j] = intercambio;
            j -= 1;
        }
        System.out.print("los datos del vector al reves son: datos[] = { ");
        for(int i = 0; i < datos.length; i++)
            System.out.printf( "%d, ",datos[i]);
        System.out.print("}");
    }
}
