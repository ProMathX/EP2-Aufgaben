public class Vector {

    private final double[] coordinates;

    public Vector(int dimensions) {
        coordinates = new double[dimensions];
    }

    /**
     * Adds one vector of n dimensions to another vector with n dimensions.
     * n need to be the same.
     * @param other the other vector that should be added to this vector.
     * @return a new vector with the other vector added to this.
     */
    public Vector add(Vector other) {
        if (coordinates.length != other.coordinates.length) {
            return null;
        }

        Vector newVector = new Vector(coordinates.length);

        for (int i = 0; i < coordinates.length; i++) {
            newVector.coordinates[i] = coordinates[i] + other.coordinates[i];
        }

        return newVector;
    }
}
