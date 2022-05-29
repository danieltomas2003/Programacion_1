package Ejercicio08;
import java.awt.*;
public class Objetos extends Frame{
    TextArea textArea;
    public static void main(String[] args){
        Objetos app = new Objetos();
    }
    public Objetos(){
        super("Trabajando con objetos en Java");
        setup();
        pack();
        resize(400, 400);
        show();
    }
    
    public void setup(){
        Panel principal = new Panel();
        principal.setLayout(new GridLayout(3, 3));
        Panel paneles[][]=new Panel[3][3];
        for (int i = 0; i < paneles.length; i++) 
            for (int j = 0; j < paneles[i].length; j++)
                paneles[i][j] = new Panel();
        
        paneles[0][0].add(new Label("Campo de texto: "));
        paneles[0][0].add(new MiTextField("", 15));
        
        principal.add(paneles[0][0]);
        
        textArea = new TextArea(5, 10);
        textArea.setBackground(Color.yellow);
        paneles[0][1].add(textArea);
        principal.add(paneles[0][1]);
        /*
        Choice eleccion = new Choice();
        eleccion.add("Uno");
        eleccion.add("Dos");
        */
        String opciones[] = {"Si","No","Quizas"};
        MiChoice eleccion = new MiChoice(opciones, textArea);
        paneles[0][2].add(eleccion);
        principal.add(paneles[0][2]);
        
        String deportes[]={"Futbol", "Natacion", "Baloncesto", "Tenis", "Padel", "Volley"};
        MiLista lista = new MiLista(deportes, textArea);
        paneles[1][0].add(lista);
        principal.add(paneles[1][0]);
        
        paneles[1][1].add(new MiCanvas());
        principal.add(paneles[1][1]);
        
        this.add(principal);
    }

    public void paint(Graphics g){
        g.drawString("", 100, 150);
    }
    
    public boolean handleEvent(Event ev){
        if(ev.id == Event.WINDOW_DESTROY){
                System.exit(0);
                return true;
        }else if(ev.id == Event.ACTION_EVENT){
            
        }
        return true;
    }
}

class MiTextField extends TextField{
    public MiTextField(String texto, int tamaño){
        super(texto, tamaño);
    }
    public boolean action(Event ev, Object ob){
        String enMayusculas=this.getText().toUpperCase();
        this.setText(enMayusculas);
        return true;
    }
}

class MiChoice extends Choice{
    TextArea texto;
    public MiChoice(String s[], TextArea txt){
        super();
        for (int i = 0; i < s.length; i++) {
            this.add(s[i]);
        }
        texto=txt;
    }
    public boolean action(Event ev, Object ob){
        texto.setText(this.getSelectedItem());
        return true;
    }
}
class MiLista extends List{
    TextArea texto;
    public MiLista(String[] d, TextArea txt){
        super(5, true);
        texto=txt;
        for (int i = 0; i < d.length; i++) {
            this.add(d[i]);
        }
    }
    public boolean handleEvent(Event ev){
        if(ev.id==Event.ACTION_EVENT){
            texto.setText("Doble click");
            return true;
        }else if(ev.id==Event.LIST_SELECT){
            texto.setText("seleccion");
            String seleccionados[]=this.getSelectedItems();
            String textoAMostrar = "";
            for (int i = 0; i < seleccionados.length; i++) {
                textoAMostrar+=seleccionados[i] + "\n";
            }
            texto.setText(textoAMostrar);
            return true;
        }else if(ev.id==Event.LIST_DESELECT){
            texto.setText("Deseleccion");
            return true;
        }
        return false;
    }
}
class MiCanvas extends Canvas{
    int posX=20;
    int posY=20;
    public MiCanvas(){
        super();
        this.resize(75, 75);
        this.setBackground(Color.YELLOW);
        this.setForeground(Color.RED);
        this.show();
    }
    public boolean mouseDown(Event ev, int x, int y){
        posX=x;
        posY=y;
        repaint();
        return true;
    }
    public void paint(Graphics g){
        g.fillRect(posX, posY, 5, 5);
    }
}
