package Septimo;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Solitario extends Applet{
    public static final int NUM_CARTAS = 52;
    public static final int NUM_PALOS = 4;
    public static final int CPP = 13;
    Image imagen;
    Graphics noseve;
    Image[] imagenes;
    String[] palos = {"_of_clubs.png", "_of_diamonds.png", "_of_hearts.png", "_of_spades.png"};
    Baraja baraja;
    Image imgReverso;
    Rectangle reverso;
    MazoSecundario mazoS;
    Carta activa;
    MazoPalo[] mazoPalo;
    MazoJuego mJuegos[];
    
    public void init(){
        this.resize(800, 900);
        imagen=this.createImage(800, 900);
        mazoPalo = new MazoPalo[4];
        for (int i = 0; i < NUM_PALOS; i++) {
            mazoPalo[i] = new MazoPalo((i*100)+300);
        }
        noseve = imagen.getGraphics();
        this.setLayout(new BorderLayout());
        imagenes = new Image[NUM_CARTAS];
        for (int i = 0; i < palos.length; i++) {
            for (int j = 0; j < CPP; j++){
                imagenes[(i*CPP)+j] = this.getImage(this.getCodeBase(), "Sexto/Cartas/" + (j+1) + palos[i]);
            }
        }
        imgReverso = this.getImage(this.getCodeBase(), "Sexto/Cartas/reverso.png");
        reverso = new Rectangle(20, 20, Carta.ANCHURA, Carta.ALTURA);
        mazoS = new MazoSecundario();
        baraja = new Baraja(imagenes);
        mJuegos = new MazoJuego[7];
        for (int i = 0; i < mJuegos.length; i++) {
            mJuegos[i] = new MazoJuego(i*100);
        }
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.GREEN);
        noseve.fillRect(0, 0, 800, 900);
        noseve.drawImage(imgReverso, 20, 20, Carta.ANCHURA, Carta.ALTURA, this);
        noseve.setColor(Color.BLACK);
        for (int i = 0; i < NUM_PALOS; i++) {
            mazoPalo[i].paint(noseve, this);
        }
        mazoS.paint(noseve, this);
        for (int i = 0; i < mJuegos.length; i++) {
            mJuegos[i].paint(noseve, this);
        }
        g.drawImage(imagen, 0, 0, this);
    }
    
    public boolean mouseDown(Event ev, int x, int y){
        if(reverso.contains(x, y)){
            if(!baraja.cartas.isEmpty()){
                mazoS.añadir(baraja.sacarCarta());
                System.out.println(baraja.cartas.size());
            }
            else{
                baraja.cartas = mazoS.cartas;
            }
            repaint();
        }
        if((!mazoS.cartas.isEmpty())&&(mazoS.extraer().contains(x, y)))
            activa = mazoS.extraer();
        return true;
    }
    public boolean mouseDrag(Event ev, int x, int y){
        if(activa != null){
            activa.x = x - (Carta.ANCHURA / 2);
            activa.y = y - (Carta.ALTURA / 2);
            repaint();
        }
        return true;
    }
    public boolean mouseUp(Event ev, int x, int y){
        boolean encontrado = false;
        if(activa!=null){
            for (int i = 0; i < NUM_PALOS; i++) {
                if(activa.intersects(mazoPalo[i])){
                    if(mazoPalo[i].añadir(activa)){
                        mazoS.eliminar();
                        mazoPalo[i].recolocar();
                        break;
                    }
                }
            }
            for (int i = 0; i < mJuegos.length; i++) {
               if(activa.intersects(mJuegos[i])){
                   mJuegos[i].añadir(activa);
                   mazoS.eliminar();
                   encontrado=true;
                   break;
               }
            }
            if(!encontrado) mazoS.recolocar(activa);
            activa=null;
            repaint();
        }
        return true;
    }
}
