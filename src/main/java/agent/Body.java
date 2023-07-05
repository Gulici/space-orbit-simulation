package agent;

import java.awt.*;
import java.util.Random;

public class Body extends Agent{

    private final Color color;
    public Body(double posX, double posY, int size, double mass) {
        super(posX, posY, size, mass);

        Random rand = new Random();

        //rgb random
//        float r = rand.nextFloat();
//        float g = rand.nextFloat();
//        float b = rand.nextFloat();
//        color = new Color(r, g, b);
//        color.brighter();

        //HSL random
        final float hue = rand.nextFloat();
        // Saturation between 0.1 and 0.3
        final float saturation = (rand.nextInt(3000) + 1000) / 10000f; // saturation between x1 and x2
        final float luminance = 0.85f;
        color = Color.getHSBColor(hue, saturation, luminance);
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(color);
        super.draw(g2);
    }
}
