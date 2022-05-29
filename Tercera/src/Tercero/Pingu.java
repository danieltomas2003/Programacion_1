package Tercero;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Pingu{
    public static final int VELY = 10;
    public static final int X = 1450;
    int y;
    Image imagen;
    int numVidas = 10;
    public Pingu(Image img){
        imagen = img;
        y = 300;
    }
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, X, y, 135, 165, a);
    }
    public void actualizar(int direccion){
        y=direccion-68;
        if(y <= 0) y = 0;
        if(y >= 815) y = 815;
    }
}
