package Trafico;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import java.awt.geom.GeneralPath;
import static Trafico.Ciudad.movimiento;

public class GraficosDibujos {
 //CONSTRUCTOR
public GraficosDibujos()
{
}
 public void dpistas(Graphics g)
{
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.gray);		
		g2d.fillRect(0,0,1200,900);
                g2d.setPaint( new GradientPaint( 35, 60, Color.GREEN, 305, 70,Color.CYAN, true ) );
		g2d.fillRect(0,0,300,200);
                g2d.fillRect(500,0,700,200);
                g2d.fillRect(0,400,300,500);
                g2d.fillRect(500,400,700,500);
                //linea amarilla
                g2d.setColor(Color.yellow);
                g2d.drawLine(400,0, 400, 200);
                g2d.drawLine(400,400, 400, 900);
                g2d.drawLine(0,300, 300, 300);
                g2d.drawLine(500,300, 1200, 300);
                //troncos arboles
                g2d.setColor(new Color (128,54,0));
                g2d.fillRect(545,150,24,50);
                g2d.fillRect(545,550,24,50);
                g2d.fillRect(245,550,24,50);
                int v=195;
                g2d.setColor(Color.LIGHT_GRAY);
                g2d.fillRect(355+v,10,74,20);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(355+v,10, 74, 20);
                g2d.drawRect(357+v,12, 70, 16);
                g2d.drawString("OFF/ON", 368+v, 25);
                
                g2d.setColor(Color.white);
                float punteo1[] = {20.0f, 15.0f};
                BasicStroke pincel1 = new BasicStroke( 4.0f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER, 3.0f,punteo1,10.0f); 
                g2d.setStroke(pincel1);
                g2d.drawLine(350,0, 350, 200);
                g2d.drawLine(350,400, 350, 900);
                g2d.drawLine(450,0, 450, 200);
                g2d.drawLine(450,400, 450, 900);
                g2d.drawLine(0,250, 300, 250);
                g2d.drawLine(500,250, 1200, 250);
                g2d.drawLine(0,350, 300, 350);
                g2d.drawLine(500,350, 1200, 350);
                
