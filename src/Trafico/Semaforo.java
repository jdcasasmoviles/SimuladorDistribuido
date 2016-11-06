package Trafico;
public class Semaforo extends Thread{
  //semaforo horizontal
private boolean norteVerde = true; // => false está rojo
private boolean cochePasando = true;
private int valorSemaforo;
private int valorSemaforo2;
private int t=10000;
private int espera=1800;

public Semaforo(){
}
//inicio run()
@Override
public void run()
{
try{ 
while(true){
hverde();
hamarillo();
hrojo();
}
}

catch(InterruptedException e){}

}

//SEMAFORO HORIZONTAL Y VERTICAL
public synchronized void hverde() throws InterruptedException {
while (norteVerde && cochePasando)
{
  setValorSemaforo(1);
  setValorSemaforo2(3);
    Thread.sleep(t);
    cochePasando = false;
}
}

public synchronized void hrojo() throws InterruptedException {
norteVerde = !norteVerde;//cambia de rojo a verde
setValorSemaforo(3);
setValorSemaforo2(1);
Thread.sleep(t);
cochePasando = true;
notifyAll();
}

public synchronized void hamarillo()throws InterruptedException{
norteVerde = !norteVerde;//cambia de verde a rojo
 setValorSemaforo(2);
 setValorSemaforo2(2);
Thread.sleep( (espera) );
notifyAll();
}


    public int getValorSemaforo() {
        return valorSemaforo;
    }

    public void setValorSemaforo(int valorSemaforo) {
        this.valorSemaforo = valorSemaforo;
    }

    public int getValorSemaforo2() {
        return valorSemaforo2;
    }
    
    public void setValorSemaforo2(int valorSemaforo2) {
        this.valorSemaforo2 = valorSemaforo2;
    }

}