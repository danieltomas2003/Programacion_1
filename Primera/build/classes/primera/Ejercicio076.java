package primera;
//Tratar con String
public class Ejercicio076 
{
    public static void main(String arg[])
    {
        String frase = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme";
        char cadena[] = new char[150];
        for(int i=0;i<frase.length(); i++)
            System.out.printf("%c ", frase.charAt(i));
        for(int i=0;i<frase.length(); i++)
            cadena[i] = frase.charAt(i);
        System.out.println();
        System.out.print(cadena);
        
        
    }
}