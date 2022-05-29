package Ejercicio14;

import java.awt.*;

public abstract class Bloque extends Rectangle{ //Las clases abstractas no pueden
    public static final Color COLORES[] = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.cyan, Color.blue};
    Color color;
    
    public Bloque(int posX, int posY, int anchura, int altura, Color color){
        super(posX, posY, anchura, altura);
        this.color=color;
    }
    public abstract void dibujar(Graphics g);
    
}
