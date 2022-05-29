package Ejercicio19;

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
    int tiempoAcum;

    Thread animacion;
    Image imagen;
    Graphics noseve;
    TRex rex;
    List<Obstaculo> obs;
    boolean f = false;
    boolean t = false;
    public void init(){
        resize(700, 500);
        imagen = this.createImage(700, 500);
        noseve = imagen.getGraphics();
        rex = new TRex();
        obs = new ArrayList<Obstaculo>();
        obs.add(new Obstaculo());
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.CYAN);
        noseve.fillRect(0, 0, 700, 500);
        noseve.setColor(Color.GRAY);
        noseve.fillRect(0, 300, 700, 100);
        noseve.setColor(Color.DARK_GRAY);
        noseve.fillRect(0, 400, 700, 100);
        rex.dibujar(noseve);
        noseve.setColor(Color.WHITE);
        noseve.drawString(rex.vidas + " Vidas", 20, 20);
        noseve.setColor(Color.WHITE);
        noseve.drawString(rex.metros + " Metros", 650, 20);
        for (int i = 0; i < obs.size(); i++) {
            obs.get(i).dibujar(noseve);
        }
        noseve.setColor(Color.black);
        if(f) noseve.drawString("Perdiste", 300, 200);
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void run(){
        do{
            tiempoAcum += TIEMPO;
            if(tiempoAcum >= 1000){
                tiempoAcum = 0;
                obs.add(new Obstaculo());
            }
            rex.actualizar();
            for (int i = 0; i < obs.size(); i++) {
                obs.get(i).actualizar();
                if(obs.get(i).x <= -60)
                    obs.remove(i);
            }
            for (int i = 0; i < obs.size(); i++)
                if(rex.intersects(obs.get(i))){
                    rex.vidas--;
                    obs.remove(i);
                    if(rex.vidas==0){
                        f = true;
                        repaint();
                        animacion.stop();
                    }
            }
            repaint();
            try{
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){};
        }while(true);
    }
    public boolean mouseDown(Event ev, int x, int y){
        int vely = 100;
        rex.y -= vely;
        return true;
    }
}
