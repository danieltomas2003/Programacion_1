package primera;
//Operadores == <=: menor o igual, >=:mayor o igual, ==: igual, !=:distinto, !: distinto
public class Ejercicio003 {
    public static void main(String arg[]){
        int x = 75;
        int y = 105;
        if(x == y)
            System.out.println("x e y son iguales y su valor es " + x);
        else if(x > y)
                System.out.println("el mayor es: " + x);
            else
                System.out.println("el mayor es: " + y);
    }
}
