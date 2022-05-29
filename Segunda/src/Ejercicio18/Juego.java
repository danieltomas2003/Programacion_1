package Ejercicio18;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Juego extends Applet implements Runnable{
    public static final int TIEMPO = 30;
    public static final int ARRIBA = 1;
    public static final int ABAJO = 2;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Raqueta raqueta1;
    Raqueta raqueta2;
    Pelota pelota;
    int marcador1=0;
    int marcador2=0;
    boolean f1=false;
    boolean f2=false;
    public void init(){
        resize(700, 500);
        imagen = this.createImage(700, 500);
        noseve = imagen.getGraphics();
        raqueta1 = new Raqueta(20);
        raqueta2 = new Raqueta(660);
        pelota = new Pelota();
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 700, 500);
        noseve.setColor(Color.WHITE);
        noseve.fillRect(347, 50, 5, 450);
        noseve.drawOval(-100, 170, 200, 200);
        noseve.drawOval(275, 185, 150, 150);
        noseve.drawOval(600, 170, 200, 200);
        noseve.fillRect(0, 40, 700, 10);
        noseve.fillRect(0, 0, 100, 50);
        noseve.setColor(Color.BLACK);
        noseve.drawString("Jugador 1", 20, 15);
        noseve.drawString(marcador1 + " Puntos", 20, 30);
        noseve.setColor(Color.WHITE);
        noseve.fillRect(600, 0, 100, 50);
        noseve.setColor(Color.BLACK);
        noseve.drawString("Jugador 2", 620, 15);
        noseve.drawString(marcador2 + " Puntos", 620, 30);
        raqueta1.dibujar(noseve);
        raqueta2.dibujar(noseve);
        pelota.dibujar(noseve);
        if(f1)noseve.drawString("Ha ganado el jugador 1", 300, 20);
        if(f2)noseve.drawString("Ha ganado el jugador 2", 300, 20);
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void run(){
        do{
            if(pelota.x<=0){
                pelota.x = 195;
                pelota.y = 445;
                pelota.velx = 3;
                marcador2 += 1;
            }if(pelota.x>=700-pelota.width){
                pelota.x = 195;
                pelota.y = 445;
                pelota.velx = -3;
                marcador1 += 1;
            }
            if((marcador1==5)){
                f1=true;
                repaint();
                animacion.stop();
            }
            if((marcador2==5)){
                f2=true;
                repaint();
                animacion.stop();
            }
            if((pelota.intersects(raqueta1))||(pelota.intersects(raqueta2))){
                pelota.velx *= -1;
                if(pelota.velx<0)
                    pelota.velx -= 1;
                else
                    pelota.velx += 1;
            }
            pelota.actualizar();
            repaint();
            try{
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){};
        }while(true);
    }
    public boolean keyDown(Event ev, int tecla){
        if(tecla == 119) raqueta1.actualizar(ARRIBA);
        if(tecla == 115) raqueta1.actualizar(ABAJO);
        if(tecla == 1004) raqueta2.actualizar(ARRIBA);
        if(tecla == 1005) raqueta2.actualizar(ABAJO);
        return true;
    }
}
