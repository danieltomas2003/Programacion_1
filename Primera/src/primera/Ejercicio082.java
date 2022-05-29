package primera;

public class Ejercicio082 
{
    public static void main(String arg[])
    {
        String frase = "En un lugar en la mancha de cuyo nombre no quiero acordarme";
        String subCadena=" ";
        int posicion=frase.indexOf(subCadena);
        while(posicion != -1)
        {
            frase=frase.substring(0, posicion).concat(frase.substring(posicion+1));
            posicion=frase.indexOf(subCadena, posicion+1);
        }
        System.out.println(frase);
    }
}
