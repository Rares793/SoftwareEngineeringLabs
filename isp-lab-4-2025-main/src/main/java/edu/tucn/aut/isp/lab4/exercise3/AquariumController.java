package edu.tucn.aut.isp.lab4.exercise3;

import java.time.LocalTime;

public class AquariumController {
    private final String manufacturer;
    private final String model;
    private LocalTime currentTime;
    private final LocalTime feedingTime;
    private final FishFeeder fishFeeder;

    AquariumController(String manufacturer, String model, LocalTime currentTime, LocalTime feedingTime, FishFeeder fishFeeder) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
        this.fishFeeder = fishFeeder;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
        if(!currentTime.isBefore(feedingTime)) {
            System.out.println("Time for feeding!");
            fishFeeder.feed();
        }
    }

    @Override
    public String toString() {
        return "AquariumController specifications: manufacturer - " + manufacturer + " | model - " + model + " | currentTime - " + currentTime + " | feedingTime - " + feedingTime;
    }
}
