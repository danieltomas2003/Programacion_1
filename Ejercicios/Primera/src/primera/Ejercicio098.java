package primera;
//Ley d´hondt
public class Ejercicio098 
{
    public static void main(String arg[])
    {
        int votos[]={119909, 47001, 92353, 158326, 52353};
        int cont[]={0, 0, 0, 0, 0};
        String partidos[]={"Pperos", "Potemos", "Ni VOX ni voto", "PedroE", "ciu_ya_nah"};
        int cocientes[]={1, 1, 1, 1, 1}; 
        int Escaños = 7;
        int posicionmax=0;
        for(int j=Escaños; j>0; j--)
        {
            for(int i = 0; i < votos.length; i++)
                if(votos[posicionmax]/cocientes[posicionmax] < votos[i]/cocientes[i])
                    posicionmax = i;
            cocientes[posicionmax]++;
            cont[posicionmax]++;
        }
        for(int i = 0; i < partidos.length; i++)
            System.out.println("El partido " + partidos[i] + " ha sacado " + cont[i] + " escaños.");
    }
}