package daniel.tomas.programacion.ev1;
/*
Dada una cadena de caracteres cuyas palabras están separadas por un espacio en blanco, 
cambiar a mayúsculas las palabras cuya longitud sea superior a 3 caracteres.
a) Hacerlo sobre la propia cadena. 1,5 puntos
b) Hacerlo sobre una nueva cadena.  1,5 puntos

*/
public class Ejercicio1 
{
    public static void main(String[] args)
    {
        char cadena[]={'h', 'o', 'l', 'a', ' ', 'q', 'u', 'e', ' ', 't', 'a', 'l', ' ', 'e', 's', 't', 'a', 's', ' '};
        char cadena2[]=new char[cadena.length];
        int cont=0;
        int inicio=0;
        for(int i=0; i<cadena.length; i++)
        {
            if(cadena[i]!=' ')
            {
                cont++;
            }
            if((cont>3)&&(cadena[i]==' '))
            {
                cadena[inicio]=Character.toUpperCase(cadena[inicio]);
                cont=0;
                inicio=i+1;
            }
        }
        System.out.println(cadena);
        inicio=0;
        cont=0;
        for(int i=0; i<cadena.length; i++)
        {
            if(cadena[i]!=' ')
            {
                cont++;
                cadena2[i]=cadena[i];
            }
            if((cont>3)&&(cadena[i]==' '))
            {
                cadena2[i]=cadena[i];
                cadena2[inicio]=Character.toUpperCase(cadena[inicio]);
                cont=0;
                inicio=i+1;
            }
        }
        System.out.print(cadena2);
        
    }
}
