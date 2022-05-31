package Ejercicio1;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 extends Applet implements Runnable{
    public static final int TIEMPO = 30;
    int tiempoAcum;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    List<Objetos> objetos;
    int velx2, vely2;
    public void init(){
        resize(700, 700);
        imagen = this.createImage(700, 700);
        noseve = imagen.getGraphics();
        objetos = new ArrayList<Objetos>();
        for (int i = 0; i < 10; i++) {
            objetos.add(new Objetos());
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
        noseve.fillRect(0, 0, 700, 700);
        for (int i = 0; i < objetos.size(); i++) {
            objetos.get(i).dibujar(noseve);
        }
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void run(){
        do{
            for (int i = 0; i < objetos.size(); i++) {
                objetos.get(i).actualizar();
            }
            repaint();
            try{
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){};
        }while(true);
    }
    public boolean mouseDown(Event ev, int x, int y){
        for (int i = 0; i < objetos.size(); i++)
            if(objetos.get(i).contains(x, y)){
                while(tiempoAcum<=2000) {                    
                    objetos.get(i).velx++;
                    objetos.get(i).vely++;
                    tiempoAcum+=TIEMPO;
                }
                tiempoAcum=0;
            }
        return true;
    }
}
