package edu.tucn.aut.isp.lab4.exercise5;

public class Actuator {
    private final String manufacturer;
    private final String model;
    private boolean on;

    Actuator(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public void turnOn() {
        System.out.println("Actuator is turned on!");
        on = true;
    }
    public void turnOff() {
        System.out.println("Actuator is turned off!");
        on = false;
    }
    @Override
    public String toString() {
        return "Actuator manufacturer: " + manufacturer + " | model: " + model;
    }

    public boolean isOn() {
        return on;
    }
}
