# EP2 Aufgabenblatt 4.3

Kernthemen: Java Collections Framework, Iteratoren, Sichtweise vs. Kopie, Datei-Ein- und Ausgabe (IO), Testen, 
Programmverstehen, Ausnahmen bei Iteratoren und IO

## Organisatorisches

Abgabe-Deadline: **23.6.2026, 13:00 Uhr**  
Art der Abgabe: `git commit` & `git push`

---

## Allgemeine Hinweise

* Die Lösung muss im vorgegebenen Projekt und somit in den vorhandenen Dateien erfolgen.
* Die Verwendung von Klassen aus dem Java Collections Framework ist in dieser Aufgabe ausdrücklich erlaubt und erwünscht.
* Verändern Sie weder die vorgegebenen Methodensignaturen noch die Signaturen der Konstruktoren.
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Konstruktoren oder zusätzliche Methoden in 
  vorgegebenen Klassen müssen `private` sein. Ausgenommen davon sind Methoden, die durch ein vorgegebenes Interface 
  gefordert sind oder überschriebene öffentliche Methoden. Zusätzlich ausgenommen sind Konstruktoren der
  Klassen `ProjectFileCollectionView` und `ProjectDirectoryCollectionView`.
* Definieren Sie keine geschachtelten oder (anonymen) inneren Klassen, also keine Klassen, die
  in einer anderen Klasse, einem Objekt oder einer Methode stehen. Stattdessen sollen vorgegebene öffentliche 
  Hilfsklassen vervollständigt werden.
* Stellen Sie sicher, dass alle Teile Ihres Projekts kompilierbar und ausführbar sind.
* Hinweise und zu bearbeitende Stellen sind im Code mit `TODO` gekennzeichnet.
* Folgen Sie den Prinzipien von Design by Contract.

---

## Aufgabenstellung

Dieses Aufgabenblatt behandelt die Verwaltung hierarchischer Projektstrukturen.

Im Mittelpunkt stehen:

* Rekursive Datenstrukturen
* Sichtweisen auf Datenstrukturen
* Iteratoren über Baumstrukturen
* Verwendung vorgefertigter Java Collections
* Datei-Ein- und Ausgabe (IO)

---

Zu bearbeitende Dateien sind:

* [ProjectFile.java](../src/ProjectFile.java)
* [ProjectDirectory.java](../src/ProjectDirectory.java)

* [ProjectFileCollectionView.java](../src/ProjectFileCollectionView.java)
* [ProjectDirectoryCollectionView.java](../src/ProjectDirectoryCollectionView.java)

* [ProjectTreeIterator.java](../src/ProjectTreeIterator.java)

* [ProjectIO.java](../src/ProjectIO.java)

Folgende Dateien sind bereits vollständig gegeben:
* [ProjectIterator.java](../src/ProjectIterator.java)
* [ProjectIterable.java](../src/ProjectIterable.java)
* [ProjectNode.java](../src/ProjectNode.java)
* [ProjectNodeCollection.java](../src/ProjectNodeCollection.java)
* [ProjectNodeSizeComparator.java](../src/ProjectNodeSizeComparator.java)

Die Datei [ApplicationAB4d3.java](../src/ApplicationAB4d3.java) kann zum Testen Ihrer Implementierung verwendet werden.
Die Datei [ApplicationProjectTree.java](../src/ApplicationProjectTree.java) beinhaltet eine zusätzliche, vollständig gegebene ausführbare 
Klasse zum Testen Ihrer Klassen.

---

## Teilaufgabe 1 – Projektbaum bestehend aus Blatt- und Composite-Knoten

Ein Projektbaum besteht aus Dateien und Verzeichnissen.

Implementieren Sie die beiden Klassen

* `ProjectFile`
* `ProjectDirectory`

als konkrete Implementierungen des Interfaces `ProjectNode`.

Dabei gilt:

* Eine Datei entspricht einem Blattknoten.
* Ein Verzeichnis ist ein Composite-Knoten und kann beliebig viele Kindknoten enthalten.
* Die Methoden `totalBytes()` und `fileCount()` sollen rekursiv über den Teilbaum arbeiten.
* Jeder Knoten stellt über `ProjectNodeCollection collectionView()` eine Sichtweise auf den 
  durch ihn repräsentierten Teilbaum bereit.
* Zur Implementierung der Sichtweise auf `ProjectFile` und `ProjectDirectory` sollen die Klassen
  `ProjectFileCollectionView` bzw. `ProjectDirectoryCollectionView` benutzt werden.
* Zur Implementierung des Iterators der Sichtweise soll die Klasse `ProjectTreeIterator` genutzt werden.
* Die vollständig gegebene Klasse `ProjectNodeSizeComparator` kann zum Sortieren von Projektknoten 
  nach `totalBytes()` verwendet werden.

### Textuelle Darstellung eines Projektbaums

Die Methode `toString()` soll eine Baumdarstellung des gesamten
Teilbaums erzeugen, inklusive der Gesamtgröße einzelner Knoten (`totalBytes`). 
Die Ausgabe soll folgendem Muster entsprechen:

