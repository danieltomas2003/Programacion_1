package Primero;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class DibujoAnimado extends Rectangle{
    int var = ((int)(Math.random()*4));
    /*int varx = ((int)(Math.random()*640));
    int vary = ((int)(Math.random()*620));*/
    private Image imagenes[][];
    int tipo;//indica que dibujos muestra
    int velx;
    public DibujoAnimado(Image img[][]){
        super(((int)(Math.random()*640)), ((int)(Math.random()*640)), 60, 80);
        imagenes = img;
        tipo = ((int)(Math.random()*3));
        velx = ((int)(Math.random()*4)+2);
        /*x = varx;
        y = vary;*/
    }
    public void paint(Graphics g, Applet caminar){ 
        g.drawImage(imagenes[tipo][var], x, y, 60, 80, caminar);
    }
    public void update(){
        var++;
        if(var >= getImagenes().length){
            var=0;
        }
        x+=velx;
        if(x>=700)
            x=-60;
    }
    public Image[][] getImagenes() {
        return imagenes;
    }

    public void setImagenes(Image[][] imagenes) {
        this.imagenes = imagenes;
    }
}
/*public class DibujoAnimado {
    int var = ((int)(Math.random()*4));
    int varx = ((int)(Math.random()*640));
    int vary = ((int)(Math.random()*620));
    private Image imagenes[];
    public DibujoAnimado(Image img[]){
        imagenes = img;
    }
    public void paint(Graphics g, Applet caminar){ 
        g.drawImage(getImagenes()[var], varx, vary, 60, 80, caminar);
    }
    public void update(){
        var++;
        if(var >= getImagenes().length){
            var=0;
        }
    }
    public Image[] getImagenes() {
        return imagenes;
    }

    public void setImagenes(Image[] imagenes) {
        this.imagenes = imagenes;
    }
}
*/