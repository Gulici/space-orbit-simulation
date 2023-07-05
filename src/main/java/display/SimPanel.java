package display;

import agent.Agent;
import core.Position;
import sim.Simulation;

import javax.swing.*;
import java.awt.*;

public class SimPanel extends JPanel {

    Simulation simulation;
    int height = 1000;
    int width = 1000;
    public SimPanel(Simulation simulation) {
        int height = 1000;
        int width = 1000;
        this.simulation = simulation;
        setPreferredSize(new Dimension (width,height));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        addKeyListener(simulation.getInput());
        setVisible(true);
        setFocusable(true);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2 = (Graphics2D) graphics;
        Position cameraPos = simulation.getCameraPosition();

        for (Agent agent : simulation.getAgents()) {
            agent.draw(g2, cameraPos);
        }
        String camPos = "xy: " + cameraPos.getX() + " " + cameraPos.getY();
        g2.setColor(Color.white);
        g2.drawString(camPos, 880, 990);

        g2.dispose();
    }
}
