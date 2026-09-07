# EP2 Aufgabenblatt 4.1

Kernthemen: Sichtbarkeit vs. Kopie, Iteratoren, Java-Collections, Ausnahmen

## Organisatorisches

Abgabe-Deadline: **9.6.2026, 13:00 Uhr**  
Art der Abgabe: `git commit` & `git push`

---

## Allgemeine Hinweise

* Die Lösung muss im vorgegebenen Projekt und somit in den vorhandenen Dateien erfolgen.
* Verändern Sie weder die vorgegebenen Methodensignaturen noch die Signaturen der Konstruktoren.
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Konstruktoren oder zusätzliche Methoden in
  vorgegebenen Klassen müssen `private` sein. Ausgenommen davon sind Methoden, die durch ein vorgegebenes Interface
  gefordert sind oder überschriebene öffentliche Methoden.
* Stellen Sie sicher, dass alle Teile Ihres Projekts kompilierbar und ausführbar sind.
* Hinweise und zu bearbeitende Stellen sind im Code mit `TODO` gekennzeichnet.
* Die Verwendung von `java.util.Stack` bei der Implementierung von `PhysicalPhysicalTreeMapSetViewIterator` ist 
  in dieser Aufgabe ausdrücklich erlaubt.

---

## Aufgabenstellung

Dieses Aufgabenblatt erweitert die vorhandenen Map-Implementierungen um eine Methode.

Im Mittelpunkt stehen:

* die Implementierung der in `PhysicalPhysicalMap` spezifizierten Methode `keySetView()`
* Mengen-Sichtweisen auf die Schlüssel der Map
* Iteratoren über Mengen-Sichtweisen ohne vollständige Vorab-Speicherung aller Elemente
* Verwendung von `java.util.Stack`
* Erkennung struktureller Änderungen während einer Iteration
* Auslösen von Ausnahmen
* eigene Klasse `ConcurrentModificationException` definieren

---

Zu bearbeitende Dateien sind:

* PhysicalPhysicalHashMap-Dateien:
  * [PhysicalPhysicalHashMap.java](../src/PhysicalPhysicalHashMap.java)
  * [PhysicalPhysicalHashMapSetViewIterator.java](../src/PhysicalPhysicalHashMapSetViewIterator.java)
  * [PhysicalPhysicalHashMapSetView.java](../src/PhysicalPhysicalHashMapSetView.java)

* PhysicalPhysicalTreeMap-Dateien:
  * [PhysicalPhysicalTreeMap.java](../src/PhysicalPhysicalTreeMap.java)
  * [PhysicalPhysicalTreeMapSetView.java](../src/PhysicalPhysicalTreeMapSetView.java)
  * [PhysicalPhysicalTreeMapSetViewIterator.java](../src/PhysicalPhysicalTreeMapSetViewIterator.java)

* Exception-Klassen:
  * [ConcurrentModificationException.java](../src/ConcurrentModificationException.java)

Folgende Dateien sind vollständig gegeben und dürfen nicht verändert werden:

* Map-Interfaces und Baumknoten:
  * [PhysicalPhysicalMap.java](../src/PhysicalPhysicalMap.java)
  * [PhysicalPhysicalTreeMapNode.java](../src/PhysicalPhysicalTreeMapNode.java)
  * [PhysicalPhysicalTreeMapNodeEmpty.java](../src/PhysicalPhysicalTreeMapNodeEmpty.java)
  * [PhysicalPhysicalTreeMapNodeNonEmpty.java](../src/PhysicalPhysicalTreeMapNodeNonEmpty.java)

* Set- und Iterator-Interfaces und Klassen:
  * [PhysicalSet.java](../src/PhysicalSet.java)
  * [PhysicalIterable.java](../src/PhysicalIterable.java)
  * [PhysicalIterator.java](../src/PhysicalIterator.java)

* sonstige Klassen und Interfaces:
  * [Physical.java](../src/Physical.java)
  * [PhysicalComparator.java](../src/PhysicalComparator.java)
  * [FoodSource.java](../src/FoodSource.java)
  * [Nest.java](../src/Nest.java)
  * [Vector2D.java](../src/Vector2D.java)
  * [XComparator.java](../src/XComparator.java)

