package primera;
//Mayor de tres numeros
public class Ejercicio004 {
    public static void main(String arg[]){
        int x, y, z;
        x = 72;
        y = 24;
        z = 84;
        if(x > y)
            if(x > z)
                System.out.println("El mayor es: " + x); 
            else
                System.out.println("El mayor es: " + z); 
        else 
            if(y > z)
                System.out.println("El mayor es: " + y);
            else
                System.out.println("El mayor es: " + z);
    }     
}