```text
project, 65
├── src, 30
│   ├── Main.java, 10
│   └── World.java, 20
└── README.md, 35
```

Ein Großteil der Implementierung ist bereits vorgegeben. Ergänzen Sie die fehlende Implementierung in
`ProjectFile`. Die bereits gegebene Klasse `ApplicationProjectTree` verwendet diese Darstellung zur Ausgabe 
des eingelesenen Projektbaums.

### Gleichheit von Projektknoten

Implementieren Sie geeignete Versionen von `equals(...)` und `hashCode()` für die Klassen `ProjectFile` und `ProjectDirectory`.
Begründen Sie Ihre Entscheidung, welche Eigenschaften eines Projektknotens zur Bestimmung der Gleichheit herangezogen werden.

### Spezielle Anforderungen an den Iterator

Der Iterator soll die Knoten eines Teilbaums in **Pre-Order-Reihenfolge** liefern.

Dabei wird zunächst der aktuelle Knoten besucht. Anschließend werden seine Teilbäume in der Reihenfolge traversiert, 
in der die entsprechenden Kindknoten von `getChildren()` geliefert werden.

Beispiel:

```text
project, 65
├── src, 30
│   ├── Main.java, 10
│   └── World.java, 20
└── README.md, 35
```

Die Traversierung ergibt:

```text
project
src
Main.java
World.java
README.md
```

Zur Repräsentation des Iteratorzustands ist ein Objekt der Klasse

```java
java.util.Stack<ProjectNode>
```

zu verwenden.

Der Iterator darf keine vollständige Liste aller Knoten vorab erzeugen.

---

## Teilaufgabe 2 – Schreiben von Projektbäumen

Vervollständigen Sie die Klasse `ProjectIO` gemäß der Spezifikation. Objekte dieser Klasse halten eine Verbindung
zu einem Pfad des Dateisystems und liefern mittels der vorgegebenen Methode `ProjectNode fromFileSystem()` die
entsprechende aktuelle Repräsentation als Projektbaum.

Neben den Objektmethoden verfügt die Klasse über die statische Methode `save`, die einen Projektbaum in einem 
entsprechenden Format speichern kann. Beim Schreiben von Dateien sollen geeignete gepufferte Ausgabeklassen 
des Java-IO-Frameworks verwendet werden.

Verzeichnisse werden in folgendem Format gespeichert:

```text
dir;root
dir;root/src
```

Dateien werden in folgender Form gespeichert:

```text
file;root/src/Main.java;120
file;root/README.md;30
```

Das allgemeine Format lautet also:

```text
dir;<pfad>
file;<pfad>;<anzahl-bytes>
```

Die Pfadbestandteile werden durch `/` getrennt.

---

## Teilaufgabe 3 - Übungen zum Programmverstehen

Beantworten Sie für sich die folgenden Fragen (keine schriftliche Abgabe erforderlich):

* Welche Invarianten gelten für ein Objekt der Klasse `ProjectDirectory`?
* Warum liefert die rekursive Implementierung von `fileCount()` die korrekte Anzahl von 
  Dateien für beliebig tief verschachtelte Projektbäume?
* Welche Rolle spielt dabei die Unterscheidung zwischen Blatt (`ProjectFile`) und Composite (`ProjectDirectory`)? 

## Weitere Denkanstöße

* Könnten Sie anstelle `ProjectFileCollectionView` und `ProjectDirectoryCollectionView` nur eine einzige Klasse
  zur Implementierung der `ProjectNodeCollection`-Sichtweise nutzen? Welchen Vorteil hat die Nutzung von zwei 
  separaten Klassen?
* Warum ist `ProjectNode` selbst nicht iterierbar?
* Welche Vorteile hat die Trennung zwischen `ProjectNode` und `ProjectNodeCollection`?
* Welche Änderungen an einer mit `getChildren()` erhaltenen Liste dürfen keine Auswirkungen auf den Projektbaum haben? 
  Welche Änderungen an den enthaltenen Kindobjekten könnten dennoch sichtbar werden?
* Welche Vor- und Nachteile hätte eine rekursive Implementierung des Iterators?
* Wie könnte eine Methode `public static ProjectNode load(String fileName) throws IOException, ProjectFormatException`
  in der Klasse `ProjectIO` spezifiziert und implementiert werden? Die Methode soll aus einer mit `save` geschriebenen 
  Datei den entsprechenden Projektbaum aufbauen. Welche Fehler repräsentiert `ProjectFormatException`?
* Welche Testfälle sind besonders wichtig für rekursive Datenstrukturen?
* Die Methode `getChildren()` liefert eine neue Liste, die jedoch dieselben
  Kindobjekte enthält. Wie müsste die Methode implementiert werden, um eine tiefe Kopie (deep copy) des 
  gesamten Projektbaums bzw. Teilbaums zu erzeugen?
* Wie könnten Sie die Sichtweisen erweitern, sodass sie zusätzlich Änderungen am Projektbaum erlauben?
* Welche Probleme können entstehen, wenn zwei verschiedene Knoten als gleich betrachtet werden, obwohl sie an
  unterschiedlichen Stellen des Baums vorkommen?