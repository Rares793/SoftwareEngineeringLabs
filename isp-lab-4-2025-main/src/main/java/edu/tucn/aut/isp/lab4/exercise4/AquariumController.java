package edu.tucn.aut.isp.lab4.exercise4;

import java.time.LocalTime;

public class AquariumController {
    private final String manufacturer;
    private final String model;
    private int lightOnTime = 0;
    private int lightOffTime = 24;
    private LocalTime currentTime;
    private final LocalTime feedingTime;
    private final FishFeeder fishFeeder;
    private final Lights lights;

    AquariumController(String manufacturer, String model, LocalTime currentTime, LocalTime feedingTime, FishFeeder fishFeeder, Lights lights) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
        this.fishFeeder = fishFeeder;
        this.lights = lights;
    }

    public void setCurrentTime(LocalTime currentTime) {
        int timeDifference = Math.abs(this.currentTime.getHour() - currentTime.getHour());
        this.currentTime = currentTime;
        if(!currentTime.isBefore(feedingTime)) {
            System.out.println("Time for feeding!");
            fishFeeder.feed();
        }
        if(lightOnTime >= 7) {
            lights.turnOff();
        } else {
            lights.turnOn();
            lightOnTime += timeDifference;
            lightOffTime -= timeDifference;
        }

        if(lightOnTime > 24) {
            lightOnTime = 24;
        } else if(lightOnTime < 0) {
            lightOnTime = 0;
        }
        if(lightOffTime > 24) {
            lightOffTime = 24;
        } else if(lightOffTime < 0) {
            lightOffTime = 0;
        }
        System.out.println("Aquarium lights turned on time: " + lightOnTime);
        System.out.println("Aquarium lights turned off time: " + lightOffTime);
    }

    @Override
    public String toString() {
        return "AquariumController specifications: manufacturer - " + manufacturer + " | model - " + model + " | currentTime - " + currentTime + " | feedingTime - " + feedingTime;
    }

    public int getLightOnTime() {
        return lightOnTime;
    }
    public int getLightOffTime() {
        return lightOffTime;
    }
}
