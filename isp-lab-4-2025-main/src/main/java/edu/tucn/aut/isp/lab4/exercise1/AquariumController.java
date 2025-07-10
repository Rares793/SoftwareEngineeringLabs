package edu.tucn.aut.isp.lab4.exercise1;

import java.time.LocalTime;

public class AquariumController {
    private final String manufacturer;
    private final String model;
    private LocalTime currentTime;
    AquariumController(String manufacturer, String model, LocalTime currentTime) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
    }

    @Override
    public String toString() {
        return "AquariumController specifications: manufacturer - " + manufacturer + " | model - " + model + " | currentTime - " + currentTime;
    }
}
