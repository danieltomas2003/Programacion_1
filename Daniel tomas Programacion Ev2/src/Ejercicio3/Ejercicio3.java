package Ejercicio3;

import java.awt.Choice;
import java.awt.Frame;
import java.awt.Event;
import java.awt.HeadlessException;
import java.awt.Label;

public class Ejercicio3 extends Frame {

    String[] comunidades = {"Aragon", "Castilla la Mancha", "Comunidad Valenciana"};
    String[][] provincias = {{"Zaragoza", "Huesca", "Teruel"},
                            {"Toledo", "Ciudad Real", "Albacete", "Cuenca", "Guadalajara",},
                            {"Alicante", "Valencia", "Castellon"}};

    Choice chComunidades;
    Choice[] chProvincias;
    Choice column;

    public static void main(String[] args) {
        Ejercicio3 app = new Ejercicio3();
    }

    public Ejercicio3() {
        super("Comunidades Autonomas");
        setup();
        pack();
        resize(500, 500);
        show();
    }

    public void setup() throws HeadlessException {
        this.add("North", new Label("Elige tu comida", Label.CENTER));
        chComunidades = new Choice();

        for (int i = 0; i < comunidades.length; i++) {
            chComunidades.add(comunidades[i]);
        }

        chProvincias = new Choice[comunidades.length];

        for (int i = 0; i < provincias.length; i++) {
            chProvincias[i] = new Choice();
            for (int j = 0; j < provincias[i].length; j++) {
                chProvincias[i].add(provincias[i][j]);
            }
        }
        column = chProvincias[0];
        this.add("West", chComunidades);
        this.add("East", column);
    }

    public boolean handleEvent(Event ev) {
        if (ev.id == Event.WINDOW_DESTROY) {
            System.exit(0);
            return true;

        } else if (ev.id == Event.ACTION_EVENT) {
            if (ev.target instanceof Choice) {
                this.remove(column);
                column = chProvincias[chComunidades.getSelectedIndex()];
                this.add("East", column);
                this.show();
                return true;
            }
        }
        return false;
    }
}
