package primera;
//darle la vuelta a filas y columnas a un tabla 4x4
public class Ejercicio037 {

    public static void main(String arg[]) 
    {
        int tabla[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        int tabla2[][] = new int[4][4];
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                tabla2[i][j] = tabla[j][i];
            }
        }
        for (int i = 0; i < tabla.length; i++) {
            System.out.print("{ ");
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.print(tabla2[i][j] + " ");
            }
            System.out.println("}");
        }
    }
}
