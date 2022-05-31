package Quinto;

import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ruleta extends Applet{
    public static final int TAM = 10;
    Image imagen;
    Graphics noseve;
    Image[] imagenes;
    List<Ficha> fichas[];
    Casilla casillas[][];
    int valores[] = {1,5,10,25,50,100,500,1000,5000,10000};
    int rojos[] = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};
    List<Integer> rojo;
    Ficha activa;
    int random;
    Button cambio;
    int jugadas[];
    int monedero = 100000;
    int acumulas = 0;
    
    public void init(){
        this.resize(800, 1000);
        imagen=this.createImage(800, 1000);
        noseve = imagen.getGraphics();
        imagenes = new Image[TAM];
        fichas = new List[TAM];
        for (int i = 0; i < fichas.length; i++) {
            fichas[i] = new ArrayList<Ficha>();
            imagenes[i] = this.getImage(this.getCodeBase(), "Quinto/Fichas/ficha" + (i+1) + ".png");
            fichas[i].add(new Ficha(i*70+10, imagenes[i], valores[i]));
        }
        casillas = new Casilla[12][3];
        rojo = new ArrayList<Integer>();
        for (int i = 0; i < rojos.length; i++) {
            rojo.add(new Integer(rojos[i]));
        }
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if(rojo.contains(i*casillas[i].length+j+1)){
                    casillas[i][j] = new Casilla(j, i, Color.RED);
                    casillas[i][j].setValor(i*casillas[i].length+j+1);
                }else{
                    casillas[i][j] = new Casilla(j, i, Color.BLACK);
                    casillas[i][j].setValor(i*casillas[i].length+j+1);
                }
            }
        }
        cambio = new Button("Iniciar");
        this.setLayout(new BorderLayout());
        this.add("North", cambio);
        jugadas = new int[10];
        
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.DARK_GRAY);
        noseve.fillRect(0, 0, 800, 1000);
        noseve.setColor(Color.GREEN);
        noseve.fillRect(0, 20, 780, 960);
        for (int i = 0; i < casillas.length; i++) 
            for (int j = 0; j < casillas[i].length; j++) 
                casillas[i][j].paint(noseve);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < fichas[i].size(); j++) 
                fichas[i].get(j).paint(noseve, this);
        }
        noseve.setFont(new Font("TimesRoman", Font.BOLD, 24));
        if(rojo.contains(random)){
            noseve.setColor(Color.RED);
            noseve.drawString(""+random, 355, 50);
        }else{
            noseve.setColor(Color.BLACK);
            noseve.drawString(""+random, 355, 50);
        }
        if(rojo.contains(random)){
                noseve.setColor(Color.RED);
                noseve.drawString("Rojo  -", 400, 50);
        }else{
            noseve.setColor(Color.BLACK);
            noseve.drawString("Negro -", 400, 50);
        }
        noseve.setColor(Color.BLACK);
        if(random%2==0){
                noseve.drawString("Par", 480, 50);
            }else{
                noseve.drawString("Impar", 480, 50);
            }
        if(random <= 18){
                noseve.drawString("Falta", 560, 50);
            }else{
                noseve.drawString("Pasa", 560, 50);
            }
        for (int i = 0; i < jugadas.length; i++) {
            if(rojo.contains(jugadas[i])){
                noseve.setColor(Color.RED);
                noseve.drawString(""+jugadas[i], 700, 50+i*50);
            }else{
                noseve.setColor(Color.BLACK);
                noseve.drawString(""+jugadas[i], 700, 50+i*50);
            }
        }
        noseve.drawString("Monedero = "+monedero, 300, 900);
        noseve.drawString("Ganancias/Perdidas = "+acumulas, 300, 850);
        g.drawImage(imagen, 0, 0, this);
    }
    public boolean mouseDown(Event ev, int x, int y){
        for (int i = 0; i < fichas.length; i++) {
            for (int j = 0; j < fichas[i].size(); j++) 
                if(fichas[i].get(j).contains(x, y))
                    if(fichas[i].get(fichas[i].size()-1).contains(x, y)){
                        fichas[i].add(new Ficha(i*70+10, imagenes[i], valores[i]));
                    activa = fichas[i].get(j);
                    break;
                }
            }
        return true;
    }
    public boolean mouseDrag(Event ev, int x, int y){
       if(activa!=null){
       activa.actualizar(x, y);
       repaint();
       }
       return true; 
    }
    public boolean mouseUp(Event ev, int x, int y){
        if(activa!=null){
            activa.numCasillas(casillas);
            activa=null;
        }
        return true;
    }
    public boolean action(Event ev, Object obj){
        if(ev.target instanceof Button){
            random = (int)(Math.random()*37);
            for (int j = 9; j > 0; j--) 
                jugadas[j] = jugadas[j-1];
            jugadas[0] = random;
            
            int apuestas = 0;
            int ganas = 0;
            for (int i = 0; i < fichas.length; i++) {
                for (int j = 0; j < fichas[i].size(); j++) {
                    if(fichas[i].get(j).numerosApostados.size()!=0)
                        apuestas += fichas[i].get(j).valor;
                        if(fichas[i].get(j).numerosApostados.contains(random))
                            ganas += 36*(fichas[i].get(j).valor/fichas[i].get(j).numerosApostados.size());
                }
            }
            acumulas = ganas - apuestas;
            monedero += acumulas;
            repaint();
        }
        return true;
    }
}
