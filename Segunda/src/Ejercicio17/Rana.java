package Ejercicio17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Rana extends Rectangle{
    public static final int VEL = 5;
    public static final int DERECHA = 0;
    public static final int IZQUIERDA = 1;
    public static final int ARRIBA = 2;
    public static final int ABAJO = 3;
    public Rana(){
        super(340, 470, 15, 20);
    }
    public void dibujar(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(x, y, width, height);        
    }
    
    public void actualizar(int direccion){
        switch(direccion){
            case ARRIBA: y-=VEL; break;
            case ABAJO: y+=VEL; break;
            case IZQUIERDA: x-=VEL; break;
            case DERECHA: x+=VEL;
        }
    }
}
