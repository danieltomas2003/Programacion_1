package Octavo;

import Noveno.*;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Casilla extends Rectangle{
    public static final int TAM = 80;
    private Image mina;
    Image reverso;
    private boolean tapada;
    private int alrededor;
    Font fuente;
    public Casilla(int posX, int posY, Image rev){
        super(posX, posY, TAM, TAM);
        mina = null;
        reverso = rev;
        tapada = true;
        alrededor = 0;
        fuente = new Font("Arial", 60, 60);
    }

    public Image getMina() {
        return mina;
    }

    public void setMina(Image mina) {
        this.mina = mina;
    }

    public boolean isTapada() {
        return tapada;
    }

    public void setTapada(boolean tapada) {
        this.tapada = tapada;
    }

    public int getAlrededor() {
        return alrededor;
    }

    public void setAlrededor(int alrededor) {
        this.alrededor = alrededor;
    }
    
    public void paint(Graphics g, Applet a){
        g.drawRect(x, y, width, height);
        if(tapada)
            g.drawImage(reverso, x, y, width, height, a);
        else{
            if(mina==null){
            reverso = null;
            g.setColor(Color.cyan);
            g.fillRect(x, y, width, height);
            g.setColor(Color.black);
            g.drawRect(x, y, width, height);
            g.setFont(fuente);
            if(alrededor == 1){
                g.setColor(Color.yellow);
                g.drawString(""+alrededor, x+20, y+60);
            }
            else if(alrededor == 2){
                g.setColor(Color.orange);
                g.drawString(""+alrededor, x+20, y+60);
            }
            else if(alrededor == 3){
                g.setColor(Color.red);
                g.drawString(""+alrededor, x+20, y+60);
            }
            else if(alrededor == 4){
                g.setColor(Color.pink);
                g.drawString(""+alrededor, x+20, y+60);
            }
            else if(alrededor == 5){
                g.setColor(Color.gray);
                g.drawString(""+alrededor, x+20, y+60);
            }
            else if(alrededor == 6){
                g.setColor(Color.blue);
                g.drawString(""+alrededor, x+20, y+60);
            }
            
            }
            if(mina!=null)
            g.drawImage(mina, x, y, width, height, a);
        }
    }
}
