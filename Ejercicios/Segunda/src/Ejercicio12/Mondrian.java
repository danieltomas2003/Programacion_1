package Ejercicio12;

import java.applet.Applet;
import java.awt.*;

public class Mondrian extends Applet implements Runnable{
    public static final int ARRIBA = 0;
    public static final int ABAJO = 1;
    public static final int IZQUIERDA = 2;
    public static final int DERECHA = 3;
    
    Thread animacion;
    Image imagen;
    Graphics noseve;
    int posX, posY;
    int direccion;
    
    public void init(){
        posX = 100;
        posY = 80;
        direccion = DERECHA;
        imagen = this.createImage(300, 300); //Estamos instanciando la imagen
        noseve = imagen.getGraphics();
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.black);
        noseve.fillRect(0, 0, 300, 300);
        noseve.setColor(Color.yellow);
        noseve.fillRect(0, 0, 90, 90);
        noseve.fillRect(250, 0, 40, 190);
        noseve.fillRect(80, 160, 100, 120);
        noseve.setColor(Color.blue);
        noseve.fillRect(80, 220, 220, 90);
        noseve.fillRect(100, 10, 90, 80);
        noseve.setColor(Color.lightGray);
        noseve.fillRect(posY, posX, 110, 90);
        noseve.setColor(Color.red);
        noseve.fillRect(200, 0, 45, 45);
        noseve.fillRect(0, 110, 70, 200);
        noseve.setColor(Color.magenta);
        noseve.fillRect(200, 55, 60, 135);
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void run(){
        do{
            actualizar();
            repaint();
            try{
                Thread.sleep(5);
            }catch(InterruptedException e){};
        }while(true);
    }

    public void actualizar() {
        switch(direccion){
            case ARRIBA:
                posY--;
                if(posY <= 30)
                    direccion = DERECHA;
                break;
            case ABAJO:
                posY++;
                if(posY >= 120)
                    direccion = IZQUIERDA;
                break;
            case IZQUIERDA:
                posX--;
                if(posX <= 60)
                    direccion = ARRIBA;
                break;
            case DERECHA:
                posX++;
                if(posX >= 100)
                    direccion = ABAJO;
        }
    }
}
