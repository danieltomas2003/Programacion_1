package Ejercicio12;

import java.applet.Applet;
import java.awt.*;

public class Mondrian2 extends Applet implements Runnable{
    
    
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Rectangulo rectangulos[];
    int posX[] = {0, 0, 250, 80, 80, 100, 200, 0, 200}; 
    int posY[] = {0, 0, 0, 160, 220, 10, 0, 110, 55};
    int anchuras[] = {300, 90, 190, 120, 90, 80, 45, 200, 135};
    int alturas[] = {300, 90, 40, 100, 220, 90, 45, 70, 60};
    Color colores[] = {Color.BLACK, Color.yellow, Color.yellow, Color.YELLOW, Color.BLUE, Color.BLUE, Color.RED, Color.RED, Color.MAGENTA};
    public void init(){
        imagen = this.createImage(300, 300);
        noseve = imagen.getGraphics();
        rectangulos = new Rectangulo[9];
        for (int i = 0; i < rectangulos.length; i++) {
            rectangulos[i] = new Rectangulo(posX[i], posY[i], anchuras[i], alturas[i], colores[i]);
        }
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
        noseve.fillRect(0, 0, 300, 300);
        for (int i = 0; i < rectangulos.length; i++) {
            rectangulos[i].dibujar(g);
        }
    }
    
    public void run(){
        do{
            for (int i = 0; i < rectangulos.length; i++) 
                rectangulos[i].actualizar();
            repaint();
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){};
        }while(true);
    }
}
