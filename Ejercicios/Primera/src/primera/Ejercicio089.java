package primera;

public class Ejercicio089 
{
    public static void main(String arg[])
    {
        String frase = "Habia una vez un circo que alegraba siempre el corazon ";
        String fraseA = "";
        String fraseB = "";
        boolean variable=true;
        int inicio=0;
        int fin=frase.indexOf(" ");
        while(fin != -1)
        {
            if(variable)
            {
                fraseA=fraseA.concat(frase.substring(inicio, fin+1));
                variable=false;
            }
            else
            {
                fraseB=fraseB.concat(frase.substring(inicio, fin+1));
                variable=true;
            }
            inicio=fin+1;
            fin=frase.indexOf(" ", inicio);
        }
        System.out.println(fraseA);
        System.out.println(fraseB);
    }
}
