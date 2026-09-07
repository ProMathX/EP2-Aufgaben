import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * A {@code Stick} has a specified stick weight, that can not be changed after
 * initialisation. Mobiles can be attached to the stick (recursive structure).
 * {@code Stick} implements {@link Mobile}.
 * You can assume that no part of a mobile has the same identity as another part.
 */
//
// TODO: Complete the methods in 'Stick'.
//       You can define further classes and methods for the implementation.
//       You may use the Java-Collection framework.
//
public class Stick implements Mobile // TODO: uncomment clause.
{
    private final int stickWeight;
    private final Mobile[] attached;

    //TODO: define missing parts of the class.

    /**
     * Initialises {@code this}; throws an {@link StickBreaksException} if the sum of the weight of
     * all mobiles in the array {@code attached} is greater than 10 times the {@code stickWeight}.
     * The detail message of the exception is "Stick breaks!".
     *
     * @param stickWeight the weight of this stick (without attached mobiles),
     *                    {@code stickWeight > 0}.
     * @param attached    an array with all the mobiles directly attached to this stick.
     *                    Precondition: {@code attached != null && attached.length > 1} and for any two mobiles
     *                    m1 and m2 being part of {@code attached} (including sub-mobiles) it holds that
     *                    {@code m1.equals(m2) == false}, this is, there are no duplicates anywhere
     *                    in a mobile.
     * @throws StickBreaksException if the sum of the weight of all mobiles in the array
     *                              {@code attached} is greater than 10 times the {@code stickWeight}.
     */
    public Stick(int stickWeight, Mobile[] attached) throws StickBreaksException {

        this.stickWeight = stickWeight;
        int totalWeight = 0;
        for (Mobile m : attached) {
            totalWeight += m.getWeight();
        }
        if (totalWeight > 10 * stickWeight) {
            throw new StickBreaksException();
        }
        this.attached = attached;

        // TODO: implement constructor.
    }

    /**
     * Replaces the mobile equal to {@code toReplace} with a new mobile {@code replaceWith} if this
     * mobile is directly attached to this stick (no recursive search). In this case {@code true}
     * is returned.
     * Otherwise, the call of this method has no effect and {@code false} is returned.
     * <p>
     * Throws a {@link StickBreaksException} if the replacement would violate the
     * condition that the sum of the weight of all attached mobiles has to be
     * less than or equal to 10 times its stick weight. In this case this mobile remains unchanged.
     *
     * @param toReplace   the mobile to be replaced, toReplace != null.
     * @param replaceWith the new mobile to replace with, replaceWith != null.
     * @return {@code true} if the replacement was successful, {@code false} otherwise.
     * @throws StickBreaksException if the replacement would violate the
     *                              condition that the sum of the weight of all attached mobiles has to be
     *                              less than or equal to 10 times its stick weight.
     */
    public boolean replace(Mobile toReplace, Mobile replaceWith) throws StickBreaksException {
        int index = -1;
        for (int i = 0; i < attached.length; i++) {
            if (attached[i].equals(toReplace)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }
        if (this.getWeight() - toReplace.getWeight() + replaceWith.getWeight() > this.stickWeight * 10) {
            throw new StickBreaksException();
        }
        attached[index] = replaceWith;
        return true;
        // TODO: implement method.

    }

    @Override
    public int getWeight() {
        int totalWeight = 0;
        for (Mobile m : attached) {
            totalWeight += m.getWeight();
        }
        return totalWeight + stickWeight;
    }

    /**
     * Returns {@code true} if {@code obj} is also of class {@code Stick}, has an equal stick
     * weight, and has equal mobiles attached, regardless of their order. This means that 'this'
     * and {@code obj} have the same number of mobiles attached and every mobile attached to this
     * stick is equal to a mobile attached to {@code obj} (and vice versa).
     * Otherwise, {@code false} is returned.
     *
     * @param obj the other object to compare with.
     * @return {@code true} if {@code this} and {@code obj} are equal and {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {

        // TODO: implement method.
        if (obj instanceof Stick other) {
            if (this == other) {
                return true;
            }
            if (other.stickWeight != this.stickWeight) {
                return false;
            }

            if (other.attached.length != this.attached.length) {
                return false;
            }

            for (Mobile m1 : attached) {
                boolean found = false;
                for (Mobile m2 : other.attached) {
                    if (m1.equals(m2)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    return false;
                }
            }

            for (Mobile m2 : other.attached) {
                boolean found = false;
                for (Mobile m1 : attached) {
                    if (m2.equals(m1)) {
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    return false;
                }
            }

            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(stickWeight); // csak a bot súlyát használom, mert a mobilok sorrendje nem számít
    }

    /**
     * Returns a readable representation of the mobile, showing its complete
     * structure with all weights using an expression with parentheses.
     * Example (compare with the graphical representation above):
     * 5[2[*7, 1[*3, *3], *2], *12, *5]
     *
     * @return a readable representation of the mobile.
     */
    @Override
    public String toString() {
        StringBuilder toReturn = new StringBuilder();
        toReturn.append(this.stickWeight + "[");
        for (Mobile m : attached) {
            toReturn.append(m.toString() + ", ");
        }
        toReturn.setLength(toReturn.length() - 2);
        toReturn.append("]");
        return toReturn.toString();
    }

    @Override
    public StickSet getStickSetView() {
        return new StickSet() {
            @Override
            public int size() {
                int count = 1;
                for (Mobile m : attached) {
                    count += m.getStickSetView().size();
                }
                return count;
            }

            @Override
            public boolean contains(Stick element) {
                if (Stick.this.equals(element)) {
                    return true;
                }
                for (Mobile m : attached) {
                    if (m.getStickSetView().contains(element)) {
                        return true;
                    }
                }
                return false;
            }
        };
    }

    @Override
    public StarIterator iterator() {
        return new StarIterator() {

            int currentIndex = 0;
            private StarIterator currentIterator = null;

            @Override
            public boolean hasNext() {
                while (true) {
                    if (currentIterator != null && currentIterator.hasNext()) {
                        return true;
                    }
                    if (currentIndex >= attached.length) {
                        return false;
                    }
                    currentIterator = attached[currentIndex++].iterator();
                }
            }

            @Override
            public Star next() {
                if(!hasNext()){
                    throw new NoSuchElementException("no star element!");
                }
                return currentIterator.next();
            }
        };
    }
}

// TODO: define additional classes if needed (either here or in a separate file).