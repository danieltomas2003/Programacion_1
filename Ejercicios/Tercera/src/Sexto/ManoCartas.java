package Sexto;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;

public class ManoCartas {
    ArrayList<Carta> cartas;
    public ManoCartas(){
        cartas = new ArrayList<Carta>();
    }
    public void mostrar(Graphics g, Applet a, int y){
        for (int i = 0; i < cartas.size(); i++) {
            g.drawImage(cartas.get(i).imagen, 70*i+100, y, 100, 170, a);
        }
    }
    public int puntuacion(){
        int acumulador = 0;
        boolean as = false;
        for (int i = 0; i < cartas.size(); i++) {
            acumulador += cartas.get(i).valor;
            if(cartas.get(i).valor == 1) as = true;
        }
        if((as)&&(acumulador <= 11)) acumulador += 10;
        return acumulador;
    }
    public boolean se_ha_pasado(){
        return (puntuacion() > 21)?true:false;
    }
    public boolean menor17(){
        return (puntuacion() < 17);
    }
    
    public void meterCarta(Carta c){
        cartas.add(c);
    }
}
