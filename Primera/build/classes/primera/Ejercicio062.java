package primera;

public class Ejercicio062 
{
    public static void main(String arg[])
    {
        char frase[] = {'h', 'o', 'l', 'a', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l', ' ', 'e', 's', 't', 'a', 's'};
        char sust = 'a';
        char sustituto[] = {'e', 'E', 'X'};
        char frasemod[] = modificar(frase, sust, sustituto);
        System.out.println(frasemod);
    }
    public static char[] modificar(char f1[], char sust, char susti[])
    {
        char f2[] = new char[50];
        for(int i = 0, j = 0; i < f1.length; i++,j++)
            if(f1[i] == sust)
                for(int k = 0; k < susti.length; k++)
                {
                    f2[j] = susti[k];
                    j++; 
                }
            else
            {
                f2[j] = f1[i];
                j++;
            }
        return f2;
    }
}
