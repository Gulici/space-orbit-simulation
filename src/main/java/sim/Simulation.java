package sim;

import agent.Agent;
import agent.Body;
import core.Position;
import core.Vector;
import display.Camera;
import input.Input;

import java.util.ArrayList;

public class Simulation {

    private ArrayList<Agent> agents;
    private Input input;
    private Camera camera;
    private final double G = 0.0001; //6.6743 * Math.pow(10,-11);
    private double screenScale = 1;

    public Simulation() {
        agents = new ArrayList<>();
        input = new Input();
        camera = new Camera(0,0);

        //agents.add(new Body(700,500,90,999999999));

        agents.add(new Body(0,0,100, 1999999999));

//        Body body1 = new Body(500,250,10,100);
//        body1.setVelocity(150,0);
//        agents.add(body1);
//
//        Body komar = new Body(600,500,5,1);
//        komar.setVelocity(0,250);
//        agents.add(komar);
//
//        Body komar2 = new Body(650,500,5,1);
//        komar2.setVelocity(0,275);
//        agents.add(komar2);
//
//        Body body2 = new Body(200,100,10,100);
//        body2.setVelocity(100,0);
//        agents.add(body2);
//
//        Body body3 = new Body(200,300,15,10000);
//        body3.setVelocity(-55,-75);
//        agents.add(body3);
//
//        Body body5 = new Body(200,200,40,100000000);
//        body5.setVelocity(-20,-50);
//        agents.add(body5);
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
        for (Agent agent : agents) {
            Vector force = new Vector(0,0);

            //calculate force
            for (Agent other : agents) {
                if(!agent.equals(other)) {
                    Vector tempVector = new Vector(agent.getCenterPosition(), other.getCenterPosition());
                    double forceValue = (G * agent.getMass() * other.getMass()) / Math.pow(tempVector.length(),2);
                    tempVector.normalize();
                    tempVector.multiply(forceValue);

                    force.add(tempVector);
                }
            }

            //calculate acceleration
            double accelValue = force.length()/agent.getMass();
            force.normalize();
            force.multiply(accelValue);
            agent.setAcceleration(force);
        }
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
