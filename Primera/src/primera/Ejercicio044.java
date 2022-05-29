package primera;

public class Ejercicio044 
{
    public static void main(String arg[])
    {
        String palabras;
        escribir();
        hablar("Buenos dias");
        animalHabla("Me llamo Tobi", "Guau Guau");
        palabras = concatenar("En un lugar", " de la Mancha");
        System.out.println(palabras);
        System.out.println("la suma de 345 + 55 es: " + suma(345, 55));
    }
    
    public static void escribir()
    {
        System.out.println("Hola");
    }
    public static void hablar(String frase)
    {
        System.out.println(frase);
    }
    public static void animalHabla(String frase, String onomatopeya)
    {
        System.out.println(frase + " : " + onomatopeya);
    }
    public static String concatenar(String frase1, String frase2)
    {
        return frase1 + frase2;
    }
    public static int suma(int a, int b)
    {
        return (a+b);
    }
}
