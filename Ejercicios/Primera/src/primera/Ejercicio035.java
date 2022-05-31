package primera;
//Alumnos que han sacado 10 y en que
public class Ejercicio035 
{
    public static void main(String arg[])
    {
    int notas[][] = {{7, 9, 3, 8}, {10, 9, 9, 8}, {9, 10, 7, 1}, {3, 10, 5, 6}, {8, 5, 4, 5}};
        String alumnos[] = {"Jose Bueno", "Marta Diaz", "Marcos Barcelona", "Hector Miranda", "Diego Muñoz"};
        String asignaturas[] = {"Programacion", "lenguaje de marcas", "base de datos", "sistemas"};
        for(int i = 0; i < alumnos.length; i++)
            for(int j = 0; j < asignaturas.length; j++)
                if(notas[i][j] == 10)
                    System.out.printf("%s en %s \n", alumnos[i], asignaturas[j]);
    }
}
