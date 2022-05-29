package Tercero;

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
    public static final int ARRIBA = 1;
    public static final int ABAJO = 2;
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Pingu pingu;
    List<Bala> balas;
    List<Foca> focas;
    List<Boss> jefe;
    int tiempoAcum = 0;
    int tiempoRayo = 0;
    int n = 0;
    int contHab = 0;
    int contJefe = 0;
    int tiempoDisparo = 0;
    int contBalas = 0;
    boolean f = false;
    boolean h = false;
    int j = 0;
    Rectangle rect;
    
    public void init(){
        this.resize(1600, 950);
        imagen=this.createImage(1600, 950);
        noseve = imagen.getGraphics();
        pingu = new Pingu(this.getImage(this.getCodeBase(), "Tercero/Imagenes3/pingu.png"));
        balas = new ArrayList<Bala>();
        focas = new ArrayList<Foca>();
        focas.add(new Foca(this.getImage(this.getCodeBase(), "Tercero/Imagenes3/focas.png")));
        rect = new Rectangle(0, 20, 1600, 100);
        jefe = new ArrayList<Boss>();
        jefe.add(new Boss(900, this.getImage(this.getCodeBase(), "Tercero/Imagenes3/leonBoss.png")));
    }
    
    public void start(){
        animacion = new Thread(this);
        animacion.start();
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        noseve.drawImage(this.getImage(this.getCodeBase(), "Tercero/Imagenes3/fondoant.jpg"), 0, 0, 1600, 950, this);
        if(h) noseve.drawImage(this.getImage(this.getCodeBase(), "Tercero/Imagenes3/barrera.png"), 0, 20, 1600, 100, this);
        noseve.setColor(Color.darkGray);
        noseve.fillRect(25, 840, 185, 65);
        noseve.fillRect(1400, 840, 100, 30);
        noseve.setColor(Color.white);
        noseve.drawString(contBalas+" balas", 1420, 860);
        if(contHab<=16){
            noseve.setColor(Color.white);
            noseve.drawRect(25, 840, 185, 65);
            noseve.drawString("Habilidad", 30, 860);
            if(contHab >= 3) noseve.fillRect(30, 870, 40, 30);
            if(contHab >= 6) noseve.fillRect(75, 870, 40, 30);
            if(contHab >= 9) noseve.fillRect(120, 870, 40, 30);
            if(contHab >= 12) noseve.fillRect(165, 870, 40, 30);
        }else{
            noseve.setColor(Color.red);
            noseve.drawRect(25, 840, 185, 65);
            noseve.drawString("Habilidad", 30, 860);
            if(contHab >= 3) noseve.fillRect(30, 870, 40, 30);
            if(contHab >= 6) noseve.fillRect(75, 870, 40, 30);
            if(contHab >= 9) noseve.fillRect(120, 870, 40, 30);
            if(contHab >= 12) noseve.fillRect(165, 870, 40, 30);
        }
        noseve.setColor(Color.black);
        if(j==0)
            for (int i = 0; i < focas.size(); i++) {
                focas.get(i).paint(noseve, this);
            }
        for (int i = 0; i < balas.size(); i++) {
            balas.get(i).paint(noseve, this);
        }
        if(j==1)
            for (int i = 0; i < jefe.size(); i++) {
                jefe.get(i).dibujar(noseve, this);
            }
        noseve.setColor(Color.BLACK);
        if(n==1) noseve.drawImage(this.getImage(this.getCodeBase(), "Tercero/Imagenes3/Bazuca.png"), 1420, pingu.y-10, 120, 85, this);
        pingu.paint(noseve, this);
        if(n==2) noseve.drawImage(this.getImage(this.getCodeBase(), "Tercero/Imagenes3/metralleta.png"), 1380, pingu.y+40, 200, 120, this);
        noseve.drawString(pingu.numVidas + " Vidas", 1450, pingu.y-10);
        if(f) noseve.drawString("Game Over", 650, 475);
        g.drawImage(imagen, 0, 0, this);
    }
    public void run(){
        do{
            if(j==0){
                tiempoAcum += TIEMPO;
                if(tiempoAcum >= 3000){
                    tiempoAcum = 0;
                    focas.add(new Foca(this.getImage(this.getCodeBase(), "Tercero/Imagenes3/focas.png")));
                }
            }
            if(h){
                tiempoRayo += TIEMPO;
                if(tiempoRayo >= 5000){
                    tiempoRayo = 0;
                    h = false;
                }
            }
            tiempoDisparo += TIEMPO;
            if(j==0)
                if(h)
                    for (int i = 0; i < focas.size(); i++) {
                        if(focas.get(i).intersects(rect)){
                            focas.get(i).explota(this.getImage(this.getCodeBase(), "Tercero/Imagenes3/explosion.png"), TIEMPO);
                            if(focas.get(i).contMuerte >= 1000){
                                focas.remove(i);
                                break;
                            }
                        }
                    }
            if(j==0)
            for (int i = 0; i < balas.size(); i++) {
                for (int j = 0; j < focas.size(); j++) {
                    if(!focas.get(j).explosion)
                        if(balas.get(i).intersects(focas.get(j))) {
                            if(balas.get(i).tipo==1){
                                focas.get(j).vida-=2;
                                contBalas ++;
                                balas.remove(i);
                                contHab++;
                                break;
                            }
                            else if(balas.get(i).tipo==0){
                                focas.get(j).vida-= 4;
                                contBalas ++;
                                balas.remove(i);
                                contHab++;
                                break;
                            }
                            else if(balas.get(i).tipo==2){
                                focas.get(j).vida-= 1;
                                contBalas ++;
                                balas.remove(i);
                                contHab++;
                                break;
                            }
                            
                        }
                }
            }
            if(j==0)
            for (int i = 0; i < focas.size(); i++) {
                if(focas.get(i).y<=-100){
                    pingu.numVidas -= focas.get(i).ataque;
                    focas.remove(i);
                }
            }
            for (int i = 0; i < balas.size(); i++) {
                if(balas.get(i).x<=-10)
                balas.remove(i);
            }
            
            if(j==0)
            for (int i = 0; i < focas.size(); i++)
                if(focas.get(i).vida<=0){
                    focas.get(i).explota(this.getImage(this.getCodeBase(), "Tercero/Imagenes3/explosion.png"), TIEMPO);
                    if(focas.get(i).contMuerte >= 300){
                        focas.remove(i);
                        break;
                    }
                }
            for (int i = 0; i < jefe.size(); i++)
                if(jefe.get(i).x>=1700){
                    f=true;
                    repaint();
                    animacion.stop();
                }
            if(pingu.numVidas<=0){
                f=true;
                repaint();
                animacion.stop();
            }
            if(j==0)
                for (int i = 0; i < focas.size(); i++) {
                    focas.get(i).actualizar();
                }
            for (int i = 0; i < balas.size(); i++) {
                balas.get(i).actualizar();
            }
            if(j==1){
                for (int i = 0; i < jefe.size(); i++) {
                    jefe.get(i).actualizar();
                }
                focas.clear();
            }
            for (int i = 0; i < jefe.size(); i++){
                for (int j = 0; j < balas.size(); j++) {
                    if(balas.get(j).intersects(jefe.get(i))){
                        if(balas.get(j).tipo==1){
                            jefe.get(i).vida-=2;
                            jefe.get(i).x-=10;
                            contBalas ++;
                            balas.remove(j);
                            break;
                        }
                        else if(balas.get(j).tipo==0){
                            jefe.get(i).vida-= 4;
                            jefe.get(i).x-=18;
                            contBalas ++;
                            balas.remove(j);
                            break;
                        }
                        else if(balas.get(j).tipo==2){
                            jefe.get(i).vida-= 1;
                            jefe.get(i).x-=6;
                            contBalas ++;
                            balas.remove(j);
                            break;
                        }
                        break;
                    }
                }
            }
            for(int i = 0; i < jefe.size(); i++) {
                if(jefe.get(i).vida<=0){
                    if(jefe.get(i).width>200){
                        jefe.add(new Boss(jefe.get(i).x, jefe.get(i).y, jefe.get(i).width/2, this.getImage(this.getCodeBase(), "Tercero/Imagenes3/leonBoss.png"), (int)(jefe.get(i).totalVida*0.5), (int)(jefe.get(i).tamañoBarra*0.7)));
                        jefe.add(new Boss(jefe.get(i).x, jefe.get(i).y+jefe.get(i).width/2, jefe.get(i).width/2, this.getImage(this.getCodeBase(), "Tercero/Imagenes3/leonBoss.png"), (int)(jefe.get(i).totalVida*0.5),(int)(jefe.get(i).tamañoBarra*0.7)));
                        jefe.remove(i);
                        break;
                    }
                    if(jefe.get(i).width<=200)
                        jefe.remove(i);
                }
            }
            contJefe += TIEMPO;
            if(contJefe >= 60000)
                j = 1;
            if(jefe.isEmpty()){
                contJefe = 0;
                jefe.add(new Boss(900, this.getImage(this.getCodeBase(), "Tercero/Imagenes3/leonBoss.png")));
                j=0;
            }
            repaint();
            try{
                Thread.sleep(TIEMPO);
            }catch(InterruptedException e){};
        }while(true);
    }
    public boolean mouseMove(Event ev, int x, int y){
        pingu.actualizar(y);
        repaint();
        return true;
    }
    public boolean mouseDown(Event ev, int posx, int posy){
                if((n==0)&&(tiempoDisparo>=200)){
                    balas.add(new Bala(pingu.y+90, this.getImage(this.getCodeBase(),"Tercero/Imagenes3/billbala.png"), 1));
                    tiempoDisparo = 0;
                }else if((n==1)&&(tiempoDisparo>=800)&&(contBalas>=5)){
                    balas.add(new Bala(pingu.y-7, this.getImage(this.getCodeBase(),"Tercero/Imagenes3/billbanzai.png"), 0));
                    tiempoDisparo = 0;
                    contBalas -=5;
                }else if((n==2)&&(tiempoDisparo>=80)&&(contBalas>=2)){
                    balas.add(new Bala(pingu.y+87, this.getImage(this.getCodeBase(),"Tercero/Imagenes3/torpedo.png"), 2));
                    tiempoDisparo = 0;
                    contBalas -= 2;
                }
        return true;
    }
    public boolean keyDown(Event ev, int tecla){
        if(tecla == 119){
            if(n == 0)
                n = 1;
            else if(n==1)
                n=2;
            else if(n==2)
                n=0;
        }if(tecla == 115){
            if(contHab >= 12){
                h=true;
                contHab = 0;
            }
        }
        return true;
    }
}
