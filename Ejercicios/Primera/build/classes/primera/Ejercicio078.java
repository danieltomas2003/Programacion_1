package primera;
//Extraer cadena de subcadena, funcion substring
public class Ejercicio078 
{
    public static void main(String arg[])
    {
        String frase = "En un lugar de la Mancha, de cuyo nombre no quiero acordarme";
        int inicio = 7;
        int fin = 19;
        System.out.println("la subcadena contiene " + frase.substring(inicio, fin));
    }
}
