package isp.lab6.exercise2;

import java.util.HashSet;
import java.util.Objects;

public class RegistryManager {
    private final HashSet<Vehicle> vehicles;

    public RegistryManager() {
        vehicles = new HashSet<Vehicle>();
    }

    public boolean addVehicle(Vehicle vehicle){
        return vehicles.add(vehicle);
    }
    public boolean removeVehicle(Vehicle vehicle){
        return vehicles.remove(vehicle);
    }
    public void displayAllVehicles(){
        System.out.println("Vehicles registered: ");
        for(Vehicle vehicle: vehicles){
            System.out.println(vehicle.toString());
        }
    }
    /*
    public String checkIfVehicleRegistered(int id){
        if(vehicles.equals(id)) return "Vehicle is in the registry";
        return "Vehicle is not in the registry";
    }
     */
}
