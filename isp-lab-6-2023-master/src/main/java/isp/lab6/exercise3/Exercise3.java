package isp.lab6.exercise3;

public class Exercise3 {

    public static void main(String[] args) {
        Product product1 = new Product("Carne", 19);
        Product product2 = new Product("Fasole", 5);
        OnlineStore store = new OnlineStore();
        store.addProduct(product1); store.addProduct(product2);
        LoginSystem loginSystem = new LoginSystem();
        loginSystem.setStore(store);
        UserInterface userInterface = new UserInterface(loginSystem, store);
        userInterface.loadInterface();
    }
}
