package Ejercicio10;
import java.awt.Canvas;
import java.awt.Event;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

public class MiCanvas extends Canvas{
    public List<DosPuntos> dps;
    public DosPuntos actual;
    public int tipo;
    public MiCanvas(){
        super();
        dps = new ArrayList<DosPuntos>();
    }
    
    public void paint(Graphics g){
        if(actual != null)
        actual.dibujar(g);
        for (int i = 0; i < dps.size(); i++) {
            dps.get(i).dibujar(g);
        }
    }
    public boolean mouseDown(Event ev, int x, int y){
        actual = new DosPuntos(x, y, tipo);
        return true;
    }
    public boolean mouseDrag(Event ev, int x, int y){
        actual.setFinX(x);
        actual.setFinY(y);
        repaint();
        return true;
    }
    public boolean mouseUp(Event ev, int x, int y){
        dps.add(actual);
        actual = null;
        return true;
    }
    
    public DosPuntos getDp() {
        return actual;
    }
    public void setDp(DosPuntos dp) {
        this.actual = dp;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
