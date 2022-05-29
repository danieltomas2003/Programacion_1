package Quinto;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Ficha extends Rectangle{
    Image imagen;
    int valor;
    List<Integer> numerosApostados;
    
    public Ficha(int y, Image img, int v){
        super(400, y+100, 70, 70);
        imagen = img;
        valor = v;
        numerosApostados = new ArrayList<Integer>();
    }
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, width, height, a);
        for (int i = 0; i < numerosApostados.size(); i++) {
            g.drawString(""+numerosApostados.get(i), x+(i*20), y);
        }
    }
    public void actualizar(int x, int y){
        this.x = x-25;
        this.y = y-25;
    }
    public void numCasillas(Casilla casillas[][]){
        numerosApostados.clear();
        for (int i = 0; i < casillas.length; i++) 
            for (int j = 0; j < casillas[i].length; j++) 
                if(intersects(casillas[i][j]))
                    numerosApostados.add(casillas[i][j].getValor());
    }
}
