package Ejercicio2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Gotas extends Rectangle{
    public static final int VELY=5;
    public Gotas(){
        super((int)(Math.random()*490)+5,-20,10,20);
    }
    public void dibujar(Graphics g){
        g.setColor(Color.CYAN);
        g.fillOval(x, y, width, height);
    }
    public void actualizar(){
        y+=VELY;
    }
}
