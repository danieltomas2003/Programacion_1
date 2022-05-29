package Ejercicio01;

public class Programa 
{
    public static void main(String[] args) {
        Persona persona1, persona2, persona3;
        
        persona1 = new Persona();
        persona2 = new Persona("Maria", "Dueñas");
        persona3 = new Persona("Camilo Jose", "Cela", 1.70, 120);
        
        persona1.mostrar();
        persona2.mostrar();
        persona3.mostrar();
        
    }   
}
