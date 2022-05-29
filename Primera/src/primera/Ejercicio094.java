package primera;

public class Ejercicio094 
{
    public static void main(String arg[])
    {
        int n=14;
        System.out.println(hora(n));
        System.out.println(horasrec(n));
    }
    public static int hora(int a)
    {
        int cont=0;
        for(int i=0;i<=a;i++)
        {
            if(i<=12)
                cont+=i;
            else
                cont+=i-12;
        }
        return cont;
    }
    public static int horasrec(int a)
    {
        
        if(a<=0)
            return 0;
        else
            if(a<=12)
            return horasrec(a-1)+a;
            else
                return horasrec(a-1)+(a-12);
    }
}
