package Ejercicio16;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bala extends Rectangle{
    public static final int VELY = 5;
    
    public Bala(int x){
        super(x, 625, 4, 10);
    }
    public void dibujar(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
    public void actualizar(){
        y -= VELY;
    }
}
