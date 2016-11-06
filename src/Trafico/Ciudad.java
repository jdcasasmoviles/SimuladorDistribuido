package Trafico;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.GradientPaint;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Ciudad extends JPanel  {
     GraficosDibujos lapiz=new GraficosDibujos();
    static Carro[] a;
    static  Semaforo s=new Semaforo();//semaforo control
    static int numAutos;//numero de carros
    int contador=1;
    static int movimiento=1;
    private JButton be[]=new JButton[2];
    int si=0;
    public Ciudad(){         
    be[0]= new JButton( "ON/OFF");
    add( be[0] );
    // crea nuevo ManejadorBoton para manejar los eventos de botón
     ManejadorBoton manejador = new ManejadorBoton();
    be[0].addActionListener( manejador );
    }
    
@Override
public void paint(Graphics g) {
    lapiz.dpistas(g);
     //Dibuja lago
    Graphics2D g2d = ( Graphics2D ) g; // convierte a g en objeto Graphics2D
    // dibuja un elipse en 2D, relleno con un gradiente color azul
    g2d.setPaint( new GradientPaint (10,1,new Color (208,232,240),10,200,new Color (0,85,136),true));
    g2d.fill( new Ellipse2D.Double(-100,580, 280, 150 ) );
    g2d.fill( new Ellipse2D.Double(-150,650, 300,140 ) );
    lapiz.dedificios(g);
    //lapiz.ejes_coordenados(g);
    lapiz.EstrellaGira(g,si);
    lapiz.darbol(g,si);
    lapiz.MontanaRusa(g,si);
    for(int i=0;i<numAutos;i++){
    if(a[i]!=null ) a[i].agregarCarroCarril(g,a[i].getCarropintar());
    }
    dibujar_semaforoh(g);
    dibujar_semaforov(g);
    repaint();     
    if(si==600){si=0;}
    si++;
    }
	
	public static void main(String[] args){
               System.out.println("ID AUTO\t|\tDIRECCION\t|\tGIRA");
                System.out.println("------------------------------------------------------------------------");
		JFrame frame = new JFrame("Simulador trafico");
                crearCarros(); 
                s.start();
                frame.add(new Ciudad());
		frame.setSize(1200, 900);
		frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
  
public static void crearCarros()
{
int n,l;
String dir; //Guarda dir norte-sur, sur-norte 
numAutos=500; 
Color CarroColor[]={Color.black,Color.orange,Color.red,Color.CYAN,Color.yellow,Color.blue,Color.green};
a=new Carro[numAutos];
for( int i=0;i<a.length;i++ ){
//crear los hilos e iniciarlos con una direccion aleatoria
n=(int)(Math.random()*4); 
l=(int)(Math.random()*7);
if(n==0)dir="A->C";
else if(n==1)dir="C->A";
else if(n==2)dir="D->B";
else dir="B->D";
a[i] = new Carro(i,dir,n,n,CarroColor[l]);
a[i].start();
}
}

public void dibujar_semaforoh(   Graphics g){
   Graphics2D g2d = (Graphics2D) g;   
        if(s.getValorSemaforo()==1){
         g2d.setColor(Color.green);
        g2d.fillRect(280, 300, 20, 20);
        g2d.fillRect(500, 300, 20, 20);
        }
        else if(s.getValorSemaforo()==2){
         g2d.setColor(Color.yellow);
        g2d.fillRect(280,300, 20, 20);
        g2d.fillRect(500, 300, 20, 20);
        }
        else  if(s.getValorSemaforo()==3){
         g2d.setColor(Color.red);
        g2d.fillRect(280,300, 20, 20);
        g2d.fillRect(500, 300, 20, 20);
        }
   
   }
   
    public void dibujar_semaforov(   Graphics g){
   Graphics2D g2d = (Graphics2D) g;   
        if(s.getValorSemaforo2()==1){
         g2d.setColor(Color.green);
        g2d.fillRect(400, 180, 20, 20);
        g2d.fillRect(400, 400, 20, 20);
        }
        else if(s.getValorSemaforo2()==2){
         g2d.setColor(Color.yellow);
        g2d.fillRect(400, 180, 20, 20);
        g2d.fillRect(400, 400, 20, 20);
        }
        else  if(s.getValorSemaforo2()==3){
         g2d.setColor(Color.red);
       g2d.fillRect(400, 180, 20, 20);
        g2d.fillRect(400, 400, 20, 20);
        }
   
   }

    public int getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(int movimiento) {
        this.movimiento = movimiento;
    }

 private class ManejadorBoton implements ActionListener
 {
 public void actionPerformed( ActionEvent evento )
 {
  Object fuente = evento.getSource();
  //boton ACTIVAR/DESACTICAR
  if (fuente==be[0])
  {
  if(contador%2!=0){ setMovimiento(0);
   JOptionPane.showMessageDialog( Ciudad.this,"PAUSADO");
  contador++;
  }
  else if(contador%2==0) {setMovimiento(1);
  JOptionPane.showMessageDialog( Ciudad.this,"START");
  contador++;
  }

  }
  
  }
  }
  
 } 
 




   
