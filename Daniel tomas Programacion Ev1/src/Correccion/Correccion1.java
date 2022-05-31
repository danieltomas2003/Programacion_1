package Correccion;

public class Correccion1 
{
    public static void main(String[] args)
    {
        char cadena[]={'h', 'o', 'l', 'a', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l', ' ', 'e', 's', 't', 'a', 's', ' '};
        char cadena2[]=new char[cadena.length];
        int fin=0;
        int inicio=0;
        while(fin<cadena.length)
        {
            while(cadena[fin] != ' ')
                fin++;
            if((fin-inicio)>3)
                for(int i=inicio; i<fin; i++)
                    cadena[i]=Character.toUpperCase(cadena[i]);
        inicio=fin;
        }
        System.out.println(cadena);
    }
}
        