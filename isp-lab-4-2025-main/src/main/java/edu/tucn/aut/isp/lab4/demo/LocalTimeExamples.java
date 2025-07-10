package edu.tucn.aut.isp.lab4.demo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeExamples {
    public static void main(String[] args) {
        // 1. get the current time.
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current time: " + currentTime);

        // 2. create a specified time (e.g., 2:30:15 PM).
        LocalTime userInputTime = LocalTime.of(14, 30, 15);
        System.out.println("Specific time: " + userInputTime);

        // 3. parse a time string into a LocalTime object.
        String timeString = "08:45:30";
        LocalTime parsedTime = LocalTime.parse(timeString);
        System.out.println("Parsed time: " + parsedTime);

        // 4. format the current time using a custom pattern.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String formattedTimeString = currentTime.format(formatter);
        System.out.println("Formatted current time: " + formattedTimeString);

        // 5. add 2 hours to the current time and subtract 15 minutes.
        LocalTime timePlusHours = currentTime.plusHours(2);
        LocalTime timeMinusMinutes = currentTime.minusMinutes(15);
        System.out.println("Current time plus 2 hours: " + timePlusHours);
        System.out.println("Current time minus 15 minutes: " + timeMinusMinutes);

        // 6. compare two times.
        if (currentTime.isBefore(userInputTime)) {
            System.out.println("Current time is before the specific time.");
        } else {
            System.out.println("Current time is after or equal to the specific time.");
        }
    }
}
