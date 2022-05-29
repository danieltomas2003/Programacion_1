package Ejercicio01;

public class Persona 
{
    public String nombre;
    public String apellidos;
    public double altura;
    public double peso;
    
    public Persona()
    {
        nombre="Pepe";
        apellidos="López";
        altura=1.76;
        peso=89;
    }
    public Persona(String nom, String ape)
    {
        nombre = nom;
        apellidos=ape;
        altura=1.76;
        peso=89;
    }
    public Persona(String nom, String ape, double altura, double peso)
    {
        this.nombre = nom;
        this.apellidos=ape;
        this.altura= altura;
        this.peso= peso;
    }
    public void mostrar()
    {
        System.out.println(nombre +" "+ apellidos +" ("+ altura +") - ("+ peso + ")");
    }
}
