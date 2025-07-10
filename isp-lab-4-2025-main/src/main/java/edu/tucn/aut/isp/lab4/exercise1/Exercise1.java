package edu.tucn.aut.isp.lab4.exercise1;

import java.time.LocalTime;

public class Exercise1 {
    public static void main(String[] args) {
        LocalTime givenTime = LocalTime.of(17, 31, 50);
        AquariumController controller = new AquariumController("PRSB", "TD", givenTime);
        givenTime = LocalTime.of(17, 41, 24);
        controller.setCurrentTime(givenTime);
        System.out.println(controller);
    }
}
