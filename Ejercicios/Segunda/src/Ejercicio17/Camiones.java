package Ejercicio17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Camiones extends Rectangle{
    int velx;
    int vely;
    Color colores[] = {Color.BLUE, Color.cyan, Color.PINK, Color.red, Color.YELLOW, Color.orange, Color.magenta};
    Color color = colores[(int)(Math.random()*colores.length)];
    public Camiones(){
        super(0, 0, 40, 20);
        velx = (Math.random() >= .5)?velx=(int)(Math.random()*4)+2:-((int)(Math.random()*4)+2);
        vely = (int)(Math.random()*5) - 2;
        /*if(Math.random() >= .5){
            velx=(int)(Math.random()*4)+2;
        }else{
            velx = -((int)(Math.random()*4)+2);
        }*/
        x = (velx>0)?-50:750;
        y = (velx>0)?((int)(Math.random()*140)+55):((int)(Math.random()*140)+265);
    }
    public void dibujar(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);        
    }
    
    public void actualizar(){
        x += velx;
        y += vely;
        if(vely>0){
            if((y >= 195)||(y <= 55))
                vely *= -1;
        }else
            if((y >= 395)||(y <= 265))
                vely *= -1;
    }
}
