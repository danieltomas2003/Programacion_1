package Ejercicio2;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 extends Applet implements Runnable{
    public static final int TIEMPO = 30;
    int tiempoAcum;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    List<Gotas> gotas;
    
    public void init(){
        resize(500, 700);
        imagen = this.createImage(500, 700);
        noseve = imagen.getGraphics();
        gotas = new ArrayList<Gotas>();
        gotas.add(new Gotas());
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
        noseve.fillRect(0, 0, 500, 700);
        for (int i = 0; i < gotas.size(); i++) {
            gotas.get(i).dibujar(noseve);
        }
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void run(){
        do{
            tiempoAcum+=TIEMPO;
            if(tiempoAcum>=100){
                tiempoAcum=0;
                gotas.add(new Gotas());
            }
            for (int i = 0; i < gotas.size(); i++) {
                gotas.get(i).actualizar();
            }
            for (int i = 0; i < gotas.size(); i++) {
                if(gotas.get(i).y>=700)
                    gotas.remove(i);
            }
            repaint();
            try{
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){};
        }while(true);
    }
}
