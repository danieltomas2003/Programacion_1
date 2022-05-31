package Septimo;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class MazoPalo extends Rectangle implements Mazo{
    public MazoPalo(int posX){
        super(posX, MazoSecundario.POSICIONY, Carta.ANCHURA, Carta.ALTURA);
    }
    public void paint(Graphics g, Applet a){
        g.drawRect(x, y, width, height);
        for (int i = 0; i < cartas.size(); i++) {
            cartas.get(i).paint(g, a);
        }
    }
    public boolean añadir(Carta c){
        if((cartas.isEmpty())&&(c.getValor() == 1)){
            recolocar();
            cartas.add(c);
            return true;
        }
        else if((!cartas.isEmpty())&&(c.getValor()==cartas.get(cartas.size()-1).getValor()+1)&&(c.getPalo()==cartas.get(0).getPalo())){
            recolocar();
            cartas.add(c);
            return true;
        }
        return false;
    }
    public void recolocar(){
        cartas.get(cartas.size()-1).x = this.x;
        cartas.get(cartas.size()-1).y = this.y;
    }
    public Carta extraer(){
        return cartas.get(cartas.size()-1);
    }
    public void eliminar(){
        cartas.remove(cartas.size()-1);
    }
}
