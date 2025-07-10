package edu.tucn.aut.isp.lab4.exercise6;

import java.time.LocalTime;

public class AquariumController {
    private final FishFeeder feeder;
    private final String manufacturer;
    private final String model;
    private LocalTime currentTime;
    private LocalTime feedingTime;
    private final int presetTemperature;
    private final float presetLevel;
    private final float presetPh;

    AquariumController(FishFeeder feeder, String manufacturer, String model, LocalTime currentTime, LocalTime feedingTime, int presetTemperature, float presetLevel, float presetPh) {
        this.feeder = feeder;
        this.manufacturer = manufacturer;
        this.model = model;
        this.currentTime = currentTime;
        this.feedingTime = feedingTime;
        this.presetTemperature = presetTemperature;
        this.presetLevel = presetLevel;
        this.presetPh = presetPh;
    }

    public void setCurrentTime(LocalTime currentTime) {
        this.currentTime = currentTime;
        if(!currentTime.isBefore(feedingTime)) {
            System.out.println("Time for feeding!");
            feeder.feed();
        }
    }
    public void setFeedingTime(LocalTime feedingTime) {
        this.feedingTime = feedingTime;
    }
    public void checkTemperature(TemperatureSensor temperatureSensor, Actuator heater) {
        if(temperatureSensor.getValue() < presetTemperature) {
            heater.turnOn();
        } else {
            heater.turnOff();
        }
    }
    public void checkWaterLevel(LevelSensor levelSensor, Actuator alarm) {
        if(levelSensor.getValue() < presetLevel) {
            alarm.turnOn();
        } else {
            alarm.turnOff();
        }
    }
    public void checkPh(PhMonitoring phMonitoring, Actuator alarm) {
        float inputPh = phMonitoring.getValue();
        if(inputPh >= presetPh - 1 && inputPh <= presetPh + 1) {
            alarm.turnOff();
            phMonitoring.setValue(presetLevel); // Controlling the pH
        } else {
            alarm.turnOn();
        }
    }

    @Override
    public String toString() {
        return "AquariumController specifications: manufacturer - " + manufacturer + " | model - " + model + " | currentTime - " + currentTime + " | feedingTime - " + feedingTime;
    }
}
