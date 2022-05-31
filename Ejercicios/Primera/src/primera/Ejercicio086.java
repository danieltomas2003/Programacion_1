package primera;

public class Ejercicio086 
{
    public static void main(String arg[])
    {
        String frase1 = "Habia una vez un circo que alegraba siempre el corazon ";
        int posicion=frase1.indexOf(" ");
        while(posicion != -1)
        {
            frase1=frase1.substring(0, posicion).concat("a").concat(frase1.substring(posicion, frase1.length()));
            posicion = frase1.indexOf(" ", posicion + 2);
        }
        System.out.println(frase1);
    }
}
