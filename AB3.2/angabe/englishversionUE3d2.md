# EP2 - Graded Exercise for AB3.2

### General Notes

* Your solution must be implemented within the provided project and therefore within the existing files.
* You are not allowed to use the Java Collections Framework to solve this task.
* Do not modify the given method signatures or constructor signatures.
* All instance variables as well as any additional methods or constructors you create in predefined classes must be `private`. Exceptions are methods required by an interface, overridden public methods, and public methods explicitly required in this assignment.
* Do not define nested or (anonymous) inner classes.

## Domain Information

The class [PhysicalPhysicalTreeMap.java](../src/PhysicalPhysicalTreeMap.java) from `AB3.2`
shall be extended with an additional iterator that traverses the nodes in pre-order, i.e. recursively first the node itself, then the left child node, and finally the right child node.

Example:

```text
          A
        /   \
       B     C
      / \   / \
     D   E F   G

Pre order:
A, B, D, E, C, F, G
```

For this purpose, the class receives an additional method `preOrderIterator()`.

The existing method `iterator()` must not be modified.

---

## Files to Edit

The files to be edited for this assignment are:

* [PhysicalPhysicalTreeMap.java](../src/PhysicalPhysicalTreeMap.java)
* [PhysicalPhysicalTreeMapNode.java](../src/PhysicalPhysicalTreeMapNode.java)
* [PhysicalPhysicalTreeMapPreOrderIterableNode.java](../src/PhysicalPhysicalTreeMapPreOrderIterableNode.java)

The class [ApplicationUE3d2.java](../src/ApplicationUE3d2.java) may be used to test your implementation.

---

## Task Description

### 1.

Add the following getter methods to the class
[PhysicalPhysicalTreeMapNode.java](../src/PhysicalPhysicalTreeMapNode.java)
and implement them:

```java
/**
 * Returns the left child subtree of this node.
 *
 * <p>The returned subtree may be {@code null} if no left child exists.</p>
 *
 * @return the left child subtree, or {@code null}
 */
public PhysicalPhysicalTreeMapNode getLeft() {

    //TODO: implement method.
    return null;
}

/**
 * Returns the right child subtree of this node.
 *
 * <p>The returned subtree may be {@code null} if no right child exists.</p>
 *
 * @return the right child subtree, or {@code null}
 */
public PhysicalPhysicalTreeMapNode getRight() {

    //TODO: implement method.
    return null;
}

/**
 * Returns the key stored in this node.
 *
 * <p>If this node represents an empty subtree,
 * {@code null} is returned.</p>
 *
 * @return the stored key, or {@code null} if this node is empty
 */
public Physical getKey() {

    //TODO: implement method.
    return null;
}

/**
 * Returns the value associated with the key stored in this node.
 *
 * <p>If this node represents an empty subtree,
 * {@code null} is returned.</p>
 *
 * @return the associated value, or {@code null} if this node is empty
 */
public Physical getValue() {

    //TODO: implement method.
    return null;
}
```

---

### 2.

Complete the class
[PhysicalPhysicalTreeMapPreOrderIterableNode.java](../src/PhysicalPhysicalTreeMapPreOrderIterableNode.java)
according to its specification.

Each object of this class “wraps” exactly one `PhysicalPhysicalTreeMapNode`
(the class is a wrapper class for a tree node) and provides an adapted
version of the method `iter`.

The class implements the interface `PhysicalIterableTreeNode`.

---

### 3.

Implement the method `preOrderIterator()` in the class
[PhysicalPhysicalTreeMap.java](../src/PhysicalPhysicalTreeMap.java)
according to the following specification:

```java
/**
 * Returns an iterator over all keys stored in this map using pre-order
 * traversal.
 *
 * <p>The iterator traverses the underlying binary search tree by first
 * visiting the node itself, then the left subtree, and finally the
 * right subtree.</p>
 *
 * <p>The returned iterator does not create an independent copy of all keys.
 * The traversal state is stored explicitly in the iterator.</p>
 *
 * <p>If this map is empty, the returned iterator has no elements.</p>
 *
 * @return an iterator over all keys in pre-order traversal
 */
public PhysicalIterator preOrderIterator();
```

The implementation must not use any additional data structure for storing
all keys in advance.

The iterator shall traverse the tree using the new class
`PhysicalPhysicalTreeMapPreOrderIterableNode`.