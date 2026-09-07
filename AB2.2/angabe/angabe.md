# EP2 Aufgabenblatt 2.2

Kernthemen: doppelt verkettete Ringliste mit speziellem Knoten `nil`, spezieller binärer Suchbaum als
räumliche Datenstruktur, Interfaces

## Organisatorisches

Abgabe-Deadline: **21.4.2026, 13:00 Uhr**
Art der Abgabe: `git commit` & `git push`

### Allgemeine Hinweise

* Die Lösung muss im vorgegebenen Projekt und somit in den vorhandenen Dateien erfolgen.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java Collections Framework zurückgreifen.
* Verändern Sie weder die vorgegebenen Methodensignaturen noch die Signaturen der Konstruktoren. Ausgenommen sind
  etwaige Änderungen in der Klasse `KDNode`.
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Methoden oder Konstruktoren in vorgegebenen Klassen
  müssen `private` sein. Ausgenommen sind zusätzliche Methoden in der Klasse `KDNode`.
* Definieren Sie keine geschachtelten oder (anonymen) inneren Klassen.
* Achten Sie darauf, dass Ihre Abgabe ausführbar ist.
* Hinweise und zu bearbeitende Stellen sind im Code mit `TODO` gekennzeichnet.

---

## Informationen zur Domäne

### Physikalische Objekte

In diesem Aufgabenblatt wird die Simulation wie folgt erweitert:

Alle Objekte in der Welt werden durch das Interface `Physical` beschrieben.  
Ein solches Objekt besitzt:

* eine Position (als `Vector2D`) im zweidimensionalen Raum
* eine räumliche Ausdehnung (Radius)

Damit können Objekte als Kreise im Raum interpretiert werden.  
Dies ermöglicht insbesondere:

* Distanzberechnungen
* Überschneidung von Objekten, die vermieden werden sollen
* räumliche Abfragen

Zwei Objekte schneiden sich genau dann, wenn der Abstand ihrer Mittelpunkte
kleiner oder gleich der Summe ihrer Radien ist.

---

### Zustandsverändernde Objekte

Objekte, die ihren Zustand in der Simulation verändern, implementieren das Interface `Steppable`.

Die Methode `step()` beschreibt eine diskrete Zustandsänderung des Objekts.
Sie wird in jedem Simulationsschritt aufgerufen und verändert den internen Zustand.

Ein Beispiel dafür ist die Klasse `Ant`.

---

## Aufgabenstellung

Dieses Aufgabenblatt besteht aus drei Teilaufgaben:

1. Doppelt verkettete Ringliste implementieren (`PhysicalDoublyLinkedRingList`)
2. Räumliche Datenstruktur implementieren (`PhysicalKDTreeSet`)
3. Simulation um physikalische Objekte und Schnittprüfungen erweitern (`Ant`, `World`)

Die zu bearbeitenden Dateien sind:

* [PhysicalDoublyLinkedRingList.java](../src/PhysicalDoublyLinkedRingList.java)
* [PhysicalKDTreeSet.java](../src/PhysicalKDTreeSet.java)
* [World.java](../src/World.java)
* [Ant.java](../src/Ant.java)
* [Obstacle.java](../src/Obstacle.java)

Vervollständigen Sie diese Klassendefinitionen gemäß der Spezifikation in den Dateien.

Die folgenden Klassen sind bereits vollständig gegeben und dürfen nicht verändert werden:

* [Physical.java](../src/Physical.java)
* [Steppable.java](../src/Steppable.java)
* [Vector2D.java](../src/Vector2D.java)
* [State.java](../src/State.java)
* [Nest.java](../src/Nest.java)
* [FoodSource.java](../src/FoodSource.java)

Die Klasse [ApplicationTest.java](../src/ApplicationTest.java) können Sie zum Testen der
Datenstrukturen ([PhysicalDoublyLinkedRingList.java](../src/PhysicalDoublyLinkedRingList.java)
und [PhysicalKDTreeSet.java](../src/PhysicalKDTreeSet.java)) verwenden. Bei einer fehlerfreien Implementierung sollten
bei der Ausführung dieser Klasse keine Ausnahmen (`Exception`) ausgelöst werden und alle Testfälle `"OK"` ausgeben. Sie
müssen diese Klasse nicht verändern, können aber eigene Testfälle hinzufügen.

Die Klasse [ApplicationAnt.java](../src/ApplicationAnt.java) dient als Beispielanwendung für die Simulation und ist
grundsätzlich vorgegeben. Sie dürfen diese Klasse jedoch erweitern oder anpassen, beispielsweise durch das Hinzufügen
von Hindernissen (`Obstacle`) oder durch andere sinnvolle Änderungen zur Beobachtung und zum Testen des Verhaltens
der Simulation.

---

## Teilaufgabe 1 – Doppelt verkettete Ringliste

