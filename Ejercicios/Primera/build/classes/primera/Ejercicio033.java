package primera;
//Estreno de la pelicula mas y menos con el dia y numero de ventas
public class Ejercicio033 
{
    public static void main(String arg[])
    {
        int entradas[][] = {{5, 8, 18, 9, 54, 6, 9}, {2, 5, 9, 3, 5, 2, 9}, {5, 8, 18, 9, 5, 6, 9}, {5, 8, 18, 9, 5, 6, 9}};
        String salas[] = {"James Bond", "Torrente", "Venom", "Spider-man"};
        String dias[] = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
        int posicionmax = 0;
        int posicionmin = 0;
        int salamax = 0;
        int salamin = 0;
        for(int i = 0; i < entradas.length; i++)
            for(int j = 0; j < entradas[i].length; j++)
        {
            if(entradas[i][j] > entradas[salamax][posicionmax])
            {
                salamax = i;
                posicionmax = j;
            }
            if(entradas[i][j] < entradas[salamin][posicionmin])
            {
                salamin = i;
                posicionmin = j;
            }
        }
        System.out.printf("El %s con el estreno de %s se vendieron %d entradas, el dia de mayores ventas \n", dias[posicionmax], salas[salamax], entradas[salamax][posicionmax]);
        System.out.printf("El %s con el estreno de %s se vendieron %d entradas, el dia de menores ventas \n", dias[posicionmin], salas[salamin], entradas[salamin][posicionmin]);
    }
       
}
