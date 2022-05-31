package Correccion;

public class Correccion3 
{
    public static void main(String[] args)
    {
        int matriz[][]={{1, 2, 3, 4},{2, 4, 6, 8},{3, 6, 9, 12},{4, 8, 12, 16}};
        int vector[]={1, 2, 3, 4};
        int fin[][]=multiplicacion(matriz, vector);
        
        for(int i=0; i<matriz.length; i++)
        {
            for(int j=0; j<matriz[i].length; j++)
                System.out.print("-"+fin[i][j]+"-");
            System.out.println();
        }
        
    }
    public static int[][] multiplicacion(int m[][], int v[])
    {
        int f[][]={{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
        for(int i=0; i<m.length; i++)
            for(int j=0; j<m[i].length; j++)
                f[i][j]=m[i][j]*v[j];
        return f;
    }
}
