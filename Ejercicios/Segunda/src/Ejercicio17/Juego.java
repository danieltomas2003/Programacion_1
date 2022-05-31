package Ejercicio17;

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
    int tiempo = 15000;

    Thread animacion;
    Image imagen;
    Graphics noseve;
    List<Camiones> camiones;
    Rana rana;
    int tiempoacum;
    int vidas = 3;
    Rectangle r1;
    Rectangle r2;
    
    boolean f = false;
    boolean s = false;
    boolean t = false;
    
    public void init(){
        resize(700, 500);
        imagen = this.createImage(700, 500);
        noseve = imagen.getGraphics();
        camiones = new ArrayList<Camiones>();
        for (int i = 0; i < 2; i++) {
            camiones.add(new Camiones());
        }
        rana = new Rana();
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.YELLOW);
        noseve.fillRect(0, 0, 700, 500);
        noseve.setColor(Color.darkGray);
        noseve.fillRect(0, 50, 700, 200);
        noseve.setColor(Color.WHITE);
        noseve.fillRect(0, 56, 700, 5);
        noseve.setColor(Color.white);
        noseve.fillRect(0, 250, 700, 10);
        noseve.setColor(Color.darkGray);
        noseve.fillRect(0, 260, 700, 200);
        noseve.setColor(Color.WHITE);
        noseve.fillRect(0, 449, 700, 5);
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 100, 40);
        noseve.setColor(Color.WHITE);
        noseve.drawString(vidas + " Vidas", 20, 20);
        noseve.setColor(Color.BLACK);
        noseve.fillRect(580, 0, 100, 40);
        noseve.setColor(Color.WHITE);
        noseve.drawString(tiempo/1000 + " Tiempo", 600, 20);
        for (int i = 0; i < camiones.size(); i++)
            camiones.get(i).dibujar(noseve);
        rana.dibujar(noseve);
        if(f) noseve.drawString("Game Over", 340, 240);
        if(s) noseve.drawString("You WIN!!!!", 340, 240);
        if(t) noseve.drawString("Se acabo el tiempo!!!", 340, 240);
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void run(){
        do{
            tiempo -= TIEMPO;
            tiempoacum += TIEMPO;
            if(tiempo <= 0){
                t = true;
                    repaint();
                    animacion.stop();
            }
            if(tiempoacum >= 500){
                tiempoacum = 0;
                camiones.add(new Camiones());
            }
            for(int i = 0; i < camiones.size(); i++){
                camiones.get(i).actualizar();
                if((camiones.get(i).x <= -60)||(camiones.get(i).x >= 760))
                    camiones.remove(i);
            }
            for (int i = 0; i < camiones.size(); i++) {
                if(camiones.get(i).intersects(rana)){
                    vidas -= 1;
                    camiones.remove(i);
                    rana.x = 340;
                    rana.y = 470;
                    if(vidas == 0){
                        f = true;
                        repaint();
                        animacion.stop();
                    }
                }
            }
            if(rana.y <= 20){
                s = true;
                    repaint();
                    animacion.stop();
            }
            repaint();
            try{
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){};
        }while(true);
    }
    
    public boolean keyDown(Event ev, int tecla){
        switch(tecla){
            case 1004: rana.actualizar(rana.ARRIBA); break;
            case 1005: rana.actualizar(rana.ABAJO); break;
            case 1006: rana.actualizar(rana.IZQUIERDA); break;
            case 1007: rana.actualizar(rana.DERECHA); break;
        }
        return true;
    }
}
