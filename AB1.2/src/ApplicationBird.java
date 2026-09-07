import codedraw.CodeDraw;

import java.util.Random;

public class ApplicationBird {
    static void main(String[] args) {
        final Random R = new Random(2026);
        final int w = 900;
        final int h = 600;
        Vector2D gustPosition = new Vector2D(R.nextDouble() * w, R.nextDouble() * h);
        Vector2D gustVelocity = new Vector2D(R.nextDouble() * 2 - 1, R.nextDouble() * 2 - 1).normalize().scale(1 + R.nextDouble() * 2);
        WindGust windGust = new WindGust(gustPosition, gustVelocity, 100);

        World world = new World(w, h, windGust);
        CodeDraw cd = new CodeDraw(world.getW(), world.getH());

        Bird[] birds = new Bird[250];

        for (int i = 0; i < birds.length; i++) {
            Vector2D position = new Vector2D(R.nextDouble() * world.getW(), R.nextDouble() * world.getH());
            Vector2D velocity = new Vector2D(R.nextDouble() * 2 - 1, R.nextDouble() * 2 - 1).normalize().scale(1 + R.nextDouble() * 2);
            birds[i] = new Bird(position, velocity, world);
        }

        while (true) {
            cd.clear();
            for (Bird bird : birds) {
                bird.calculateSteering(birds);
                bird.draw(cd);
            }
            cd.show();
        }
    }
}
