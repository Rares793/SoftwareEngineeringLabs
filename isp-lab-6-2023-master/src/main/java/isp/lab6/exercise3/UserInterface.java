package isp.lab6.exercise3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    private final LoginSystem loginSyst;
    private final OnlineStore store;

    public UserInterface(LoginSystem loginSyst, OnlineStore store) {
        this.loginSyst = loginSyst;
        this.store = store;
    }

    public void loadInterface() {
        while (true) {
            int input;
            System.out.println("Choose one of the following options (number): 1. Register | 2. Login | 3. Exit");
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextInt();
            if(input == 3) {
                System.out.println("Exiting...");
                break;
            }
            switch (input) {
                case 1: registedInterface(); break;
                case 2: loginInterface(); break;
                default: System.out.println("Invalid option! Try again.");
            }
        }
    }

    public void registedInterface() {
        int beforeRegisterUsers = loginSyst.getUsers().size();
        String username, password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: "); username = scanner.nextLine();
        System.out.println("Enter your password: "); password = scanner.nextLine();
        loginSyst.register(username, password);
        if(beforeRegisterUsers + 1 == loginSyst.getUsers().size()) {
            System.out.println("Account created! Please login.");
        } else {
            System.out.println("Username is taken! Try again!");
        }
    }

    public void loginInterface() {
        String username, password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        username = scanner.nextLine();
        System.out.println("Enter your password: ");
        password = scanner.nextLine();
        if (loginSyst.login(username, password)) {
            while (true) {
                System.out.println("Choose one of the following options (number): 1. View products | 2. Order products | 3. Add to cart | 4. Checkout | 5. Logout");
                int input = scanner.nextInt();
                switch (input) {
                    case 1:
                        System.out.println("Available products: " + store.getProducts());
                        break;
                    case 2:
                        System.out.println("Order criteria (name, price): ");
                        scanner.nextLine();
                        while (true) {
                            String criteriaText = scanner.nextLine();
                            Comparator<Product> criteria = null;
                            boolean valid = true;
                            switch (criteriaText) {
                                case "name": criteria = Comparator.comparing(product -> product.name); break;
                                case "price": criteria = Comparator.comparingInt(product -> product.price); break;
                                default:
                                    System.out.println("Invalid criteria! Try again.");
                                    valid = false;
                                    break;
                            }
                            if (valid) {
                                System.out.println("Available products: " + store.getProductsSorted(criteria));
                                break;
                            }
                        }
                        break;
                    case 3:
                        List<Product> products = store.getProducts();
                        System.out.println("Choose an product index (0 -> " + (products.size() - 1) + ")" + " or type -1 to go back");
                        while (true) {
                            int productIndex = scanner.nextInt();
                            if(productIndex == -1) {
                                break;
                            }
                            if(productIndex < 0 || productIndex >= products.size()) {
                                System.out.println("Invalid product index! Try again.");
                            } else {
                                System.out.println("Enter quantity: ");
                                int quantity = scanner.nextInt();
                                store.addToCart(username, products.get(productIndex), quantity);
                                break;
                            }
                        }
                        break;
                    case 4:
                        Map<Product, Integer> cart = store.getSessions().get(username).getShoppingCart();
                        System.out.println("Cart items: " + cart);
                        System.out.println("Finish checkout (0, 1)");
                        while (true) {
                            int option = scanner.nextInt();
                            switch (option) {
                                case 0: System.out.println("Checkout canceled. Returning..."); break;
                                case 1: System.out.println("Checkout success!"); store.checkout(username); break;
                                default: System.out.println("Invalid option! Try again.");
                            }
                            if(option == 0 || option == 1) {
                                break;
                            }
                        }
                        break;
                    case 5: logoutInterface(username); break;
                    default: System.out.println("Invalid option! Try again.");
                }
                if(input == 5) {
                    break;
                }
            }
        } else {
            System.out.println("Invalid username or password! Please try again.");
        }
    }

    public void logoutInterface(String username) {
        if(loginSyst.logout(username)) {
            System.out.println("Goodbye...");
        } else {
            System.out.println("You are not logged in!");
        }
    }
}
