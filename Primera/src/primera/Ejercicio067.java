package primera;

public class Ejercicio067 
{
    public static void main(String arg[])
    {
        char frase[] = {'h', 'o', 'l', 'a', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l', ' ', 'e', 's', 't', 'a', 's', ' ', 'e', 'n', ' ', 'e', 's', 't', 'e', ' ', 'm', 'o', 'm', 'e', 'n', 't', 'o', ' '};
        char frase2[] = new char[150];
        int i=0;
        for(i = 0; i < frase.length; i++)
            frase2[i]=frase[i];
        for(int j = 0; j < frase.length; j++, i++)
            frase2[i]=frase[j];
        System.out.println(frase2);
                
    }
}
