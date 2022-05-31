package Ejercicio_EX;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

public class Juego_Banderas extends Applet implements Runnable{
    public static final int TAMAÑO = 4;
    public static final int TIEMPO = 1000;
    Image imagen;
    Graphics noseve;
    Image imagenes_banderas[];
    Casilla casillas_banderas[][];
    Bandera banderas[];
    Bandera activa;
    Casilla casillas_nombres[][];
    Font fuente;
    int contador_errores;
    int contador_tiempo;
    Thread animacion;
    boolean f=false;
    boolean v=false;
    AudioClip exito, error;
    String nombre_pais[]={"PORTUGAL", "IRLANDA", "RUMANIA", "FINLANDIA", "BELGICA", "ALEMANIA", "REINO UNIDO", "GRECIA", "UCRANIA", "POLONIA", "FRANCIA", "SUIZA", "CROACIA", "REPUBLICA CHECA", "AUSTRIA", "ESPAÑA"};
    public void init(){
        this.resize(1200, 1100);
        imagen=this.createImage(1200, 1100);
        noseve = imagen.getGraphics();
        imagenes_banderas = new Image[TAMAÑO*TAMAÑO];
        banderas = new Bandera[TAMAÑO*TAMAÑO];
        activa = new Bandera(-20, -20, null, 0);
        for (int i = 0; i < imagenes_banderas.length; i++) {
            imagenes_banderas[i] = getImage(getCodeBase(), "Ejercicio_EX/Banderas/pais"+(i+1)+".jpg");
        }
        for (int i = 0; i < banderas.length; i++) {
            banderas[i] = new Bandera(-20, -20, imagenes_banderas[i], (i+1));
        }
        casillas_banderas = new Casilla[TAMAÑO][TAMAÑO];
        for (int i = 0; i < TAMAÑO; i++) {
            for (int j = 0; j < TAMAÑO; j++) {
                casillas_banderas[i][j] = new Casilla(i*130+20, j*130+20);
                casillas_banderas[i][j].introduccion_Bandera(banderas[(i*TAMAÑO)+j]);
            }
        }
        
        casillas_nombres = new Casilla[TAMAÑO][TAMAÑO];
        for (int i = 0; i < TAMAÑO; i++) {
            for (int j = 0; j < TAMAÑO; j++) {
                casillas_nombres[i][j] = new Casilla(i*130+600, j*130+20, nombre_pais[(i*TAMAÑO)+j], (i*TAMAÑO)+j+1);
            }
        }
        contador_errores = 0;
        contador_tiempo = 120;
        fuente = new Font("Arial", 40, 40);
        try{
            error = getAudioClip(new URL(this.getCodeBase(), "Ejercicio_EX/sonidos/error.wav"));
            exito = getAudioClip(new URL(this.getCodeBase(), "Ejercicio_EX/sonidos/nice.wav"));
        }catch(MalformedURLException m){}
        reordena();
    }
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.GREEN);
        noseve.fillRect(0, 0, 1200, 1100);
        noseve.setFont(new Font("Arial", 10, 10));
        for (int i = 0; i < TAMAÑO; i++) {
            for (int j = 0; j < TAMAÑO; j++) {
                casillas_nombres[i][j].paint(noseve, this);
            }
        }
        for (int i = 0; i < TAMAÑO; i++) {
            for (int j = 0; j < TAMAÑO; j++) {
                casillas_banderas[i][j].paint(noseve, this);
            }
        }
        noseve.setFont(fuente);
        noseve.drawString("Contador de errores:"+contador_errores, 400, 700);
        noseve.drawString("TIEMPO:"+contador_tiempo+" Segundos", 400, 800);
        if(f){
            noseve.setFont(new Font("Arial", 70, 70));
            noseve.drawString("SE ACABO EL TIEMPO", 350, 900);
        }
        if(v){
            noseve.setFont(new Font("Arial", 70, 70));
            noseve.drawString("SE ACABO EL TIEMPO", 350, 900);
        }
        for (int i = 0; i < banderas.length; i++)
            banderas[i].paint(noseve, this);
        g.drawImage(imagen, 0, 0, this);
    }
    public void run(){
        do{
            contador_tiempo-=TIEMPO/1000;
            if(contador_tiempo==0){
                f=true;
                for (int i = 0; i < banderas.length; i++) 
                    banderas[i].setDrageable(false);
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
        for (int i = 0; i < banderas.length; i++) {
            if(banderas[i].isDrageable())
                if(banderas[i].contains(x, y))
                    activa = banderas[i];
        }
        return true;
    }
    public boolean mouseDrag(Event ev, int x, int y){
        if(activa != null){
            activa.x = x - (Bandera.TAM / 2);
            activa.y = y - (Bandera.TAM / 2);
            repaint();
        }
        return true;
    }
    public boolean mouseUp(Event ev, int x, int y){
        if(activa!=null){
            for (int i = 0; i < TAMAÑO; i++) {
                for (int j = 0; j < TAMAÑO; j++) {
                    if(activa.intersects(casillas_nombres[i][j]))
                        if(activa.getValor()==casillas_nombres[i][j].valor){
                            activa.x=casillas_nombres[i][j].x;
                            activa.y=casillas_nombres[i][j].y;
                            exito.play();
                        }else{
                            contador_errores++;
                            activa.x = activa.posicion_Ini_X;
                            activa.y = activa.posicion_Ini_Y;
                            error.play();
                        }
                    
                }
            }
            
            activa=null;
            repaint();
        }
        return true;
    }
    public void reordena(){
        Bandera auxiliar1;
        for (int i = 0; i < 25; i++) {
            int alea1 = (int)(Math.random()*16);
            int alea2 = (int)(Math.random()*16);
            auxiliar1 = casillas_banderas[alea1/4][alea1%4].bdra;
            casillas_banderas[alea1/4][alea1%4].bdra = casillas_banderas[alea2/4][alea2%4].bdra;
            casillas_banderas[alea2/4][alea2%4].bdra = auxiliar1;
        }
        String auxiliar2;
        int aux_valor;
        for (int i = 0; i < 25; i++) {
            int alea1 = (int)(Math.random()*16);
            int alea2 = (int)(Math.random()*16);
            auxiliar2 = casillas_nombres[alea1/4][alea1%4].getStr();
            casillas_nombres[alea1/4][alea1%4].setStr(casillas_nombres[alea2/4][alea2%4].getStr());
            casillas_nombres[alea2/4][alea2%4].setStr(auxiliar2);
            aux_valor = casillas_nombres[alea1/4][alea1%4].valor;
            casillas_nombres[alea1/4][alea1%4].valor = casillas_nombres[alea2/4][alea2%4].valor;
            casillas_nombres[alea2/4][alea2%4].valor = aux_valor;
        }
        
    }
}