Implementieren Sie die Klasse `PhysicalDoublyLinkedRingList` als doppelt verkettete, zyklische Liste mit `nil`-Knoten.

### Anforderungen

* Die Liste ist als Ring organisiert.
* Ein spezieller `nil`-Knoten ist immer vorhanden.
* Für eine leere Liste gilt: `nil.next == nil` und `nil.prev == nil`.
* Die Liste enthält keine `null`-Referenzen als gespeicherte Elemente.
* Die gespeicherten Elemente sind vom Typ `Physical`.

Der `nil`-Knoten vereinfacht die Implementierung, da Randfälle (z. B. leere Liste oder Einfügen am Anfang/Ende)
einheitlich behandelt werden können.

---

## Teilaufgabe 2 – Räumliche Datenstruktur (k-d-Baum)

Vervollständigen Sie die Klasse `PhysicalKDTreeSet` zur Speicherung von `Physical`-Objekten.
Diese Klasse repräsentiert einen speziellen zweidimensionalen k-d-Baum, der die räumliche Position zur Organisation
der Objekte nutzt. 'k' steht für die Dimensionalität der gespeicherten Vektoren, in unserem Fall 2. Das Prinzip lässt
sich auf größere 'k' verallgemeinern.  
Ein Großteil der Klasse [PhysicalKDTreeSet.java](../src/PhysicalKDTreeSet.java) ist bereits vorgegeben, sodass Sie sich
daran orientieren können.

### Grundidee des k-d-Baums

Im Unterschied zum gewöhnlichen binären Suchbaum aus Aufgabenblatt 2.1 hängt es bei diesem k-d-Baum von der Tiefe des aktuellen
Knotens ab, ob die x- oder die y-Koordinate als Schlüssel fungiert. Beispielsweise wird bei der Suche beginnend mit dem
Wurzelknoten die x-Koordinate als Schlüssel verglichen, in den direkten Nachfolgerknoten dann die y-Koordinate, in deren
Nachfolgerknoten wieder die x-Koordinate und so weiter. Die Aufteilung erfolgt rekursiv und alternierend entlang
der Koordinatenachsen:

* auf ungeraden Tiefen: Vergleich nach x-Koordinate
* auf geraden Tiefen: Vergleich nach y-Koordinate

Im Unterschied zu einem gewöhnlichen Suchbaum erlaubt der k-d-Baum effiziente Bereichsabfragen, da der Suchraum bei
Abfragen schrittweise eingeschränkt werden kann. Bei jedem Schritt fällt ein Teilbaum (Raumhälfte) weg, sodass die
Suche effizient erfolgen kann (liegt die Wurzel eines Teilbaums innerhalb des Rechtecks, wird links und rechts
weitergesucht, ansonsten wird nur einseitig weitergesucht).

Beispiel:
Wir suchen unter den Positionen `A` bis `G` nur jene, die in einem spezifizierten Rechteck liegen
(x von 2 bis 5, y von 2 bis 8):

```
y
8 |               +--------------------+
7 |        D(1,7) |                    |                      C(8,7)
6 |               |                    |          
5 |               |            G(4,5)  |          
4 |               |                    |      A(6,4)   
3 |               |      B(3,3)        |                  
2 |               +--------------------+
1 |                           E(4,1)                 F(7,2) 
0 +----------------------------------------------------------------- x
    0      1      2      3      4      5      6      7      8      9
```

Der Baum könnte beispielsweise so aufgebaut sein:

```text

                A(6,4)[x]
               /      \
         B(3,3)[y]    C(8,7)[y]
        /    \          /
 E(4,1)[x]  D(1,7)[x]  F(7,2)[x]
                \
              G(4,5)[y]
              
```

Die Suche läuft wie folgt ab:

- A(6,4) [Vergleich nach x]:
  Da x = 6 rechts vom Suchbereich liegt (x > 5), kann der rechte Teilbaum ausgeschlossen werden → es wird nur im linken Teilbaum weitergesucht.

- B(3,3) [Vergleich nach y]:
  Da y = 3 innerhalb des Suchbereichs liegt, können sowohl der linke als auch der rechte Teilbaum relevante Punkte enthalten → beide Teilbäume werden durchsucht. Der Punkt B liegt im Suchbereich.

- E(4,1) [Vergleich nach x]:
  Da x = 4 innerhalb des Suchbereichs liegt, kann kein Teilbaum ausgeschlossen werden. Der Punkt liegt aufgrund von y = 1 unterhalb des Suchbereichs und gehört nicht zur Lösung.

- D(1,7) [Vergleich nach x]:
  Da x = 1 links vom Suchbereich liegt (x < 2), kann der linke Teilbaum ausgeschlossen werden → es wird nur im rechten Teilbaum weitergesucht. Der Punkt gehört nicht zur Lösung.

- G(4,5):
  Es gibt keine Nachfolger. Der Punkt liegt im Suchbereich und wird als Ergebnis aufgenommen.

