package Ejercicio03;

public class EjecutableNif 
{
    public static void main(String[] args)throws Exception{
        //try sirve para tratar errores o excepciones
        Nif persona1;
        Nif persona2;
        try{
            int a = 7/0;
            System.out.println("No llega");
        }catch(ArithmeticException ex){
            System.out.println("Has dividido por cero");
        }
        System.out.println("Continua la ejecucion");
        
        persona1 = new Nif(73444660, 'W');
        persona2 = new Nif(22222222);
        
        persona1.mostrar();
        persona2.mostrar();
    }
}
