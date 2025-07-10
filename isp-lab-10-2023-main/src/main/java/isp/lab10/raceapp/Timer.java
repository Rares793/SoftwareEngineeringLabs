package isp.lab10.raceapp;

public class Timer extends Thread {
    private boolean isRunning = true;
    private long count = 0;

    @Override
    public void run() {
        long lastTime = System.currentTimeMillis();
        while (isRunning) {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - lastTime;
            if (elapsedTime >= 10) {
                count += elapsedTime / 10;
                lastTime += (elapsedTime / 10) * 10;
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stopTimer() {
        isRunning = false;
    }

    public long getCount() {
        return count;
    }

    public double getCountInSeconds() {
        return count * 10 / 1000.0;
    }
}

