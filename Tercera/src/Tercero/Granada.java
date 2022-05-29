package Tercero;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Granada extends Rectangle{
    int velx, vely;
    Image imagen;
    public Granada(int x, int y, Image img){
        super(x, y, 50, 50);
        imagen = img;
    }
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, width, height, a);
    }
    public void actualizar(){
        
    }
}
