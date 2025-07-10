package isp.lab3.exercise2;

public class Rectangle {
    private int length = 2;
    private int width = 1;
    private String color = "red";
    public Rectangle(int length,int width){
        this.length = length;
        this.width = width;
    }
    public Rectangle(int length,int width, String color){
        this.length = length;
        this.width = width;
        this.color = color;
    }
    public int getLength(){
        return length;
    }
    public int getWidth(){
        return width;
    }
    public String getColor(){
        return color;
    }
    public int getPerimeter() {
        int perimeter = 2*(length + width);
        return perimeter;
    }
    public int getArea(){
        int area = length * width;
        return area;
    }
    public static void main(String[] args){
        Rectangle rectangle = new Rectangle(3,4,"blue");
        System.out.println("The length of rectangle is " +rectangle.getLength()+ ",the width is "+rectangle.getWidth()+ ",color "+rectangle.getColor() +",with perimeter"+ rectangle.getPerimeter() +",area"+ rectangle.getArea());
    }
}
