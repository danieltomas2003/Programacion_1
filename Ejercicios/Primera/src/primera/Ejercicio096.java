package primera;
//Pasar numero de decimal a binario
public class Ejercicio096 
{
    public static void main(String arg[])
    {
        int num=30;
        pasar(num);
    }
    public static void pasar(int b)
    {
        if(b != 0)
        {
            pasar(b/2);
            System.out.print(b%2);
        }
    }
}
