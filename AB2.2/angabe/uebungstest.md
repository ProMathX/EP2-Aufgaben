# EP2 - beurteilte Übung zu AB2.2

### Allgemeine Hinweise

* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt und damit in den vorhandenen Dateien erfolgen.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java Collections Framework zurückgreifen.
* Verändern Sie weder die vorgegebenen Methodensignaturen noch die Signaturen der Konstruktoren.
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Methoden oder Konstruktoren
  in vorgegebenen Klassen müssen `private` sein, mit Ausnahme von für die Lösung erforderlichen Methoden in den
  Knotenklassen.
* Definieren Sie keine geschachtelten oder (anonymen) inneren Klassen.

## Information zur Domäne

Zwei Klassen aus `AB2.2` sollen jeweils zusätzliche Funktionalität bekommen.

## Zu bearbeitende Dateien

Die für diesen Test zu bearbeitenden Dateien sind:

* [PhysicalKDTreeSet.java](../src/PhysicalKDTreeSet.java)
* [PhysicalDoublyLinkedRingList.java](../src/PhysicalDoublyLinkedRingList.java)

Die Klasse [ApplicationUE2.java](../src/ApplicationUE2.java) kann zum Testen Ihrer Implementierung verwendet werden.

## Aufgabenstellung

1. Fügen Sie der Klasse [PhysicalKDTreeSet](../src/PhysicalKDTreeSet.java) folgende Methode hinzu und implementieren Sie diese:
```java
/**
 * Returns the number of all physical objects stored in this k-d tree whose
 * y-coordinate is strictly greater than the specified value.
 *
 * <p>This method traverses the tree and counts all {@link Physical} objects
 * {@code p} for which {@code p.getPosition().getY() > y} holds.</p>
 *
 * <p>The structure of the k-d tree should be used to avoid unnecessary traversal
 * of subtrees that cannot contain matching elements.</p>
 *
 * @param y the threshold for the y-coordinate
 * @return the number of all matching objects
 */
public int countAllWithYGreater(double y) {

    //TODO: implement method.
}
```

2. Fügen Sie der Klasse [PhysicalDoublyLinkedRingList](../src/PhysicalDoublyLinkedRingList.java) folgende Methode hinzu und implementieren Sie diese:

```java
/**
 * Removes all elements from the beginning of this list up to index {@code i}
 * (inclusive) and returns them as a new list.
 *
 * <p>The first removed element is the element that was stored at index
 * {@code 0} before the operation, and the last removed element is the
 * element that was stored at index {@code i} before the operation.</p>
 *
 * <p>The relative order of the removed elements in the returned list is
 * the same as in this list before the removal.</p>
 *
 * <p>After the operation, this list contains only the elements with
 * indices greater than {@code i} in their original order.</p>
 *
 * @param i the last index to remove; {@code 0 <= i < size()}
 * @return a new list containing all removed elements in their original order
 */
public PhysicalDoublyLinkedRingList removeUntil(int i) {

  // TODO: implement method.
}
```