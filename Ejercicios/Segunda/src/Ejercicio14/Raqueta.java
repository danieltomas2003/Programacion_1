package Ejercicio14;

import java.awt.Color;
import java.awt.Graphics;

public class Raqueta extends Bloque{
    public static final int VELX = 10;
    
    public Raqueta(){
        super(120, 270, 60, 10, Color.WHITE);
    }
    public void dibujar(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);        
    }
    
    public void actualizar (int direccion){
        if(direccion==Arkanoid.DERECHA)
            x += VELX;
        else 
            x -= VELX;
        if(x <= 0) x = 0;
        if(x >= 240) x = 240;
    }
}
