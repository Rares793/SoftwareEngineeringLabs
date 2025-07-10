package isp.lab3.exercise2;

public class MainOfExercise2 {

    private int length = 2;
    private int width = 1;
    private String color = "red";
    int area,parameter;
    public MainOfExercise2(int length, int width){
        this.length = length;
        this.width = width;
    }
    public MainOfExercise2(int length, int width, String color){
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
    public int getParameter(){

        return parameter;
    }
    public int getArea(){

        return area;
    }
}
