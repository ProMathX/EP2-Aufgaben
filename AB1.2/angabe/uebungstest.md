# EP2 - beurteilte Übung zu AB1.2

### Allgemeine Hinweise

* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt und damit in den vorhandenen Dateien
  erfolgen.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java Collections Framework zurückgreifen.
* Verändern Sie keine der vorgegebenen Methodensignaturen.
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Methoden in vorgegebenen
  Klassen müssen `private` sein.
* Definieren Sie keine geschachtelten oder (anonymen) inneren Klassen, also keine Klassen, die
  in einer anderen Klasse, einem Objekt oder einer Methode stehen.

## Information zur Domäne

Zu den Klassen aus `AB1.2` wird eine weitere Klasse `WindGust` hinzugefügt, die ein bewegtes Objekt
repräsentiert. Sie müssen die Klasse `WindGust` vervollständigen. Weiters soll das Verhalten von `World`
und `Bird` geändert werden.

## Zu bearbeitende Dateien

Die für diesen Test zu bearbeitenden Dateien sind:

* [WindGust](../src/WindGust.java)
* [World](../src/World.java)
* [Bird](../src/Bird.java)

### Aufgabenstellung

Vervollständigen Sie die Klasse [WindGust](../src/WindGust.java) bitte
wie in den Kommentaren beschrieben an den mit TODO gekennzeichneten Stellen.

Ändern Sie die Klasse [World](../src/World.java) wie folgt: 
1. Die Klasse soll ein Objekt vom Typ `WindGust` enthalten. Entweder dieses wird als zusätzlicher 
   Parameter dem Konstruktor übergeben, oder es wird vom Konstruktor erzeugt. 
2. Ändern Sie die Sichtbarkeit der Methode `enforceBoundary` zu `private`. 
3. Fügen Sie nun als Ersatz folgende neue Methode in der Klasse `World` hinzu und implementieren Sie diese  
   gemäß folgender Spezifikation:
    ```
    /**
     * Applies the influence of the world to the given state.
     *
     * <p>
     * This includes:
     * <ul>
     *   <li>boundary handling (e.g. reflection or wrapping)</li>
     *   <li>the influence of wind gusts</li>
     *   <li>...</li>
     * </ul>
     *
     * The position and/or velocity of the state may be modified.
     * </p>
     *
     * @param s the state to be influenced; {@code s != null}
     * @return a new {@link State} representing the influenced state
     */
    public State worldInfluence(State s) {
    
        // TODO: implement method.
    }
    ``` 
   Die Methode soll nun einerseits die Behandlung der Weltgrenzen von `enforceBoundary` übernehmen und 
   andererseits auch den Einfluss der `WindGust` miteinbeziehen.

Ändern Sie dann die Klasse [Bird](../src/Bird.java), sodass diese anstelle von `enforceBoundary`
die Methode `worldInfluence` aufruft. Testen Sie mit der bestehenden Klasse 
`ApplicationBird`.
