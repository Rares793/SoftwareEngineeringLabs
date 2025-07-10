package isp.lab3.exercise6;

public class MainOfExercise6 {
    public static void main(String[] args) {
        String[] products = {"Apple", "Banana", "Orange"};
        int[] productsPrice = {2, 3, 5};
        VendingMachineSingleton vendingMachine = VendingMachineSingleton.getInstance(products, productsPrice);
        vendingMachine.userMenu();
        int[] newProductsPrice = {1, 2, 3};
        VendingMachineSingleton newVendingMachine = VendingMachineSingleton.getInstance(products, newProductsPrice);
        newVendingMachine.userMenu();
    }
}
