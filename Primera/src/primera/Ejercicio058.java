package primera;

public class Ejercicio058 
{
    public static void main(String arg[])
    {
        char caracter = 'i';
        char frase[] = {'h', 'o', 'l', 'a', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l'};
        System.out.printf("la frase tiene %d caracteres en blanco. \n", frase(frase));
    }
    public static int frase( char[] f)
    {
        int cont = 0;
        for(int i = 0; i < f.length; i++)
            if(f[i] == ' ')
                cont += 1;
        return cont;
    }
}
