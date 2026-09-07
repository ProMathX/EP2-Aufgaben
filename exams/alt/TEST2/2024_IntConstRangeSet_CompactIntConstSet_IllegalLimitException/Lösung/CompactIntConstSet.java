import java.sql.Array;
import java.util.*;

/**
 * A 'CompactIntConstSet' implements 'IntConstSet' as a collection of
 * non-overlapping, non-consecutive 'IntConstRangeSet' objects. Consecutive
 * ranges are stored as a single 'IntConstRangeSet' object, rather than two
 * separate objects. For example, instead of a set storing two objects 3-5 and 6-9 the set is
 * represented internally by a single object 3-9 of class 'IntConstRangeSet'.
 */
//
// TODO: Complete the methods in 'CompactIntConstSet'.
//       You can define further classes and methods for the implementation.
//       You may use the Java-Collection framework.
//
public class CompactIntConstSet implements IntConstSet // TODO: uncomment clause.
{
    private List<IntConst> elements;
    private IntConstRangeSet rangeView;

    /**
     * Initialises 'this' as an empty set.
     *
     * Ez a konstruktor inicializálja 'this'-t egy üres halmazként.
     */
    public CompactIntConstSet() {
        this.elements = new ArrayList<>();
        this.rangeView = null;
    }

    /**
     * Adds the specified element 'e' to this set if the set contains no element 'e2' such that
     * e.equals(e2). If this set already contains such an element, the call leaves the set unchanged.
     *
     *
     * @param e the element to be added to the set, e != null.
     */
    public void add(IntConst e) {
        // TODO_: Implement the method.
        if (e == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        if (elements.contains(e)) {
            return; // Element already exists, do nothing
        }
        // beszúrási hely megkeresése
        int index = 0;
        while (index < elements.size() && elements.get(index).lessThan(e)) {
            index++;
        }
        // beszúrás
        elements.add(index, e);

        // RangeView frissítése
        if (rangeView == null) {
            rangeView = new IntConstRangeSet(e, e);
        } else {
            rangeView.add(e);
        }
    }

    /**
     * Returns a readable representation of the set. The representation shows the numbers in
     * ascending order separated by ','. Wherever a range of consecutive numbers from n to m
     * appears in the representation this representation is in the form n-m.
     * <p>
     * Example:
     * 1,3,6-9,12-20,22.
     *
     * @return a readable representation of the set.
     */
    public String toString() {

        List<IntConst[]> ranges = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < elements.size(); i++) {
            counter++;
            if (i == elements.size() - 1 || elements.get(i).plus(new IntConst(1)).lessThan(elements.get(i+1))) {
                ranges.add(new IntConst[]{elements.get(i-counter + 1), elements.get(i)});
                counter = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (IntConst[] range : ranges) {
            if (range[0].equals(range[1])) {
                sb.append(range[0].toString());
            } else {
                sb.append(range[0].toString()).append("-").append(range[1].toString());
            }
            sb.append(",");
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1); // remove last comma
        }
        return sb.toString();
    }

    @Override
    public IntConstRange getRangeView() {
        return rangeView;
    }

    @Override
    public boolean contains(IntConst element) {
        // TODO_: Implement the method.
        if (element == null) {
            throw new IllegalArgumentException("Element cannot be null");
        }
        return elements.contains(element);
    }

    /**
     * Returns the union of this set and the specified set (see specification in 'IntConstSet').
     * The method returns a new object of the most specific subtype of 'IntConstSet':
     * The returned object is of 'IntConstRangeSet' if the returned set can be represented by a
     * single range. Otherwise, the returned set is of 'CompactIntConstSet'.
     *
     * @param other the other set, other != null.
     * @return a new set representing the union of 'this' with 'other'.
     */
    //@Override
    public IntConstSet union(IntConstSet other) {
        if (other == null) {
            throw new IllegalArgumentException("other is null");
        }
        if (this.equals(other)) {
            return this;
        }
        CompactIntConstSet result = new CompactIntConstSet();
        for (var element : this) {
            result.add(element);
        }
        for (var element : other) {
            result.add(element);
        }
        // Eldöntés - állítás: minden következő elem 1-el nagyobb az aktuálisnál (vagyis a result egy range)
        boolean antiHit = false;
        for (int i = 0; i < result.elements.size() - 1; i++) {
            if (result.elements.get(i).plus(new IntConst(1)).lessThan(result.elements.get(i + 1))) {
                antiHit = true;
                break;
            }
        }
        if (!antiHit) {
            return new IntConstRangeSet(result.elements.getFirst(), result.elements.getLast());
        }
        return result;
    }

    /**
     * Returns 'true' if 'o' is also of class 'CompactIntConstSet' and represents the same
     * set as 'this' in a mathematical sense (has equal 'IntConst' elements).
     * Otherwise, 'false' is returned.
     * The method should not compare objects by using their toString() method.
     *
     * @param o the other object to compare with.
     * @return 'true' if 'this' and 'o' are equal and 'false' otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CompactIntConstSet other)) {
            return false;
        }
        if (this.elements.size() != other.elements.size()) {
            return false;
        }
        for (int i = 0; i < this.elements.size(); i++) {
            if (!this.elements.get(i).equals(other.elements.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public IntConstIterator iterator() {
        // TODO_: Implement the method.
        return new IntConstIterator() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < elements.size();
            }

            @Override
            public IntConst next() {
                if (!hasNext()) {
                    throw new NoSuchElementException("no element!");
                }
                return elements.get(currentIndex++);
            }
        };
    }

//    /*
//    //TODO: define missing parts of the class.
//    private ArrayList<IntConstRangeSet> ranges;
//
//
//    /**
//     * Initialises 'this' as an empty set.
//     */
//    public CompactIntConstSet() {
//        this.ranges=new ArrayList<>();
//    }
//
//    /**
//     * Adds the specified element 'e' to this set if the set contains no element 'e2' such that
//     * e.equals(e2). If this set already contains such an element, the call leaves the set unchanged.
//     *
//     * @param e the element to be added to the set, e != null.
//     */
//    public void add(IntConst e) {
////        if(ranges.contains(e)){
////            return;
////        }
////        ranges.add(new IntConstRangeSet(e,e));
////        ranges.sort(IntConstSet::compare);
//    }
//
//    /**
//     * Returns a readable representation of the set. The representation shows the numbers in
//     * ascending order separated by ','. Wherever a range of consecutive numbers from n to m
//     * appears in the representation this representation is in the form n-m.
//     * <p>
//     * Example:
//     * 1,3,6-9,12-20,22.
//     *
//     * @return a readable representation of the set.
//     */
//    public String toString() {
//        if(ranges.isEmpty()){
//            return "";
//        }
//        ranges.sort(IntConstSet::compare);   // sort((x, y) -> x.compare(y))
//        StringBuilder builder = new StringBuilder();
//        for(IntConstSet set : ranges){
//            if(!builder.isEmpty()){
//                builder.append(", ");
//            }
//            builder.append(set.toString());
//        }
//        return builder.toString();
//    }
//
//    @Override
//    public IntConstRange getRangeView() {
//
//        return new IntConstRange() {
//            @Override
//            public IntConst getSmallest() {
//                if(ranges.isEmpty()){
//                    throw new NoSuchElementException("ranges is empty");
//                }
//                // IntConst minValue = (new ArrayList<>(ranges)).getFirst().getSmallest();
//                IntConst minValue = ranges.get(0).getSmallest();
//                for (IntConstRangeSet range : ranges) {
//                    if (range.getSmallest().lessThan(minValue)){
//                        minValue=range.getSmallest();
//                    }
//                }
//
//                return minValue;
//            }
//
//            @Override
//            public IntConst getLargest() {
//                if(ranges.isEmpty()){
//                    throw new NoSuchElementException("ranges is empty");
//                }
//                // IntConst minValue = (new ArrayList<>(ranges)).getFirst().getSmallest();
//                IntConst maxValue = ranges.get(0).getLargest();
//                for (IntConstRangeSet range : ranges) {
//                    if (maxValue.lessThan(range.getLargest())){
//                        maxValue=range.getLargest();
//                    }
//                }
//
//                return maxValue;
//            }
//
//            @Override
//            public IntConstIterator iterator() {
//                if(ranges.isEmpty()){
//                    throw new NoSuchElementException("ranges is empty");
//                }
//                return this.iterator();
//                /*
//                return new IntConstIterator() {
//
//                    private int currentIndex = 0;
//
//                    @Override
//                    public boolean hasNext() {
//                        return currentIndex < ranges.size();
//                    }
//
//                    @Override
//                    public IntConst next() {
//                        if (!hasNext()) {
//                            throw new NoSuchElementException();
//                        }
//                        return (IntConst) ranges.toArray()[currentIndex++];
//                    }
//                };
//
//                 */
//            }
//        };
//    }
//
//    @Override
//    public boolean contains(IntConst element) {
//        if(element==null){
//            throw new IllegalArgumentException("element empty");
//        }
//        for(IntConstRangeSet range:ranges){
//            if (range.contains(element)){
//                return true;
//            }
//        }
//        return false;
//    }
//
//    /**
//     * Returns the union of this set and the specified set (see specification in 'IntConstSet').
//     * The method returns a new object of the most specific subtype of 'IntConstSet':
//     * The returned object is of 'IntConstRangeSet' if the returned set can be represented by a
//     * single range. Otherwise, the returned set is of 'CompactIntConstSet'.
//     *
//     * @param other the other set, other != null.
//     * @return a new set representing the union of 'this' with 'other'.
//     */
//    //@Override
//    public IntConstSet union(IntConstSet other) {
//        if(this.equals(other)){
//            throw new NoSuchElementException("ranges and other are the same");
//        }
//        CompactIntConstSet toReturn = new CompactIntConstSet();
//        for(IntConstRangeSet rangeSet : ranges){
//            if(rangeSet.compare(other)==0){
//                IntConst newSmall = rangeSet.getSmallest().lessThan(other.getRangeView().getSmallest()) ? rangeSet.getSmallest() : other.getRangeView().getSmallest();
//                IntConst newLarge = rangeSet.getLargest().lessThan(other.getRangeView().getLargest()) ? other.getRangeView().getLargest() : rangeSet.getLargest();
//
//                toReturn.ranges.add(new IntConstRangeSet(newSmall, newLarge));
//            }else{
//
//            }
//        }
//        if (toReturn.ranges.size() == 1) {
//            return toReturn.ranges.get(0);
//        }
//        return toReturn;
//    }
//
//    /**
//     * Returns 'true' if 'o' is also of class 'CompactIntConstSet' and represents the same
//     * set as 'this' in a mathematical sense (has equal 'IntConst' elements).
//     * Otherwise, 'false' is returned.
//     * The method should not compare objects by using their toString() method.
//     *
//     * @param o the other object to compare with.
//     * @return 'true' if 'this' and 'o' are equal and 'false' otherwise.
//     */
//    @Override
//    public boolean equals(Object o) {
//        if(o instanceof CompactIntConstSet other){
//            return this.ranges.equals(other.ranges);
//        }
//        return false;
//    }
//
//    @Override
//    public int hashCode(){
//        return ranges.hashCode();
//    }
//
//    @Override
//    public IntConstIterator iterator() {
//        return new IntConstIterator() {
//
//            private int currentIndex = 0;
//
//            @Override
//            public boolean hasNext() {
//                return currentIndex < ranges.size();
//            }
//
//            @Override
//            public IntConst next() {
//                if (!hasNext()) {
//                    throw new NoSuchElementException();
//                }
//                return (IntConst) ranges.toArray()[currentIndex++];
//            }
//        };
//    }

}
