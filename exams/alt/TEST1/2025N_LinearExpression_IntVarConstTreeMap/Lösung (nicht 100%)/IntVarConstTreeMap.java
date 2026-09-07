/**
 * This data structure maps keys of type {@code IntVar} to values of type {@code IntConst}.
 * It is implemented as a binary search tree where keys are sorted lexicographically according
 * their name (via {@code getName()} of {@code IntVar}) using the {@code compareTo} method of
 * String. The map allows multiple keys with the same name as long as they are not identical.
 * The map also allows a key of {@code null}, where it is assumed that in the key order
 * relation {@code null} is less than any non-{@code null} key.
 * However, {@code null} values are not allowed in this map.
 * There is no limit on the number of key-value mappings stored in the map.
 */
//
// TODO: define further classes and methods for the implementation of the binary search tree, if
//  needed.
//
public class IntVarConstTreeMap {
    private IntConst value=null;
    private IntVar key=null;
    private IntVarConstTreeMap left=null;
    private IntVarConstTreeMap right=null;

    //TODO: additional variables, constructors and methods must be private.

    /**
     * Constructs {@code this} as an empty map.
     */
    public IntVarConstTreeMap() {

        //TODO: implement constructor.
    }
    private IntVarConstTreeMap(IntVar key, IntConst value) {
        this.value=value;
        this.key=key;

        //TODO: implement constructor.
    }

    /**
     * Constructs this map as a copy of the specified {@code map}. This map will have the same
     * key-value mappings as {@code map}. This map will also have the same tree structure as
     * {@code map}. The individual {@link IntVar} and {@link IntConst} objects themselves are
     * reused (they need not be duplicated, since they are immutable).
     * If {@code map} is changed later, it will not affect {@code this} and vice versa.
     *
     * @param map the map from which key-value mappings are copied to this new map,
     *      {@code map != null}.
     */
    public IntVarConstTreeMap(IntVarConstTreeMap map) {
        if(map.left!=null){
            this.left= new IntVarConstTreeMap(map.left);
        }
        this.key=map.key;
        this.value=map.value;
        if(map.right!=null){
            this.right= new IntVarConstTreeMap(map.right);
        }

        //TODO: implement constructor.
    }

    /**
     * Adds a new key-value association to this map. If the key already exists in this map,
     * the value is replaced and the old value is returned. Otherwise, {@code null} is returned.
     *
     * @param key a variable or {@code null}.
     * @param value the constant to be associated with the key, {@code value != null}.
     * @return the old value if the key already existed in this map, or {@code null} otherwise.
     */
    public IntConst put(IntVar key, IntConst value) {
        if(this.key==null){
            if(key!=null){
                this.key=key;
            }
            this.value=value;
        }else if (key==null) {
            if(this.right==null){
                this.right=new IntVarConstTreeMap();
            }
            this.right.put(key, value);
        } else if (this.key.getName().charAt(0)-key.getName().charAt(0)<0) {
            if(this.right==null){
                this.right=new IntVarConstTreeMap();
            }
            this.right.put(key, value);
        }else if (key.equals(this.key)){
            IntConst toReturn=this.value;
            this.value=value;
            return toReturn;
        } else if (this.key.getName().charAt(0)-key.getName().charAt(0)>0) {
            if(this.left==null){
                this.left=new IntVarConstTreeMap();
            }
            this.left.put(key, value);
        }else{
            this.key=key;
            this.value=value;
        }
        //TODO: implement method.
        return null;
    }

    /**
     * Returns the value associated with the specified key, i.e. the constant associated with the
     * specified variable. Returns {@code null} if the key is not contained in this map.
     *
     * @param key a variable or {@code null}.
     * @return the value associated with the specified key or {@code null} if the key is
     * not contained in this map.
     */
    public IntConst get(IntVar key) {
        if(this.key==null){
            if(key==null){
                return this.value;
            }
            return null;
        }else if (key==null) {
            if(this.right!=null){
                this.right.get(key);
            }
        } else if (this.key.getName().charAt(0)-key.getName().charAt(0)<0) {
            if(this.right!=null){
                return this.right.get(key);
            }
        }else if (key.equals(this.key)){
            return this.value;
        } else if (this.key.getName().charAt(0)-key.getName().charAt(0)>0) {
            if(this.left!=null){
                return this.left.get(key);
            }

        }
        //TODO: implement method.
        return null;
    }

    /**
     * Returns the number of key-value mappings in this map.
     *
     * @return the number of key-value mappings in this map.
     */
    public int size() {
        int count=1;
        if(this.left!=null){
            count+=this.left.size();
        }
        if(this.right!=null){
            count+=this.right.size();
        }

        //TODO: implement method.
        return count;
    }

    /**
     * Returns a new queue with all the keys of this map. The returned queue provides all keys of
     * this map according to the key order relation.
     *
     * This means that for any two keys {@code x} and {@code y}, {@code x} is added before
     * {@code y} to the queue, if {@code x == null && y != null} or
     * if {@code x.getName().compareTo(y.getName()) < 0}.
     * If there are variables with equal names, they are consecutive entries in the returned queue
     * (their relative order is unspecified).
     *
     * @return a queue with the keys of this map.
     */
    public IntVarQueue getKeyQueue() {
        IntVarQueue toReturn=new IntVarQueue();

        //TODO: implement method.
        return getKeyQueuePlus(toReturn);
    }

    private IntVarQueue getKeyQueuePlus(IntVarQueue toReturn) {
        if(this.left!=null){
            //toReturn.add(this.right.getKeyQueuePlus(toReturn);
        }
        if(this.key!=null){
            toReturn.add(this.key);
        }if(this.right!=null){
            //toReturn.add(this.right.getKeyQueuePlus(toReturn));
        }

        //TODO: implement method.
        return toReturn;
    }
}

// TODO: define further classes, if needed (either here or in a separate file).
