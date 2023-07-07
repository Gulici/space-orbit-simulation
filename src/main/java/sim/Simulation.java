package sim;

import agent.Agent;
import agent.Body;
import core.GravityForce;
import core.Position;
import display.Camera;
import input.Input;

import java.util.ArrayList;

public class Simulation {

    private ArrayList<Agent> agents;
    private Input input;
    private Camera camera;
    private GravityForce gravityForce;
    private double screenScale = 1;

    public Simulation() {
        agents = new ArrayList<>();
        input = new Input();
        camera = new Camera(0,0);
        gravityForce = new GravityForce(this);

        initializeAgents();
    }

    private void initializeAgents() {
        Body bigBoy = new Body(0,0, 100, 10000000);
        agents.add(bigBoy);

        Body smol = new Body(200,0,10, 10);
        smol.setVelocity(0,15);
        agents.add(smol);

        Body smol2 = new Body(100,0,10, 10);
        smol2.setVelocity(0,25);
        agents.add(smol2);
    }

    public void update() {
        handleForces();

        for (Agent agent : agents) {
            agent.update();
        }

        handleCameraMovement();
        handleZooming();
    }

    private void handleZooming() {
        if (input.plusPressed) {
            screenScale += 0.01;
        }
        if (input.minusPressed) {
            screenScale -= 0.01;
        }
    }

    private void handleCameraMovement() {
        camera.update(input);
    }

    private void handleForces() {
        gravityForce.handleForces();
    }

    public ArrayList<Agent> getAgents() {
        return agents;
    }
    public Input getInput() {
        return input;
    }
    public Position getCameraPosition() {
        return camera.getPosition();
    }
    public double getScreenScale() {
        return screenScale;
    }
}
