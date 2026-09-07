# EP2 Aufgabenblatt 1.2

Kernthemen: Objekt- vs. Klassen-Methode (Wiederholung), Data-Hiding, Konstruktor, Datensatz

## Organisatorisches

Abgabe Deadline: **17.3.2026 13:00**  
Art der Abgabe: `git commit` & `git push`

### Allgemeine Hinweise

* Die Lösung muss im vorgegebenen Projekt und damit in den vorhandenen Dateien erfolgen.
* Importieren Sie keine zusätzlichen Pakete und Klassen. Ausnahme ist der Import der Pakete `CodeDraw` und `Random`.
* Achten Sie darauf, dass Ihre Abgabe ausführbar ist.
* Hinweise und zu bearbeitende Stellen sind im Code mit `TODO` gekennzeichnet.

---

## Information zur Domäne

### Schwarmverhalten

In der gegebenen Simulation bewegen sich viele „Vögel“ in einer 2D-Welt. Jeder Vogel hat wie bisher:

- eine Position (2D-Vektor)
- einen Geschwindigkeitsvektor (2D-Vektor)

In jedem Zeitschritt wird eine „Steuerkraft“ (steering) berechnet, die aus drei Einflüssen besteht:

1. Separation: Abstand halten (nahen Nachbarn ausweichen)
2. Alignment: Richtung an Nachbarn anpassen
3. Cohesion: zum Schwerpunkt der Nachbarn bewegen

Zusätzlich gibt es eine "Torus-Welt" (Wrap-around): Wer links rausfliegt, kommt rechts wieder hinein (analog oben/unten).

---

## Aufgabenstellung

Dieses Aufgabenblatt besteht aus drei Teilaufgaben:

1. `Vector2D` implementieren und mit `ApplicationVector2D` testen
2. `State`, `World` und `Bird` implementieren
3. `ApplicationBird` implementieren, sodass die Simulation identisches Verhalten wie `ApplicationVector2D` zeigt

Die für dieses Aufgabenblatt zu bearbeitenden Dateien sind:

* [Vector2D.java](../src/Vector2D.java)
* [World.java](../src/World.java)
* [Bird.java](../src/Bird.java)
* [ApplicationVector2D.java](../src/ApplicationVector2D.java)
* [ApplicationBird.java](../src/ApplicationBird.java)

Die folgende Klasse ist bereits vollständig definiert gegeben: 
* [State.java](../src/State.java)

---

### Teilaufgabe 1 – `Vector2D` implementieren und testen

Implementieren Sie die Klasse `Vector2D` so, dass der auskommentierte Block in `ApplicationVector2D` aktiviert
werden kann und die Simulation läuft.

#### Anforderungen an `Vector2D`

* `Vector2D` ist jetzt 'immutable':
  * Nach der Initialisierung des Objekts durch den Konstruktor ändern sich Koordinaten nicht mehr.
  * Alle Operationen liefern stattdessen neue `Vector2D`-Objekte zurück.
* Implementieren Sie folgende öffentliche Methoden und Konstruktoren (wie in `ApplicationVector2D` verwendet):
  * Konstruktor `Vector2D(double x, double y)`
  * `double getX()`, `double getY()`
  * `Vector2D add(Vector2D other)`
  * `Vector2D subtract(Vector2D other)`
  * `Vector2D scale(double factor)`
  * `double length()`
  * `Vector2D normalize()`: um zu verhindern, dass beim Normalisieren durch eine mögliche Länge von 0 dividiert wird,
     müssen entsprechende Vorbedingungen eingehalten werden, oder es muss dieser Fall von der Methode behandelt werden.
     Eine einfache Möglichkeit ist, in diesem Fall einen Vektor (0.0, 0.0) als Ergebnis zu liefern. Das verhindert, dass
     in der Simulation `NaN`-Werte (Not-a-Number) entstehen. 
* Schreiben Sie für alle öffentlichen Methoden und Konstruktoren Spezifikationen als Kommentare. Aus diesen 
  Kommentaren soll auch hervorgehen, welche Bedingungen beim Aufruf der Methode erfüllt sein müssen, damit die Methode 
  wie spezifiziert funktioniert. Diese Bedingungen muss also der Aufrufer der Methode sicherstellen und die 
  Methodenimplementierung setzt voraus, dass diese erfüllt sind. Die Methode darf diese Bedingungen prüfen, muss das
  aber nicht. Sie können in `State`, `World` und `Bird` vergleichen, in welcher Form diese Bedingungen in den Kommentaren
  beschrieben sind.

#### Test

* Aktivieren Sie den auskommentierten Block in `ApplicationVector2D`.
* Das Programm muss ausführbar sein und die Animation sichtbar laufen. Ein Schwarmverhalten sollte zu erkennen sein.

---

### Teilaufgabe 2 – Refaktorisierung (`State`, `World`, `Bird`)

Nun wird die prozedurale Simulation aus `ApplicationVector2D` schrittweise in Klassen zerlegt.
Ziel ist, dass die gleiche Logik in diesen Klassen umgesetzt wird. Übertragen Sie 
daher die entsprechenden Codeblöcke aus `ApplicationVector2D` in entsprechende Objektmethoden (durch Kopieren 
und Anpassen). Überlegen Sie sich, in welche Klasse die einzelnen Konstanten, die die Simulation beeinflussen
(`W`, `H`, `N`, `VIEW`, `SEP_DIST`, `MAX_V`, `MAX_F`, Gewichte) am besten passen, und ob Sie diese als Objektvariablen, 
als Klassenvariablen oder als lokale Variablen deklarieren möchten.

#### `State`

Die Klasse `State` ist bereits vollständig vorgegeben und repräsentiert einen Zustand mit Position (`Vector2D`)
und Geschwindigkeitsvektor (`Vector2D`). `State` wird von `Bird` benutzt.

#### `World` und `Bird`

Implementieren Sie `World` gemäß der Spezifikation, die Sie als Kommentare in der Datei [World.java](../src/World.java) 
finden. Machen Sie das analog für `Bird`. Auch hier sind die Bedingungen für die Parameter in den Kommentaren angegeben.
Wenn also beispielsweise bei der Beschreibung des Parameters `position` die Bedingung `position != null` steht, muss 
der Aufrufer der Methode sicherstellen, dass diese erfüllt ist. Bei der Implementierung der Methode dürfen Sie das 
prüfen, müssen es aber nicht (die Implementierung geht davon aus, dass diese erfüllt ist).

---

### Teilaufgabe 3 – `ApplicationBird`: identisches Verhalten wie `ApplicationVector2D`

Erstellen Sie eine neue Klasse `ApplicationBird` mit einer `main`-Methode.

#### Anforderungen

Die Simulation in `ApplicationBird` soll sich gleich verhalten wie in `ApplicationVector2D`. Erzeugen Sie ein 
`World`-Objekt und ein Array `Bird[] birds` der Größe `N`. Initialisieren Sie die Vögel zufällig analog zu 
`ApplicationVector2D`. Implementieren Sie die Simulationsschleife.

### Denkanstöße 
- Welche alternativen Klassenentwürfe gibt es aus Ihrer Sicht? Was ändert Sich, wenn beispielweise `World` das Array
  `birds` kapseln würde?
- In `ApplicationVector2D` wird für den `i`-ten Vogel sofort `position[i]` und `velocity[i]` überschrieben und 
der neue Zustand wird für die Aktualisierung aller Vögel mit Index größer `i` genutzt. Welche Alternativen gibt es hier 
für die Reihenfolge der Zustandsänderungen?
- Wie wirken sich die einzelnen Konstanten der Simulation aus?