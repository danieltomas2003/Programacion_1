package primera;
//funcion que devuelva un vector de 4 elementos con lo que ha cobrado cada empleado en los seis meses
public class Ejercicio047 
{
    public static void main(String arg[])
    {
        int salarios[][] = {{2000, 1200, 1000, 1300, 1400}, {1000, 1200, 1000, 1300, 1400},{1000, 1000, 1000, 1300, 1400},{1000, 1000, 1000, 1000, 1400},{1000, 1000, 1000, 1300, 1000}, {1000, 1000, 1000, 1300, 1000}};
        String empleados[] = {"Jose Bueno", "Marta Diaz", "Marcos Barcelona", "Hector Miranda", "Diego Muñoz"};
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio"};
        int empleadosAcum[] = salariosemestral(salarios);
        
        for(int i = 0; i < empleados.length; i++)
            System.out.printf("%s ha cobrado %d euros este semestre \n", empleados[i], empleadosAcum[i]);
        System.out.println();
        
        int emplAcum[] = {0, 0, 0, 0, 0};
        salariosemestral2(salarios, emplAcum);
        for(int i = 0; i < empleados.length; i++)
            System.out.printf("%s ha cobrado %d euros este semestre \n", empleados[i], emplAcum[i]);
        System.out.println();
        
        int salmes[] = salariomes(salarios);
        for(int i = 0; i < meses.length; i++)
            System.out.printf("En %s se ha pagado %d \n", meses[i], salmes[i]);
        System.out.println();
    }
    public static int[] salariosemestral(int sal[][])
    {
        int acum[] = {0, 0, 0, 0, 0};
        for(int i = 0; i < sal.length; i++)
            for(int j = 0; j <sal[i].length; j++)
                acum[j] += sal[i][j];
        return acum;
    }
    public static void salariosemestral2(int sal[][], int acum[])
    {
        for(int i = 0; i < sal.length; i++)
            for(int j = 0; j < sal[i].length; j++)
                acum[j] += sal[i][j];
    }
    public static int[] salariomes(int sal[][])
    {
        int acum[] = {0, 0, 0, 0, 0, 0};
        for(int i = 0; i < sal.length; i++)
            for(int j = 0; j <sal[i].length; j++)
                acum[i] += sal[i][j];
        return acum;
    }
}
