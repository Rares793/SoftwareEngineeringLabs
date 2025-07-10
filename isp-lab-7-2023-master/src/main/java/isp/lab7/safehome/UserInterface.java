package isp.lab7.safehome;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private final DoorLockController doorLockController = new DoorLockController(new Door()); // Only 'one' door controller (assuming more than one tenant lives inside an apartment)
    // It's possible to make a list of door controllers in order to manage each apartment door individually (more realistic, but it wasn't required in the homework)

    public void begin() {
        int input;
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Select your role (by number): 1) Admin | 2) User | 3) Exit");
            input = scanner.nextInt();
            if(input == 3) {
                System.out.println("Exiting...");
                break;
            }
            switch (input) {
                case 1:
                    while(true) {
                        System.out.println("Select and option (by number): 1) Add tenant | 2) Remove tenant | 3) View access logs | 4) Back");
                        int option = scanner.nextInt();
                        if(option == 4) {
                            System.out.println("Going back...");
                            break;
                        }
                        String pin, name;
                        switch (option) {
                            case 1:
                                scanner.nextLine();
                                System.out.println("Enter a pin for the new tenant: ");
                                pin = scanner.nextLine();
                                System.out.println("Enter a name for the new tenant: ");
                                name = scanner.nextLine();
                                try{
                                    doorLockController.addTenant(pin, name);
                                    System.out.println("Adding tenant...");
                                }
                                catch(Exception exception) {
                                    System.out.println("Tenant already exists! Try again!");
                                }
                                break;
                            case 2:
                                scanner.nextLine();
                                System.out.println("Enter a name for the tenant you want to remove: ");
                                name = scanner.nextLine();
                                try{
                                    doorLockController.removeTenant(name);
                                    System.out.println("Removing tenant...");
                                }
                                catch(Exception exception) {
                                    System.out.println("Tenant not found! Try again.");
                                }
                                break;
                            case 3:
                                System.out.println("Viewing all access logs: ");
                                ArrayList<AccessLog> accessLogs = doorLockController.getAccessLogs();
                                for(AccessLog accessLog : accessLogs) {
                                    System.out.println(accessLog);
                                }
                                break;
                            default:
                                System.out.println("Invalid option! Try again.");
                        }
                    }
                    break;
                case 2:
                    while(true) {
                        System.out.println("Select and option (by number): 1) Enter pin | 2) Back");
                        int option = scanner.nextInt();
                        if(option == 2) {
                            System.out.println("Going back...");
                            break;
                        }
                        if (option == 1) {
                            scanner.nextLine();
                            String pin = scanner.nextLine();
                            try {
                                DoorStatus status = doorLockController.enterPin(pin);
                                System.out.println("Correct pin!");
                                System.out.println("Door status: " + status);
                            }
                            catch(Exception exception) {
                                System.out.println(exception.getMessage());
                            }
                        } else {
                            System.out.println("Invalid option! Try again.");
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
                    break;
            }
        }
    }
}
