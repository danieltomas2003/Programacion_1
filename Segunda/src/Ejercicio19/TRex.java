/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio19;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class TRex extends Rectangle{
    int vely;
    int vidas = 3;
    int metros = 0;
    public TRex(){
        super(30, 250, 30, 50);
        vely = 5;
    }
    
    public void dibujar(Graphics g){
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);
    }
    public void actualizar(){
        metros++;
        if(y <= 250)
            y += vely;
        else
            y += 0;
    }
}
