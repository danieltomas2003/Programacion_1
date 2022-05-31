package Tercero;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Boss extends Rectangle{
    int velx, vely;
    Image imagen;
    int vida;
    int totalVida;
    int tamañoBarra;
    public Boss(int radio, Image img){
        super(-1000, 20, radio, radio);
        imagen =  img;
        velx = (int)(Math.random())+1;
        vely = (int)(Math.random()*2)-2;
        vida = 100;
        totalVida = vida;
        tamañoBarra = 300;
    }
    public Boss(int x, int y, int radio, Image img, int vid, int tamaño){
        super(x, y, radio, radio);
        imagen =  img;
        velx = (int)(Math.random())+1;
        vely = (int)(Math.random()*2)-2;
        vida = vid;
        totalVida = vida;
        tamañoBarra = tamaño;
    }
    public void dibujar(Graphics g, Applet a){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y+width-10, tamañoBarra, 30);
        if(vida>=totalVida*0.7){
            g.setColor(Color.GREEN);
            g.fillRect(x, y+width-10, vida*tamañoBarra/totalVida, 30);
        }
        if((vida>totalVida*0.30)&&(vida<totalVida*0.7)){
            g.setColor(Color.ORANGE);
            g.fillRect(x, y+width-10, vida*tamañoBarra/totalVida, 30);
        }
        if(vida<=totalVida*0.30){
            g.setColor(Color.RED);
            g.fillRect(x, y+width-10, vida*tamañoBarra/totalVida, 30);
        }
        g.setColor(Color.WHITE);
        g.drawString(vida + " Vida", x+tamañoBarra/2-30, y+height+10);
        g.drawImage(imagen, x, y, width, height, a);
    }
    
    public void actualizar(){
        x += velx;
        y += vely;

        if((y<0)||(y>950-height))
            vely *= -1;
            
    }
}
