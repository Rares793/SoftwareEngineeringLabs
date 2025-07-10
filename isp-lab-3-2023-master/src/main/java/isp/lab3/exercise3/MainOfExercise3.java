package isp.lab3.exercise3;

public class MainOfExercise3 {
    static int objects_created = 0;
    private String model;
    private String type;
    private int speed;
    private char Fueltype;

    public MainOfExercise3(String model, String type, int speed, char Fueltype){
        this.model = model;
        this.type = type;
        this.speed = speed;
        this.Fueltype = Fueltype;
    }
    public String getModel(){
        return model;
    }
    public String getType(){
        return type;
    }
    public int getSpeed(){
        return speed;
    }
    public char getFueltype(){
        return Fueltype;
    }
    public void setModel(String model){
        this.model = model;
    }
    public void setType(String type){
        this.type = type;
    }
    public void setSpeed(int speed){
        this.speed = speed;
    }
    public void setFueltype(char Fueltype){
        this.Fueltype = Fueltype;
    }
    public String toString(){
        return "{" + getModel() + "}" + " ({" + getType() + "}) speed" + getSpeed() +"{ fuel type" + getFueltype() + "} ";
    }
    public static void objects_creater(){
        System.out.println("Number of bjects created is: " + objects_created);
    }
    {
        ++objects_created;
    }
    public static void main(String[] args){
        MainOfExercise3 v0 = new MainOfExercise3("Bugatti","Sport car",400,'D');
        System.out.println("The car selected is " + v0.getModel() +","+v0.getType()+","+v0.getSpeed()+","+v0.getFueltype()+"\n" );
        MainOfExercise3 v1 = new MainOfExercise3("Dacia","Logna",90,'G');
        System.out.println(v1.toString());
        v1.setSpeed(120);
        System.out.println(v1.toString());
        v1.setModel("Honda");
        v1.setType("Kawasaki");
        v1.setFueltype('A');
        v1.getSpeed();
        v1.getModel();
        v1.getFueltype();
        v1.getType();
        System.out.println(v1.toString());
        System.out.println(v1.getModel() +" "+ v1.getSpeed()+ " "+v1.getFueltype()+" "+v1.getType());
        MainOfExercise3 v2 = new MainOfExercise3("Honda","Cevic",50,'C');
        System.out.println(v1.equals(v2));
        objects_creater();
    }
}
