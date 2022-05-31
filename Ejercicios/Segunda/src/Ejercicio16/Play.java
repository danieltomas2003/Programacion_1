package Ejercicio16;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Play extends Applet implements Runnable{

    public static final int TIEMPO = 30;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Gun pistoleta;
    List<Bala> balas;
    List<Nave> naves;
    int tiempoAcum = 0;
    boolean fin = false;
    public void init(){
        resize(400, 700);
        imagen = this.createImage(400, 700);
        noseve = imagen.getGraphics();
        pistoleta = new Gun();
        balas = new ArrayList<Bala>();
        naves = new ArrayList<Nave>();
        naves.add(new Nave());
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start();
        
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.cyan);
        noseve.fillRect(0, 0, 400, 700);
        pistoleta.dibujar(noseve);
        for (int i = 0; i < balas.size(); i++) {
            balas.get(i).dibujar(noseve);
        }
        for (int i = 0; i < naves.size(); i++) {
            naves.get(i).dibujar(noseve);
        }
        if(fin) noseve.drawString("Game Over", 200, 350);
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void run(){
        do{
            tiempoAcum += TIEMPO;
            if(tiempoAcum >= 3000){
                tiempoAcum = 0;
                naves.add(new Nave());
            }
            for (int i = 0; i < naves.size(); i++) {
                naves.get(i).actualizar();
                if((naves.get(i).y >= 700)||(naves.get(i).intersects(pistoleta))){
                    fin = true;
                    repaint();
                    animacion.stop();
                }
            }
            for (int i = 0; i < balas.size(); i++) {
                balas.get(i).actualizar();
                if(balas.size() > 0)
                if((balas.get(i).y <= 0)){
                    balas.remove(0);
                }
            }
            for (int i = 0; i < balas.size(); i++) {
                for (int j = 0; j < naves.size(); j++) {
                    if(balas.get(i).intersects(naves.get(j))){
                        balas.remove(i);
                        naves.remove(j);
                        break;
                    }
                }
            }
            repaint();
            try{
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){};
        }while(true);
    }
    public boolean mouseMove(Event ev, int posx, int posy){
        pistoleta.actualizar(posx);
        return true;
    }
    public boolean mouseDown(Event ev, int posx, int posy){
        balas.add(new Bala(pistoleta.x+3));
        for (int i = 0; i < balas.size(); i++)
            balas.get(i).actualizar();
        return true;
    }
}
