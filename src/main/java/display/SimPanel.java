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
        //change origin point from 0,0 to center of the screen
        graphics.translate(width/2,height/2);
        Graphics2D g2 = (Graphics2D) graphics;
        Position cameraPos = simulation.getCameraPosition();

        int cameraX = cameraPos.getIntX();
        int cameraY = cameraPos.getIntY();

        drawCordLine(g2, cameraX, cameraY);

        for (Agent agent : simulation.getAgents()) {
            agent.draw(g2, cameraX, cameraY, simulation.getScreenScale());
        }

        //print center of the screen's coordinates
        String camPos = "xy: " + cameraPos.getX() + " " + cameraPos.getY();
        g2.setColor(Color.white);
        g2.drawString(camPos,(int)(width*0.4),(int)(height*0.48));

        g2.dispose();
    }

    private void drawCordLine(Graphics2D g2, int cameraX, int cameraY) {
        g2.setColor(Color.lightGray);
        int lineLenght = 10000;
        int screenX12 = (int) Math.floor((-cameraX) * simulation.getScreenScale());
        int screenY11 = (int) Math.floor((-lineLenght - cameraY) * simulation.getScreenScale());
        int screenY12 = (int) Math.floor((lineLenght - cameraY) * simulation.getScreenScale());

        int screenY21 = (int) Math.floor((-cameraY) * simulation.getScreenScale());
        int screenX21 = (int) Math.floor((-lineLenght - cameraX) * simulation.getScreenScale());
        int screenX22 = (int) Math.floor((lineLenght - cameraX) * simulation.getScreenScale());

        g2.drawLine(screenX12,screenY11, screenX12, screenY12);
        g2.drawLine(screenX21,screenY21, screenX22, screenY21);
    }
}
