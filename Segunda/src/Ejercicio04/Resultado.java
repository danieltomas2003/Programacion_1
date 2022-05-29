package Ejercicio04;

public class Resultado {
    public static void main(String[] args) {
        Bombo bombo= new Bombo();
        int resultado[][]= new int[6][8];
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                resultado[i][j]=bombo.sacar();
            }
        }
        for (int i = 0; i < resultado.length; i++) {
            for (int j = 0; j < resultado[i].length; j++) {
                System.out.print(resultado[i][j]+" ");
            }
            System.out.println();
        }
    }
}