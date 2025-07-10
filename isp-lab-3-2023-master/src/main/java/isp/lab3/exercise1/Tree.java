package isp.lab3.exercise1;

public class Tree {
    private int height;
    public Tree() {

        this.height = 15;
    }
    public void growth(int meters){
        if(meters >= 1) {
            this.height += meters;
            System.out.println("The height has been added");
        }
        else
            System.out.println("Failed to assign more height.");
    }
    public int getHeight(){
        return height;
    }
    public String toString(){
        return "Tree{" + "height=" + height + '}';
    }
    public static void main(String[] args){
        Tree t1 = new Tree();
        t1.growth(6);
        t1.growth(-1);
        t1.growth(3);
        System.out.println(t1);
    }
}
