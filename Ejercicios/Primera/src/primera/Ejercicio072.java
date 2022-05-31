package primera;
//eliminar de la frase un caracter
public class Ejercicio072 
{
    public static void main(String arg[])
    {
        char frase[] = {'h', 'o', 'l', 'a', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l', ' ', 'e', 's', 't', 'a', 's', ' ', 'e', 'n', ' ', 'e', 's', 't', 'e', ' ', 'm', 'o', 'm', 'e', 'n', 't', 'o'};
        char cambio = 'e';
        for(int i=0; i<frase.length; i++)
            if(frase[i]==cambio)
            {
                for(int j=i; j<frase.length-1; j++)
                    frase[j]=frase[j+1];
                frase[frase.length-1] = ' ';
            }
        System.out.println(frase);
    }
}
