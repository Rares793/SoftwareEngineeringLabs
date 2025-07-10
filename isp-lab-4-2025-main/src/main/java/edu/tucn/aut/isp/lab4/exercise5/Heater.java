package edu.tucn.aut.isp.lab4.exercise5;

public class Heater extends Actuator {
    Heater(String manufacturer, String model) {
        super(manufacturer, model);
    }
    @Override
    public void turnOn() {
        System.out.println("Heater is turned on!");
        super.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Heater is turned off!");
        super.turnOff();
    }
    @Override
    public boolean isOn() {
        return super.isOn();
    }
}
