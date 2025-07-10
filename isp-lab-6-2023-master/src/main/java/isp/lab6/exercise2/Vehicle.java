package isp.lab6.exercise2;

import java.util.Objects;

public class Vehicle {
    private int vin;
    private final String license_plate;
    private final String make;
    private final String model;
    private int year;

    public Vehicle(int vin, String license_plate, String make, String model, int year) {
        this.vin = vin;
        this.license_plate = license_plate;
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public int getVin() {
        return vin;
    }

    public void setVin(int vin) {
        this.vin = vin;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object id) {
        if(this == id) return true;
        if(id == null ||getClass() != id.getClass()) return false;
        Vehicle vehicle = (Vehicle) id;
        System.out.println("Vehicle is in the registry");
        return Objects.equals(vin,vehicle.vin);
    }
    public int hashCode(){
        return Objects.hash(vin);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin=" + vin +
                ", license_plate='" + license_plate + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
