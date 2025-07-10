package isp.lab6.exercise2;

import java.rmi.registry.Registry;

public class Exercise2 {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle(001,"SM 26 DIM","Ceva","Opel",2004);
        Vehicle v2 = new Vehicle(002,"BM 18 AVG","Toyota","Hillux",2012);

        RegistryManager r1 = new RegistryManager();

        r1.addVehicle(v1);
        r1.addVehicle(v2);
        r1.displayAllVehicles();
        r1.removeVehicle(v2);
        r1.displayAllVehicles();
    }
}
