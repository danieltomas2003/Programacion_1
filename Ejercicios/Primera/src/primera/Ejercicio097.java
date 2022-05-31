package primera;
//pasar numero de binario a decimal
public class Ejercicio097 
{
    public static void main(String arg[])
    {
        int binario=11110;     
        int dos=2;
        int resultado=0;
        int potenciasDiez;
        
        while(binario>1)
        {
            potenciasDiez=dieces(binario);
            if(binario-potenciasDiez==binario%potenciasDiez)
                resultado=suma(binario, dos, resultado);
            binario-=potenciasDiez;
        }
        if(binario<1)
            System.out.println(resultado);
        else
            System.out.println(resultado+1);
    }
    
    public static int contar(int n)
    {
        int cont=0;
        while(n>1)
        {
            cont++;
            n/=10;
        }
        
        return cont;
    }
    
    public static int dieces(int n)
    {
        int diez=10;
        int cont=0;
        while(n>1)
        {
            cont++;
            n/=10;
        }
        for(int i=0; i<cont-1; i++)
            diez*=10;
        return diez;
    }
    
    public static int suma(int n, int dos, int num)
    {
        int s=contar(n);
        for(int i=0; i<s-1; i++)
            dos*=2;
        num+=dos;
        return num;
    }
}
