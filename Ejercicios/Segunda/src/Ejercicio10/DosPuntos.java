package Ejercicio10;
import java.awt.Graphics;

public class DosPuntos {
    public static final int LINEA = 0;
    public static final int OVALO = 1;
    public static final int RECTANGULO = 2;
    private int inicioX, inicioY, finX, finY;
    private int tipo;
    public DosPuntos(int ix, int iy, int fx, int fy,int tipo){
        inicioX = ix;
        inicioY = iy;
        finX = fx;
        finY = fy;
        this.tipo = tipo;
    }
    public DosPuntos(int ix, int iy, int tipo){
        this(ix, iy, ix, iy, tipo);
    }
    public DosPuntos(){
        this(0, 0, LINEA);
    }
    public int getInicioX() {
        return inicioX;
    }
    public void setInicioX(int inicioX) {
        this.inicioX = inicioX;
    }
    public int getInicioY() {
        return inicioY;
    }
    public void setInicioY(int inicioY) {
        this.inicioY = inicioY;
    }
    public int getFinX() {
        return finX;
    }
    public void setFinX(int finX) {
        this.finX = finX;
    }
    public int getFinY() {
        return finY;
    }
    public void setFinY(int finY) {
        this.finY = finY;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public void dibujar(Graphics gp){
        int anchura, altura;
        anchura = Math.abs(finX - inicioX);
        altura = Math.abs(finY - inicioY);
        switch(tipo){
            case LINEA:
                gp.drawLine(inicioX, inicioY, finX, finY);
                break;
            case OVALO:
                gp.drawOval(inicioX, inicioY, anchura, altura);
                break;
            case RECTANGULO:
                gp.drawRect(inicioX, inicioY, anchura, altura);
                break;
        
        }
    }
    
}
