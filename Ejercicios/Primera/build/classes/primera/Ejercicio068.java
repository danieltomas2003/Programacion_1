package primera;

public class Ejercicio068 
{
    public static void main(String arg[])
    {
        char frase[] = {'h', 'o', 'l', 'a', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l', ' ', 'e', 's', 't', 'a', 's', ' ', 'e', 'n', ' ', 'e', 's', 't', 'e', ' ', 'm', 'o', 'm', 'e', 'n', 't', 'o', ' '};
        char frase2[] = new char[150];
        for(int i=0, j=(frase.length-1); i < frase.length; i++, j--)
                frase2[i] = frase[j];
        System.out.println(frase2);
    }
}
