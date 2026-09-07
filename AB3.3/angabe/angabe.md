# EP2 Aufgabenblatt 3.3

Kernthemen: Mengen und Maps, rekursive Datenstrukturen, Gleichheit und Hashcodes

## Organisatorisches

Abgabe-Deadline: **26.05.2026, 13:00 Uhr**  
Art der Abgabe: `git commit` & `git push`

---

## Allgemeine Hinweise

* Die Lösung muss im vorgegebenen Projekt und somit in den vorhandenen Dateien erfolgen.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java Collections Framework zurückgreifen.
* Verändern Sie weder die vorgegebenen Methodensignaturen noch die Signaturen der Konstruktoren.
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Konstruktoren oder zusätzliche Methoden in
  vorgegebenen Klassen müssen `private` sein. Ausgenommen davon sind Methoden, die durch ein vorgegebenes Interface
  gefordert sind oder überschriebene öffentliche Methoden.
* Ihre Lösung von diesem Aufgabenblatt wird beim Test nicht nur lesbar zur Verfügung stehen, sondern dient
  auch direkt als Arbeitsgrundlage. Aufgaben werden daher direkt in diesem Projekt zu lösen sein.
* Führen Sie aus diesem Grund keine zusätzlichen Klassen ein, um Namenskonflikte zu vermeiden.
* Führen Sie keine neuen Dateien ein.
* Stellen Sie sicher, dass alle Teile Ihres Projekts kompilierbar und ausführbar sind.
* Hinweise und zu bearbeitende Stellen sind im Code mit `TODO` gekennzeichnet.

---

## Aufgabenstellung

Dieses Aufgabenblatt erweitert die Datenstrukturen aus AB3.1 und AB3.2 um zusätzliche
abstrakte Datentypen und Operationen.

Im Mittelpunkt stehen:

* die Implementierung einer Mengenstruktur (`PhysicalSet`)
* binäre Suchbäume mit Knoten-Interface
* Iteratoren
* inhaltliche Gleichheit (`equals`)
* konsistente Hashcodes (`hashCode`)
* die Trennung zwischen abstrakter Semantik und interner Repräsentation

---

Zu bearbeitende Dateien sind

* PhysicalTreeSet-Dateien:
  * [PhysicalTreeSet.java](../src/PhysicalTreeSet.java)
  * [PhysicalTreeSetNodeEmpty.java](../src/PhysicalTreeSetNodeEmpty.java)
  * [PhysicalTreeSetNodeNonEmpty.java](../src/PhysicalTreeSetNodeNonEmpty.java)

* PhysicalPhysicalMap-Dateien:
  * [PhysicalPhysicalHashMapIterator.java](../src/PhysicalPhysicalHashMapIterator.java)
  * [PhysicalPhysicalHashMap.java](../src/PhysicalPhysicalHashMap.java)
  * [PhysicalPhysicalTreeMap.java](../src/PhysicalPhysicalTreeMap.java)

Folgende Dateien sind vollständig gegeben:

* PhysicalTreeSet-Dateien:
  * [PhysicalTreeSetNode.java](../src/PhysicalTreeSetNode.java)

* PhysicalPhysicalMap-Dateien:
  * [PhysicalPhysicalMap.java](../src/PhysicalPhysicalMap.java)
  * [PhysicalPhysicalTreeMapNode.java](../src/PhysicalPhysicalTreeMapNode.java)
  * [PhysicalPhysicalTreeMapNodeEmpty.java](../src/PhysicalPhysicalTreeMapNodeEmpty.java)
  * [PhysicalPhysicalTreeMapNodeNonEmpty.java](../src/PhysicalPhysicalTreeMapNodeNonEmpty.java)
  
* sonstige Interfaces:
  * [Physical.java](../src/Physical.java)
  * [PhysicalSet.java](../src/PhysicalSet.java)
  * [PhysicalComparator.java](../src/PhysicalComparator.java)
  * [PhysicalIterator.java](../src/PhysicalIterator.java)
  * [PhysicalIterable.java](../src/PhysicalIterable.java)
  * [PhysicalIterableTreeNode.java](../src/PhysicalIterableTreeNode.java)
  * [PhysicalTreeIterator.java](../src/PhysicalTreeIterator.java)
  
* sonstige fertige Klassen:
  * [FoodSource.java](../src/FoodSource.java)
  * [Nest.java](../src/Nest.java)
  * [Vector2D.java](../src/Vector2D.java)
  * [XComparator.java](../src/XComparator.java)

Die Klasse [ApplicationAB3d3.java](../src/ApplicationAB3d3.java) können Sie zum Testen der Datenstrukturen verwenden.
Diese Klasse stellt einige grundlegende Testfälle bereit, die bei Ausführung keine Ausnahmen (`Exception`) auslösen dürfen.
Die Ausführung dieser Testfälle muss mit Ihrer Implementierung zur Ausgabe von "OK" führen. Andernfalls ist Ihre
Implementierung jedenfalls mangelhaft. Beachten Sie jedoch, dass auch dann, wenn alle gegebenen Testfälle "OK" liefern,
dies nicht automatisch bedeutet, dass Ihre Implementierung vollständig korrekt ist. Darüber hinaus dürfen und sollten
Sie eigene Testfälle hinzufügen.