---
## Teilaufgabe 1 - Vergleich von Implementierungen

Vergleichen Sie Ihre Implementierung aus AB3.2 mit den nun gegebenen Klassen und lesen Sie die neuen Spezifikationen 
sorgfältig durch. Das Interface `PhysicalPhysicalMap` besitzt nun anstelle der Methode `keySet` aus AB3.3, die eine 
unabhängige Kopie aller Schlüssel liefert, die Methode `keySetView`. Diese liefert eine `PhysicalSet`-Sichtweise auf 
die aktuell in der Map gespeicherten Schlüssel. Änderungen an der Map werden daher in der Sichtweise sichtbar und umgekehrt.

Beachten Sie, dass Werte in `PhysicalPhysicalMap` in dieser Version auch `null` sein dürfen.

Beachten Sie außerdem, dass `PhysicalPhysicalMap` im Unterschied zu früheren Versionen nicht mehr iterierbar ist.
Da `PhysicalSet` die Methode `iterator()` spezifiziert, müssen nun stattdessen die Sichtweisen iterierbar sein. 
`PhysicalIterator` spezifiziert die Methode `next()` so, dass diese eine eigens definierte 
`ConcurrentModificationException` auslösen kann, wenn während einer laufenden Iteration strukturelle Änderungen an 
der zugrunde liegenden Datenstruktur erkannt werden. Dieses sogenannte „Fail-Fast“-Verhalten verhindert 
inkonsistente Traversierungen.

Die Methode `put(...)` von `PhysicalPhysicalTreeMapNode` besitzt nun eine geänderte Signatur. 
Referenzen bzw. Werte werden teilweise über Arrays übergeben. Dadurch können Änderungen innerhalb 
rekursiver Aufrufe nach außen sichtbar gemacht werden.

Beachten Sie außerdem, dass `PhysicalPhysicalTreeMapNode` im Unterschied zu früheren Versionen nicht mehr 
iterierbar ist, also kein Untertyp von `PhysicalIterableTreeNode` mehr ist.

## Teilaufgabe 2 – Implementieren von `keySetView()`

Vervollständigen Sie die Implementierungen von `PhysicalPhysicalMap` in den Klassen
`PhysicalPhysicalHashMap` und `PhysicalPhysicalTreeMap`. Im Vordergrund steht dabei die Methode
`keySetView()`, die eine `PhysicalSet`-Sichtweise auf die Schlüssel der Map zurückliefert.

Die Sichtweisen sollen in den Klassen `PhysicalPhysicalHashMapSetView` und `PhysicalPhysicalTreeMapSetView` implementiert
werden. Die Sichtweise speichert keine eigenen Elemente, sondern arbeitet direkt auf der zugrunde liegenden Map.

Dabei gilt für die Sichtweise:

* `add(p)` fügt `p` als Schlüssel in die zugrunde liegende Map ein und assoziiert den Schlüssel mit `null`.
  Beachten Sie, dass Werte in `PhysicalPhysicalMap` in dieser Version auch `null` sein dürfen.
* `contains(p)` prüft, ob `p` als Schlüssel in der Map enthalten ist.
* `size()` liefert die Größe der zugrunde liegenden Map.
* `isEmpty()` prüft, ob die zugrunde liegende Map leer ist.
* `clear()` leert die zugrunde liegende Map.
* `iterator()` liefert einen Iterator über alle aktuell gespeicherten Schlüssel der zugrunde liegenden Map.

Die Iteratoren sollen strukturelle Änderungen während einer Iteration erkennen. Strukturelle Änderungen sind 
insbesondere das Einfügen eines neuen Schlüssels und das Leeren der Map.
Dazu steht in den Map-Klassen jeweils ein gemeinsamer Modifikationszähler zur Verfügung. 

Es gelten folgende Anforderungen:

* Der Modifikationszähler wird bei strukturellen Änderungen erhöht, insbesondere beim Einfügen eines neuen Schlüssels
  und beim Leeren der Map.
