package Noveno;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Casilla extends Rectangle{
    public static final int TAM = 100;
    private Image imagen;
    public Image reverso;
    private boolean tapada = true;

    public boolean isTapada() {
        return tapada;
    }
    public void setTapada(boolean tapada) {
        this.tapada = tapada;
    }
    public Image getImagen() {
        return imagen;
    }
    public void setImagen(Image mina) {
        this.imagen = mina;
    }
    public Casilla(int posX, int posY, Image rev, Image img){
        super(posX, posY, TAM, TAM);
        imagen = img;
        reverso = rev;
    }
    public void paint(Graphics g, Applet a){
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        if(tapada)
            g.drawImage(reverso, x, y, width, height, a);
        else
            g.drawImage(imagen, x, y, width, height, a);
    }
}
