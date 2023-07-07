package core;

public class Vector {
    private double x, y;

    public Vector (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector (Position start, Position end) {
        this.x = end.getX() - start.getX();
        this.y = end.getY() - start.getY();
    }

    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    public void normalize() {
        double length = length();
        x = x == 0 ? 0 : x/length;
        y = y == 0 ? 0 : y/length;
    }

    public void multiply(double value) {
        x *= value;
        y *= value;
    }

    public void add(Vector other) {
        x += other.getX();
        y += other.getY();
    }

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
}
