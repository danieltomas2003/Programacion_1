package Ejercicio11;

import java.awt.Frame;
import java.awt.Event;
import java.awt.Graphics;

public class Animacion1 extends Frame implements Runnable{
    Thread animacion;
    public int actual = 0;
    String frames[] = {"*","**","***","****","*****","******","*****","****","***","**","*"};
    
    public static void main(String[] args) {
        Animacion1 app = new Animacion1();
    }
    public Animacion1(){
        super("Animacion sencilla");
        pack();
        resize(200, 200);
        show();
        animacion = new Thread(this);
        animacion.start(); //El metodo start llama al metodo run
    }
    
    public void paint(Graphics g){
        g.drawString(frames[actual], 50, 100);
    }
    
    public void run(){
        do{
            actual = (actual+1) % frames.length;
            repaint();
            try{
                Thread.sleep(300);
            }catch(InterruptedException e){};
        }while(true);
    }
    public boolean handleEvent(Event ev){
        if(ev.id == Event.WINDOW_DESTROY){
            System.exit(0);
            return true;
        }
        return false;
    }
}
