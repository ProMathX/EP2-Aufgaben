/**
 * This data structure maps keys ('IntConst' objects) to values ('IntConst' objects).
 * It is implemented as a binary search tree where keys are ordered according to the order
 * relation of the 'IntConst' class defined by its 'lessThan' and 'isEqual' method.
 * For the keys k1 and k2 of any two mappings in this map the following condition holds:
 * k1.isEqual(k2) == false.
 * There is no limit on the number of key-value mappings stored in the map.
 */
//
// TODO: Complete the methods in 'ConstConstTreeMap'.
//       You can define further classes and methods for the implementation of the
//       binary search tree if needed.
//       Do NOT use the Java-Collection framework in 'ConstConstTreeMap' or any other class.
//
public class ConstConstTreeMap {
    private IntConst key=null;
    private IntConst value=null;
    private ConstConstTreeMap left=null;
    private ConstConstTreeMap right=null;

    /**
     * Initializes 'this' as an empty map.
     */
    public ConstConstTreeMap() {
    }

    /**
     * Constructs this map as a copy of the specified 'map'. This map has the same key-value mappings
     * as 'map'. If 'map' is changed later, it will not affect 'this' and vice versa.
     *
     * @param map the map from which key-value mappings are copied to this new map, map != null.
     */
    public ConstConstTreeMap(ConstConstTreeMap map) {
        this.value=map.value;
        this.key=map.key;
        if(map.left!=null){
            this.left= new ConstConstTreeMap(map.left);
        }
        if(map.right!=null){
            this.right= new ConstConstTreeMap(map.right);
        }
    }


    /**
     * Adds a new key-value association to this map. If the key already exists in this map,
     * the value is replaced and the old value is returned. Otherwise, 'null' is returned.
     *
     * @param key   a variable != null.
     * @param value the constant to be associated with the key (can also be 'null').
     * @return the old value if the key already existed in this map, or 'null' otherwise.
     */
    public IntConst put(IntConst key, IntConst value) {
        if(this.key==null){
            this.key=key;
            this.value=value;
            return null;
        } else if (this.key.lessThan(key)) {
            if(this.right==null){
                this.right=new ConstConstTreeMap();
            }
            return this.right.put(key, value);
        } else if (key.lessThan(this.key)) {
            if(this.left==null){
                this.left=new ConstConstTreeMap();
            }
            return this.left.put(key, value);
        } else {
            IntConst toReturn=this.value;
            this.value=value;
            return toReturn;
        }
    }

    /**
     * Returns the value associated with the specified key. Returns 'null' if the key is not
     * contained in this map.
     *
     * @param key a constant != null.
     * @return the value associated with the specified key (or 'null' if the key is not contained in
     * this map).
     */
    public IntConst get(IntConst key) {
        if(this.key==null){
            return null;
        } else if (this.key.lessThan(key)) {
            if(this.right!=null){
                return this.right.get(key);
            }
        } else if (key.lessThan(this.key)) {
            if(this.left!=null){
                return this.left.get(key);
            }
        } else {
            return this.value;
        }
        return null;
    }


    /**
     * Calculates the number of keys that are common between this map and another specified map.
     * <p>
     * The operation does not modify either of the maps and ensures that only keys that are present
     * in both maps are considered in the count.
     *
     * @param other The other map to compare with this map, other != null.
     * @return The number of common keys between the two maps.
     */
    public int countCommonKeys(ConstConstTreeMap other) {
        int count=0;
        IntConst search=this.key;
        if (other.get(search)!=null){
            count++;
        }
        if(this.left!=null){
            count+=this.left.countCommonKeys(other);
        }
        if(this.right!=null){
            count+=this.right.countCommonKeys(other);
        }
        return count;
    }

    /**
     * Returns a string representation of this 'map' with all its mappings in the format: key
     * followed by '=' and the value. The list of mappings is enclosed in square
     * brackets ("[]"). Adjacent elements are separated by ','.
     * The mappings are listed in ascending order according to the key order relation.
     * Example: "[-2=0,1=4,2=4,3=-1,5=5,8=10]"
     *
     * @return the string representation of this map.
     */
    public String toString() {
        return "["+toStringPlus().substring(0,toStringPlus().length()-1)+"]";
    }

    public String toStringPlus() {
        StringBuilder toReturn=new StringBuilder();
        if(this.left!=null){
            toReturn.append(this.left.toStringPlus());
        }
        toReturn.append(this.key+"="+this.value+",");
        if(this.right!=null){
            toReturn.append(this.right.toStringPlus());
        }
        return toReturn.toString();
    }

    /**
     * Returns a string representation of this 'map' listing only those mappings of 'this'
     * with keys lying in the specified inclusive range. The representation has the following
     * format: key followed by '=' and the value. The list of mappings is enclosed in square
     * brackets ("[]"). Adjacent elements are separated by ','.
     * The mappings are listed in ascending order according to the key order relation.
     * Example: "[2=4,3=-1,5=5]"
     * <p>
     * This method exploits the structure of the binary search tree and traverses only
     * relevant parts of the tree.
     *
     * @param lower the inclusive lower bound for the range of keys, lower != null.
     * @param upper the inclusive upper bound for the range of keys, lower <= upper, upper != null.
     * @return the string representation of a range of mappings of this map.
     */
    public String toString(IntConst lower, IntConst upper) {
        return "["+toStringPlus(lower,upper).substring(0,toStringPlus(lower,upper).length()-1)+"]";
    }

    public String toStringPlus(IntConst lower, IntConst upper) {
        if(this.key.lessThan(lower) && this.right!=null){
            this.right.toStringPlus(lower, upper);
        } else if (upper.lessThan(this.key) && this.left!=null) {
            this.left.toStringPlus(lower,upper);
        }
        StringBuilder toReturn=new StringBuilder();
        if(this.left!=null && lower.plus(new IntConst(-1)).lessThan(this.left.key)){
            toReturn.append(this.left.toStringPlus(lower, upper));
        }
        if (this.key.lessThan(upper.plus(new IntConst(1))) && lower.plus(new IntConst(-1)).lessThan(this.key)){
            toReturn.append(this.key+"="+this.value+",");
        }
        if(this.right!=null && this.right.key.lessThan(upper.plus(new IntConst(1)))){
            toReturn.append(this.right.toStringPlus(lower, upper));
        }
        return toReturn.toString();
    }

}
