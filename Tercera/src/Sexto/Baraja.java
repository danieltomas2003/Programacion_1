package Sexto;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;

public class Baraja {
    ArrayList<Carta> cartas;
    public Baraja(Image[] img){
        cartas = new ArrayList<Carta>();
        for (int i = 0; i < BlackJack.NUM_CARTAS; i++) {
            cartas.add(new Carta(img[i], (i%BlackJack.CPP)+1));
        }
    }
    public Carta sacarCarta(){
        Collections.shuffle(cartas);
        Carta c = cartas.get(0);
        cartas.remove(0);
        return c;
    }
}
