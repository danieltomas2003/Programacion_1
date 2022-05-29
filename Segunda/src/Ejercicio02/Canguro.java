package Ejercicio02;

public class Canguro extends Animal
{
    String raza;
    boolean sexo;

    public Canguro(int id, String fn, String nom, boolean v, String raza, boolean p)
    {
        super(id, fn, nom, v);
        this.raza=raza;
        sexo=p;
    }
    public void mostrar()
    {
        System.out.printf("Soy %s y soy de la raza %s \n", getNombre(), raza);
    }
}
