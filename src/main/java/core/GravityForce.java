package core;

import agent.Agent;
import sim.Simulation;

import java.util.ArrayList;

public class GravityForce {
    Simulation simulation;

    public GravityForce(Simulation simulation) {
        this.simulation = simulation;
    }

    public void handleForces() {
        //6.6743 * Math.pow(10,-11);
        double g = 0.0001;
        ArrayList<Agent> agents = simulation.getAgents();

        for (Agent agent : agents) {
            Vector force = new Vector(0,0);

            //calculate force
            for (Agent other : agents) {
                if(!agent.equals(other)) {
                    Vector tempVector = new Vector(agent.getPosition(), other.getPosition());
                    double forceValue = (g * agent.getMass() * other.getMass()) / Math.pow(tempVector.length(),2);
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
}
