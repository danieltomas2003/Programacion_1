package Ejercicio20;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Circulo extends Rectangle{
    int velx, vely;
    Color colores[] = {Color.ORANGE, Color.green, Color.magenta, Color.red, Color.white, Color.cyan, Color.blue,Color.orange, Color.pink, Color.lightGray};
    Color color;
    public Circulo(int x, int y, int radio){
        super(x, y, radio, radio);
        color = colores[(int)(Math.random()*colores.length)];
        velx = (int)(Math.random()*6)-3;
        vely = (int)(Math.random()*6)-3;
    }
    public void dibujar(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
    
    public void actualizar(){
        x += velx;
        y += vely;
        if((x<0)||(x>700-width))
            velx *= -1;
        if((y<0)||(y>700-height))
            vely *= -1;
            
    }
}
