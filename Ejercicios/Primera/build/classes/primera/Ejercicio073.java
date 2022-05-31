package primera;

public class Ejercicio073 
{
    public static void main(String arg[])
    {
        char frase[] = {'h', 'o', 'l', 'a', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l', ' ', 'e', 's', 't', 'a', 's', ' ', 'e', 'n', ' ', 'e', 's', 't', 'e', ' ', 'm', 'o', 'm', 'e', 'n', 't', 'o'};
        char cambio[] = {'e', 'n', ' '};
        for(int i=0, j=0; i < frase.length; i++, j++)
            if(frase[i] == cambio[0])
            {
                int is = 1;
                while((is<cambio.length) && (frase[i+is] == cambio[is]))
                {
                    is++;
                    if(is == cambio.length) 
                    {
                        for(int k=0; k<cambio.length; k++)
                        {
                            for(int l=i; l<frase.length-1; l++)
                                frase[l]=frase[l+1];
                            frase[frase.length-1] = ' ';
                        }
                    }
                }
            }
                    System.out.println(frase);
    }
}
