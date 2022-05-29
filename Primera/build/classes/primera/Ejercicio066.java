package primera;

public class Ejercicio066 
{
    public static void main(String arg[])
    {
        char frase[] = {'h', 'o', 'l', 'a', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l', ' ', 'e', 's', 't', 'a', 's', ' ', 'e', 'n', ' ', 'e', 's', 't', 'e', ' ', 'm', 'o', 'm', 'e', 'n', 't', 'o', ' '};
        int inicio = 0;
        int fin = 0;
        desplazard(frase, inicio, fin);
        System.out.println(frase);
        desplazari  (frase, inicio, fin);
        System.out.println(frase);
    }
    public static void desplazari(char fr[], int in, int fi)
    {
        for(int i=0; i<fr.length; i++)
            if(fr[i] == ' ')
            {
                fi = i-1;
                char aux = fr[in];
                int j;
                for(j = in; j < fi; j++)
                {
                    fr[j] = fr[j + 1];
                }
                fr[fi] = aux;
                in = i+1;
            }
    }
    
    public static void desplazard(char fr[], int in, int fi)
    {
        for(int i=0; i<fr.length; i++)
        {
            if(fr[i] == ' ')
            {
                fi = i-1;
                char aux = fr[fi];
                int j;
                for(j = fi; j > in; j--)
                {
                    fr[j] = fr[j - 1];
                }
                fr[in] = aux;
                in = i+1;
            }
        }
    }
}
