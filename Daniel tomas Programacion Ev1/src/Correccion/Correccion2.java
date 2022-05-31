package Correccion;

public class Correccion2 
{
    public static void main(String[] args)
    {
        String frase="En un lugar de la mancha de cuyo nombre no quiero acordarme ";
        int fin=frase.indexOf(" ");
        int inicio=0;
        while(fin != -1)
        {
            if((fin-inicio)>3)
                frase=frase.substring(0, inicio).concat(frase.substring(inicio, fin).toUpperCase()).concat(frase.substring(fin));
            inicio=fin+1;
            fin=frase.indexOf(" ", fin+1);
        }
        
        System.out.println(frase);  
    }
}
