package Septimo;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    ArrayList<Carta> cartas;
    public Baraja(Image[] img){
        cartas = new ArrayList<Carta>();
        for (int i = 0; i < Solitario.NUM_CARTAS; i++) {
            cartas.add(new Carta(img[i], 5,5,5));
        }
    }
    public Carta sacarCarta(){
        Collections.shuffle(cartas);
        Carta c = cartas.get(0);
        cartas.remove(0);
        return c;
    }
}
