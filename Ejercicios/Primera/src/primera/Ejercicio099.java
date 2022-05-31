package primera;
/*
Mostrar por pantalla el trimestre con mas nacimientos
Mes en el que mas bajas se han producido (defuncion o traslados)
Mostrar por pantalla cuantas personas nuevas han venido al pueblo y cuantas se han ido.
*/
public class Ejercicio099 
{
    public static void main(String arg[])
    {
        String movimientos[]={"Nacimientos", "Defunciones", "Traslados fuera", "Traslados dentro"};
        String meses[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        int movPoblacion[][]={{1, 0, 5, 2},{2, 4, 3, 9},{1, 0, 3, 5},{1, 3, 4, 2},{1, 1, 1, 1},{4, 8, 9, 2},{1, 2, 1, 5},{5, 2, 7, 2},{1, 3, 5, 1},{9, 9, 2, 1},{3, 1, 9, 1},{2, 1, 12, 2}};
        suma(movPoblacion);
        bajas(meses, movPoblacion);
        Movimiento(meses, movPoblacion);
        
    }
    public static void suma(int m[][])
    {
        int suma[] = {0, 0, 0, 0};
        int posmax=0;
        int l=0;
        int s=3;
        String tri[]={"El primero", "El segundo", "El tercero", "El cuarto"};
        for(int i=0; i<suma.length;i++)
        {
            for(int j=l; j<s;j++)
            {
                suma[i]+=m[j][0];
                l++;
            }
            s+=3;
        }
        for(int i = 0; i < suma.length; i++)
            if(suma[posmax] < suma[i])
                posmax = i;
        System.out.println("El trimestre con mas nacimientos es: " +tri[posmax]+ " con " +suma[posmax]+ " nacimientos.");
    }
    public static void bajas(String m[], int mo[][])
    {
        int suma[]={0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0 ,0};
        int posmax=0;
        for(int i=0; i<suma.length; i++)
            for(int j=2; j<mo[i].length;j++)
                suma[i]+=mo[i][j];
        for(int i = 0; i < suma.length; i++)
            if(suma[posmax] < suma[i])
                posmax = i;
        System.out.println("El mes con mas bajas es: " +m[posmax]+ " con " + suma[posmax] + " bajas.");
    }
    public static void Movimiento(String m[], int mo[][])
    {
        int suma[]={0, 0};
        for(int i=0; i<suma.length; i++)
            for(int j=0; j<mo.length;j++)
                suma[i]+=mo[j][i+2];
        System.out.println("En este año se han ido "+suma[0]+" personas y han venido "+suma[1]+" personas");
    }
}
