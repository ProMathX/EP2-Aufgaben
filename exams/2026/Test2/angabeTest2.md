# EP2 Test 2

### Allgemeine Hinweise

* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt und damit in den vorhandenen
 Dateien erfolgen.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java Collections Framework
 zurückgreifen.
* Verändern Sie weder die vorgegebenen Methodensignaturen noch die Signaturen der
 Konstruktoren.
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Methoden oder 
 Konstruktoren in vorgegebenen Klassen müssen `private` sein.
* Definieren Sie keine zusätzlichen Klassen.
* Nicht kompilierbare Projekte werden ausnahmslos mit 0 Punkten bewertet.

## Information zur Domäne

Die Aufgabenstellung modelliert ein Universum (`Universe`) als sortierte Sammlung von
Himmelskörpern. Die Himmelskörper (`CelestialBody`) sind ein Untertyp von `Physical`
und besitzen neben Position und Radius zusätzlich einen  Namen. 
`CelestialBody`-Objekte werden im Universe in absteigender Reihenfolge nach ihrem 
Radius sortiert. Das `Universe` nutzt zur sortierten Speicherung der Himmelskörper die
einfach verkettete Liste `OrderedPhysicalSinglyLinkedList`, welche Physical-Objekte
absteigend nach ihrem Radius organisiert. `OrderedPhysicalSinglyLinkedList` nutzt zum 
Vergleich von `Physical`-Objekten einen `RadiusComparator`, der das Interface
`PhysicalComparator` implementiert.

## Aufgabenstellung

Die für diesen Test zu bearbeitenden Dateien sind:

* [RadiusComparator.java](../src/RadiusComparator.java)
* [OrderedPhysicalSinglyLinkedList.java](../src/OrderedPhysicalSinglyLinkedList.java)
* [Universe.java](../src/Universe.java)

Vervollständigen Sie diese Klassen an den mit TODO markierten Stellen.
Die Klasse [CelestialBody.java](../src/CelestialBody.java) ist bereits vollständig vorgegeben und darf 
nicht verändert werden.

Die Klasse [ApplicationTest2.java](../src/ApplicationTest2.java) kann zum Testen Ihrer Implementierung verwendet
werden.

Folgende Dateien (aus AB2.3) werden verwendet, sollen aber nicht bearbeitet werden:

* [Physical.java](../src/Physical.java)
* [PhysicalComparator.java](../src/PhysicalComparator.java)
* [Vector2D.java](../src/Vector2D.java)
* [PhysicalSinglyLinkedListNode](../src/PhysicalSinglyLinkedListNode.java)


### Punkteverteilung

* `RadiusComparator`: 1 Punkt
* `OrderedPhysicalSinglyLinkedList`: 13 Punkte
* `Universe`: 4 Punkte

**Total: 18 Punkte**