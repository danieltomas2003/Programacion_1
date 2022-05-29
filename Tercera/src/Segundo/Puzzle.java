package Segundo;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Puzzle extends Applet{
    public static final int TIEMPO = 100;
    public static final int PIEZAS = 25;
    public static final int FILAS = 5;
    Image imagen;
    Graphics noseve;
    Image[] imagenes;
    Pieza[] piezas;
    Pieza activa;
    Rectangle[][] rectangulos;
    
    public void init(){
        this.resize(700, 700);
        imagen=this.createImage(700, 700);
        noseve = imagen.getGraphics();
        imagenes = new Image[PIEZAS];
        piezas = new Pieza[PIEZAS];
        rectangulos = new Rectangle[5][5];
        for (int i = 0; i < rectangulos.length; i++) {
            for (int j = 0; j < rectangulos[i].length; j++) {
                rectangulos[i][j] = new Rectangle(20+j*Pieza.DIMENSION,20+i*Pieza.DIMENSION,Pieza.DIMENSION, Pieza.DIMENSION);
            }
        }
        for (int i = 0; i < imagenes.length; i++) {
                imagenes[i] = this.getImage(this.getCodeBase(), "Segundo/directorioImagenes/" + (i+1) + ".png");
                piezas[i] = new Pieza(imagenes[i], i);
        }
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.CYAN);
        noseve.fillRect(0, 0, 700, 700);
        noseve.setColor(Color.BLACK);
        noseve.drawImage(this.getImage(this.getCodeBase(), "Segundo/directorioImagenes/mapamundi3.png"), 20, 20, this);
        for (int i = 0; i < rectangulos.length; i++) {
            for (int j = 0; j < rectangulos[i].length; j++) {
                noseve.drawRect(rectangulos[i][j].x, rectangulos[i][j].y, rectangulos[i][j].width, rectangulos[i][j].height);
            }
        }
        for (int i = 0; i < piezas.length; i++) {
            piezas[i].paint(noseve, this);
        }
        g.drawImage(imagen, 0, 0, this);
    }
    public boolean mouseDown(Event ev, int x, int y){
        for (int i = 0; i < piezas.length; i++) {
            if(piezas[i].contains(x, y))
                activa = piezas[i];
        }
        return true;
    }
    public boolean mouseDrag(Event ev, int x, int y){
       if(activa!=null){
       activa.mover(x, y);
       repaint();
       }
       return true; 
    }
    public boolean mouseUp(Event ev, int x, int y){
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < FILAS; j++) {
                if(rectangulos[i][j].intersects(activa)){
                    if(activa.posicion == ((i*FILAS)+j)){                        
                        activa.setColocado(true);
                        activa.ajustar(rectangulos[i][j].x, rectangulos[i][j].y);
                        repaint();
                    }
                }
            }
        }
        
        activa=null;
        return true;
    }
}

