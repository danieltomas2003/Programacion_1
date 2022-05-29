package Ejercicio14;

import java.awt.*;

public class Ladrillo extends Bloque{
    
    public Ladrillo(int x, int y, int anchura, int altura, Color color){
        super(x, y, anchura, altura, color);
    }
    public void dibujar(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);        
    }
}
