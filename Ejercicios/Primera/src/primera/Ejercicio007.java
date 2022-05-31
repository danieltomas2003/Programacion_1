package primera;
//Mostrar si un numero es multiplo de otro o no
public class Ejercicio007 {
    public static void main(String arg[]){
        int x, y, aux;
        x = 21;
        y = 3;
        if (x < y){
            aux = y;
            y = x;
            x = aux;
        }
        if (x % y == 0)
            System.out.println(x + " es multiplo de " + y);
        else
            System.out.println(x + " no es multiplo de " + y);
    }
}
