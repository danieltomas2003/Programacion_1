package primera;
//Tememos una tabla de enteros y un entero llamado multiplicador.
//multiplicamos cada elemento por el multiplicador.
public class Ejercicio053 
{
    public static void main(String arg[])
    {
        int tabla[][] = {{10, 20, 30, 40}, {50, 60, 70, 80}, {90, 100, 110, 120}, {130, 140, 150, 160}, {170, 180, 190, 200}};
        int multiplicador = 4;
        multiplicar(tabla, multiplicador);
        for(int i = 0; i < tabla.length; i++)
        {
            for(int j = 0; j < tabla[i].length; j++)
                System.out.print(tabla[i][j] + " - ");
            System.out.println();
        }        
    }
    
    public static void multiplicar(int v[][], int mult)
    {
        for(int i = 0; i < v.length; i++)
            for(int j = 0; j < v[i].length; j++)
                v[i][j] *= mult;
    }
}
