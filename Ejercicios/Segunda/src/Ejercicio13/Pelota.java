package Ejercicio13;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pelota extends Rectangle{
    Color color;
    Color colores[] = {Color.ORANGE, Color.green, Color.magenta, Color.red, Color.white, Color.cyan, Color.blue,Color.orange, Color.pink, Color.lightGray};
    int velx, vely;
    
    public Pelota(){
        super((int)(Math.random()*250), (int)(Math.random()*250), 0, 0);
        int diametro = (int)(Math.random()*25)+20;
        width = height = diametro;
        color = colores[(int)(Math.random()*colores.length)];
        velx = (int)(Math.random()*5)+1;
        vely = (int)(Math.random()*5)+1;
    }
    
    public void dibujar(Graphics g){
        g.setColor(color);
        g.fillOval(x, y, width, height);
    }
    
    public void actualizar(){
        x += velx;
        y += vely;
        if((x<0)||(x>300-width))
            velx *= -1;
        if((y<0)||(y>300-height))
            vely *= -1;
    }
}
