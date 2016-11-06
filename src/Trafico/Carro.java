package Trafico;
import static Trafico.Ciudad.a;
import static Trafico.Ciudad.s;
import static Trafico.Ciudad.movimiento;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
public class Carro extends Thread {   
int velocidad=10;
//variables de movimiento
Graphics g;
private int cant=5; 
private int autos = 0; // número de autos atravesando el carril
private int d=0; // 0-sur a norte, 1-norte a sur....
private boolean entra=true; //Llega al carril y pasa
//variables del constructor
private String direccion;
private int direccionN;
private int idAuto;
private int x;
private int y;
private int npintar;
private Color Carropintar;
public Carro(int idA, String dir, int dirN,int npintar,Color Carropintar)
{
this.direccion=dir;
this.direccionN=dirN;
this.idAuto=idA;
this.npintar=npintar;
this.Carropintar=Carropintar;
//Checamos de donde viene para colocarlo
//s-n
if( direccionN==0 ){ if(idAuto%2==0){this.setX(450);this.setY(1000);}
                     else {this.setX(400); setY(1000);}}
//n-s
else if( direccionN==1 ){if(idAuto%2!=0){ this.setX(300); setY(-100);}
                         else { this.setX(350); setY(-100);}}
//o-e
else if( direccionN==2 ){if(idAuto%2==0){ this.setX(-100); setY(350);}
                         else { this.setX(-100); setY(300);}}
//e-o
else{if(idAuto%2!=0){setX(1300); setY(200);}
     else{setX(1300); setY(250);}}
}

//inicio run()
@Override
public void run()
{

try{ //simular que llegan aleatoriamente al carril
   
Thread.sleep( (int)(Math.random()*1000*2000) );
}
catch(InterruptedException e){}
agregarCarro(direccion, idAuto, getDireccionN());
verificarSalir(idAuto);
salir( idAuto,direccion );

}

//llega al puente
synchronized void agregarCarro(String dir, int idA, int dirN){
try{ //Lo dormimos un momento para ver
Thread.sleep(500);
}catch(InterruptedException e){}
while(entra==true){
if( autos==0 ) //si no hay coches entrar
{
d=dirN;
autos++;
return;
}
else
{
if( autos < cant ) 
{
if( dirN==d )
{
autos++;
return;
}
try{
wait();
}catch(InterruptedException e){}
}
try{
wait();
}catch(InterruptedException e){}
}//fin del esle
}
}

//inicio pasar()
void verificarSalir(int id)
{
try{ //Nos detenemos un momento para ver el movimiento
Thread.sleep( (int)(Math.random()*2000) );
}catch(InterruptedException e){}
while(a[id].getY()>= -100 && a[id].getY() <=1000 && a[id].getX() <=1300 && a[id].getX() >=-100 )
{

if(movimiento==1){
//En caso de que venga de s-n
if(this.getDireccionN() == 0 )dir_sn(id);
//En caso de que venga de n-s
else if(this.getDireccionN()==1)dir_ns(id);
//En caso de que venga de o-e
else if(this.getDireccionN()==2)dir_oe(id);
else if(this.getDireccionN()==3)dir_eo(id);
}
else{
}

try{Thread.sleep(100);}
catch(InterruptedException e){}
}

}//fin pasar()

//Salida del carril
synchronized void salir( int idA, String dir)
{
if(queDireccionFinal(this.getDireccionN()).equals(dir))
System.out.println(""+idA+"\t|\t"+dir+"\t\t|\tAVANZA DERECHO NO GIRA");
else 
System.out.println(""+idA+"\t|\t"+dir+"\t\t|\t"+queDireccion(this.getDireccionN()));
autos--;
notifyAll();
}

//Pinta los carros
 public void agregarCarroCarril(Graphics g,Color pintar){
this.g=g;
Graphics2D g2d = ( Graphics2D ) g;
g2d.setPaint( new GradientPaint( 5,33, Color.white, 45, 100,pintar, true ) );
if(this.direccionN==0 ||this.direccionN==1){
g.fillRoundRect(getX()+5,getY()+5,40,70, 30, 30 );
//lunas
g2d.setPaint( new GradientPaint( 5, 3, Color.cyan, 5, 100,Color.blue, true ) );
g.fillRect(getX()+10,getY()+20,30,10);
g.fillRect(getX()+10,getY()+50,30,10);
//luces
g.setColor(new Color(247,98,26));
g.fillRect(getX()+6,getY()+10,6,6);
g.fillRect(getX()+36,getY()+10,6,6);
g.fillRect(getX()+6,getY()+64,6,6);
g.fillRect(getX()+36,getY()+64,6,6);
//placa
g.setColor(Color.BLACK);
g.drawString(""+idAuto, getX()+15, getY()+44);
}
else {
g.fillRoundRect(getX()+5,getY()+5,70,40, 30, 30 );
//lunas
g2d.setPaint( new GradientPaint( 5, 3, Color.cyan, 5, 100,Color.blue, true ) );
g.fillRect(getX()+20,getY()+10,10,30);
g.fillRect(getX()+50,getY()+10,10,30);
//luces
g.setColor(new Color(247,98,26));
g.fillRect(getX()+10,getY()+6,6,6);
g.fillRect(getX()+10,getY()+36,6,6);
g.fillRect(getX()+64,getY()+6,6,6);
g.fillRect(getX()+64,getY()+36,6,6);
//placa
g.setColor(Color.BLACK);
g.drawString(""+idAuto, getX()+29, getY()+30);

}



}
 
