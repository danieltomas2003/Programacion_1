package primera;

public class Ejercicio064 
{
    public static void main(String arg[])
    {
        char cadena[] = {'h', 'o', 'l', 'a', 'a', 'a', 'a', 'a',' ', 'q', 'u', 'e', ' ', 't', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'l', ' ', 'e', 's', 't', 'a', 'a', 's'};
        char subcadena[] = {'a', 'a', 'a'};
        int cont = 0;
        
        for(int i=0; i < cadena.length - subcadena.length; i++)
            if(cadena[i] == subcadena[0])
            {
                int j = 1;
                while((j<subcadena.length)&&(cadena[i+j] == subcadena[j]))
                {
                    j++;
                    if(j == subcadena.length)
                        cont += 1;
                }
            }
        System.out.println(cont);
    }
}
