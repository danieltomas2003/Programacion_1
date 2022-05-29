package primera;

public class Ejercicio083 
{
    public static void main(String arg[])
    {
        String frase = "5cinco 6seis 7siete 2dos 1uno 3tres 4cuatro ";
        int posicion=frase.indexOf(" ");
        int cont=0;
        while(posicion!=-1)
        {
            posicion = frase.indexOf(" ", posicion+1);
            cont++;
        }
        String frase2[] = new String[cont];
        int inicio=0;
        int fin=0;
        for(int i=0; i<frase2.length;i++)
        {
            fin=frase.indexOf(" ", fin+1);
            frase2[i]=frase.substring(inicio, fin);
            inicio=fin+1;
        }
        String aux;
        for(int j=0; j<frase2.length-1; j++)
            for(int i = frase2.length-1; i > j; i--)
            {
                int x = frase2[i].compareTo(frase2[i-1]);
                if(x<0)
                {
                    aux = frase2[i];
                    frase2[i] = frase2[i-1];
                    frase2[i-1] = aux;
                }
            }
        for(int i = 0; i < frase2.length; i++)
            System.out.print(frase2[i] + " ");  
    }
}
