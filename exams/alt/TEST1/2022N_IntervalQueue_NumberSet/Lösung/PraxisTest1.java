// This class can be modified and is for testing your solution.
// Modifications will NOT be reviewed or assessed.
//
public class PraxisTest1 {

    public static void main(String[] args) {

        Interval i1 = new Interval(-1.2,5.0);
        Interval i2 = new Interval(7.33,12.5);
        Interval i3 = new Interval(15.0,20.0);
        Interval i4 = new Interval(3.3,8.7);

        System.out.println("\nTest 1:");
        IntervalQueue queue = new IntervalQueue();
        System.out.println(queue.toString());
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());

        System.out.println("\nTest 2:");
        queue.addLast(i1);
        queue.addLast(i2);
        queue.addLast(i3);
        queue.addLast(i4);
        System.out.println(queue.toString());
        System.out.println(queue.isEmpty());
        System.out.println(queue.size());

        System.out.println("\nTest 3:");
        NumberSet set = new NumberSet(i2,i1,i3);
        System.out.println(set.toString());

        System.out.println("\nTest 4:");
        set = new NumberSet(i1,i2,i3,i4);
        System.out.println(set.toString());

        /*

        Test 1:
        EMPTY
        true
        0

        Test 2:
        [-1.2, 5.0], [7.33, 12.5], [15.0, 20.0], [3.3, 8.7]
        false
        4

        Test 3:
        [-1.2, 5.0], [7.33, 12.5], [15.0, 20.0]

        Test 4:
        [-1.2, 12.5], [15.0, 20.0]

        */

    }
}
