package primera;
//Alumno con mejores y peores notas y media
public class Ejercicio034 
{
    public static void main(String arg[])
    {
        int notas[][] = {{7, 9, 3, 8}, {10, 9, 9, 8}, {9, 10, 7, 1}, {3, 10, 5, 6}, {8, 5, 4, 5}};
        String alumnos[] = {"Jose Bueno", "Marta Diaz", "Marcos Barcelona", "Hector Miranda", "Diego Muñoz"};
        String asignaturas[] = {"Programacion", "lenguaje de marcas", "base de datos", "sistemas"};
        double suma[] = {0, 0, 0, 0, 0};
        int entrmin = 0;
        int entrmax = 0;
        int posicionmax = 0;
        int posicionmin = 0;

        for(int i = 0; i < notas.length; i++)
            for(int j = 0; j < notas[i].length; j++)
                suma[i] += notas[i][j];

        for(int i = 0; i < suma.length; i++)
        {
            if(suma[i] > suma[posicionmax])
                posicionmax = i;

            if(suma[i] < suma[posicionmin])
                posicionmin = i;
        }
        System.out.printf("%s es el alumno con mejores notas y tiene una media de %.2f \n", alumnos[posicionmax], suma[posicionmax]/4);
        System.out.printf("%s es el alumno con mejores notas y tiene una media de %.2f \n", alumnos[posicionmin], suma[posicionmin]/4);
        System.out.println();
        posicionmax = 0;
        posicionmin = 0;
        double vasignotas[] = {0, 0, 0, 0};
        for(int i = 0; i < alumnos.length; i++)
            for(int j = 0; j < asignaturas.length; j++)
                vasignotas[j] += notas[i][j];
        for(int i = 0; i < vasignotas.length; i++)
        {
            if(vasignotas[i] > vasignotas[posicionmax])
                posicionmax = i;

            if(vasignotas[i] < vasignotas[posicionmin])
                posicionmin = i;
        }    
        System.out.printf("La mejor media es de %s con %.2f de media. La peor es %s con %.2f \n",asignaturas[posicionmax], vasignotas[posicionmax]/5, asignaturas[posicionmin], vasignotas[posicionmin]/5);
    }
}
