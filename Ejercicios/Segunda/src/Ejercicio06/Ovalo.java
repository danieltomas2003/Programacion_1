package Ejercicio06;
import Ejercicio05.*;
import java.awt.Color;
import java.util.Random;
import java.awt.Graphics;
public class Ovalo {
    int posX, posY, anchura, altura;
    Color color;
    Random r;
    public Ovalo(){
        r=new Random();
        inicializar();
    }

    public void inicializar() {
        posX=r.nextInt(200);
        posY=r.nextInt(200);
        anchura=r.nextInt(100);
        altura=r.nextInt(100);
        color=new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
    }
    public void Dibujar(Graphics gg){
        gg.setColor(color);
        gg.fillOval(posX, posY, anchura, altura);
    }
}