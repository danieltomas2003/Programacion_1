package primera;
//Cambiar primera y ultima letra a mayusculas
public class Ejercicio074 
{
     public static void main(String arg[])
    {
        char frase[] = {'h', 'o', 'l', 'a', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l', ' ', 'e', 's', 't', 'a', 's', ' ', 'e', 'n', ' ', 'e', 's', 't', 'e', ' ', 'm', 'o', 'm', 'e', 'n', 't', 'o',' '};
        int inicio=0;
        int fin=0;
        while(fin<frase.length)
        {
            while(frase[fin]!=' ')
                fin++;
            frase[inicio]=Character.toUpperCase(frase[inicio]);
            frase[fin-1]=Character.toUpperCase(frase[fin-1]);
            inicio = ++fin;
        }
        System.out.println(frase);
    }
}
