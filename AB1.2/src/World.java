/**
 * Represents the simulation world in which birds move.
 *
 * <p>
 * The world is defined as a rectangular region with width {@code w}
 * and height {@code h}. It applies boundary rules to states that
 * leave this region.
 * </p>
 */
public class World {

    private final int w;
    private final int h;
    private final WindGust windGust;

    /**
     * Creates a new world with the given dimensions.
     *
     * @param w the width of the world; {@code w > 0}
     * @param h the height of the world; {@code h > 0}
     */
    public World(int w, int h, WindGust windGust) {
        this.w = w;
        this.h = h;
        this.windGust = windGust;
    }

    /**
     * Applies the influence of the world to the given state.
     *
     * <p>
     * This includes:
     * <ul>
     *   <li>boundary handling (e.g. reflection or wrapping)</li>
     *   <li>the influence of wind gusts</li>
     *   <li>...</li>
     * </ul>
     *
     * The position and/or velocity of the state may be modified.
     * </p>
     *
     * @param s the state to be influenced; {@code s != null}
     * @return a new {@link State} representing the influenced state
     */
    public State worldInfluence(State s) {
        State newState = enforceBoundary(s);

        newState = windGust.apply(newState);

        return newState;
    }

    /**
     * Applies the world's boundary rule to the given state.
     *
     * <p>
     * If the position lies outside the world, it is wrapped to the
     * opposite side (torus topology). The velocity remains unchanged
     * (see also {@link ApplicationVector2D}).
     * </p>
     *
     * @param s the state to be adjusted; {@code s != null}
     * @return a new {@link State} whose position lies inside the world
     */
    private State enforceBoundary(State s) {
        double x = s.getPosition().getX();
        double y = s.getPosition().getY();

        if (x < 0) x += w;
        if (y < 0) y += h;
        if (x >= w) x -= w;
        if (y >= h) y -= h;

        return new State(new Vector2D(x, y), s.getVelocity());
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }
}