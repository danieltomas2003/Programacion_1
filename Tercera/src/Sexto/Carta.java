package Sexto;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Carta{
    Image imagen;
    int valor;
    private int posx;
    private int posy;
    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }
    public Carta(Image img, int v){
        imagen = img;
        valor = (v > 10)?10:v;
    }
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, getPosx(), getPosy(), 50, 70, a);
    }
}
