# EP2 Aufgabenblatt 2.3

Kernthemen: doppelt verkettete Liste, Interfaces, `toString`

## Organisatorisches

Abgabe-Deadline: **28.4.2026, 13:00 Uhr**  
Art der Abgabe: `git commit` & `git push`

### Allgemeine Hinweise

* Die Lösung muss im vorgegebenen Projekt und somit in den vorhandenen Dateien erfolgen.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java Collections Framework zurückgreifen.
* Verändern Sie weder die vorgegebenen Methodensignaturen noch die Signaturen der Konstruktoren,  
  **mit Ausnahme der in Teilaufgabe 3 ausdrücklich geforderten Anpassung**.
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Methoden oder Konstruktoren in vorgegebenen Klassen
  müssen `private` sein, **mit Ausnahme der in Teilaufgabe 4 geforderten Methoden `toString` und `toIndentedString`**.
* Die Lösung von diesem Aufgabenblatt wird beim Test nicht nur lesbar zur Verfügung stehen, sondern dient 
  auch direkt als Arbeitsgrundlage. Aufgaben werden daher direkt in diesem Projekt zu lösen sein.
* Führen Sie aus diesem Grund keine zusätzlichen Klassen ein, um Namenskonflikte zu vermeiden.
* Führen Sie keine neuen Dateien ein.
* Stellen Sie unbedingt sicher, dass alle Teile Ihres Projekts kompilierbar und ausführbar sind.
* Hinweise und zu bearbeitende Stellen sind im Code mit `TODO` gekennzeichnet.

---

## Informationen zur Domäne

---

## Aufgabenstellung

Dieses Aufgabenblatt besteht aus vier Teilaufgaben:

1. Vergleich von Implementierungen
2. Doppelt verkettete Liste implementieren (`PhysicalDoublyLinkedList`)
3. `PhysicalComparator` implementieren und in `PhysicalStringTreeMap` nutzen
4. `toString`-Methode in `PhysicalStringTreeMap` implementieren, die die Baumstruktur sichtbar macht

Die zu bearbeitenden Dateien sind:

* [PhysicalDoublyLinkedList.java](../src/PhysicalDoublyLinkedList.java)
* [XComparator.java](../src/XComparator.java)
* [PhysicalStringTreeMap.java](../src/PhysicalStringTreeMap.java)
* [PhysicalStringTreeMapNode.java](../src/PhysicalStringTreeMapNode.java)

Die folgenden Klassen sind bereits vollständig gegeben und dürfen grundsätzlich nicht verändert werden:

* [Physical.java](../src/Physical.java)
* [PhysicalComparator.java](../src/PhysicalComparator.java)
* [PhysicalDoublyLinkedListNode.java](../src/PhysicalDoublyLinkedListNode.java)
* [Vector2D.java](../src/Vector2D.java)
* [Nest.java](../src/Nest.java)
* [FoodSource.java](../src/FoodSource.java)
* [PhysicalSinglyLinkedList.java](../src/PhysicalSinglyLinkedList.java)
* [PhysicalSinglyLinkedListNode.java](../src/PhysicalSinglyLinkedListNode.java)
* [PhysicalKDTreeSet.java](../src/PhysicalKDTreeSet.java)
* [PhysicalKDTreeSetNode.java](../src/PhysicalKDTreeSet.java)
* [PhysicalDoublyLinkedRingList.java](../src/PhysicalDoublyLinkedRingList.java)
* [PhysicalDoublyLinkedRingListNode.java](../src/PhysicalDoublyLinkedRingListNode.java)

Die Klasse [ApplicationAB2d3.java](../src/ApplicationAB2d3.java) können Sie zum Testen der
Datenstrukturen ([PhysicalDoublyLinkedList.java](../src/PhysicalDoublyLinkedList.java)
und [PhysicalStringTreeMap.java](../src/PhysicalStringTreeMap.java)) verwenden.
Diese Klasse stellt einige grundlegende Testfälle bereit, die bei Ausführung keine Ausnahmen (`Exception`) auslösen dürfen.
Die Ausführung dieser Testfälle muss mit Ihrer Implementierung zur Ausgabe von "OK" führen. Andernfalls ist Ihre
Implementierung jedenfalls mangelhaft. Beachten Sie jedoch, dass auch dann, wenn alle gegebenen Testfälle "OK" liefern,
dies nicht automatisch bedeutet, dass Ihre Implementierung vollständig korrekt ist. Darüber hinaus dürfen und sollten
Sie eigene Testfälle hinzufügen.

Die Klassen `PhysicalSinglyLinkedList`, `PhysicalKDTreeSet`, `PhysicalDoublyLinkedRingList` sowie die dazugehörigen 
`Node`-Klassen dienen als Referenzimplementierungen und werden nicht für die Implementierung der zu bearbeitenden Klassen 
gebraucht.

---

## Teilaufgabe 1 – Vergleich von Implementierungen

