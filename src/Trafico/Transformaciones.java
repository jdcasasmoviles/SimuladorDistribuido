package Trafico;
public class Transformaciones {
    static double x1,y1;
static void translate(int x, int y, double tx, double ty){
  x1 = Math.round(x + tx);
  y1 = Math.round(y + ty);
}

static void Reflex(int x, int y){
  x1 = Math.round(y);
  y1 = Math.round(x);
}


static void scale(int x, int y, double sx, double sy){
  x1 = Math.round(sx*x);
  y1 = Math.round(sy*y);
}
static void rotate(int x, int y, double a){
  double sn = Math.sin(a*(Math.PI)/180);
  double cs = Math.cos(a*(Math.PI)/180);
  x1 = Math.round((cs*x)-(sn*y));
  y1 = Math.round((cs*y)+(sn*x));
}
static void rotateFix(int x, int y, double a,double xr, double yr){
  translate(x,y,-xr,-yr);
  rotate((int)x1,(int)y1,a);
  translate((int)x1,(int)y1,xr,yr);
}

static void scaleFix(int x, int y, double sx, double sy,double xf, double yf){
  translate(x,y,-xf,-yf);
  scale((int)x1,(int)y1,sx,sy);
  translate((int)x1,(int)y1,xf,yf);
  }    

 public static double getX1() {
        return x1;
    }

    public static void setX1(double aX1) {
        x1 = aX1;
    }

    public static double getY1() {
        return y1;

}
}
