package primera;

public class Ejercicio092 
{
    public static void main(String arg[])
    {
        int b=5;
        mostrarFrase(b);
    }
    public static void mostrarFrase(int a)
    {
        if(a>0){
            System.out.println("MostrarFrase(" + a + ")");
            mostrarFrase(a-1);
            System.out.println("MostrarFrase(" + a + ")");
        }
    }
}
