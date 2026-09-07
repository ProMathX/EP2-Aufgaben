# EP2 - Graded Exercise for AB4.2

### General Notes

* Your solution must be implemented within the provided project and therefore in the existing files.
* The use of classes from the Java Collections Framework is explicitly allowed in this exercise.
* Do not modify the given method signatures or constructor signatures.
* All object variables as well as any additional methods or constructors you create in the provided classes must be `private`. Exceptions are methods required by an interface, overridden public methods, and public methods explicitly required by this assignment.
* Do not define nested or (anonymous) inner classes.

## Domain Information

The class [SimulationLogger.java](../src/SimulationLogger.java) from `AB4.2`
shall be extended by a static evaluation method.

The log file contains one line for each unresolved collision.

Example:

```text
step=3; ant=Ant@A; obstacle=Ant@X
step=4; ant=Ant@B; obstacle=Ant@Y
step=5; ant=Ant@A; obstacle=Nest@(100.0,100.0)
```

In this example, `Ant@A` first occurs in step 3 and `Ant@B` first occurs in step 4.

## Files to Modify

The file to be modified for this exercise is:

* [SimulationLogger.java](../src/SimulationLogger.java)

The class [ApplicationUE4d2.java](../src/ApplicationUE4d2.java) may be used to test your implementation.

## Task

Implement the following method in the class [SimulationLogger.java](../src/SimulationLogger.java):

```java
/**
 * Reads a simulation log file and returns the first simulation step in
 * which each ant was involved in an unresolved collision.
 *
 * <p>The method parses the log file directly. Only the first occurrence
 * of each ant is stored.</p>
 *
 * @param fileName the log file name; {@code fileName != null}
 * @return a map assigning each ant identifier to its first collision step
 * @throws IOException if the file cannot be read
 */
public static Map<String, Integer> firstCollisionStepPerAnt(String fileName) throws IOException {

}
```

The method shall read the file directly and evaluate the contained
`step=...` and `ant=...` entries.

For each ant, exactly the simulation step in which it first occurs in a recorded collision shall be stored.

Use suitable classes from the Java IO framework and an appropriate map from the Java Collections Framework.

### Hint

To split a string at a separator, the following method can be used:

```java
String[] parts = text.split(";");
```

The method

```java
text.trim()
```

removes leading and trailing whitespace from a string.