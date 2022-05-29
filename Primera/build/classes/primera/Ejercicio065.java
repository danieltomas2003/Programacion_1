package primera;
//invertir las letras de palabras
public class Ejercicio065 
{
    public static void main(String arg[])
    {
        char frase[] = {'h', 'o', 'l', 'a', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l', ' ', 'e', 's', 't', 'a', 's', ' ', 'e', 'n', ' ', 'e', 's', 't', 'e', ' ', 'm', 'o', 'm', 'e', 'n', 't', 'o', ' '};
        int inicio = 0;
        int fin = 0;
        for(int i=0; i<frase.length; i++)
        {
            char inter ;
            if(frase[i] == ' ')
            {
                fin = i-1;
                for(int j = inicio; j < fin; j++)
                {
                    inter = frase[j];
                    frase[j] = frase[fin];
                    frase[fin] = inter;
                    fin -= 1;
                }
                inicio = i+1;
            }
        }
        System.out.println(frase);
    }
}
