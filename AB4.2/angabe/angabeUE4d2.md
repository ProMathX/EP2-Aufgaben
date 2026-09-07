# EP2 - beurteilte Übung zu AB4.2

### Allgemeine Hinweise

* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt und damit in den vorhandenen Dateien erfolgen.
* Die Verwendung von Klassen aus dem Java Collections Framework ist in dieser Aufgabe ausdrücklich erlaubt.
* Verändern Sie weder die vorgegebenen Methodensignaturen noch die Signaturen der Konstruktoren.
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Methoden oder Konstruktoren
  in vorgegebenen Klassen müssen `private` sein. Ausgenommen sind Methoden, die durch ein Interface gefordert sind,
  überschriebene öffentliche Methoden sowie die in dieser Aufgabenstellung ausdrücklich geforderten öffentlichen Methoden.
* Definieren Sie keine geschachtelten oder (anonymen) inneren Klassen.

## Information zur Domäne

Die Klasse [SimulationLogger.java](../src/SimulationLogger.java) aus `AB4.2`
soll um eine statische Auswertungsmethode erweitert werden.

Die Log-Datei enthält eine Zeile pro nicht auflösbarer Kollision.

Beispiel:

```text
step=3; ant=Ant@A; obstacle=Ant@X
step=4; ant=Ant@B; obstacle=Ant@Y
step=5; ant=Ant@A; obstacle=Nest@(100.0,100.0)
```

In diesem Beispiel tritt `Ant@A` erstmals in Schritt 3 und`Ant@B` erstmals in Schritt 4 auf.

## Zu bearbeitende Dateien

Die für diesen Test zu bearbeitende Datei ist:

* [SimulationLogger.java](../src/SimulationLogger.java)

Die Klasse [ApplicationUE4d2.java](../src/ApplicationUE4d2.java) kann zum Testen Ihrer Implementierung verwendet werden.

## Aufgabenstellung

Implementieren Sie in der Klasse [SimulationLogger.java](../src/SimulationLogger.java) die folgende Methode:

```java
/**
 * Reads a simulation log file and returns the first simulation step in
 * which each ant was involved in an unresolved collision.
 *
 * <p>The method parses the log file directly. Only the first occurrence
 * of each ant is stored.</p>
 *
 * @param fileName the log file name; {@code fileName != null}
 * @return a map assigning each ant identifier to its first collision step
 * @throws IOException if the file cannot be read
 */
public static Map<String, Integer> firstCollisionStepPerAnt(String fileName) throws IOException {
    
}
```

Die Methode soll die Datei selbst einlesen und die enthaltenen
`step=...`- und `ant=...`-Einträge auswerten.

Für jede Ameise soll genau jener Simulationsschritt gespeichert werden,
in dem sie erstmals in einer protokollierten Kollision vorkommt.

Verwenden Sie dazu geeignete Klassen aus dem Java-IO-Framework und eine geeignete Map aus dem Java Collections Framework.

Hinweis: Zum Zerlegen einer Zeichenkette an einem Trennzeichen kann die Methode
```String[] parts = text.split(";");``` verwendet werden.

Die Methode ```text.trim()```
entfernt führende und nachfolgende Leerzeichen aus einer Zeichenkette.