package edu.tucn.aut.isp.lab4.exercise2;

public class Exercise2 {
    public static void main(String[] args) {
        FishFeeder fishFeeder = new FishFeeder("RTN", "V2", 5);
        fishFeeder.fillUp();
        for(int i = 0; i < 15; i++) {
            fishFeeder.feed();
        }
    }
}
