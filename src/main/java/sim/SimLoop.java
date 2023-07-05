package sim;

import display.Display;

public class SimLoop implements Runnable {

    Simulation simulation;
    Display display;
    Thread thread;
    private final int tps = 60;

    public SimLoop() {
        simulation = new Simulation();
        display = new Display(simulation);
        startThread();
    }

    private void startThread() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long currentTime, deltaTime = 0, deltaAccumulated = 0;
        double tickInterval = (double) 1000000000 / tps;
        long timer = 0;
        int tpsCounter = 0;
        int fpsCounter = 0;

        while (thread.isAlive()){

            currentTime = System.nanoTime();
            deltaTime = (currentTime - lastTime);
            deltaAccumulated += deltaTime;
            timer += deltaTime;
            lastTime = currentTime;

            while (deltaAccumulated >= tickInterval) {
                deltaAccumulated -= tickInterval;
                tpsCounter++;
                simulation.update();
            }

            display.render(simulation);
            fpsCounter++;

            if (timer >= 1000000000) {
                System.out.println("TPS:" + tpsCounter + " FPS:" + fpsCounter);
                tpsCounter = 0;
                fpsCounter = 0;
                timer = 0;
            }
        }
    }
}
