package primera;
//sustituir cadena 1 por 2 en la frase
public class Ejercicio070 
{
    public static void main(String arg[])
    {
        char frase[] = {' ','h', 'o', 'l', 'a', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l', ' ', 'e', 's', 't', 'a', 's', ' ', 'e', 'n', ' ', 'e', 's', 't', 'a', ' ', 'm', 'o', 'm', 'e', 'n', 't', 'o'};
        char cadena1[] = {'t', 'a'};
        char cadena2[] = {'X','X','X','X','X'};
        char frase2[] = modificar(frase, cadena1, cadena2);
        System.out.println(frase2);   
    }
    public static char[] modificar(char fr[], char ca1[], char ca2[])
    {
        char f2[]=new char[150];
        for(int i=0, j=0; i < fr.length; i++, j++)
            if(fr[i] == ca1[0])
            {
                int is = 1;
                while((is<ca1.length) && (fr[i+is] == ca1[is]))
                {
                    is++;
                    if(is == ca1.length) 
                    {
                        for(int z = 0; z < ca2.length; z++)
                            f2[j++] = ca2[z];
                        i += ca1.length-1;
                    }
                    else
                        f2[j] = fr[i];
                }
            }
            else
                f2[j] = fr[i];
        return f2;
    }
}
