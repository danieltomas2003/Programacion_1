package primera;
//Invertir el orden de palabras en una frase
public class Ejercicio071 
{
    public static void main(String arg[])
    {
        char frase[] = {' ','h', 'o', 'l', 'a', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l', ' ', 'e', 's', 't', 'a', 's', ' ', 'e', 'n', ' ', 'e', 's', 't', 'e', ' ', 'm', 'o', 'm', 'e', 'n', 't', 'o'};
        char frase2[] = new char[150];
        int inicio=frase.length-1;
        int fin=inicio;
        int pos=0; //Indice frase 2
        
        while(inicio > 0)
        {
            while(frase[inicio] != ' ')
                inicio--;
            for(int i=inicio; i <= fin;pos++, i++)
                frase2[pos] = frase[i];
            inicio=fin=inicio-1;  
        }       
        System.out.println(frase2);
    }
}
