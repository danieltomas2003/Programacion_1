package Noveno;

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Parejas extends Applet implements Runnable{
    public static final int DIM = 10;
    Image donuts[];
    Image imgTapado;
    Casilla casillas[][];
    int temporal;
    int cuentaSegundos;
    Casilla cUno, cDos;
    
    public void init(){
        this.resize(1200, 1100);
        imgTapado = getImage(getCodeBase(), "Noveno/donutsMatch/reverso.png");
        donuts = new Image[8];
        for (int i = 0; i < 8; i++) {
            donuts[i] = getImage(getCodeBase(), "Noveno/donutsMatch/img"+(i+1)+".png");
        }
        casillas = new Casilla[4][4];
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = new Casilla(100+i*100, 100+j*100, imgTapado, donuts[((i*4)+j)%8]);
            }
        }
        desordenar();
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j].paint(g, this);
            }
        }
    }
    
    public boolean mouseDown(Event ev, int x, int y){
        for (int i = 0; i < casillas.length; i++) 
            for (int j = 0; j < casillas[i].length; j++) 
                if(casillas[i][j].contains(x, y))
                    if(casillas[i][j].isTapada()){
                        casillas[i][j].setTapada(false);
                        switch(cuantas()){
                            case 0:
                                cUno = casillas[i][j];
                                break;
                            case 1:
                                cDos = casillas[i][j];
                                if(cUno.getImagen() == cDos.getImagen()){
                                    cUno = cDos = null;
                                }else{
                                    temporal = cuentaSegundos;
                                }
                        }
                        cUno = casillas[i][j];
                    }
        repaint();
        
        return true;
    }
    
    public int cuantas(){
        int num = 0;
        if(cUno != null) num++;
        if(cDos != null) num++;
        return num;
    }
    
    @Override
    public void run(){
        do{
            while(true){
                
            }
        }
    }
    
    public int[] obtenerAleatorios(){
        int aleatorios[];
        aleatorios = new int[DIM];
        return aleatorios;
    }
    public void desordenar(){
        Image auxiliar;
        for (int i = 0; i < 25; i++) {
            int alea1 = (int)(Math.random()*16);
            int alea2 = (int)(Math.random()*16);
            auxiliar = casillas[alea1/4][alea2/4].getImagen();
            casillas[alea1/4][alea1%4].setImagen(casillas[alea2/4][alea2%4].getImagen());
            casillas[alea2/4][alea2%4].setImagen(auxiliar);
        }
    }
}
