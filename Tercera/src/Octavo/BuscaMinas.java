package Octavo;

import Noveno.Casilla;
import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BuscaMinas extends Applet{
    public static final int DIM = 10;
    Image mina;
    Image imgTapado;
    Casilla[][] casillas;
    
    public void init(){
        this.resize(1200, 1100);
        imgTapado = getImage(getCodeBase(), "Octavo/Imagenes/casilla.png");
        mina = getImage(getCodeBase(), "Octavo/Imagenes/mina.png");
        casillas = new Casilla[DIM][DIM];
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                casillas[i][j] = new Casilla(100+(j*Casilla.TAM), 20+(i*Casilla.TAM), imgTapado);
            }
        }
        int aleatorios[] = obtenerAleatorios();
        for (int i = 0; i < DIM; i++) {
            casillas[aleatorios[i]/10][aleatorios[i]%10].setMina(mina);
        }
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                casillas[i][j].setAlrededor(obtenerAlrededor(i, j));
            }
        }
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                casillas[i][j].paint(g, this);
            }
        }
    }
    
    public boolean mouseDown(Event ev, int x, int y){
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                if(casillas[i][j].contains(x, y)){
                    casillas[i][j].setTapada(false);
                    destaparVacias();
                    repaint();
                }
            }
        }
        return true;
    }
    public int[] obtenerAleatorios(){
        int numeros[];
        numeros = new int[(DIM*DIM)-1];
        int aleatorios[];
        aleatorios = new int[DIM];
        for(int i = 0; i < numeros.length; i++)
            numeros[i] = i+1;
        for (int i = 0; i < DIM; i++){
            int al = (int)(Math.random()*(numeros.length-i));
            aleatorios[i] = numeros[al];
            numeros[al] = numeros[99-i-1];
        }
        
        return aleatorios;
    }
    public int obtenerAlrededor(int f, int c){
        int alrededor = 0;
        int inif = (f==0)?0:-1;
        int inic = (c==0)?0:-1;
        int finf = (f==9)?1:2;
        int finc = (c==9)?1:2;
        
        for (int i = inif; i < finf; i++) {
            for (int j = inic; j < finc; j++) {
                if(casillas[f+i][c+j].getMina()!=null)
                    alrededor+=1;
            }
        }
            
        return alrededor;
    }
    public void destaparVacias(){
        int x, y;
        for (int i = 0; i < DIM; i++) {
            for (int j = 0; j < DIM; j++) {
                x = i;
                y = j;
                int inif = (y==0)?0:-1;
                int inic = (x==0)?0:-1;
                int finf = (y==9)?1:2;
                int finc = (x==9)?1:2;
                if((casillas[x][y].isTapada())&&(casillas[x][y].getMina() == null)&&(casillas[x][y].getAlrededor()==0))
                for (int k = inif; k < finf; k++) {
                    for (int h = inic; h < finc; h++) {
                        if((casillas[x+h][y+k].isTapada())&&(casillas[x+h][y+k].getMina() == null))
                            casillas[x+h][y+k].setTapada(false);
                    }
                }
            }
        }
        
    }
}
