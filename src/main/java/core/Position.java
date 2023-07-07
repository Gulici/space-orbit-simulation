package core;

public class Position {
    private double x;
    private double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void applyMotion(Vector velocity) {
        x += velocity.getX()/60;
        y += velocity.getY()/60;
    }

    public double getX() {
        return x;
    }
    public void setX(double x) {
        this.x = x;
    }
    public double getY() {
        return y;
    }
    public void setY(double y) {
        this.y = y;
    }
    public int getIntX() {
        return (int) Math.round(x);
    }
    public int getIntY() {
        return (int) Math.round(y);
    }
}
