
package Ejercicio_EX;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Bandera extends Rectangle{
    public static final int TAM = 130;
    private Image imagen;
    private int valor;
    int posicion_Ini_X;
    int posicion_Ini_Y;
    private boolean drageable = true;

    public boolean isDrageable() {
        return drageable;
    }

    public void setDrageable(boolean drageable) {
        this.drageable = drageable;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public Bandera(int posX, int posY, Image img, int v){
        super(posX, posY, TAM, TAM);
        imagen = img;
        valor = v;
    }
    
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, width, height, a);
    }
}
