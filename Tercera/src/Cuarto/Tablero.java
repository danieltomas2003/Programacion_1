package Cuarto;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Tablero extends Applet{
    public static final int TAM = 5;
    Image imagen;
    Graphics noseve;
    Image[][] imagenes;
    Lugar[][] lugares;
    int cont[][];
    int total = -1;
    AudioClip exito, error, acierto;
    Point blanco;
    boolean f = false;
    Button cambio;
    public void init(){
        this.resize(240, 260);
        imagen=this.createImage(240, 260);
        noseve = imagen.getGraphics();
        imagenes = new Image[TAM][TAM];
        lugares = new Lugar[TAM][TAM];
        for (int i = 0; i < TAM; i++)
            for (int j = 0; j < TAM; j++){
                imagenes[i][j] = this.getImage(this.getCodeBase(), "Cuarto/botones/" + ((i*TAM)+j+1) + ".gif");
                lugares[i][j] = new Lugar(imagenes[i][j], i*TAM+j+1);
            }
        try{
        error = getAudioClip(new URL(this.getCodeBase(), "Cuarto/sonidos/error.wav"));
        acierto = getAudioClip(new URL(this.getCodeBase(), "Cuarto/sonidos/nice.wav"));
        exito = getAudioClip(new URL(this.getCodeBase(), "Cuarto/sonidos/exito.wav"));
        }catch(MalformedURLException m){  
        }
        blanco = new Point(TAM-1, TAM-1);
        cont = new int[TAM][TAM];
        for (int i = 0; i < TAM; i++) 
            for (int j = 0; j < TAM; j++)
                cont[i][j]=0;
        cambio = new Button("Iniciar");
        this.setLayout(new BorderLayout());
        this.add("South", cambio);
    }
    
    public void update(Graphics g){
        paint(g);
    }
    
    public void paint(Graphics g){
        noseve.setColor(Color.WHITE);
        noseve.fillRect(0, 0, 240, 260);
        for (int i = 0; i < TAM; i++)
            for (int j = 0; j < TAM; j++)
                lugares[i][j].paint(noseve, this, i, j);
        g.drawImage(imagen, 0, 0, this);
    }
    public boolean mover(Point click){
        Point desplazamiento, hasta;
        desplazamiento = new Point(delta(click.x, blanco.x), delta(click.y, blanco.y));
        if((desplazamiento.x==0)&&(desplazamiento.y==0))
            return false;
        if((desplazamiento.x!=0)&&(desplazamiento.y!=0))
            return false;
        hasta = new Point(click.x + desplazamiento.x, click.y + desplazamiento.y);
        if(!((hasta.x==blanco.x)&&(hasta.y==blanco.y)))
            mover(hasta);
        lugares[blanco.x][blanco.y].setImagen(lugares[click.x][click.y].getImagen());
        lugares[blanco.x][blanco.y].valor=lugares[click.x][click.y].valor;
        lugares[click.x][click.y].setImagen(null);
        lugares[click.x][click.y].valor=25;
        blanco=click;
        repaint();

        return true;
    }

    
    public int delta(int a, int b){
        if(a==b) return 0;
        else return ((b-a)/Math.abs(b-a));
    }
    public boolean mouseDown(Event ev, int x, int y){
        Point click;
        click = new Point(y/Lugar.DIM, x/Lugar.DIM);
        if(f)
        if(mover(click)){
            acierto.play();
            comprobacion();
        }else{
            error.play();
        }
        return true;
    }
    public boolean action(Event ev, Object obj){
        if(ev.target instanceof Button){
            for (int i = 0; i < 10; i++) {
                mover(new Point((int)(Math.random()*5), (int)(Math.random()*5)));
                repaint();
                f=true;
            }
        }
        return true;
    }
    public void comprobacion() {
        for (int i = 0; i < TAM; i++) 
            for (int j = 0; j < TAM; j++){
                if(lugares[i][j].valor==i*TAM+j+1){
                    cont[i][j]=1;
                }else
                    cont[i][j]=0;
                total+=cont[i][j];
        }
        if(total==25){
            exito.play();
        }else
            total=0;
    }
}
