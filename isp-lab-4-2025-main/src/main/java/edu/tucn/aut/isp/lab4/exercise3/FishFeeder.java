package edu.tucn.aut.isp.lab4.exercise3;

public class FishFeeder {
    private final String manufacturer;
    private final String model;
    private int meals;

    public FishFeeder(String manufacturer, String model, int meals) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.meals = meals;
    }

    public void feed() {
        if(meals < 1) {
            System.out.println("No meals available!");
            return;
        }
        meals--;
        System.out.println("One meal is fed to the fish. Meals left: " + meals);
    }
    public void fillUp() {
        meals = 14;
        System.out.println("The " + model + " from " + manufacturer + " fish feeder is filled up.");
    }
    @Override
    public String toString() {
        return "FishFeeder specifications: manufacturer - " + manufacturer + " | model - " + model + " | meals - " + meals;
    }

    public int getMeals() {
        return meals;
    }
}
