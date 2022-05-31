package primera;
//Tablas de multiplicar
public class Ejercicio009 
{
    public static void main(String arg[]) 
    {
        for(int num = 1; num <= 10; num++)
        {
            System.out.println("la tabla del " + num + " es:");
            System.out.println(" ");
            
            for (int tabla = 1; tabla <= 10; tabla++)
                System.out.println(num + " por " + tabla + " es " + num * tabla);
            
            System.out.println();
            System.out.println();
        }    
    }
}
