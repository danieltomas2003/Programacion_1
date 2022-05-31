package primera;
//Cambiar vocales minusculas a mayusculas y mayusculas a minusculas con el Switch y las consonantes se sustituyen por @.
public class Ejercicio075 
{
    public static void main(String arg[])
    {
        char frase[] = {'H', 'o', 'l', 'A', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l', ' ', 'E', 's', 't', 'a', 's', ' ', 'e', 'n', ' ', 'e', 's', 't', 'E', ' ', 'm', 'o', 'm', 'e', 'n', 't', 'O'};
        for(int i=0; i<frase.length; i++)
            switch(frase[i])
            {
                case 'A': case 'E': case 'I': case 'O': case 'U':
                    frase[i] = Character.toLowerCase(frase[i]);
                    break;
                case 'a': case 'e': case 'i': case 'o': case 'u':
                    frase[i] = Character.toUpperCase(frase[i]);
                    break;
                default:
                    frase[i] = '$';
            }
        System.out.println(frase);
    }
}
