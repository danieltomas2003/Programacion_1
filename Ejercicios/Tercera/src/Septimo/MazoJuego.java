package Septimo;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public class MazoJuego extends Rectangle implements Mazo{
    public static final int POSICIONY = 200;
    public MazoJuego(int posx){
        super(posx, POSICIONY, Carta.ANCHURA, Carta.ALTURA);
    }
    public boolean añadir(Carta c){
        if(cartas.isEmpty()){
            cartas.add(c);
            recolocar();
            return true;
        }else if((!cartas.isEmpty())&&(c.intersects(cartas.get(cartas.size()-1)))&&(c.getValor()==cartas.get(cartas.size()-1).getValor()-1)&&(c.getColor()!=cartas.get(cartas.size()-1).getColor())){
            cartas.add(c);
            recolocar();
            System.out.println(cartas.size());
            return true;
        }
        return false;
    }
    public void paint(Graphics g, Applet a){
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        for (int i = 0; i < cartas.size(); i++) {
            cartas.get(i).paint(g, a);
        }
    }
    public void recolocar(){
        cartas.get(cartas.size()-1).x=this.x;
        cartas.get(cartas.size()-1).y=this.y;
    }
    public Carta extraer(){
        return cartas.get(cartas.size()-1);
    }
    public void eliminar(){
        cartas.remove(cartas.size()-1);
    }
}