* Iteratoren speichern beim Erzeugen den aktuellen Wert des Modifikationszählers.
* Bei `next()` wird geprüft, ob der gespeicherte Wert noch dem aktuellen Wert entspricht.
* Falls nicht, wird eine `ConcurrentModificationException` geworfen.
* `hasNext()` muss lediglich angeben, ob noch ein weiteres Element vorhanden ist. Eine Erkennung nebenläufiger
  struktureller Änderungen in `hasNext()` ist nicht erforderlich.

Nicht jede Änderung ist strukturell. Das Ersetzen eines Werts zu einem bereits vorhandenen Schlüssel verändert die
Schlüsselmenge nicht und muss daher nicht als strukturelle Änderung behandelt werden. Überlegen Sie: Wann muss der 
gespeicherte Modifikationszähler mit dem aktuellen Modifikationszähler verglichen werden?

Vervollständigen Sie für die Implementierung der Iteratoren die Klassen `PhysicalPhysicalHashMapSetViewIterator` 
und `PhysicalPhysicalTreeMapSetViewIterator`. Der Iterator soll direkt auf den zugrunde liegenden
Datenstrukturen arbeiten. Die Implementierung darf keine zusätzliche Vorab-Speicherung aller Schlüssel in einer separaten 
Datenstruktur verwenden.

Vervollständigen Sie die Definition der Klasse `ConcurrentModificationException`. Achten Sie darauf, dass die Fehlermeldung
dem spezifizierten Format entspricht. Die Nachricht soll die Form `"2 modification(s) detected!"` haben.

### Spezielle Anforderungen an `PhysicalPhysicalTreeMapSetViewIterator`

In AB3.2 wurde der Iterator durch Implementierungen von `PhysicalIterableTreeNode` und `PhysicalTreeIterator` umgesetzt.
Diese Interfaces gibt es nun nicht mehr. Stattdessen soll in der Implementierung von `PhysicalPhysicalTreeMapSetViewIterator`
der Iteratorzustand explizit durch ein Objekt der vorgefertigten Java-Klasse `java.util.Stack<PhysicalPhysicalTreeMapNode>`
repräsentiert werden.

Der Iterator soll die Schlüssel in der durch den Comparator der zugrunde liegenden TreeMap definierten aufsteigenden 
Ordnung liefern, also gemäß einer in-order Traversierung. Die Set-View darf keinen eigenen, unabhängigen Comparator verwenden. 
Sie muss dieselbe Ordnung verwenden wie die zugrunde liegende TreeMap.

---

## Denkanstöße

* In welcher Situation verhält sich die von `keySetView()` gelieferte Datenstruktur anders als die Datenstruktur,
  die in AB3.3 von `keySet()` geliefert wurde?
* Was kann passieren, wenn eine Sichtweise einen anderen Comparator verwendet als die zugrunde liegende TreeMap?
* Wie könnten Sie die Sichtweise implementieren, die einen eigenen Comparator zulässt?
* Warum muss ein Iterator über eine Hashmap belegte und unbelegte Tabellenplätze unterscheiden?
* Warum darf der Iterator `null` nicht als reguläres Element liefern?
* Warum ist das Ersetzen eines Werts in einer Map keine strukturelle Änderung?
* Warum hat der Konstruktor von `PhysicalPhysicalTreeMapSetViewIterator` den Parameter `PhysicalPhysicalTreeMapNode root` 
  und nicht `PhysicalPhysicalTreeMapNode[] rootBox`? Wann wäre `rootBox` besser geeignet?
* Wie könnten Sie das Fail-Fast-Verhalten auch in `hasNext()` implementieren? Welchen Vorteil hätte dies?
* Überlegen Sie, welche Änderungen in welchen Dateien notwendig wären, wenn `next()` eine `NoSuchElementException`
  auslösen soll, sobald kein weiteres Element mehr vorhanden ist.
* Wie könnten Sie den Iterator von `PhysicalPhysicalTreeMapSetView` nach dem Muster aus AB3.2 mit den
  vorgegebenen Interfaces `PhysicalIterableTreeNode` und `PhysicalTreeIterator` implementieren?
  Welche Änderungen an bestehenden Klassen und welche neuen Klassen wären dafür notwendig, wenn alle gegebenen
  Interfaces unverändert bleiben sollen?