/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio16;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
public class Nave extends Rectangle{
    public static final Color colores[] = {Color.BLUE, Color.darkGray, Color.GREEN, Color.red, Color.YELLOW, Color.green, Color.orange, Color.magenta};
    public static final int ANCHURA = 30;
    public static final int ALTURA = 10;
    int velx, vely;
    Color color = colores[(int)(Math.random()*colores.length)];;
    
    public Nave(){
        super((int)(Math.random()*370), (int)(Math.random())*(-40)+10, ANCHURA, ALTURA);
        velx = (int)((Math.random()*11)-5);
        vely = (int)((Math.random()*5)+1);
    }
    public void dibujar(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }
    
    public void actualizar(){
        if((x <= 0)||(x >= 370))
            velx *= -1;
        this.x += velx;
        this.y += vely;
    }
}
