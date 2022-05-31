package Ejercicio_EX;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Casilla extends Rectangle{
    public static final int TAM = 130;
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
    Bandera bdra;
    int valor;

    public Casilla(int posX, int posY){
        super(posX, posY, TAM, TAM);
    }

    public void introduccion_Bandera(Bandera bandera) {
        bdra = bandera;
        bdra.x = x;
        bdra.y = y;
        bdra.posicion_Ini_X = x;
        bdra.posicion_Ini_Y = y;
    }
    
    public Casilla(int posX, int posY, String str, int v){
        super(posX, posY, TAM, TAM);
        this.str = str;
        valor = v;
    }
    
    public void paint(Graphics g, Applet a){
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(x, y, width, height);
        if(bdra==null){
            g.drawString(str, x+10, y+60);
        }
    }
}
