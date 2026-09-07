import java.util.ArrayList;
import java.util.List;

/**
 * Exception indicating that a complete simulation step failed because one
 * or more unresolved collisions occurred.
 *
 * <p>A {@code SimulationStepException} aggregates all
 * {@link UnresolvedCollisionException}s that occurred during a single
 * simulation step.</p>
 *
 * <p>The contained exceptions are stored in a predefined Java collection.
 * The list returned by {@link #getCollisions()} is independent of the
 * internal representation of this exception.</p>
 */
public class SimulationStepException extends StepException {

    private final List<UnresolvedCollisionException> collisions;

    /**
     * Creates a new simulation step exception.
     *
     * @param step the simulation step in which the failure occurred;
     *             {@code step >= 0}
     * @param collisions the unresolved collisions that occurred during
     *                   the simulation step; {@code collisions != null}
     *                   and no element is {@code null}
     */
    public SimulationStepException(
            int step,
            List<UnresolvedCollisionException> collisions) {

        super(step);
        this.collisions = new ArrayList<>(collisions);
    }

    /**
     * Returns all unresolved collisions that occurred during the failed
     * simulation step.
     *
     * <p>The returned list is independent of the internal representation
     * of this exception. Modifications to the returned list do not affect
     * this exception.</p>
     *
     * @return all unresolved collisions of the failed simulation step
     */
    public List<UnresolvedCollisionException> getCollisions() {
        return new ArrayList<>(this.collisions);
    }

    /**
     * Returns the number of unresolved collisions that occurred during the
     * failed simulation step.
     *
     * @return the number of unresolved collisions
     */
    public int collisionCount() {
        return this.collisions.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append(":").append(System.lineSeparator());
        for (UnresolvedCollisionException exception : collisions) {
            sb.append(exception.toString());
        }
        return sb.toString();
    }
}