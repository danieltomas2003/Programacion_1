package Ejercicio15;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Columna{
    private Rectangle r1, r2;
    int velx = 1;
    
    public Columna(){
        int altura = (int)(Math.random()*200)+50;
        r1 = new Rectangle(500, 0, 30, altura);
        r2 = new Rectangle(500, altura + 50, 30, 500-(altura+50));
    }

    public void setR1(Rectangle r1) {
        this.r1 = r1;
    }

    public Rectangle getR1() {
        return r1;
    }

    public Rectangle getR2() {
        return r2;
    }

    public void setR2(Rectangle r2) {
        this.r2 = r2;
    }
    
    public void dibujar(Graphics g){
        g.setColor(Color.red);
        g.fillRect(r1.x, r1.y, r1.width, r1.height);
        g.fillRect(r2.x, r2.y, r2.width, r2.height);
    }
    public void actualizar(){
        r1.x -= velx;
        r2.x -= velx;
    }
}
