package Correccion;

public class Correccion4 
{
    public static void main(String[] args)
    {
        int num1=27;
        int num2=6;
        int sust1=num1;
        int sust2=num2;
        while(sust1!=sust2)
        {
            if(sust1>sust2)
                sust1-=sust2;
            else
                sust2-=sust1;
        }
        System.out.println("El maximo comun divisor de " + num1 + " y " + num2 + " es " + sust1);
        int recnum=euclidesRecursiva(num1, num2);
        System.out.println("El maximo comun divisor de " + num1 + " y " + num2 + " es " + recnum);
    }
    public static int euclidesRecursiva(int num1, int num2)
    {
        if(num1!=num2)
            if(num1>num2)
                return euclidesRecursiva(num1-num2, num2);
            else
                return euclidesRecursiva(num2-num1, num1);
        else 
            return num1;
    }
}
