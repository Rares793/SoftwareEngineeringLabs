package edu.tucn.aut.isp.lab4.exercise4;

public class Lights {
    private boolean isOn;

    public void turnOn() {
        isOn = true;
        System.out.println("Turning the light ON!");
    }
    public void turnOff() {
        isOn = false;
        System.out.println("Turning the light OFF!");
    }
    public boolean getIsOn() {
        return isOn;
    }
}
