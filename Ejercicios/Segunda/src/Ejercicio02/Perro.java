package Ejercicio02;

public class Perro extends Animal
{
    private String raza;
    boolean peligrosidad;
    
    public Perro(int id, String fn, String nom, boolean v, String raza, boolean p)
    {
        super(id, fn, nom, v);
        this.raza=raza;
        peligrosidad=p;
    }
    public String getRaza(){
        return raza;
    }
    public void setRaza(String r){
        raza = r;
    }
    public void mostrar()
    {
        if(peligrosidad)
            System.out.printf("Soy %s y soy de la raza %s y soy peligrosismo\n", getNombre(), raza);
        else
            System.out.printf("Soy %s y soy de la raza %s y no soy nah peligrocho\n", getNombre(), raza);
    }
}
