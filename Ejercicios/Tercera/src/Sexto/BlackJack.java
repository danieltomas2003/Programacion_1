package Sexto;

import java.applet.Applet;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.ArrayList;
import java.util.List;

public class BlackJack extends Applet{
    public static final int NUM_CARTAS = 52;
    public static final int CPP = 13;
    Image imagen;
    Graphics noseve;
    Image[] imagenes;
    String[] palos = {"_of_clubs.png", "_of_diamonds.png", "_of_hearts.png", "_of_spades.png"};
    Baraja baraja;
    Image reverso;
    ManoCartas manocrouppier;
    ManoCartas manoJugador;
    TextField apuesta;
    Button boton1;
    Button boton2;
    boolean f;
    
    public void init(){
        this.resize(800, 900);
        imagen=this.createImage(800, 900);
        noseve = imagen.getGraphics();
        this.setLayout(new BorderLayout());
        imagenes = new Image[NUM_CARTAS];
        for (int i = 0; i < palos.length; i++) {
            for (int j = 0; j < CPP; j++){
                imagenes[(i*CPP)+j] = this.getImage(this.getCodeBase(), "Sexto/Cartas/" + (j+1) + palos[i]);
            }
        }
        reverso = this.getImage(this.getCodeBase(), "Sexto/Cartas/reverso.png");
        baraja = new Baraja(imagenes);
        manocrouppier = new ManoCartas();
        manoJugador = new ManoCartas();
        Label etiqueta = new Label("Introduce tu apuesta : ", Label.RIGHT);
        apuesta = new TextField("", 10);
        Panel panel1 = new Panel();
        panel1.add(etiqueta);
        panel1.add(apuesta);
        this.add("North", panel1);
        Panel panel2 = new Panel();
        boton1 = new Button("Carta");
        boton2 = new Button("Me planto");
        panel2.add(boton1);
        panel2.add(boton2);
        this.add("South", panel2);
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.DARK_GRAY);
        noseve.fillRect(0, 0, 800, 900);
        noseve.setColor(Color.GREEN);
        noseve.fillRect(0, 20, 780, 900);
        if(f){
        manocrouppier.mostrar(noseve, this, 100);
        manoJugador.mostrar(noseve, this, 600);
        }
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void juegaElCrouppier(){
        while(manocrouppier.menor17())
            manocrouppier.meterCarta(baraja.sacarCarta());
        repaint();
    }
    
    public boolean action(Event ev, Object obj){
        if(ev.target instanceof TextField){
            f=true;
            apuesta.setEditable(false);
            manocrouppier.meterCarta(baraja.sacarCarta());
            manoJugador.meterCarta(baraja.sacarCarta());
            manoJugador.meterCarta(baraja.sacarCarta());
            repaint();
            return true;
        }
        if(ev.target instanceof Button){
            if(ev.arg.equals("Carta")){
                manoJugador.meterCarta(baraja.sacarCarta());
                repaint();
                if(manoJugador.se_ha_pasado())
                    juegaElCrouppier();
                return true;
            }
            if(ev.arg.equals("Me planto")){
                juegaElCrouppier();
                return true;
            }
            return true;
        }
        return true;
    }
}
