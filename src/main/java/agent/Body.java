package agent;

import java.awt.*;
import java.util.Random;

public class Body extends Agent{

    private final Color color;
    public Body(double posX, double posY, int size, double mass) {
        super(posX, posY, size, mass);

        //HSL random
        Random rand = new Random();
        final float hue = rand.nextFloat();
        final float saturation = (rand.nextInt(3000) + 1000) / 10000f; // saturation between x1 and x2
        final float luminance = 0.85f;
        color = Color.getHSBColor(hue, saturation, luminance);
    }

    @Override
    public void draw(Graphics2D g2, int cameraX, int cameraY, double screenScale) {
        g2.setColor(color);
        super.draw(g2, cameraX, cameraY, screenScale);
    }
}
