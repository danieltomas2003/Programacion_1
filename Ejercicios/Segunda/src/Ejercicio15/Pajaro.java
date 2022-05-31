package Ejercicio15;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Pajaro extends Rectangle{
    int vely;
    
    public Pajaro(){
        super(20, 20, 15, 15);
        vely = 3;
    }
    
    public void dibujar(Graphics g){
        g.setColor(Color.blue);
        g.fillOval(x, y, width, height);
    }
    public void actualizar(){
        if(y >= 285)
            y += 0;
        else
            y += vely;
    }
}
