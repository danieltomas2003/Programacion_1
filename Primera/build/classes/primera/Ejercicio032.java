package primera;
//Pelicula mas y menos taquillera y entradas vendidas en ellas
public class Ejercicio032 
{
    public static void main(String arg[])
    {
        int entradas[][] = {{5, 8, 18, 9, 54, 6, 9}, {1, 5, 9, 2, 5, 1, 9}, {5, 8, 18, 9, 5, 6, 9}, {5, 8, 18, 9, 5, 6, 9}};
        String salas[] = {"James Bond", "Torrente", "Venom", "Spider-man"};
        int posicionmax = 0;
        int posicionmin = 0;
        int suma[] = {0, 0, 0, 0};
        for(int i = 0; i < entradas.length; i++)
                for(int j = 0; j < entradas[i].length; j++)
                    suma[i] += entradas[i][j];        
        for(int i = 0; i < suma.length; i++)
        {
            if(suma[i] > suma[posicionmax])
                posicionmax = i;
            
            if(suma[i] < suma[posicionmin])
                posicionmin = i;
        }
        System.out.printf("La pelicula mas taquillera fue %s vendiendo %d entradas, la pelicula menos taquillera fue %s que vendio %d entradas", salas[posicionmax], suma[posicionmax], salas[posicionmin], suma[posicionmin]);
    }
}
