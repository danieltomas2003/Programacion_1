package primera;

public class Ejercicio063 
{
    public static void main(String arg[])
    {
        char frase[] = {'h', 'o', 'l', 'a', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l', ' ', 'e', 's', 't', 'a', 's'};
        char sust = 'a';
        char sustituto[] = {'e', 'E', 'X'};
        char frase2[] = new char[100];
        for(int i=0;i<frase.length;i++)
            frase2[i] = frase[i];
        modificar(frase2, sust, sustituto, frase.length);
        System.out.print(frase2);
    }
    public static void modificar(char fr[], char s1, char s2[], int longitud)
    {
        for(int i=0; i<longitud; i++)
            if(s1 == fr[i])
            {
                fr[i] = s2[0];
                for(int x=1; x<s2.length; x++)
                {
                    for(int j = longitud; j > i; j--)
                        fr[j] = fr[j-1];
                    longitud++;
                    fr[++i] = s2[x];
                }
            }
    }
}
