# EP2 Aufgabenblatt 2.4

Kernthemen: lineare Liste, binärer Suchbaum, rekursive Datenstrukturen, Fundierung (siehe Skriptum Seiten 60–70)

## Organisatorisches

Abgabe-Deadline: **14.4.2026, 13:00 Uhr**  
Art der Abgabe: `git commit` & `git push`

### Allgemeine Hinweise

* Die Lösung muss im vorgegebenen Projekt und somit in den vorhandenen Dateien erfolgen.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java Collections Framework zurückgreifen.
* Verändern Sie weder die vorgegebenen Methodensignaturen noch die Signaturen der Konstruktoren.
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Methoden oder Konstruktoren
  in vorgegebenen Klassen müssen `private` sein.
* Definieren Sie keine geschachtelten oder (anonymen) inneren Klassen, also keine Klassen, die
  in einer anderen Klasse, einem Objekt oder einer Methode stehen. Erlaubt sind stattdessen 
  Hilfsklassen, die entweder in eigenen Dateien stehen, oder als nicht-`public` Klassen in gleichen
  Dateien zusammen mit `public` Klassen.
* Achten Sie darauf, dass Ihre Abgabe ausführbar ist.
* Hinweise und zu bearbeitende Stellen sind im Code mit `TODO` gekennzeichnet.

---

## Informationen zur Domäne

### Ameisen suchen Futter

Wir bleiben in diesem Aufgabenblatt bei der Problemdomäne von Aufgabenblatt 1.3 (AB1.3). Im Zentrum der Aufgabe
steht die Implementierung und die Nutzung der Datenstrukturen `Vector2DSinglyLinkedList` und `Vector2DAntTreeMap`.

---

## Aufgabenstellung

Dieses Aufgabenblatt besteht aus zwei Teilaufgaben:

1. Datenstrukturen implementieren (`Vector2DSinglyLinkedList`, `Vector2DAntTreeMap`)
2. Klassen `World`, `Ant` und `ApplicationAnt` anpassen.

Die zu bearbeitenden Dateien sind:

* [Vector2DSinglyLinkedList.java](../src/Vector2DSinglyLinkedList.java)
* [Vector2DAntTreeMap.java](../src/Vector2DAntTreeMap.java)
* [World.java](../src/World.java)
* [Ant.java](../src/Ant.java)
* [ApplicationAnt.java](../src/ApplicationAnt.java)

Die folgenden Klassen sind bereits vollständig gegeben:

* [Vector2D.java](../src/Vector2D.java)
* [State.java](../src/State.java)
* [ApplicationTest.java](../src/ApplicationTest.java)

Die Dateien [Vector2D.java](../src/Vector2D.java) und [State.java](../src/State.java) dürfen nicht verändert werden.

Die Klasse [ApplicationTest.java](../src/ApplicationTest.java) können Sie zum Testen der
Datenstrukturen ([Vector2DSinglyLinkedList.java](../src/Vector2DSinglyLinkedList.java)
und [Vector2DAntTreeMap.java](../src/Vector2DAntTreeMap.java)) verwenden. Bei einer fehlerfreien Implementierung sollten
bei der Ausführung dieser Klasse keine Ausnahmen (`Exception`) ausgelöst werden und alle Testfälle `"OK"` ausgeben. Sie
müssen diese Klasse nicht verändern, können aber eigene Testfälle hinzufügen.

---

### Teilaufgabe 1 – Datenstrukturen implementieren

In dieser Teilaufgabe implementieren Sie zwei Datenstrukturen. Vervollständigen Sie dazu die Klassen
`Vector2DSinglyLinkedList` und `Vector2DAntTreeMap` gemäß den Kommentaren in den entsprechenden Dateien.

* `Vector2DSinglyLinkedList` ist als *rekursive lineare Datenstruktur* zu implementieren.
* `Vector2DAntTreeMap` ist als *binärer Suchbaum* zu implementieren.

Diese Datenstrukturen werden später in der Simulation verwendet. Orientieren Sie sich dabei an den Beispielen im
Skriptum auf Seiten 60–70. Testen Sie Ihre Implementierungen mit [ApplicationTest.java](../src/ApplicationTest.java).

---

### Teilaufgabe 2 – Klassen `World`, `Ant` und `ApplicationAnt` implementieren

Vervollständigen Sie die Klassen `World`, `Ant` und `ApplicationAnt` gemäß den Kommentaren in den entsprechenden Dateien. 
Sie können dazu Ihre Implementierung aus AB1.3 kopieren und anpassen.

Verwenden Sie dabei die in Teilaufgabe 1 implementierten Datenstrukturen anstelle von `Vector2DStack` und
`Vector2DAntMap` aus AB1.3. `AntQueue` wird nicht mehr gebraucht, stattdessen wird ein Array genutzt.

Vervollständigen Sie `ApplicationAnt`, sodass die Ameisensimulation grafisch mit `CodeDraw` dargestellt wird.
Die Visualisierung der Ameisen soll so aussehen wie in AB1.3.

---

## Denkanstöße

* Um eine Ordnung von `Vector2D`-Objekten zu definieren, benötigen Sie für zwei Schlüssel A und B nicht
  nur die Relation „A ist kleiner als B“ bzw. „A ist größer als B“, sondern auch „A ist gleich B“. In welcher
  Klasse haben Sie eine solche Vergleichsmöglichkeit vorgesehen? Welche anderen Möglichkeiten gibt es?
* Gilt in Ihrer Implementierung, dass aus „A ist gleich B“ und „B ist gleich C“ folgt, dass auch „A ist gleich C“?
* Die Ordnung der Elemente im Array, das von `Vector2DAntTreeMap#values()` geliefert wird, ist nicht spezifiziert.
  Welche Ordnung generiert Ihre Implementierung?