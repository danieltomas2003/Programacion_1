package Tercero;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Bala extends Rectangle{
    int velx = 0;
    Image imagen;
    int tipo;
    public Bala(int y, Image img, int tipo){
        super(1450, y, 0, 0);
        imagen = img;
        this.tipo=tipo;
        if(this.tipo==0){
            width = 60;
            height = 43;
            velx = 6;
        }else if(this.tipo == 1){
            width = 14;
            height = 8;
            velx = 10;
        }else if(this.tipo == 2){
            width = 20;
            height = 15;
            velx = 20;
        }
    }
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, width, height, a);
    }
    public void actualizar(){
        x -= velx;
    }
}