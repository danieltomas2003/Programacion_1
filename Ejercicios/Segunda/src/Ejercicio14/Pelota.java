package Ejercicio14;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;

public class Pelota extends Bloque{
    Color color;
    int velx, vely;
    
    public Pelota(){
        super(150, 200, 9, 9, Color.WHITE);
        velx = -3;
        vely = -2;
    }
    
    public void dibujar(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public void actualizar(Raqueta raqueta, List<Ladrillo> ladrillos){
        x += velx;
        y += vely;
        if((x<0)||(x>300-width))
            velx *= -1;
        if((y<0)||(y>300-height))
            vely *= -1;
        if(this.intersects(raqueta)){
             this.vely *= -1;   
        }
        for (int i = 0; i < ladrillos.size(); i++){
            if(this.intersects(ladrillos.get(i))){
                this.vely *= -1;
                ladrillos.remove(i);
            }
        }
    }
    
}
