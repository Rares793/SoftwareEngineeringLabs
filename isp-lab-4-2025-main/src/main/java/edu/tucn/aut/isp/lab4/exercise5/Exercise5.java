package edu.tucn.aut.isp.lab4.exercise5;

import java.time.LocalTime;

public class Exercise5 {
    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("PRSB", "21", 0);
        fishFeeder.fillUp();
        LocalTime givenTime = LocalTime.of(13, 18, 0);
        AquariumController aquariumController = new AquariumController(fishFeeder, "PRSB", "21", givenTime, givenTime, 26, 80);
        aquariumController.setFeedingTime(LocalTime.of(14, 0, 0));
        aquariumController.setCurrentTime(LocalTime.of(14, 0, 0));
        LevelSensor levelSensor = new LevelSensor("PROB", "L1");
        levelSensor.setValue(79);
        TemperatureSensor temperatureSensor = new TemperatureSensor("PROB", "T1");
        temperatureSensor.setValue(26.5f);
        Actuator heater = new Heater("Bosch", "H1");
        Actuator alarm = new Alarm("Bosch", "A1");
        aquariumController.checkTemperature(temperatureSensor, heater);
        aquariumController.checkWaterLevel(levelSensor, alarm);
    }
}
