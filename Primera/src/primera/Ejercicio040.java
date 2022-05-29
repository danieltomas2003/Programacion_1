package primera;

public class Ejercicio040 
{
    public static void main(String arg[]) 
    {
        int goles[][] = {{11, 21, 31, 33, 11}, {13, 26, 17, 18, 22}, {19, 30, 21, 12, 23}, {23, 14, 35, 16, 10}};
        String futbolistas[] = {"Messi", "Grizman", "Neymar", "Suarez", "Ronaldo"};
        double suma = 0;
        for(int i = 0; i < futbolistas.length; i++)
        {
            for(int j = 0; j < goles.length; j++)
                suma += goles[j][i];
            System.out.printf("%s ha metido una media de %.2f goles por temporada. \n", futbolistas[i], suma/goles.length);
            suma = 0;
        }   
    }
}