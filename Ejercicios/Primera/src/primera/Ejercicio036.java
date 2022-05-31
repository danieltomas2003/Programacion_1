package primera;
//Empleado mas remunerado y media
public class Ejercicio036 
{
    public static void main(String arg[])
    {
        int salarios[][] = {{1000, 1200, 1000, 1300, 1400}, {1000, 1200, 1000, 1300, 1400},{1000, 1200, 1000, 1300, 1400},{1000, 1200, 1000, 1300, 1400},{1000, 1200, 1000, 1300, 1400}};
        String empleados[] = {"Jose Bueno", "Marta Diaz", "Marcos Barcelona", "Hector Miranda", "Diego Muñoz"};
        String meses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo"};
        double empleadosAcum[] = {0, 0, 0, 0, 0};
        double mesesAcum[] = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int posmax = 0, posmin = 0;
        for(int i = 0; i < meses.length; i++)
            for(int j = 0; j < empleados.length; j++)
            {
                empleadosAcum[i] += salarios[i][j];
                mesesAcum[j] += salarios[i][j];
            }
        for(int i=1; i<empleados.length; i++)
        {
            if(empleadosAcum[i] > empleadosAcum[posmax])
                posmax = i;
            if(empleadosAcum[i] < empleadosAcum[posmax])
                posmin = i;
        }  
        System.out.printf("El empleado que mas a cobrado es %s, con una media de %.2f euros al mes. \n", empleados[posmax], empleadosAcum[posmax]/meses.length);
        System.out.printf("El empleado que mas a cobrado es %s, con una media de %.2f euros al mes.\n", empleados[posmin], empleadosAcum[posmin]/meses.length);
        posmax = 0; posmin = 0;
        for(int i=1; i<empleados.length; i++)
        {
            if(mesesAcum[i] > mesesAcum[posmax])
                posmax = i;
            if(mesesAcum[i] < mesesAcum[posmax])
                posmin = i;
        }  
        System.out.printf("El empleado que mas a cobrado es %s, con una media de %.2f euros al mes. \n", meses[posmax], mesesAcum[posmax]/empleados.length);
        System.out.printf("El empleado que mas a cobrado es %s, con una media de %.2f euros al mes.\n", meses[posmin], mesesAcum[posmin]/empleados.length);
    }
}