                g2d.setPaint(efecto((int)(Math.random()*4)));
                g2d.fill( new Ellipse2D.Double(30,400, 90, 50 ) );
                g2d.fill( new Ellipse2D.Double(680,400, 90, 50 ) );
                g2d.setPaint(efecto2((int)(Math.random()*4)));
                g2d.fill( new Ellipse2D.Double(520,470, 70, 90 ) );
                g2d.fill( new Ellipse2D.Double(220,470, 70, 90 ) );
                g2d.fill( new Ellipse2D.Double(520,70, 70, 90 ) );
                g.setColor(Color.white);
                g.drawString("CALLE D", 50,180);
                g.drawString("<--------", 50,190);
                 g.drawString("CALLE D", 50,420);
                 g.drawString("-------->", 50,430);
                g.drawString("CALLE B", 700,180);
                g.drawString("<--------",700,190);
                g.drawString("CALLE B", 700,420);
                g.drawString("-------->",700,430);
                g.drawString("CALLE A", 230,500);
                g.drawString("CALLE A", 530,500);
                g.drawString("^", 549,520);
                 g.drawString("v", 249,530);
                for(int i=0;i<10;i++){
                g.drawString("|", 250,520+i);
                g.drawString("|", 550,520+i);
                }
                g.drawString("CALLE C", 230,100);
                g.drawString("CALLE C", 530,100);
                g.drawString("^", 549,120);
                 g.drawString("v", 249,130);
                for(int i=0;i<10;i++){
                g.drawString("|", 250,120+i);
                g.drawString("|", 550,120+i);
                }
                g.setColor(Color.black);
                 g.drawString("SIMULADOR DE TRAFICO",10,20);
                 g.drawString("El boton OFF / ON detiene el movimiento",10,40);
                  g.drawString("Alumno : Tomas Casas Rodriguez",10,60);
   }
 
    public void darbol(Graphics g,int si)
    {
                 int arbx[]={185};
                 int arby[]={650};
                 Graphics2D g2d = (Graphics2D) g;
                 for ( int j = 1; j <= 12; j++ )
                {
                 for ( int i = 0; i < arbx.length; i++ ){   
                 Transformaciones.rotateFix(arbx[i],arby[i],-30,40 ,620);
                 arbx[i]=(int)Transformaciones.getX1();
                 arby[i]=(int)Transformaciones.getY1(); 
                 }
                 //dibuja el arbol
                 g2d.setColor(new Color (128,54,0));
                 g2d.fillRect(arbx[0]+29,arby[0]+70,14,60);
                 g2d.setPaint(new GradientPaint(1,330,new Color (0,128,128),1,1,new Color (15,113,17),true));
                 g2d.fill( new Ellipse2D.Double(arbx[0],arby[0], 70, 90 ) );
                 }
                 g2d.setColor(new Color (128,54,0));
                 for ( int r = 0; r < 3; r++ ){
                     arbx[0]=900+r*40;
                     arby[0]=400+r*100;
                     for ( int i = 0; i < 10; i++ ){
                    Transformaciones.translate(arbx[0],arby[0],30 ,0);
                     arbx[0]=(int)Transformaciones.getX1();
                     arby[0]=(int)Transformaciones.getY1();
                     g2d.setColor(new Color (128,54,0));
                      g2d.fillRect(arbx[0]+29,arby[0]+70,14,60);
                     g2d.setPaint(new GradientPaint(1,330,new Color (0,128,128),1,1,new Color (15,113,17),true));
                     g2d.fill( new Ellipse2D.Double(arbx[0],arby[0], 70, 90 ) );
                 }
                 }
    }  
    public void ejes_coordenados(Graphics g)
    {   int longejey=900,longejex=1200,origenx=400,origeny=300;
         //cuadricula
        g.setColor(Color.BLUE);
        for(int salx=0;salx<longejex;salx=salx+10){
         g.drawLine(salx,0,salx,longejey);
        }
        for(int saly=0;saly<longejey;saly=saly+10){
        g.drawLine(0,saly,longejex,saly);
        }
         //Dibujando ejes coordenados
        g.setColor(Color.red);
        g.drawLine(origenx-longejex/2, origeny, origenx+longejex/2, origeny);
        g.drawLine(origenx, origeny-longejey/2, origenx, origeny+longejey/2); 
        //num ejex
        g.setColor(Color.black);
        for(int salx=0;salx<longejex;salx=salx+50){
           g.drawString(String.valueOf(-origenx+salx),salx,origeny+5);
        }
        //num ejey
        for(int saly=0;saly<longejey;saly=saly+50){
            if((origeny-saly)==0){}
            else  g.drawString(String.valueOf(origeny-saly),origenx-10,saly);
        } 
    }
    
    public void dedificios(Graphics g){
     int edificioX[] = {0,50,200};
     int edificioY[] = {50,100,50}; 
     int etamX[] = {50,150,100};
     int etamY[] = {150,100,150}; 
     Color arreColor[]={Color.CYAN,new Color(247,98,26),Color.blue,Color.red,Color.yellow,Color.green,new Color(247,98,26),Color.cyan,new Color (128,54,0),Color.red,Color.yellow,Color.green};
     Random aleatorio = new Random();int l=0;
      for(int k=0;k<=2;k++){
       for(int i=0;i<3;i++){
       //edificios
       Graphics2D g2d = ( Graphics2D ) g;
       g2d.setPaint( new GradientPaint( 35, 3, Color.white, 5, 100,arreColor[l++], true ) );
       g.fillRect(edificioX[i],edificioY[i],etamX[i],etamY[i]);  
       //ventanas
       g2d.setPaint( new GradientPaint( 5, 3, Color.cyan, 5, 100,Color.blue, true ) );
       g.fillRect(edificioX[i]+15,edificioY[i]+20,20,25);
       g.fillRect(edificioX[i]+15,edificioY[i]+70,20,25);
       if(i>0){
       g.fillRect(edificioX[i]+etamX[i]-35,edificioY[i]+20,20,25);
       g.fillRect(edificioX[i]+etamX[i]-35,edificioY[i]+70,20,25);
       }
       //Puerta
       g.setColor(new Color(128,64,64));
       g.fillRect((int)(edificioX[i]+0.3*etamX[i]),(int)(edificioY[i]+(2*etamY[i]/3.0)),(int)(0.4*etamX[i]),(int)(etamY[i]/3.0));
       }
       if(k==1){
        for(int j=0;j<edificioX.length;j++){
       Transformaciones.translate( edificioX[j],edificioY[j],300 ,0 );
       edificioX[j]=(int)Transformaciones.getX1();
       edificioY[j]=(int)Transformaciones.getY1();
       }
       }
       else{
       for(int j=0;j<edificioX.length;j++){
       Transformaciones.translate( edificioX[j],edificioY[j],600 ,0 );
       edificioX[j]=(int)Transformaciones.getX1();
       edificioY[j]=(int)Transformaciones.getY1();
       }
       }
      }
    }
    
    
     public void MontanaRusa(Graphics g,int si)
     {
         //Montaña rusa
      int[ ] montanaX = new int[1200];
      int[ ] montanaY = new int[1200];
       montanaX[0]=549;
      for(int i=0;i<1200;i++){
          montanaX[i]=549+i;
          montanaY[i]=(int)(100*Math.sin(montanaX[i]*(Math.PI)/180))+800;
      }
      g.setColor(Color.yellow);
      g.fillPolygon(montanaX,montanaY,montanaX.length);
      g.setColor(Color.black);
       for(int i=0;i<montanaY.length-1;i++){
         g.drawLine( montanaX[i],  montanaY[i],  montanaX[i+1],  montanaY[i+1]);
      }
      //carrito movil
      int carritoX=montanaX[0]-5;
      int carritoY=montanaY[0]-30;
      if(movimiento==1){
      //translandando
      Transformaciones.translate(carritoX,carritoY,montanaX[si+1]-montanaX[0] ,montanaY[si+1]-montanaY[0] );
      carritoX=(int)Transformaciones.getX1();
      carritoY=(int)Transformaciones.getY1(); 
      //cabeza
      g.setColor(new Color(247,98,26));
       Graphics2D g2d = (Graphics2D) g;
      g2d.fill( new Ellipse2D.Double(carritoX+10,carritoY-10,15,15));
      //cuerpo carro
      g.setColor(Color.red);
      g.fillRect(carritoX,carritoY,30,20);
      //llantita
      g.setColor(Color.blue);
      g.drawOval(carritoX+5,carritoY+13, 7,7);
      g.drawOval(carritoX+20,carritoY+13, 7,7);
     }
     }
     
    public void EstrellaGira(Graphics g,int si){
     Random aleatorio = new Random(); // obtiene el generador de números aleatorios
     
     //pico
     g.setColor(Color.black);
     int patoX[] = { 55,55, 42};
     int patoY[] = {610,618,614};
     g.fillPolygon(patoX,patoY,patoX.length);
     //cuerpo
      Graphics2D g2d = (Graphics2D) g;
      g.setColor(Color.yellow);
      g2d.fill( new Ellipse2D.Double(50,600, 20, 20));
      g.fillRect(60,618,5,15);
      g2d.fill( new Ellipse2D.Double(60,620,40,20));
      //ojo
      g.setColor(Color.black);
      g.drawOval(60,606, 1,1);
      //Estrella
     int puntosX[] = { 55, 67, 109, 73, 83, 55, 27, 37, 1, 43 };
     int puntosY[] = { 0, 36, 36, 54, 96, 72, 96, 54, 36, 36 };
     //escalando
     for ( int i = 0; i < puntosX.length; i++ ){
     Transformaciones.scale(puntosX[i],puntosY[i],0.9,0.9);
      puntosX[i]=(int)Transformaciones.getX1();
      puntosY[i]=(int)Transformaciones.getY1();
     }
     //translandando
     for ( int i = 0; i < puntosX.length; i++ ){
     Transformaciones.translate( puntosX[i],puntosY[i],800 ,550 );
      puntosX[i]=(int)Transformaciones.getX1();
      puntosY[i]=(int)Transformaciones.getY1();
     }
     //Pincel para la rueda
      g2d.setColor(Color.black);
      float punteo1[] = {20.0f, 15.0f};
      BasicStroke pincel1 = new BasicStroke( 4.0f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_MITER, 3.0f,punteo1,10.0f); 
      g2d.setStroke(pincel1);
      for ( int i = 0; i <360; i++ ){   
      Transformaciones.rotateFix(puntosX[3],puntosY[3],-45*i,800 ,550);
      int ejeX=(int)Transformaciones.getX1();
      int ejeY=(int)Transformaciones.getY1(); 
      g2d.setColor(Color.red);
      g2d.drawLine(ejeX,ejeY, 800,550);
      Transformaciones.rotateFix(puntosX[3],puntosY[3],-i,800 ,550);
      ejeX=(int)Transformaciones.getX1();
      ejeY=(int)Transformaciones.getY1();
      g2d.setColor(Color.black);
      g.drawOval(ejeX,ejeY, 1,1);
      }
      g2d.setColor(Color.white);
      g2d.fillRect(794, 600, 20,70);
      g2d.setColor(Color.red);
      g2d.fillRect(770, 640, 70,20);
      g2d.setColor(Color.blue);
      g2d.fillRect(750, 660, 120,20);
      if(movimiento==1){
      // gira alrededor del origen y dibuja estrellas en colores aleatorios
      for ( int i = 0; i < puntosX.length; i++ ){   
      Transformaciones.rotateFix(puntosX[i],puntosY[i],-30*si,800 ,550);
      puntosX[i]=(int)Transformaciones.getX1();
      puntosY[i]=(int)Transformaciones.getY1(); 
      }
     // establece el color de dibujo al azar
     g.setColor( new Color( aleatorio.nextInt( 256 ), aleatorio.nextInt( 256 ), aleatorio.nextInt( 256 ) ) );
     g.fillPolygon(puntosX,puntosY,puntosX.length);
    }
    }
    
    public GradientPaint efecto2(int si){
    GradientPaint patron = new GradientPaint(1,330,new Color (0,128,128),1,1,new Color (15,113,17),true);
   
    if(si==0){
            //patron = new GradientPaint (17,200,Color.GREEN,41,200,new Color (0,128,128),true);
            
            }
            else if(si==1){
            patron = new GradientPaint (17,100,new Color (15,113,17),41,200,new Color (0,128,128),true);
            
            }
            else if(si==2){
            patron = new GradientPaint (17,150,Color.cyan,41,200,new Color (0,128,128),true);
            
            }
            else{
            patron = new GradientPaint (17,200,new Color (15,113,179),41,200,new Color (0,128,128),true);
            }
    return  patron;
    }
    
     public GradientPaint efecto(int si){
    GradientPaint patron = new GradientPaint(1,330,new Color (202,67,1),1,1,new Color (255,199,0),true);
   
    if(si==0){
            patron = new GradientPaint (17,200,new Color (3,78,162),41,200,new Color (247,0,0),true);
            
            }
            else if(si==1){
            patron = new GradientPaint (17,200,new Color (247,0,0),41,200,new Color (247,0,0),true);
            
            }
            else if(si==2){
            patron = new GradientPaint (17,200,new Color (247,0,0),41,200,new Color (3,78,162),true);
            
            }
            else{
            patron = new GradientPaint (17,200,new Color (3,78,162),41,200,new Color (3,78,162),true);
            }
    return  patron;
    }
    
}


