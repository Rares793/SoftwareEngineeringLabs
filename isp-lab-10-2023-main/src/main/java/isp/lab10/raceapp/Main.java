package isp.lab10.raceapp;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Timer raceTimer = new Timer();
        PlaySound playSound = new PlaySound();
        Semaphore.startSemaphore();

        long raceStartTime = System.currentTimeMillis();
        raceTimer.start();

        CarRace.startRace();

        playSound.playSound();
        while(true) {
            if(CarPanel.getCarsFinished() >= 4) {
                raceTimer.stopTimer();
                playSound.stopSound();
                System.out.println("All cars finished.\n");
                CarPanel.printStandings(raceStartTime);
                System.out.printf("Measured race time by thread: %.2f seconds -> %d counts each 10ms%n", raceTimer.getCountInSeconds(), raceTimer.getCount());
                break;
            }
        }
    }
}


