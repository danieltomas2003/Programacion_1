package Ejercicio03;

public class Nif {
    public int dni;
    public char letra;
    public static char tabla[]={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
    
    public Nif(int dni, char letra) throws Exception{
        this.dni=dni;
        if(tabla[dni%23]!=letra)
            throw new Exception("El dni es incorrecto");
        this.letra=tabla[dni%23];
    }
    public Nif(int dni) throws Exception{
        this(dni, tabla[dni%23]);
    }
    public void mostrar()
    {
        System.out.printf("%d-%c", this.dni, this.letra);
    }
}
