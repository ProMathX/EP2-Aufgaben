# EP2 - beurteilte Übung zu AB3.2

### Allgemeine Hinweise

* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt und damit in den vorhandenen Dateien erfolgen.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java Collections Framework zurückgreifen.
* Verändern Sie weder die vorgegebenen Methodensignaturen noch die Signaturen der Konstruktoren.
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Methoden oder Konstruktoren
  in vorgegebenen Klassen müssen `private` sein. Ausgenommen sind Methoden, die durch ein Interface gefordert sind,
  überschriebene öffentliche Methoden sowie die in dieser Aufgabenstellung ausdrücklich geforderten öffentlichen Methoden.
* Definieren Sie keine geschachtelten oder (anonymen) inneren Klassen.

## Information zur Domäne

Die Klasse [PhysicalPhysicalTreeMap.java](../src/PhysicalPhysicalTreeMap.java) aus `AB3.2`
soll einen zusätzlichen Iterator erhalten, der die Knoten pre-order traversiert, d. h. rekursiv zuerst den
Knoten selbst, danach den linken Kindknoten und danach den rechten Kindknoten.

Beispiel:

```text
          A
        /   \
       B     C
      / \   / \
     D   E F   G

Pre order:
A, B, D, E, C, F, G
```

Dazu bekommt die Klasse eine zusätzliche Methode `preOrderIterator()`.
Die bisherige Methode `iterator()` soll nicht verändert werden.

---

## Zu bearbeitende Dateien

Die für diesen Test zu bearbeitenden Dateien sind:

* [PhysicalPhysicalTreeMap.java](../src/PhysicalPhysicalTreeMap.java)
* [PhysicalPhysicalTreeMapNode.java](../src/PhysicalPhysicalTreeMapNode.java)
* [PhysicalPhysicalTreeMapPreOrderIterableNode.java](../src/PhysicalPhysicalTreeMapPreOrderIterableNode.java)

Die Klasse [ApplicationUE3d2.java](../src/ApplicationUE3d2.java) kann zum Testen Ihrer Implementierung verwendet werden.

---

## Aufgabenstellung

### 1.

Fügen Sie der Klasse [PhysicalPhysicalTreeMapNode](../src/PhysicalPhysicalTreeMapNode.java)
folgende Getter-Methoden hinzu und implementieren Sie diese:

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

Vervollständigen Sie die Klasse
[PhysicalPhysicalTreeMapPreOrderIterableNode.java](../src/PhysicalPhysicalTreeMapPreOrderIterableNode.java)
gemäß der Spezifikation.

Jedes Objekt dieser Klasse „verpackt“ genau einen `PhysicalPhysicalTreeMapNode`
(die Klasse ist eine Wrapper-Klasse für einen Baumknoten) und bietet eine angepasste
Version der Methode `iter` an. Die Klasse implementiert `PhysicalIterableTreeNode`.

---

### 3.

Implementieren Sie in der Klasse
[PhysicalPhysicalTreeMap.java](../src/PhysicalPhysicalTreeMap.java)
die Methode `preOrderIterator()` gemäß folgender Spezifikation:

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

Die Implementierung darf keine zusätzliche Datenstruktur zur
Vorab-Speicherung aller Schlüssel verwenden. Der Iterator soll den Baum mithilfe
der neuen Klasse `PhysicalPhysicalTreeMapPreOrderIterableNode` traversieren.