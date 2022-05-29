package Ejercicio18;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Raqueta extends Rectangle{
    public static final int VELY = 10;
 
    public Raqueta(int posx){
        super(posx, 240, 10, 60);
    }
    public void dibujar(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);        
    }
    
    public void actualizar (int direccion){
        if(direccion==Juego.ARRIBA)
            y -= VELY;
        else if(direccion==Juego.ABAJO)
            y += VELY;
        if(y <= 50) y = 50;
        if(y >= 440) y = 440;
    }
}