package isp.lab3.exercise4;

import static java.lang.Math.sqrt;

public class MyPoint {
    private int x,y,z;
    public MyPoint(){
        x = 0;
        y = 0;
        z = 0;
    }
    public MyPoint(int x,int y,int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public int getx(){return x;}
    public int getY(){return y;}
    public int getZ(){return z;}
    public void setX(int x){this.x = x;}
    public void setY(int y){this.y = y;}
    public void setZ(int z){this.z = z;}
    public void setXYZ(int x,int y,int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public String toString(){
        return "(" + getx() + "," + getY() + "," + getZ() + ")";
    }
    public double distance(int x,int y, int z){
        int x1 = this.x - x;
        int y1 = this.y - y;
        int z1 = this.z - z;
        return sqrt( x1 * x1 + y1 * y1 + z1 * z1 );
    }
    public double distance(MyPoint another){
        return distance(another.getx(), another.getY(), another.getZ());
    }
    public static void main(String[] args){
        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(-1,1,0);
        MyPoint p3 = new MyPoint(1,1,1);
        System.out.println("point1: " + p1);
        System.out.println("point2: " + p2);
        System.out.println("Distance from point1 to given point is: " + p1.distance(2,2,2));
        System.out.println("Distance from point1 to point2 is: " + p1.distance(p2));
        System.out.println("Distance from point2 to point3 is: " + p2.distance(p3));
    }
}
