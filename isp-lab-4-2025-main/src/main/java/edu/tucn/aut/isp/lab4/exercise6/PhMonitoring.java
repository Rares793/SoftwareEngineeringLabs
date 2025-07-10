package edu.tucn.aut.isp.lab4.exercise6;

public class PhMonitoring extends Sensor {
    private float value;

    PhMonitoring(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public float getValue() {
        return value;
    }
    public void setValue(float value) {
        this.value = value;
    }
}