Bei der Suche wurden `B` und `G` im Bereich liegend gefunden. Ähnlich lassen sich auch Punkte in Kreisregionen finden.

### Ziel

Die Datenstruktur dient dazu, räumliche Abfragen effizient zu unterstützen, z. B.:

* Finden aller Objekte in einer Umgebung
* Einschränken von Suchbereichen
* Vorbereitung von Überprüfung auf Überschneidungen

---

## Teilaufgabe 3 – Simulation erweitern

In dieser Teilaufgabe wird die Simulation um physikalische Objekte und deren räumliche Beziehungen erweitert.

### Klasse `World`

Die Klasse `World` verwaltet alle Objekte der Simulation, insbesondere:

* das Nest (`Nest`)
* die Futterquelle (`FoodSource`)
* die Ameisen (`Ant`)
* Hindernisse (`Obstacle`)

Zusätzlich stellt sie Methoden bereit, um:

* auf diese Objekte zuzugreifen
* alle physikalischen Objekte gemeinsam zu betrachten
* Randbedingungen der Welt umzusetzen

---

### Klasse `Ant`

`Ant` ist nun auch ein physikalisches Objekt (Untertyp von `Physical`). Eine Ameise besitzt eine
Position und eine Bewegungsrichtung (`State`). Sie hat zusätzlich eine räumliche Ausdehnung
(Radius). Sie ändert ihren Zustand in jedem Simulationsschritt und ist somit auch Untertyp
von `Steppable`. Verwenden Sie die Implementierung von `step()` aus Aufgabenblatt 2.1 als Vorlage 
und adaptieren Sie sie so, dass die Ameise folgendes Verhalten hat.

Die Bewegung ergibt sich aus:

* einem Anteil der bisherigen Bewegungsrichtung
* einer zufälligen Richtungsänderung
* einer gerichteten Bewegung in Richtung einer Zielposition

Die Zielposition ist:

* die Futterquelle, solange keine Nahrung getragen wird
* das Nest, sobald Nahrung aufgenommen wurde

---

### Überschneidungen

Die Ameise soll vermeiden, dass sie sich mit den meisten anderen Objekten (z.B. `Ant`, `Obstacle`) überschneidet.

Dabei gilt:

* Überschneidungen mit Nest sind erlaubt, wenn die Ameise gerade auf Nestsuche ist.
* Überschneidungen mit Futterquelle sind erlaubt, wenn die Ameise gerade auf Futtersuche ist.
* Andere Objekte stellen Hindernisse dar und dürfen sich so weit wie möglich nicht mit der Ameise überschneiden.

#### Vermeidung von Überschneidungen

Die Klasse `Ant` besitzt vorgegebene Hilfsmethoden, die von `step` dazu genutzt werden soll, Überschneidungen
zu vermeiden. Dabei wird ausgehend von einer berechneten Kandidatenposition schrittweise wie folgt eine gültige
Position bestimmt:

1. Bestimmen der Kandidatenposition für den nächsten Schritt (ohne auf Überschneidung zu achten).
2. Prüfen, ob sich das Objekt an dieser Position mit einem blockierenden Objekt überschneidet.
3. Falls eine solche Überschneidung vorliegt, wird die Position in eine Richtung, die vom blockierenden
   Objekt wegführt verschoben. Dabei kann es vorkommen, dass eine Korrektur eine neue Überschneidung mit einem
   anderen Objekt verursacht. Daher wird Prüfung und Anpassung wiederholt, bis keine Überschneidung mehr vorliegt.

Um sicherzustellen, dass dieser Prozess terminiert, sollte die Anzahl der Korrekturschritte begrenzt werden. Dadurch
sind Überschneidungen nie ganz ausgeschlossen, werden aber so gut es geht vermieden.

##### Freiwillige Zusatzaufgabe: 
Der k-d-Baum wird momentan in der Simulation nicht eingesetzt. Als zusätzliche Übung steht es Ihnen jedoch frei, 
die `ApplicationAnt`,`World` und `Ant` so zu ändern, dass der k-d-Baum verwendet wird.

---

## Denkanstöße

* Welche Vorteile bietet ein `nil`-Knoten?
* Wie kann ein k-d-Baum den Suchraum systematisch einschränken? Warum geht das nicht in gleicher Weise beim gewöhnlichen
  binären Suchbaum?
* Wann kann ein Teilbaum bei einer Abfrage ausgeschlossen werden?
* Nutzt Ihre Implementierung von `contains` die k-d-Baumstruktur effizient, oder werden alle Knoten traversiert, ohne
  Teilbäume zu auszulassen?
* Wie geht der Baum mit mehreren `Physical`-Elementen mit gleichen Koordinaten um?
* Welche Vor- und Nachteile hätte der Einsatz des k-d-Baums in der Ameisensimulation?
