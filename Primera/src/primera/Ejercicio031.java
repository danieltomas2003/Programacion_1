//Mostrar por pantalla el dia en que mas entradas se vendieron y cuantas entradas fueron
package primera;

public class Ejercicio031 
{
    public static void main(String arg[])
    {
        int entradas[][] = {{5, 8, 18, 9, 5, 6, 9}, {5, 8, 18, 9, 5, 6, 9}, {5, 8, 18, 9, 5, 6, 9}, {5, 8, 18, 9, 5, 6, 9}};
        String dias[] = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
        int suma[] = {0, 0, 0, 0, 0, 0, 0};
        int posicionmax = 0;
        int posicionmin = 0;
        for(int i = 0; i < entradas.length; i++)
                for(int j = 0; j < entradas[i].length; j++)
                    suma[j] += entradas[i][j];
        for(int i = 0; i < suma.length; i++)
        {
            if(suma[i] > suma[posicionmax])
                posicionmax = i;
            
            if(suma[i] < suma[posicionmin])
                posicionmin = i;
        }
        System.out.printf("el dia %s se vendieros %d entradas, el dia que mas se vendio, el dia %s se vendieron %d entradas, el dia que menos se vendio \n", dias[posicionmax], suma[posicionmax], dias[posicionmin], suma[posicionmin]);
    }
}
