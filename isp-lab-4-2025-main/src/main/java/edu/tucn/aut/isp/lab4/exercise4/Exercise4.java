package edu.tucn.aut.isp.lab4.exercise4;

import java.time.LocalTime;

public class Exercise4 {
    public static void main(String[] args) {
        Lights lights = new Lights();
        FishFeeder fishFeeder = new FishFeeder("As", "x2", 14);
        LocalTime givenTime = LocalTime.of(13, 0, 0);
        AquariumController aquariumController = new AquariumController("ttt", "io", givenTime, givenTime, fishFeeder, lights);
        aquariumController.setCurrentTime(LocalTime.of(15, 0, 0));
        aquariumController.setCurrentTime(LocalTime.of(21, 0, 0));
        aquariumController.setCurrentTime(LocalTime.of(23, 0, 0));
    }
}
