package primera;

public class Ejercicio060 
{
    public static void main(String arg[])
    {
        char frase[] = {'h', 'o', 'l', 'a', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l'};
        modificar(frase);
        System.out.println(frase);
    }
    public static void modificar(char f1[])
    {
        for(int i = 0; i < f1.length; i++)
        { 
            f1[i] = Character.toUpperCase(f1[i]);
        }
    }
}
