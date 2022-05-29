package Ejercicio15;

import java.applet.Applet;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Event;
import java.util.List;
import java.util.ArrayList;

public class Flappy extends Applet implements Runnable{
    public static final int TIEMPO = 30;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Pajaro pajaro;
    List<Columna> columnas;
    int tiempoAcumulado = 0;
    boolean fin;
    
    public void init(){
        resize(500, 300);
        imagen = this.createImage(500, 300);
        noseve = imagen.getGraphics();
        pajaro = new Pajaro();
        columnas = new ArrayList<Columna>();
        columnas.add(new Columna());
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
        noseve.fillRect(0, 0, 500, 500);
        pajaro.dibujar(noseve);
        for (int i = 0; i < columnas.size(); i++) {
            columnas.get(i).dibujar(noseve);
        }
        if(fin) noseve.drawString("Game Over", 200, 200);
        g.drawImage(imagen, 0, 0, this);
        
        
    }
    
    public void run(){
        do{
            tiempoAcumulado += TIEMPO;
            if(tiempoAcumulado >= 5000){
                tiempoAcumulado = 0;
                columnas.add(new Columna());
            }
            pajaro.actualizar();
            for (int i = 0; i < columnas.size(); i++)
                columnas.get(i).actualizar();
            if(columnas.get(0).getR1().x <= -30)
                columnas.remove(0);
            if((pajaro.intersects(columnas.get(0).getR1()))||(pajaro.intersects(columnas.get(0).getR2()))){
                fin = true;
                animacion.stop();
            }
                
            repaint();
            try{
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){};
        }while(true);
    }
    
    public boolean mouseDown(Event ev, int x, int y){
        if(pajaro.y > 0)
            pajaro.y -= 30;
        return true;
    }
}
