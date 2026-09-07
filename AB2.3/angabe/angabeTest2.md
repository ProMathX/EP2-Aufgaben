# EP2 Test 2

### Allgemeine Hinweise

* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt und damit in den vorhandenen
 Dateien erfolgen.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java Collections Framework
 zurückgreifen.
* Verändern Sie weder die vorgegebenen Methodensignaturen noch die Signaturen der
 Konstruktoren.
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Methoden oder 
 Konstruktoren in vorgegebenen Klassen müssen `private` sein. Die einzige Ausnahme 
 ist die Klasse [PhysicalStringTreeMapNode.java](../src/PhysicalStringTreeMapNode.java),
 bei der Sie zusätzliche `public` Methoden hinzufügen können.
* Definieren Sie keine zusätzlichen Klassen.
* Nicht kompilierbare Projekte werden ausnahmslos mit 0 Punkten bewertet.

## Information zur Domäne

Die Aufgabenstellung modelliert ein Universum (`Universe`) als sortierte Sammlung von
Himmelskörpern. Die Himmelskörper (`CelestialBody`) sind ein Untertyp von `Physical`
und besitzen demnach eine Position und einen Radius. `CelestialBody`-Objekte werden 
im Universe in einer `UniverseTreeMap` organisiert. Die `UniverseTreeMap` ist wie 
`PhysicalStringTreeMap` eine assoziative Datenstruktur, die `Physical`-Objekte mit
einem String assoziiert. Dadurch können die Himmelskörper mit einem Namen versehen 
und gleichzeitig nach der Distanz zum Koordinatenursprung sortiert werden.
`UniverseTreeMap` nutzt zum Vergleich von `Physical`-Objekten einen 
`DistanceComparator`, der das Interface `PhysicalComparator` implementiert.

## Aufgabenstellung

Die für diesen Test zu bearbeitenden Dateien sind:

* [DistanceComparator.java](../src/DistanceComparator.java)
* [UniverseTreeMap.java](../src/UniverseTreeMap.java) und zusätzlich die bestehende Node-Klasse [PhysicalStringTreeMapNode.java](../src/PhysicalStringTreeMapNode.java)
* [Universe.java](../src/Universe.java)

Vervollständigen Sie diese Klassen an den mit TODO markierten Stellen.
Die Klasse [CelestialBody.java](../src/CelestialBody.java) ist bereits vollständig vorgegeben und darf 
nicht verändert werden.

Die Klasse [ApplicationTest2.java](../src/ApplicationTest2.java) kann zum Testen Ihrer Implementierung verwendet
werden.

Folgende Dateien (aus AB2.3) werden verwendet, sollen aber nicht bearbeitet werden:

* [Physical.java](../src/Physical.java)
* [PhysicalComparator.java](../src/PhysicalComparator.java)


### Punkteverteilung

* `DistanceComparator`: 1 Punkt
* `UniverseTreeMap`: 14 Punkte
* `Universe`: 3 Punkte

**Total: 18 Punkte**