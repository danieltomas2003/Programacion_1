package Septimo;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.ArrayList;

public interface Mazo {
    public ArrayList<Carta> cartas = new ArrayList<Carta>();
    public boolean añadir(Carta c);
    public void recolocar();
    public void eliminar();
    public void paint(Graphics g, Applet a);
    public Carta extraer();
}
