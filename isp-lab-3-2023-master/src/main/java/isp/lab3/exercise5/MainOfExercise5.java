package isp.lab3.exercise5;

public class MainOfExercise5 {
    public static void main(String[] args) {
        String[] products = {"Apple", "Banana", "Orange"};
        VendingMachine vendingMachine = new VendingMachine(products);
        vendingMachine.userMenu();
    }
}
