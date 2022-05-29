package primera;

public class Ejercicio081 
{
    public static void main(String arg[])
    {
        String nombres[] = {"en un lugar", "en la mancha", "de cuyo nombre", "no quiero acordarme",};
        String subCadena="en";
        for(int i=0; i<nombres.length; i++)
        {
            nombres[i]=nombres[i].replace(subCadena, subCadena.toUpperCase());
            System.out.print(" " + nombres[i]);
        }
    }
}
