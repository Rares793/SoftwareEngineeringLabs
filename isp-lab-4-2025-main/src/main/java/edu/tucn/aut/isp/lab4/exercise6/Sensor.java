package edu.tucn.aut.isp.lab4.exercise6;

public abstract class Sensor {
    protected String manufacturer;
    protected String model;

    @Override
    public String toString() {
        return "Sensor manufacturer: " + manufacturer + " | model: " + model;
    }
}