 public void dir_sn(int id){
 //si pasa el semaforo y quiere voltear    
if(a[id].getX()==450 && a[id].getY()==350&&id%2==0 ){
this.setDireccionN(aleDirec(this.direccionN));
if(this.getDireccionN()==0){a[id].setY(a[id].getY() -velocidad);}
}
 //si pasa el semaforo y quiere voltear 
else if(a[id].getX()==400 && a[id].getY()==300 && id%2!=0 ){
this.setDireccionN(aleDirec(this.direccionN));
if(this.getDireccionN()==0){a[id].setY(a[id].getY() -velocidad);}
}
// si es verde o amarillo avanza
else if(s.getValorSemaforo2()==1 || s.getValorSemaforo2()==2)
{a[id].setY(a[id].getY() -velocidad);}
//si es rojo 
else if(s.getValorSemaforo2()==3 ){
                                   //si esta antes del semaforo avanza
                                  if(a[id].getY()>400)
                                  a[id].setY(a[id].getY() - velocidad);
                                    //si esta en rojo y pasa semaforo avanza
                                  else if(a[id].getY()<400) 
                                   a[id].setY(a[id].getY() - velocidad);
                                  
}
}
 
  public void dir_ns(int id){
   //si pasa el semaforo y quiere voltear    
    if(a[id].getX()==350 && a[id].getY()==250 && id%2==0 ){
    this.setDireccionN(aleDirec(this.direccionN));
    if(this.getDireccionN()==1){a[id].setY(a[id].getY() +velocidad);}
    }
     //si pasa el semaforo y quiere voltear 
    else if(a[id].getX()==300 && a[id].getY()==200 && id%2!=0 ){
    this.setDireccionN(aleDirec(this.direccionN));
    if(this.getDireccionN()==1){a[id].setY(a[id].getY() +velocidad);}
    }
  // si es verde o amarillo avanza
  else if(s.getValorSemaforo2()==1 || s.getValorSemaforo2()==2)
  {a[id].setY(a[id].getY() +velocidad);}
  //si es rojo 
  else if(s.getValorSemaforo2()==3 ){
                                      //si esta antes del semaforo avanza
                                       if(a[id].getY()<150)
                                       a[id].setY(a[id].getY() +velocidad);
                                       //si esta en rojo y pasa semaforo avanza
                                       else if(a[id].getY()>200) 
                                       {a[id].setY(a[id].getY() + velocidad);}
  }    
  }
  
