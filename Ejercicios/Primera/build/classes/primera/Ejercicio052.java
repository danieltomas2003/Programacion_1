package primera;

public class Ejercicio052 
{
    public static void main(String arg[])
    {
        int salarios[][] = {{1000, 1200, 900, 1300, 1100, 700}, {800, 1200, 500, 1300, 1000, 700},{1000, 1100, 800, 500, 1400, 700}, {1000, 800, 900, 500, 600, 700},{1000, 800, 2000, 1300, 3000, 700}};
        String empleados[] = {"Jose Bueno", "Marta Diaz", "Marcos Barcelona", "Hector Miranda", "Diego Muñoz"};
        int salariosAcum[] = suma(salarios);
        for(int i = 0; i < empleados.length; i++)
            System.out.printf("El/La señor/a %s ha cobrado en estos seis meses %d euros. \n", empleados[i], salariosAcum[i]);
    }
    public static int[] suma(int v[][])
    {
        int acum[] = {0, 0, 0, 0, 0};
        for(int i = 0; i < v.length; i++)
            for(int j = 0; j < v[i].length; j++)
                acum[i] +=v[i][j];
        return acum;
    }
}
