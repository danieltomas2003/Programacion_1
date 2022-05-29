package Ejercicio18;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Pelota extends Rectangle{
    int velx, vely;
    
    public Pelota(){
        super(195, 445, 9, 9);
        velx = 3;
        vely = 2;
    }
    
    public void dibujar(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
    }
    
    public void actualizar(){
        x += velx;
        y += vely;
        if((x<0)||(x>700-width))
            velx *= -1;
        if((y<50)||(y>500-height))
            vely *= -1;
            
    }
    
}
