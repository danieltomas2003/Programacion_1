/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio16;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Gun extends Rectangle{
    public static final int VELX = 10;
    
    public Gun(){
        super(200, 630, 10, 50);
    }
    public void dibujar(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, width, height);        
    }
    
    public void actualizar (int posx){
        x = posx;
        if(x >= 390) x = 390;
        if(x <= 0) x = 0;
    }
}
