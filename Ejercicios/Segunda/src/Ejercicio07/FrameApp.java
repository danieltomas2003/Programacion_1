package Ejercicio07;
import java.awt.*;
public class FrameApp extends Frame{
    MenuBar porDefecto;
    MenuBar alternativo;
    String tituloInicial;
    int cursores[] = {CROSSHAIR_CURSOR, DEFAULT_CURSOR, E_RESIZE_CURSOR, HAND_CURSOR, 
        MOVE_CURSOR, NE_RESIZE_CURSOR, NW_RESIZE_CURSOR, TEXT_CURSOR, WAIT_CURSOR};
    int posCursor=0;
    Color colores[] = {Color.BLACK, Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, 
        Color.RED, Color.YELLOW, Color.ORANGE, Color.PINK};
    int posColor1=0;
    int posColor2=0;
    String fuentes[] = {"Helvetica","TimesRoman","Courier","Dialog","DialogInput","Arial"};
    int posLetra=0;
    
    public static void main(String[] args){
        FrameApp app = new FrameApp();
    }
    public FrameApp(){
        super("Trabajando con frames");
        tituloInicial = getTitle();
        setup();
        pack();
        resize(400, 400);
        show();
    }
    
    public void setup(){
        setupMenu();
        setupPaneles();
    }

    public void setupPaneles() throws HeadlessException {
        Panel principal = new Panel();
        principal.setLayout(new GridLayout(4, 1));
        
        principal.add(new Label("Cambian las caracteristicas de la ventana", Label.CENTER));
        
        Panel panel1 = new Panel();
        panel1.add(new Button("Titulo"));
        panel1.add(new Button("MenuBar"));
        panel1.add(new Button("Resizable"));
        principal.add(panel1);
        
        principal.add(new Label("Salidas en la ventana", Label.CENTER));
        
        Panel panel2 = new Panel();
        panel2.add(new Button("Cursor"));
        panel2.add(new Button("Background"));
        panel2.add(new Button("Foreground"));
        panel2.add(new Button("Font"));
        principal.add(panel2);
        
        this.add("South", principal);
    }

    public void setupMenu() throws HeadlessException {
        porDefecto= new MenuBar();
        Menu fileMenu = new Menu("File");
        fileMenu.add(new MenuItem("exit"));
        porDefecto.add(fileMenu);
        
        alternativo= new MenuBar();
        Menu fileMenu2 = new Menu("Archivo");
        fileMenu2.add(new MenuItem("Salir"));
        alternativo.add(fileMenu2);
        
        this.setMenuBar(porDefecto);
    }
    public void paint(Graphics g){
        g.drawString("Cambia el color al pulsar Foreground", 100, 150);
    }
    
    public boolean handleEvent(Event ev){
        if(ev.id == Event.WINDOW_DESTROY){
                System.exit(0);
                return true;
        }else if(ev.id==Event.ACTION_EVENT)
            if(ev.target instanceof Button)
                if(ev.arg.equals("Titulo")){
                    if(this.getTitle().equals(tituloInicial))
                        this.setTitle("Titulo alternativo");
                    else
                        this.setTitle(tituloInicial);
                    return true;
                }else if(ev.arg.equals("MenuBar")){
                    if(this.getMenuBar().equals(porDefecto))
                        this.setMenuBar(alternativo);
                    else
                        this.setMenuBar(porDefecto);
                    return true;
                }else if(ev.arg.equals("Resizable")){
                    this.setResizable(!this.isResizable());
                    return true;
                }else if(ev.arg.equals("Cursor")){
                    this.setCursor(cursores[posCursor]);
                    posCursor++;
                    if(posCursor==cursores.length)
                        posCursor=0;
                    return true;
                }else if(ev.arg.equals("Background")){
                    this.setBackground(colores[posColor1]);
                    posColor1++;
                    if(posColor1==colores.length)
                        posColor1=0;
                    return true;
                }else if(ev.arg.equals("Foreground")){
                    this.setForeground(colores[posColor2]);
                    posColor2++;
                    if(posColor2==colores.length)
                        posColor2=0;
                    return true;
                }else if(ev.arg.equals("Font")){
                    this.setFont(new Font(fuentes[posLetra], Font.BOLD, 15));
                    posLetra++;
                    if(posLetra==fuentes.length)
                        posLetra=0;
                    return true;
                }
                
        return false;
    }
}
