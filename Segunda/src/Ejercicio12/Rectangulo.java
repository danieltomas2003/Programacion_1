package Ejercicio12;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangulo {
    
    public static final int ARRIBA = 0;
    public static final int ABAJO = 1;
    public static final int IZQUIERDA = 2;
    public static final int DERECHA = 3;
    
    Color color;
    int posInX, posInY, altura, anchura;
    int posInicialX, posInicialY, posFinalX, posFinalY;
    int direccion;
    public Rectangulo(int x, int y, int al, int an, Color color){
        posInX = x;
        posInY = y;
        altura = al;
        anchura = an;
        posInicialX = x-20;
        posInicialY = y-20;
        posFinalX = x+20;
        posFinalY = y+20;
        this.color = color;
        direccion = DERECHA;
    }
    public void dibujar(Graphics gg){
        gg.setColor(color);
        gg.fillRect(posInX, posInY, anchura, altura);
    }
    public void actualizar() {
        switch(direccion){
            case ARRIBA:
                posInY--;
                if(posInY <= posInicialY)
                    direccion = DERECHA;
                break;
            case ABAJO:
                posInY++;
                if(posInY >= posFinalY)
                    direccion = IZQUIERDA;
                break;
            case IZQUIERDA:
                posInX--;
                if(posInX <= posInicialX)
                    direccion = ARRIBA;
                break;
            case DERECHA:
                posInX++;
                if(posInX >= posFinalX)
                    direccion = ABAJO;
        }
    }
}
