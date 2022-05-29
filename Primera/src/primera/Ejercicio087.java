package primera;

public class Ejercicio087 
{
    public static void main(String arg[])
    {
        String frase = "Habia     una   vez un          circo      que   alegraba       siempre    el      corazon ";
        frase=frase.replaceAll(" +", " ");
        System.out.println(frase);
    }
}
