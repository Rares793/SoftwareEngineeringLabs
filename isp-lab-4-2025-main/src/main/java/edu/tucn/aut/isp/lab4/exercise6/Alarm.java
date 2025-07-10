package edu.tucn.aut.isp.lab4.exercise6;

public class Alarm extends Actuator {
    Alarm(String manufacturer, String model) {
        super(manufacturer, model);
    }
    @Override
    public void turnOn() {
        System.out.println("Alarm is turned on!");
        super.turnOn();
    }

    @Override
    public void turnOff() {
        System.out.println("Alarm is turned off!");
        super.turnOff();
    }

    public boolean isOn() {
        return super.isOn();
    }
}
