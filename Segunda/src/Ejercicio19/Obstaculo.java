package Ejercicio19;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Obstaculo extends Rectangle{
    int velx = 20;
    public Obstaculo(){
        super(760, 0, (int)((Math.random()*20)+10), (int)((Math.random()*40)+10));
        y = 300 - height;
    }
    public void dibujar(Graphics g){
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
    public void actualizar(){
        x -= velx;
    }
}
