package primera;

public class Ejercicio079 
{
    public static void main(String arg[])
    {
        String frase = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme";
        String frase2 = frase.replace('a', 'X');
        System.out.println(frase2);
        //Nº de veces que se encuentra uuna cadena dentro de otra
        int posicion=frase.indexOf("de");
        int cont=0;
        while(posicion!=-1)
        {
            posicion = frase.indexOf("de", posicion+1);
            cont++;
        }
        System.out.println("El numero de veces de la subcadena es:" + cont);
    }
}
