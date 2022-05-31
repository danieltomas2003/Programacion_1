/*
 * funcion que sume los elementos de una tabla
 */
package primera;

public class Ejercicio046 
{
    public static void main(String arg[])
    {
        int salarios[][] = {{1000, 1200, 1000, 1300, 1400}, {1000, 1200, 1000, 1300, 1400},{1000, 1200, 1000, 1300, 1400},{1000, 1200, 1000, 1300, 1400},{1000, 1200, 1000, 1300, 1400}};
        System.out.printf("La suma de todos los sueldos es: %d ", suma(salarios));
    }
    public static int suma(int sueldo[][])
    {
        int suma = 0;
        for(int i = 0; i < sueldo.length; i++)
            for(int j = 0; j < sueldo[i].length; j++)
                    suma += sueldo[i][j];
        return suma;
            
    }
}
