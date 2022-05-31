package Ejercicio20;
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
    List<Circulo> circulos;
    int radio = 300;
    boolean f = false;
    int contador = 0;
    public void init(){
        resize(700, 700);
        imagen = this.createImage(700, 700);
        noseve = imagen.getGraphics();
        circulos = new ArrayList<Circulo>(radio);
        circulos.add(new Circulo(300, 300, radio));
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.DARK_GRAY);
        noseve.fillRect(0, 0, 700, 700);
        for (int i = 0; i < circulos.size(); i++) {
            circulos.get(i).dibujar(noseve);
        }
        noseve.setColor(Color.white);
        if(f) noseve.drawString("Ganaste", 300, 300);
        noseve.fillRect(0, 0, 100, 50);
        noseve.setColor(Color.black);
        noseve.drawString(contador+" Puntos", 20, 20);
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void run(){
        do{
            if(circulos.isEmpty()){
                f=true;
                repaint();
                animacion.stop();
            }
            for (int i = 0; i < circulos.size(); i++) {
                circulos.get(i).actualizar();
            }
            repaint();
            try{
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){};
        }while(true);
    }
    public boolean mouseDown(Event ev, int x, int y){
        for (int i = 0; i < circulos.size(); i++){
            if((x>circulos.get(i).x)&&(x<(circulos.get(i).x+circulos.get(i).width))&&((y>circulos.get(i).y)&&(y<(circulos.get(i).y+circulos.get(i).height)))&&(circulos.get(i).width>20)){
                circulos.add(new Circulo(x, y, circulos.get(i).width/2));
                circulos.add(new Circulo(x, y, circulos.get(i).width/2));
                circulos.remove(i);
                contador++;
                break;
            }else if((x>circulos.get(i).x)&&(x<(circulos.get(i).x+circulos.get(i).width))&&((y>circulos.get(i).y)&&(y<(circulos.get(i).y+circulos.get(i).height)))&&(circulos.get(i).width<=20)){
                circulos.remove(i);
                contador++;
                break;
            }
        }
        return true;
    }
}