Die vorgegebenen Klassen `PhysicalSinglyLinkedList`, `PhysicalKDTreeSet` und `PhysicalDoublyLinkedRingList`
repräsentieren Datenstrukturen, wie Sie sie in Aufgabenblatt 2.1 und 2.2 selbst umgesetzt haben (teilweise mit
anderen Elementtypen). Vergleichen Sie Ihre Implementierung mit diesen Klassen. Welche Unterschiede gibt es?

Beim Test 2 in Woche 18 werden Sie dieses Aufgabenblatt mit diesen Klassen in den hier gezeigten Varianten
(mit den vorhandenen Methodensignaturen und Objektvariablen) als Arbeitsgrundlage für den Test zur Verfügung haben.
Aufgaben werden direkt in diesem Projekt zu lösen sein. Führen Sie aus diesem Grund keine zusätzlichen Dateien ein, um 
Namenskonflikte zu vermeiden.

---

## Teilaufgabe 2 – Doppelt verkettete Liste

Implementieren Sie die Klasse `PhysicalDoublyLinkedList` als doppelt verkettete Liste und nutzen Sie die
voegegebene `PhysicalDoublyLinkedListNode` Klasse für die Knoten.

* Die Liste soll nicht zyklisch organisiert sein.
* Es soll kein `nil`-Knoten verwendet werden.

---

## Teilaufgabe 3 – `PhysicalStringTreeMap` mit `PhysicalComparator` ausstatten

Implementieren Sie in der Klasse `PhysicalStringTreeMap` den folgenden Konstruktor:

```java
/**
 * Creates an empty map with specified comparator that defines the key order
 * of this tree.
 */
public PhysicalStringTreeMap(PhysicalComparator comparator) {

    // TODO: implement constructor.

}
```
Ändern Sie die Klasse so, dass die Ordnung der Schlüssel im Baum ausschliesslich mittels `comparator` 
erzeugt wird. Entsprechend müssen ev. auch bestehende Methodenimplementierungen in der 
Klasse [PhysicalStringTreeMapNode](../src/PhysicalStringTreeMapNode.java) geändert werden. Vervollständigen Sie dazu auch die Klasse `XComparator`.

### Anforderungen

* Die Ordnung der Schlüssel darf nicht mehr fest in der Baumklasse kodiert sein.
* Stattdessen muss die Vergleichslogik über ein Objekt vom Typ `PhysicalComparator` bereitgestellt werden.
* `XComparator` soll die Ordnung der Schlüssel lexikographisch anhand der Position festlegen:
  zuerst nach x, dann nach y.
* Die bereits vorhandenen Operationen der Map sollen weiterhin gemäß ihrer Spezifikation funktionieren.
* Der Konstruktor von [PhysicalStringTreeMap](../src/PhysicalStringTreeMap.java) ohne Parameter `comparator` soll 
  ein neues Objekt von `XComparator` verwenden. Passen Sie die Kommentare des Konstruktors entsprechend an.
  Auch in [PhysicalStringTreeMapNode](../src/PhysicalStringTreeMapNode.java) müssen entsprechende Änderungen gemacht werden.

Damit wird die Vergleichslogik von der Datenstruktur getrennt und austauschbar gemacht. 
Passen Sie Kommentare in der Baumklasse entsprechend an.

## Teilaufgabe 4 – `toString` Methode für `PhysicalStringTreeMap`

Fügen Sie der Klasse `PhysicalStringTreeMap` folgende Methodendefinition hinzu:

```java
/**
 * Returns a string representation of this map.
 *
 * <p>Each node of the underlying binary search tree is shown in its own line.
 * Child nodes are indented relative to their parent so that the tree structure
 * becomes visible.</p>
 *
 * <p>The left subtree is shown before the right subtree.</p>
 *
 * <p>
 * Example:
 *
 * FoodSource@(350.0, 300.0), r=80.0 -> "A"
 *   FoodSource@(300.0, 200.0), r=50.0 -> "B"
 *   Nest@(400.0, 300.0), r=100.0 -> "C"
 *     Nest@(420.0, 320.0), r=20.0 -> "D"
 * </p>
 *
 * @return a string representation of this map
 */
@Override
public String toString() {

    //TODO: implement method.
}
```

Die Implementierung dieser Methode soll folgende Methode der Knotenklasse `PhysicalStringTreeMapNode` nutzen.
Implementieren Sie auch diese: 

```java
/**
 * Returns a string representation of this subtree in the same format as
 * described in {@link PhysicalStringTreeMap#toString()}, using the specified
 * indentation.
 *
 * @param indent the indentation prefix for this node
 * @return a string representation of this subtree
 */
public String toIndentedString(String indent) {

  //TODO: implement method.
}
```

---

## Denkanstöße

* Welche Vorteile hat die Verwendung des Interfaces `PhysicalComparator` gegenüber einer fest codierten Ordnung?
* Welche Vor- und Nachteile haben einfach bzw. doppelt verkettete Listen?
* Welche Methoden in `PhysicalSinglyLinkedList` würden durch eine zusätzliche Objektvariable `last` einfacher?
* Warum lässt sich die Klasse `ApplicationAB2d3` fehlerfrei übersetzen, bevor in `PhysicalStringTreeMap` eine 
  eigene `toString`-Methode deklariert wurde?

