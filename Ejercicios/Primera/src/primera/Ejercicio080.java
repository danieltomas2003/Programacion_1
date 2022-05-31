package primera;

public class Ejercicio080 
{
    public static void main(String arg[])
    {
        String nombres[] = {"En un lugar", "De la mancha", "de uyo nombre", "no quiero acordarme",};
        int cont=0;
        for(int i=0; i<nombres.length; i++)
        {
            int posicion=nombres[i].indexOf("a");
            while(posicion!=-1)
            {
                posicion = nombres[i].indexOf("a", posicion+1);
                cont++;
            }
        }
        System.out.println("El numero de veces de la subcadena es:" + cont);
    }
}
