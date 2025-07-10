package isp.lab10.raceapp;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class CarRace {
    public static void main(String[] args) {
        startRace();
    }
    public static void startRace() {
        JFrame frame = new JFrame("Car Race");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CarPanel carPanel = new CarPanel();
        frame.getContentPane().add(carPanel);
        frame.pack();
        frame.setSize(500,300);
        frame.setVisible(true);

        Car car1 = new Car("Red car", carPanel);
        Car car2 = new Car("Blue car", carPanel);
        Car car3 = new Car("Green car", carPanel);
        Car car4 = new Car("Yellow car", carPanel);
        car1.start();
        car2.start();
        car3.start();
        car4.start();
    }
}

class Car extends Thread {
    private final String name;
    private int distance = 0;
    private final CarPanel carPanel;

    public Car(String name, CarPanel carPanel) {
        setName(name);
        this.name = name;
        this.carPanel = carPanel;
    }

    public void run() {
        while (distance < 400) {
            int speed = (int) (Math.random() * 10) + 1;
            distance += speed;
            carPanel.updateCarPosition(name, distance);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        carPanel.carFinished(name);
    }
}

class CarPanel extends JPanel {
    private final int[] carPositions;
    private final String[] carNames;
    private final Color[] carColors;
    private static volatile int carsFinished = 0;
    private static final ArrayList<String> finishOrder = new ArrayList<>();
    private static final Map<String, Long> finishTimes = new HashMap<>();

    public CarPanel() {
        carPositions = new int[4];
        carNames = new String[]{"Red car", "Blue car", "Green car", "Yellow car"};
        carColors = new Color[]{Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW};
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < 4; i++) {
            int yPos = 50 + i * 50; // Vertical position of the car
            int xPos = carPositions[i]; // Horizontal position of the car
            int carSize = 30; // Size of the car

            g.setColor(carColors[i]);
            g.fillOval(xPos, yPos, carSize, carSize);
            g.setColor(Color.BLACK);
            g.drawString(carNames[i], xPos, yPos - 5);
        }
    }

    public static void printStandings(long raceStartTime) {
        System.out.println("=== Final Standings ===");
        for (int i = 0; i < finishOrder.size(); i++) {
            String carName = finishOrder.get(i);
            long duration = finishTimes.get(carName) - raceStartTime;
            System.out.printf("%d. %s - Time: %.2f seconds%n", i + 1, carName, duration / 1000.0);
        }
    }

    public void updateCarPosition(String carName, int distance) {
        int carIndex = getCarIndex(carName);
        if (carIndex != -1) {
            carPositions[carIndex] = distance;
            repaint();
        }
    }

    public synchronized void carFinished(String carName) {
        long finishTime = System.currentTimeMillis();
        if (!finishOrder.contains(carName)) {
            finishOrder.add(carName);
            finishTimes.put(carName, finishTime);
            carsFinished++;
            System.out.println(carName + " finished race.");
        }
    }

    private int getCarIndex(String carName) {
        for (int i = 0; i < 4; i++) {
            if (carNames[i].equals(carName)) {
                return i;
            }
        }
        return -1;
    }

    public static int getCarsFinished() {
        return carsFinished;
    }
}
