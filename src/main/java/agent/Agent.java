package agent;

import core.Position;
import core.Vector;

import java.awt.*;

public abstract class Agent {
    private Position position;
    private int size;
    private final double mass;

    private Vector velocity;
    private Vector acceleration;

    public Agent(double posX, double posY, int size, double mass) {

        this.position = new Position(posX,posY);
        this.size = size;
        this.mass = mass;

        this.velocity = new Vector(0,0);
        this.acceleration = new Vector(0,0);
    }

    public void update() {
        handleAcceleration();
        handleMotion();
    }
    private void handleAcceleration() {
        velocity.setX(velocity.getX() + acceleration.getX());
        velocity.setY(velocity.getY() + acceleration.getY());
    }

    public void handleMotion() {
        position.applyMotion(velocity);
    }
    public void draw(Graphics2D g2,int cameraX, int cameraY, double screenScale) {
        //find position on screen
        double x = position.getX();
        double y = position.getY();

        double screenX = (x - cameraX) * screenScale;
        double screenY = (y - cameraY) * screenScale;



        int intScreenX = (int) Math.round(screenX);
        int intScreenY = (int) Math.round(screenY);

        int scaledSize = (int) Math.round(size * screenScale);

        g2.fillOval(intScreenX, intScreenY, scaledSize , scaledSize);
    }

    public Position getCenterPosition() {
        int centerX = position.getIntX() + size/2;
        int centerY = position.getIntY() + size/2;
        return new Position(centerX,centerY);
    }

    public double getMass() {
        return mass;
    }

    public void setAcceleration(Vector acceleration) {
        this.acceleration = acceleration;
    }

    public double getAccelerationValue() {
        return acceleration.length();
    }

    public void setVelocity(double x, double y) {
        velocity = new Vector(x,y);
    }
}
