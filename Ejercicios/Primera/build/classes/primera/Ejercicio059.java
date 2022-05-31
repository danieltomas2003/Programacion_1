package primera;

public class Ejercicio059 
{
    public static void main(String arg[])
    {
        char frase[] = {'h', 'o', 'l', 'a', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l'};
        char frasemod[] = new char[50];
        
        modificar1(frase, frasemod);
        System.out.println(frasemod);
        
        char nueva[] = modificar1(frase);
        System.out.println(nueva);
    }
    public static void modificar1(char f1[], char f2[])
    {
        for(int i = 0, j = 0; i < f1.length; i++,j++)
        {
            if(f1[i] == ' ')
            {
                f2[j] = 'x';
                j++;
            }
            f2[j] = f1[i];
        }
    }
    public static char[] modificar1(char f1[])
    {
        char f2[] = new char[50];
        for(int i = 0, j = 0; i < f1.length; i++,j++)
        {
            if(f1[i] == ' ')
            {
                f2[j] = 'x';
                j++;
            }
            f2[j] = f1[i];
        }
        return f2;
    }
}