package primera;

public class Ejercicio061 
{
    public static void main(String arg[])
    {
        char frase[] = {'h', 'o', 'l', 'a', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l', ' ', 'e', 's', 't', 'a', 's'};
        char sust = 'a';
        char sustituto = 'e';
        modificar(frase, sust, sustituto);
        System.out.println(frase);
    }
    public static void modificar(char f1[], char sust, char susti)
    {
        for(int i = 0; i < f1.length; i++)
        {
            if(f1[i] == sust) 
                f1[i] = susti;
            f1[i] = Character.toUpperCase(f1[i]);
        }
    }
}
