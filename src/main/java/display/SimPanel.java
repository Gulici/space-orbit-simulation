package display;

import agent.Agent;
import sim.Simulation;

import javax.swing.*;
import java.awt.*;

public class SimPanel extends JPanel {

    Simulation simulation;
    public SimPanel(Simulation simulation) {
        int height = 1000;
        int width = 1000;
        this.simulation = simulation;
        setPreferredSize(new Dimension (width,height));
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
        setVisible(true);
        setFocusable(true);
    }

    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2 = (Graphics2D) graphics;

        for (Agent agent : simulation.getAgents()) {
            agent.draw(g2);
        }

        g2.dispose();
    }
}
