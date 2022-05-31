package Ejercicio1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Objetos extends Rectangle{
    Color colores[]={Color.BLUE, Color.CYAN, Color.GREEN, Color.MAGENTA, Color.YELLOW, Color.RED, Color.PINK, Color.ORANGE, Color.LIGHT_GRAY, Color.WHITE};
    Color color = colores[(int)(Math.random()*colores.length)];
    int num = ((int)(Math.random()*2)+1);
    int num2 = ((int)(Math.random()*2)+1);
    int velx;
    int vely;
    public Objetos(){
        super(((int)(Math.random()*500)+50),((int)(Math.random()*500)+50),((int)(Math.random()*80)+30), 0);
        velx=((int)(Math.random()*20)-10);
        vely=((int)(Math.random()*20)-10);
        switch(num){
            case 1:height=((int)(Math.random()*80)+30); break;
            case 2:height=width;
        }
    }
    public void dibujar(Graphics g){
        g.setColor(color);
        switch(num2){
            case 1: g.fillOval(x, y, width, height); break;
            case 2: g.fillRect(x, y, width, height);
        }
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
