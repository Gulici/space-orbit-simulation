package display;

import sim.Simulation;

import javax.swing.*;

public class Display extends JFrame {

    private final SimPanel simPanel;
    public Display(Simulation simulation) {
        setTitle("Gravity Simulation");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        simPanel = new SimPanel(simulation);

        add(simPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(Simulation simulation) {
        simPanel.repaint();
    }
}
