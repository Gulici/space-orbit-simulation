package display;

import core.Position;
import input.Input;

public class Camera {
    private Position position;
    private final int cameraSpeed = 10;
    public Camera(double x, double y) {
        position = new Position(x,y);
    }
    public void update(Input input) {


        double x = position.getX();
        double y = position.getY();

        if(input.rightPressed) {
            x += cameraSpeed;
        }
        if(input.leftPressed) {
            x -= cameraSpeed;

        }
        if (input.downPressed) {
            y += cameraSpeed;

        }
        if (input.upPressed) {
            y -= cameraSpeed;
        }

        position.setX(x);
        position.setY(y);

        //System.out.println(position.getX() + " "  + position.getY());
    }

    public Position getPosition() {
        return position;
    }
}
