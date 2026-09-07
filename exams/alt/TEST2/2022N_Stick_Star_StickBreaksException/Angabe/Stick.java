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
public class Stick // implements Mobile // TODO: uncomment clause.
{

    //TODO: define missing parts of the class.

    /**
     * Initialises {@code this}; throws an {@link StickBreaksException} if the sum of the weight of
     * all mobiles in the array {@code attached} is greater than 10 times the {@code stickWeight}.
     * The detail message of the exception is "Stick breaks!".
     *
     * @param stickWeight the weight of this stick (without attached mobiles),
     *      {@code stickWeight > 0}.
     * @param attached an array with all the mobiles directly attached to this stick.
     *      Precondition: {@code attached != null && attached.length > 1} and for any two mobiles
     *                m1 and m2 being part of {@code attached} (including sub-mobiles) it holds that
     *                {@code m1.equals(m2) == false}, this is, there are no duplicates anywhere
     *                in a mobile.
     * @throws StickBreaksException if the sum of the weight of all mobiles in the array
     *        {@code attached} is greater than 10 times the {@code stickWeight}.
     */
    public Stick(int stickWeight, Mobile[] attached) throws StickBreaksException {

        // TODO: implement constructor.
    }

    /**
     * Replaces the mobile equal to {@code toReplace} with a new mobile {@code replaceWith} if this
     * mobile is directly attached to this stick (no recursive search). In this case {@code true}
     * is returned.
     * Otherwise, the call of this method has no effect and {@code false} is returned.
     *
     * Throws a {@link StickBreaksException} if the replacement would violate the
     * condition that the sum of the weight of all attached mobiles has to be
     * less than or equal to 10 times its stick weight. In this case this mobile remains unchanged.
     *
     * @param toReplace the mobile to be replaced, toReplace != null.
     * @param replaceWith the new mobile to replace with, replaceWith != null.
     * @return {@code true} if the replacement was successful, {@code false} otherwise.
     * @throws StickBreaksException if the replacement would violate the
     *        condition that the sum of the weight of all attached mobiles has to be
     *        less than or equal to 10 times its stick weight.
     */
    public boolean replace(Mobile toReplace, Mobile replaceWith) throws StickBreaksException {

        // TODO: implement method.
        return false;
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
        return false;
    }
}

// TODO: define additional classes if needed (either here or in a separate file).