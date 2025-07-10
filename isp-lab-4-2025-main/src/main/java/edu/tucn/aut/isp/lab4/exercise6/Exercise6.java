package edu.tucn.aut.isp.lab4.exercise6;

import java.time.LocalTime;

public class Exercise6 {
    public static void main(String[] args) {
        FishFeeder feeder = new FishFeeder("RO", "A1", 0);
        feeder.fillUp();
        LocalTime givenTime = LocalTime.now();
        AquariumController aquariumController = new AquariumController(feeder, "TEST", "V2", givenTime, givenTime, 28, 80, 7);
        aquariumController.setFeedingTime(LocalTime.of(16, 0, 0));
        aquariumController.setCurrentTime(LocalTime.of(16, 0, 0));
        PhMonitoring phMonitoring = new PhMonitoring("BO", "0");
        phMonitoring.setValue(8);
        aquariumController.checkPh(phMonitoring, new Alarm("ROS", "V2"));
        phMonitoring.setValue(7);
        aquariumController.checkPh(phMonitoring, new Alarm("ROS", "V2"));
    }
}
