package primera;

public class Ejercicio088 
{
    public static void main(String arg[])
    {
        String frase = "Habia     una   vez un          circo      que   alegraba       siempre    el      corazon";
        int posicion=frase.indexOf(" ");
        while(posicion != -1)
        {
            while(frase.charAt(posicion+1) == ' ')
                frase=frase.substring(0, posicion).concat(frase.substring(posicion+1, frase.length()));
            posicion=frase.indexOf(" ", posicion+1);
        }
        System.out.println(frase);
    }
}
