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
    public void draw(Graphics2D g2) {
        g2.fillOval(position.getIntX(), position.getIntY(), size , size);
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