---

## Teilaufgabe 1 – `PhysicalTreeSet`

Implementieren Sie `PhysicalSet` als binären Suchbaum in der Klasse `PhysicalTreeSet` unter Verwendung der
Knotenschnittstelle `PhysicalTreeSetNode`. Implementieren Sie die Knotenschnittstelle in
`PhysicalTreeSetNodeEmpty` und `PhysicalTreeSetNodeNonEmpty`.

Die Ordnung der Elemente wird durch einen `PhysicalComparator`
festgelegt. Der Iterator des Sets soll die Elemente in aufsteigender Reihenfolge
gemäß dem verwendeten Comparator liefern. Implementieren Sie die Traversierung analog zum Baumiterator aus AB3.2
unter Verwendung von `PhysicalTreeIterator` und der Methode `PhysicalTreeSetNode#iter()`.
Lesen Sie sich dazu die Spezifikation von `PhysicalIterableTreeNode` durch.
Verwenden Sie keine vollständige Vorab-Speicherung aller Elemente. Der Traversierungszustand soll explizit
gespeichert werden.

---

## Teilaufgabe 2 – Iterator für `PhysicalPhysicalHashMap`

Da `PhysicalPhysicalHashMap` nun Untertyp von `PhysicalIterable` ist muss die Methode `iterator()` implementiert werden. 
Vervollständigen Sie dazu die Klasse `PhysicalHashMapIterator`. 

Der Iterator soll alle aktuell in der Hashmap gespeicherten Schlüssel liefern.

### Anforderungen

* Die Reihenfolge der Traversierung ist nicht spezifiziert.
* `null` darf niemals als reguläres Element geliefert werden.
* Die Implementierung darf keine zusätzliche Vorab-Speicherung aller Schlüssel in einer separaten
  Datenstruktur verwenden.
* Der Iterator soll direkt auf dem internen Array der Hashmap arbeiten.

### Hinweise

Die Hashmap verwendet offene Adressierung mit linearer Sondierung. Dadurch können belegte Einträge an
beliebigen Positionen im internen Array auftreten.

Überlegen Sie insbesondere:

* Welche Information muss der Iterator als Zustand speichern?
* Wie findet der Iterator den nächsten belegten Array-Eintrag?
* Wann ist die Traversierung beendet?

## Teilaufgabe 3 – `equals` und `hashCode`

Implementieren Sie `equals` und `hashCode` in folgenden Klassen gemäß den jeweiligen Spezifikationen:

* `PhysicalTreeSet`
* `PhysicalPhysicalHashMap`
* `PhysicalPhysicalTreeMap`

Beachten Sie dabei insbesondere die unterschiedlichen Gleichheitsbedingungen der Datenstrukturen:

* Gemäß der Spezifikation von `PhysicalTreeSet` kann ein Objekt nur dann gleich `this` sein, wenn es ebenfalls ein 
  Objekt der Klasse `PhysicalTreeSet` ist.
* Gemäß der Spezifikation von `PhysicalPhysicalMap` können hingegen auch Objekte unterschiedlicher Klassen gleich sein, 
  sofern sie dieselben Schlüssel-Wert-Assoziationen repräsentieren.

---

## Teilaufgabe 4 – Methode `keySet()` implementieren

Implementieren Sie die Methode `keySet()` in den Klassen, die `PhysicalPhysicalMap` implementieren.

## Zusätzliche Übungsmöglichkeiten (freiwillig – nicht Teil dieses Aufgabenblatts)

* Spezifizieren und überschreiben Sie `equals` und `hashCode` in den Klassen `PhysicalDoublyLinkedList` und 
  `PhysicalMultiTree` aus AB3.2.
* Entwickeln Sie eine alternative Spezifikation von `equals` und `hashCode` für `PhysicalTreeSet`,
  bei der nicht nur die gespeicherten Elemente, sondern auch die konkrete Struktur des binären Suchbaums
  berücksichtigt wird. Überlegen Sie insbesondere:
  * Wann sollen zwei Baumstrukturen als gleich gelten? Worin unterscheidet sich eine strukturabhängige Gleichheit 
    von der üblichen Mengensemantik?
  * Welche Auswirkungen hat die Einfügereihenfolge auf die Gleichheit?
  * Wie muss `hashCode` angepasst werden, damit die Beziehung zwischen `equals` und `hashCode`
    weiterhin korrekt bleibt?

## Denkanstöße

- Welche alternativen Implementierungen von `equals` für `PhysicalMultiTree` fallen Ihnen ein, 
  die dieselbe Spezifikation erfüllen?
- Welche Auswirkungen kann es auf ein bereits existierendes Iterator-Objekt haben, wenn während einer laufenden
  Traversierung neue Assoziationen in die Hashmap eingefügt werden? Wie verhält sich dies bei `PhysicalTreeSet`?
- Wie könnte man einen post-order Iterator implementieren, der zuerst die Blattknoten eines Knotens traversiert,
  bevor der Wert des Knotens zurückgegeben wird?
- Warum spielt bei der Implementierung von `equals` die Reihenfolge der Elemente bei Mengen (wie etwa `PhysicalTreeSet`)
  typischerweise keine Rolle?
