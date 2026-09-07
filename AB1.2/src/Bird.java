import codedraw.CodeDraw;

import java.util.Random;

/**
 * The class {@code Bird} models a simple moving object in a two-dimensional space.
 * <p>
 * A bird has a state (consisting of position and velocity vector).
 * The position determines the current location of the bird, while the velocity describes
 * direction and speed of movement.
 * <p>
 * Birds can update their position over time and may adjust their velocity vector
 * in order to avoid other objects and maintain a minimum distance.
 */
public class Bird {
    private static final Random R = new Random();
    private static final double view = 100;
    private static final double SEP_DIST = 18;
    private static final double W_SEP = 0.7;
    private static final double W_ALI = 0.8;
    private static final double W_COH = 0.6;
    private static final double MAX_V = 3.0;   // max speed (max length of velocity vector)
    private static final double MAX_F = 0.1;   // max steering power

    private State state;
    private World livesIn;

    /**
     * Creates a new bird with an initial position and velocity in the given world.
     *
     * @param position the initial position; {@code position != null}
     * @param velocity the initial velocity; {@code velocity != null}
     * @param livesIn  the world the bird lives in; {@code livesIn != null}
     */
    public Bird(Vector2D position, Vector2D velocity, World livesIn) {
        this.state = new State(position, velocity);
        this.livesIn = livesIn;
    }

    /**
     * Computes the steering force based on the given array of birds and updates
     * this bird's position and velocity (use {@link ApplicationVector2D} to see how this works).
     *
     * <p>This method modifies {@code this}. It does not modify other birds.</p>
     *
     * @param birds the array of all birds in the simulation including {@code this};
     *              {@code birds != null}
     */
    public void calculateSteering(Bird[] birds) {
        Vector2D separation = new Vector2D(0, 0);
        Vector2D alignment = new Vector2D(0, 0);
        Vector2D cohesion = new Vector2D(0, 0);
        int count = 0;

        for (Bird other : birds) {
            if (other == this) {
                continue;
            }

            double dx = other.state.getPosition().getX() - this.state.getPosition().getX();
            double dy = other.state.getPosition().getY() - this.state.getPosition().getY();
            double d2 = dx * dx + dy * dy;

            if (d2 < view * view) {
                count++;
                alignment = alignment.add(other.state.getVelocity());
                cohesion = cohesion.add(other.state.getPosition());

                if (d2 < SEP_DIST * SEP_DIST) {
                    double d = Math.sqrt(d2) + 1e-12;
                    separation = separation.subtract(new Vector2D(dx, dy).scale(1.0 / d));
                }
            }
        }

        Vector2D steer = new Vector2D(0, 0);

        if (count > 0) {
            Vector2D alignmentDir = alignment.scale(1.0 / count).normalize().scale(MAX_V).subtract(this.state.getVelocity());
            Vector2D center = cohesion.scale(1.0 / count);
            Vector2D cohesionDir = center.subtract(this.state.getPosition()).normalize().scale(MAX_V).subtract(this.state.getVelocity());
            Vector2D separationDir = separation.normalize().scale(MAX_V).subtract(this.state.getVelocity());

            steer = steer
                    .add(separationDir.scale(W_SEP))
                    .add(alignmentDir.scale(W_ALI))
                    .add(cohesionDir.scale(W_COH));

            if (steer.length() > MAX_F) {
                steer = steer.normalize().scale(MAX_F);
            }

            Vector2D newVelocity = this.state.getVelocity().add(steer);
            if (newVelocity.length() > MAX_V) {
                newVelocity = newVelocity.normalize().scale(MAX_V);
            }

            Vector2D newPosition = this.state.getPosition().add(newVelocity);

            State newState = new State(newPosition, newVelocity);
            newState = livesIn.worldInfluence(newState);
            this.state = newState;

        }
    }

    /**
     * Draws this bird onto the given {@link CodeDraw} canvas (use {@link ApplicationVector2D} to see how this works).
     *
     * <p>The bird is rendered as a small filled circle at its position and a short line
     * ("nose") indicating its current direction of movement.</p>
     *
     * @param cd the CodeDraw canvas to draw on; {@code cd != null}
     */
    public void draw(CodeDraw cd) {
        Vector2D position = this.state.getPosition();
        cd.fillCircle(position.getX(), position.getY(), 2.2);
        Vector2D nose = position.add(position.normalize().scale(7));
        cd.drawLine(position.getX(), position.getY(), nose.getX(), nose.getY());
    }
}
