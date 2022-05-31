package Segundo;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Pieza extends Rectangle{
    private boolean colocado = false;
    public boolean isColocado() {
        return colocado;
    }
    
    public void setColocado(boolean colocado) {
        this.colocado = colocado;
    }
    public static final int DIMENSION = 60;
    Image imagen;
    int posicion;
    public Pieza(Image img, int posicion){
        super(((int)((Math.random()*250)+400)), ((int)((Math.random()*600)+100)), DIMENSION, DIMENSION);
        imagen = img;
        this.posicion = posicion;
    }
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, width, height, a);
    }
    public void mover(int posx, int posy){
        if(!isColocado()){
            x = posx-(DIMENSION/2);
            y = posy-(DIMENSION/2);
        }
    }
    public void ajustar(int x, int y){
        this.x = x;
        this.y = y;
    }
}
