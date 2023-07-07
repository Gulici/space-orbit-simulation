package agent;

import core.Position;
import core.Vector;

import java.awt.*;

public abstract class Agent {
    private Position position;
    private final int size;
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
        double x = position.getX();
        double y = position.getY();

        //find position on screen
        int screenX = (int)((x - cameraX ) * screenScale);
        int screenY = (int)((y - cameraY ) * screenScale);
        int scaledSize = (int) Math.round(size * screenScale);

        g2.fillOval(screenX - scaledSize/2, screenY - scaledSize/2, scaledSize , scaledSize);
    }

    public Position getPosition() {
        return position;
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
