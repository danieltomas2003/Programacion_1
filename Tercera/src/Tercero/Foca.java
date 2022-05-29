package Tercero;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Foca extends Rectangle{
    Image imagen;
    int ataque = ((int)(Math.random()*4)+1);
    int vida = (int)(2*ataque);
    int totalVida = vida;
    int vely = ((int)(((Math.random()*5)+2)/ataque)+1);
    boolean explosion = false;
    int contMuerte = 0;
    
    public Foca(Image img){
        super(((int)(Math.random()*1000)), 0, 110, 110);
        imagen = img;
        y = 1000;
        width += 30*ataque;
        height += 30*ataque;
    }
    public void paint(Graphics g, Applet a){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y+width-10, width, 30);
        if(vida>=totalVida*0.7){
            g.setColor(Color.GREEN);
            g.fillRect(x, y+width-10, vida*width/totalVida, 30);
        }
        if((vida>totalVida*0.30)&&(vida<totalVida*0.7)){
            g.setColor(Color.ORANGE);
            g.fillRect(x, y+width-10, vida*width/totalVida, 30);
        }
        if(vida<=totalVida*0.30){
            g.setColor(Color.RED);
            g.fillRect(x, y+width-10, vida*width/totalVida, 30);
        }
        g.setColor(Color.WHITE);
        g.drawRect(x, y+width-10, width, 30);
        g.drawString(ataque + " Ataque", x+width/2-60, y+height+10);
        g.drawString(vida + " Vida", x+width/2+10, y+height+10);
        g.drawImage(imagen, x, y, width, height, a);
    }
    public void actualizar(){
        if(!explosion)
            y-=vely;
    }
    public void explota(Image img, int t){
        imagen = img;
        contMuerte += t;
        explosion = true;
    }
}
