package Septimo;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.ArrayList;

public class MazoSecundario implements Mazo{
    public static final int POSICIONX = 110;
    public static final int POSICIONY = 20;
    
    public MazoSecundario(){
    }
    
    public boolean añadir(Carta carta){
        cartas.add(carta);
        recolocar();
        return true;
    }
    public void recolocar(){
        cartas.get(cartas.size()-1).x = POSICIONX;
        cartas.get(cartas.size()-1).y = POSICIONY;
    }
    public void recolocar(Carta activa){
        activa.x = POSICIONX;
        activa.y = POSICIONY;
    }
    public Carta extraer(){
        return cartas.get(cartas.size()-1);
    }
    public void eliminar(){
        cartas.remove(cartas.size()-1);
    }
     
    public void paint(Graphics g, Applet a){
        for (int i = 0; i < cartas.size(); i++) {
            cartas.get(i).paint(g, a);
        }
    }
}
