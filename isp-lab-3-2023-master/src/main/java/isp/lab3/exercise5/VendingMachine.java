package isp.lab3.exercise5;

import java.util.Scanner;

public class VendingMachine {
    private final String[] products;
    private int credit;

    VendingMachine(){
        products = null;
        credit = 0;
    }
    VendingMachine(String[] products) {
        this.products = products;
        credit = 0;
    }

    public void displayProducts() {
        if(products == null) {
            throw new IllegalArgumentException("Product array cannot be empty!");
        }
        System.out.println("Available products: ");
        for(int i = 0; i < products.length; i++) {
            System.out.println("Product name - " + products[i] + " | Product id - " + i);
        }
    }
    public void insertCoin(int value) {
        System.out.println();
        System.out.println("Adding " + value + " credit...");
        credit += value;
    }
    public String selectProduct(int id) {
        if(products == null) {
            throw new IllegalArgumentException("Product array cannot be empty!");
        }
        System.out.println();
        System.out.println("Selecting the product with id " + id + "...");
        if(id < 0 || id > products.length - 1) {
            System.out.println("Invalid product id!");
            return null;
        }
        return products[id];
    }
    private void displayCredit() {
        System.out.println("Available credit: " + credit);
        System.out.println();
    }
    public void userMenu() {
        if(products == null) {
            throw new IllegalArgumentException("Product array cannot be empty!");
        }
        System.out.println("Welcome! Available commands - 1) Display products 2) Select product 3) Enter credit, 4) exit ");
        while(true) {
            System.out.println("Please enter the name or the number of the next command: ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("display products") || input.equalsIgnoreCase("1")) {
                displayProducts();
            } else if (input.equalsIgnoreCase("select product") || input.equalsIgnoreCase("2")) {
                System.out.println("Enter an product id: ");
                while(true) {
                    scanner = new Scanner(System.in);
                    String newInput = scanner.nextLine();
                    if(newInput.equalsIgnoreCase("back")) {
                        System.out.println("Returning...");
                        break;
                    }
                    int id = Integer.parseInt(newInput);
                    String result = selectProduct(id);
                    if(result == null) {
                        System.out.printf("Enter a valid product id (0 -> %d) or go 'back': ", products.length - 1);
                    } else {
                        System.out.printf("Selected product name and id - (%s | %d)\n\n", result, id);
                        break;
                    }
                }
            } else if(input.equalsIgnoreCase("enter credit") || input.equalsIgnoreCase("3")) {
                System.out.println("Enter credit: ");
                scanner = new Scanner(System.in);
                insertCoin(scanner.nextInt());
                displayCredit();
            } else if(input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("4")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid command! Try again.");
            }
        }
    }

    public int getCredit() {
        return credit;
    }
}
