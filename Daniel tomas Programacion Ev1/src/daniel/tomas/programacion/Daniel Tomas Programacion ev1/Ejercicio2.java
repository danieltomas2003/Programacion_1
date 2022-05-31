package daniel.tomas.programacion.ev1;
/*
El mismo ejercicio anterior, pero en lugar de tratar con una cadena de caracteres, 
hacerlo con un String.  Sobre el mismo String.
*/
public class Ejercicio2 
{
    public static void main(String[] args)
    {
        String cadena=" hola que tal estas";
        int inicio=0;
        for(int i=0; i<cadena.length(); i++)
            if(cadena.charAt(i)==' ')
                cadena=cadena.substring(inicio).concat(cadena.substring(i+1));
        System.out.println(cadena);
    }
}
