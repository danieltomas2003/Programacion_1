package Ejercicio02;

public class SobreAnimales 
{
    public static void main(String[] args) {
        Perro p1;
        Canguro c1;
        
        p1= new Perro(10, "10/03/2020", "Toby", true, "Terrier", true);
        c1 = new Canguro(15, "11/06/2020", "Tob", true, "Terrier", false);
        
        p1.mostrar();
        
        System.out.println("Hola me llamo " + p1.getNombre() + " y soy un " + p1.getRaza());
        p1.setRaza("Pastor Aleman");
        System.out.println("No, soy un " + p1.getRaza());
    }
}