   public void dir_oe(int id){  
    //si pasa el semaforo y quiere voltear    
    if(a[id].getX()==300 && a[id].getY()==350 && id%2==0 ){
    this.setDireccionN(aleDirec(this.direccionN));
    if(this.getDireccionN()==2){a[id].setX(a[id].getX() +velocidad);}
    }
     //si pasa el semaforo y quiere voltear 
    else if(a[id].getX()==350 && a[id].getY()==300 && id%2!=0 ){
    this.setDireccionN(aleDirec(this.direccionN));
    if(this.getDireccionN()==2){a[id].setX(a[id].getX() +velocidad);}
    }
   // si es verde o amarillo avanza
    else if(s.getValorSemaforo()==1 || s.getValorSemaforo()==2)
    {a[id].setX(a[id].getX() +velocidad);}
    //si es rojo 
    else if(s.getValorSemaforo()==3 ){
                                     //si esta antes del semaforo avanza
                                      if(a[id].getX()<250)
                                      a[id].setX(a[id].getX() + velocidad);
                                      //si esta en rojo y pasa semaforo avanza
                                     else if(a[id].getX()>300)
                                     {a[id].setX(a[id].getX() + velocidad);}
     }
   }
   
   public void dir_eo(int id){
        //si pasa el semaforo y quiere voltear    
    if(a[id].getX()==400 && a[id].getY()==250 && id%2==0 ){
    this.setDireccionN(aleDirec(this.direccionN));
    if(this.getDireccionN()==3){a[id].setX(a[id].getX() -velocidad);}
    }
     //si pasa el semaforo y quiere voltear 
    else if(a[id].getX()==450 && a[id].getY()==200 && id%2!=0 ){
    this.setDireccionN(aleDirec(this.direccionN));
    if(this.getDireccionN()==3){a[id].setX(a[id].getX() -velocidad);}
    }
       // si es verde o amarillo avanza
    else if(s.getValorSemaforo()==1 || s.getValorSemaforo()==2)
    {a[id].setX(a[id].getX() -velocidad);}
    //si es rojo 
    else if(s.getValorSemaforo()==3 ){
                                   //si esta antes del semaforo avanza
                                   if(a[id].getX()>500)
                                   a[id].setX(a[id].getX() - velocidad);
                                   //si esta en rojo y pasa semaforo avanza
                                  else if(a[id].getX()<500) 
                                  {a[id].setX(a[id].getX() - velocidad);}
    }
   }
 
 public  int aleDirec(int direccionN){
  int m=0;
 if(direccionN==0){
 int[ ] ale = {0,2}; 
 m=ale[(int)(Math.random()*2)];
 }
 else if(direccionN==1){
 int[ ] ale = {1,3}; 
 m=ale[(int)(Math.random()*2)];
 }
 else if(direccionN==2){
 int[ ] ale = {2,1}; 
 m= ale[(int)(Math.random()*2)];
 }
 else if(direccionN==3){
 int[ ] ale = {3,0}; 
 m= ale[(int)(Math.random()*2)];
 }
 return m;
 }
 
  public  String queDireccion(int nem){
    String me="";
    if(nem==0)me="GIRA CALLE C";
    else if(nem==1)me="GIRA CALLE A";
    else if(nem==2)me="GIRA CALLE B";
    else me="GIRA CALLE D";
    return me;
 }
 
   public  String queDireccionFinal(int nem){
    String me="";
    if(nem==0)me="A->C";
    else if(nem==1)me="C->A";
    else if(nem==2)me="D->B";
    else me="B->D";
    return me;
 }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDireccionN() {
        return direccionN;
    }

    public void setDireccionN(int direccionN) {
        this.direccionN = direccionN;
    }


    public int getNpintar() {
        return npintar;
    }

  
    public void setNpintar(int npintar) {
        this.npintar = npintar;
    }

    /**
     * @return the Carropintar
     */
    public Color getCarropintar() {
        return Carropintar;
    }

    /**
     * @param Carropintar the Carropintar to set
     */
    public void setCarropintar(Color Carropintar) {
        this.Carropintar = Carropintar;
    }

}

