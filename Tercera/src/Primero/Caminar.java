package Primero;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

public class Caminar extends Applet implements Runnable{
    public static final int TIEMPO = 100;
    Image fotogramas[][];
    List<DibujoAnimado> dibujo;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    boolean f = false;
    //int var;
    
    public void init(){
        this.resize(700, 700);
        imagen=this.createImage(700, 700);
        noseve = imagen.getGraphics();
        
        fotogramas = new Image[3][4]; 
        String elementos[] = {"Primero/Sprites/Guerrillero/g", "Primero/Sprites/Hampon/h", "Primero/Sprites/Vaquero/v"};
        for (int i = 0; i < elementos.length; i++) {
            for (int j = 0; j < fotogramas[i].length; j++) {
                fotogramas[i][j] = this.getImage(this.getCodeBase(), elementos[i]+(j+1)+".gif");
            }
        }
        dibujo = new ArrayList<DibujoAnimado>();
        for (int i = 0; i < 20; i++) {
            dibujo.add(new DibujoAnimado(fotogramas));
            //dibujo.add(new DibujoAnimado(fotogramas[((int)(Math.random()*3))]));
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
        noseve.setColor(Color.WHITE);
        noseve.fillRect(0, 0, 700, 700);
        noseve.setColor(Color.black);
        if(f) noseve.drawString("Game Over", 340, 240);
        for (int i = 0; i < dibujo.size(); i++) {
            dibujo.get(i).paint(noseve, this);
        }
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void run(){
        do{
            for (int i = 0; i < dibujo.size(); i++) {
                dibujo.get(i).update();
            }
            if(dibujo.size() == 0){
                        f = true;
                        repaint();
                        animacion.stop();
                    }
            repaint();
            try{
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){};
        }while(true);
    }
    public boolean mouseDown(Event ev, int x, int y){
        for (int i = 0; i < dibujo.size(); i++)
            if(dibujo.get(i).contains(x, y))
                dibujo.remove(i);
        return true;
    }
    /*public boolean keyDown(Event ev, int tecla){
        switch(tecla){
            case 103: 
            case 71: for (int i = 0; i < dibujo.size(); i++) 
                    dibujo.get(i).setImagenes(fotogramas[0]); break;
            case 104: 
            case 72: for (int i = 0; i < dibujo.size(); i++) 
                    dibujo.get(i).setImagenes(fotogramas[1]); break;
            case 118: 
            case 86: for (int i = 0; i < dibujo.size(); i++) 
                    dibujo.get(i).setImagenes(fotogramas[2]);
            
        }
        return true;
    }*/
}
