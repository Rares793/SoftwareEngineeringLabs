package edu.tucn.aut.isp.lab4.exercise3;

import java.time.LocalTime;

public class Exercise3 {
    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("T2", "x2", 10);
        fishFeeder.fillUp();
        LocalTime givenTime = LocalTime.of(17, 31, 50);
        AquariumController aquariumController = new AquariumController("Ter", "42", givenTime, givenTime, fishFeeder);
        LocalTime feedingTime = LocalTime.of(17, 31, 50);
        aquariumController.setCurrentTime(feedingTime);
    }
}
