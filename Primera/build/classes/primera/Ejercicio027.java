package primera;
//Tabla de 3*4 donde cada fila es multiplicada por valores de otro vector
public class Ejercicio027 
{
    public static void main(String arg[])
    {
        int tabla[][] = {{10, 20, 30, 40}, {50, 60, 70, 80}, {90, 100, 110, 120}};
        int multiplo[] = {2, 4, 6};
        for(int i = 0; i < tabla.length; i++)
        {
            for(int j = 0; j < tabla[i].length; j++)
                System.out.print("- " + tabla[i][j] * multiplo[i] + " ");
            System.out.println("-");
        }
        }
    }
}
