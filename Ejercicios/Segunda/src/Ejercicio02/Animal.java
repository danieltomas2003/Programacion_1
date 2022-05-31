package Ejercicio02;

abstract class Animal 
{
    int id;
    String nacimiento;
    private String nombre; //private "x" atributo encapsulado
    boolean vacunado;
    
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nom){
        nombre = nom;
    }
    
    public Animal(int id, String nac, String nombr, boolean vacuna)
    {
        this.id = id;
        nacimiento=nac;
        nombre = nombr;
        vacunado = vacuna;
    }
    //Las subclases de la clase animal al declarar un metodo como abstracto estan obligadas a implementar este metodo como abstracto
    abstract void mostrar();
        
}
