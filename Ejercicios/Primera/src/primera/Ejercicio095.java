package primera;
//Diseccionar un nuemro entero
public class Ejercicio095 
{
    public static void main(String arg[])
    {
        int a=256806;
        String medidas[]={"Unidades", "Decenas", "Centenas", "Unidades de millar", "Decenas de millar", "Centenas de millar"};
        int i=0;
        while(a>0)
        {
            System.out.println((a%10) + " " + medidas[i]+" ");
            a/=10;
            i++;
        }
        System.out.println();
        System.out.println();
        a=256806;
        i=0;
        disecciona(a, medidas, i);        
    }
    public static void disecciona(int n, String m[], int i)
    {
        if(n>0)
        {
            disecciona(n/10, m, i+1);
            System.out.println((n%10) + " " + m[i]);
        }
    }
}
