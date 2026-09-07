# EP2 Aufgabenblatt 3.2

Kernthemen: Ersetzbarkeit, dynamisches Binden, eigene Iteratoren, sortierte Datensammlung 

## Organisatorisches

Abgabe-Deadline: **19.05.2026, 13:00 Uhr**  
Art der Abgabe: `git commit` & `git push`

---
 
## Allgemeine Hinweise

* Die Lösung muss im vorgegebenen Projekt und somit in den vorhandenen Dateien erfolgen.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java Collections Framework zurückgreifen.
* Verändern Sie weder die vorgegebenen Methodensignaturen noch die Signaturen der Konstruktoren.
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Konstruktoren oder zusätzliche Methoden in 
  vorgegebenen Klassen müssen `private` sein. Ausgenommen davon sind Methoden, die durch ein vorgegebenes Interface
  gefordert sind.
* Stellen Sie sicher, dass alle Teile Ihres Projekts kompilierbar und ausführbar sind.
* Hinweise und zu bearbeitende Stellen sind im Code mit `TODO` gekennzeichnet.

---

## Aufgabenstellung

Dieses Aufgabenblatt behandelt Iteratoren für rekursive Datenstrukturen. Die drei gegebenen
Datenstrukturen `PhysicalDoublyLinkedList`, `PhysicalPhysicalTreeMap` und `PhysicalMultiTree` sollen iterierbar werden,
wobei bei `PhysicalPhysicalTreeMap` der Iterator über die Schlüssel iterieren soll.
Dazu müssen nicht nur diese Klassen angepasst werden, sondern auch neue Klassen für die jeweiligen 
Iteratoren erzeugt werden.

Im Skriptum wird in Abschnitt *Baum als sortierte Datensammlung* gezeigt, dass ein Iterator für einen Baum nicht 
einfach nur rekursiv „alles durchlaufen“ kann, sondern den Zustand einer begonnenen Traversierung speichern muss. 
Dazu wird der Rekursionsstack explizit durch Objekte simuliert. In diesem Aufgabenblatt übertragen Sie diese Idee
auf die in AB3.1 eingeführten Klassen `PhysicalMultiTree` und `PhysicalPhysicalTreeMap`.

---

Die zu bearbeitenden Dateien sind:

* [PhysicalDoublyLinkedListIterator.java](../src/PhysicalDoublyLinkedListIterator.java)
* [PhysicalDoublyLinkedListSortedIterator.java](../src/PhysicalDoublyLinkedListSortedIterator.java)
* [PhysicalDoublyLinkedList.java](../src/PhysicalDoublyLinkedList.java)
* [PhysicalPhysicalTreeMap.java](../src/PhysicalPhysicalTreeMap.java)
* [PhysicalPhysicalTreeMapNode.java](../src/PhysicalPhysicalTreeMapNode.java)
* [PhysicalMultiTree.java](../src/PhysicalMultiTree.java)
* [PhysicalMultiTreeNode.java](../src/PhysicalMultiTreeNode.java)
* [PhysicalMultiTreeNodeLeaf.java](../src/PhysicalMultiTreeNodeLeaf.java)
* [PhysicalMultiTreeNodeEmpty.java](../src/PhysicalMultiTreeNodeEmpty.java)
* [PhysicalMultiTreeNodeInternal.java](../src/PhysicalMultiTreeNodeInternal.java)

Folgende Dateien sind vollständig gegeben:

* [PhysicalDoublyLinkedListNode.java](../src/PhysicalDoublyLinkedListNode.java)
* [PhysicalIterable.java](../src/PhysicalIterable.java)
* [PhysicalIterator.java](../src/PhysicalIterator.java)
* [PhysicalIterableTreeNode.java](../src/PhysicalIterableTreeNode.java)
* [PhysicalTreeIterator.java](../src/PhysicalTreeIterator.java)
* [PhysicalPhysicalMap.java](../src/PhysicalPhysicalMap.java)
* [PhysicalPhysicalHashMap.java](../src/PhysicalPhysicalHashMap.java)
* [Physical.java](../src/Physical.java)
* [FoodSource.java](../src/FoodSource.java)
* [Nest.java](../src/Nest.java)
* [Vector2D.java](../src/Vector2D.java)
* [XComparator.java](../src/XComparator.java)
* [PhysicalComparator.java](../src/PhysicalComparator.java)


## Teilaufgabe 1 – Vergleich der Implementierungen

Vergleichen Sie Ihre Implementierung von AB3.1 mit den gegebenen Klassen. Welche Unterschiede gibt es?

---

## Teilaufgabe 2 – Iteratoren für `PhysicalDoublyLinkedList`

