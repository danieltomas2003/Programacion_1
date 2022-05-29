package Quinto;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Casilla extends Rectangle{

    public int getValor() {
        return valor;
    }
    public void setValor(int valor) {
        this.valor = valor;
    }
    public static final int TAM = 75;
    private int valor;
    Color color;
    public Casilla(int x, int y, Color c){
        super(20+x*TAM, 20+y*TAM, TAM, TAM);
        color = c;
    }
    public void paint(Graphics g){
        g.setColor(Color.YELLOW);
        g.drawRect(x, y, width, height);
        g.setFont(new Font("TimesRoman", Font.BOLD, 24));
        g.setColor(color);
        g.drawString(""+getValor(), x+30, y+50);
    }
}
