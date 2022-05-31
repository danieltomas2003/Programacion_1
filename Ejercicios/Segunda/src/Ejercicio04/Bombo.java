package Ejercicio04;
import java.util.Random;
public class Bombo {
    public int bolas[];
    Random aleatorio;
    private int numBolas=48;
    
    public Bombo(){
        bolas = new int[numBolas];
        for(int i=0; i<numBolas; i++)
            bolas[i]=1+i;
        aleatorio=new Random();
    }
    
    public int sacar()
    {
        int aux;
        int x = aleatorio.nextInt(numBolas);
        aux=bolas[x];
        bolas[x]=bolas[numBolas-1];
        numBolas--;
        return aux;
    }
}