Machen Sie `PhysicalDoublyLinkedList` gemäß der Kommentare zu einem Untertyp von `PhysicalIterable`. Die Methode `iterator()`
liefert einen Iterator, der über alle Elemente der Liste in der entsprechenden Listenreihenfolge (angefangen vom Kopf der Liste bis
zum letzten Eintrag) traversiert. Vervollständigen Sie dazu die Klasse `PhysicalDoublyLinkedListIterator`.

Implementieren Sie auch die spezifizierte Methode `sortedIterator(PhysicalComparator)` und die entsprechende Klasse
`PhysicalDoublyLinkedListSortedIterator`. Orientieren Sie sich an den Beispielen im Skriptum.

---

## Teilaufgabe 3 – Iterator für `PhysicalPhysicalTreeMap` und `PhysicalMultiTree`

Auch `PhysicalPhysicalTreeMap` und `PhysicalMultiTree` sollen `PhysicalIterable` implementieren. Achten Sie auf die
weiter unten angeführten **Anforderungen**! 

Für `PhysicalPhysicalTreeMap` ist eine reverse in-order Traversierung umzusetzen:
```java
/**
 * {@inheritDoc}
 *
 * Returns an iterator over all keys stored in this map in descending
 * order according to the comparator of this tree map.
 *
 * <p>The iterator performs a reverse in-order traversal of the
 * underlying binary search tree.</p>
 *
 * <p>If the map is empty, the returned iterator has no
 * elements.</p>
 */
@Override
public PhysicalIterator iterator() {

    // TODO: implement method.
}
```

Für `PhysicalMultiTree` ist eine pre-order Traversierung umzusetzen:
```java
/**
 * {@inheritDoc}
 *
 * Returns an iterator that traverses all elements of this tree
 * in pre-order. 
 * 
 * <p>The children of a node must be traversed in the order in which
 * they appear in the array returned by {@link PhysicalMultiTreeNode#getChildren()}.</p>
 *
 * <p>If this tree is empty, the returned iterator has no
 * elements.</p>
 */
@Override
public PhysicalIterator iterator() {

    // TODO: implement method.
}
```

Der Iterator von `PhysicalPhysicalTreeMap` soll alle Schlüssel in absteigender Reihenfolge gemäß dem benutzten
`PhysicalComparator` liefern. Der Iterator von `PhysicalMultiTree` soll die Elemente des n-ären Baums `pre-order` liefern,
wobei die Kindknoten in der Reihenfolge traversiert werden, in der sie im von `getChildren()` gelieferten Array vorkommen.

### Anforderungen

Implementieren Sie den Iterator **nicht** mittels vollständiger Vorab-Speicherung aller Elemente in einer Liste oder 
einem Array. Stattdessen soll - analog zum Skriptumsbeispiel - der Zustand einer begonnenen Traversierung gespeichert werden.
Dazu ist die Klasse `PhysicalTreeIterator` bereits vollständig gegeben und entspricht dem Iterator-Beispiel aus dem Skriptum. 
Diese Klasse soll unverändert sowohl für den Iterator von
`PhysicalPhysicalTreeMap` als auch für den Iterator von `PhysicalMultiTree` genutzt werden. Beachten Sie, dass diese
Klasse das Interface `PhysicalIterableTreeNode` benutzt, dessen Methode `iter` die Traversierung der Bäume steuert.
Alle Baumknoten müssen dazu `PhysicalIterableTreeNode` implementieren. Der Schwerpunkt dieser Teilaufgabe ist daher
die Implementierung von `iter` in den Knotenklassen. Sie können sich dabei am Iterator-Beispiel aus dem Skriptum orientieren.

### Hinweis

Wie wird der Aufrufstack des Iterators durch die vorgegebenen Strukturen simuliert? Überlegen Sie, welche Informationen 
ein rekursiver Methodenaufruf implizit auf dem Aufrufstack speichert. 

Insbesondere:

- In welchem Teilbaum befinden Sie sich gerade?
- Welcher Nachfolger eines Knotens wäre als nächstes zu besuchen?
- Wie gelangt der Iterator wieder zu einem Elternknoten zurück?

---

## Denkanstöße

- Warum benötigt ein Iterator für einen Baum einen gespeicherten Zustand?
- Wie simuliert Ihre Implementierung den Rekursionsstack?
- Welche Vorteile hat dieses Vorgehen gegenüber einer vollständigen Vorab-Speicherung aller Elemente?
- Welche Vorteile hat dieses Vorgehen gegenüber einer rekursiven Implementierung von `next()`, die rekursiv `next()`
  von Iteratoren der Unterbäume aufruft? 

