# EP2 Test 1

### Allgemeine Hinweise

* Die Lösung Ihrer Aufgabe muss im vorgegebenen Projekt und damit in den vorhandenen Dateien erfolgen.
* Sie dürfen zur Lösung dieser Aufgabe *nicht* auf das Java Collections Framework zurückgreifen.
* Verändern Sie weder die vorgegebenen Methodensignaturen noch die Signaturen der Konstruktoren.
* Alle Objektvariablen und etwaige von Ihnen zusätzlich erstellte Methoden oder Konstruktoren in vorgegebenen Klassen müssen `private` sein.
* Nicht kompilierbare Projekte werden ausnahmslos mit 0 Punkten bewertet.

## Information zur Domäne

Die Aufgabenstellung modelliert einen vereinfachten Checkout-Prozess in einem Supermarkt. Kunden (`Customer`) werden als eigenständiger abstrakter Datentyp repräsentiert, der den Gesamtwert des Einkaufswagens (`cartValue`) speichert. An den Kassen (`CheckoutCounter`) werden wartende Kunden der Reihe nach abgearbeitet. Dazu besitzt jede Kassa eine Warteschlange (First-In-First-Out, `CustomerQueue`) von Kunden. Werden Kunden an der Kassa bedient, so werden sie der Reihe nach von der Warteschlange entfernt und ihr Einkaufswagenwert zurückgegeben.

Die Gesamtheit aller Kassen des Supermarkts wird durch einen Stack (Last-In-First-Out, `CheckoutCounterStack`) in der Klasse `Supermarket` repräsentiert. Der Supermarkt kann parallel mehrere Kassen betreiben, deren Kunden abarbeiten und den Gesamtumsatz erfassen. Bei Bedarf kann eine neue Kassa geöffnet werden, indem die Warteschlange der obersten Kassa aufgeteilt wird – die ersten `n` Kunden verbleiben an der Kassa, die restlichen Kunden kommen in die neu eröffnete oberste neue Kassa. Leere Kassen können wieder geschlossen werden.

## Aufgabenstellung

Die für diesen Test zu bearbeitenden Dateien sind:

* [CustomerQueue.java](../src/CustomerQueue.java)
* [CheckoutCounter.java](../src/CheckoutCounter.java)
* [CheckoutCounterStack.java](../src/CheckoutCounterStack.java)
* [Supermarket.java](../src/Supermarket.java)

Vervollständigen Sie diese Klassen an den mit TODO markierten Stellen.
Die Klasse [Customer.java](../src/Customer.java) ist bereits vollständig vorgegeben und darf nicht verändert werden.

Die Klasse [ApplicationTest1.java](../src/ApplicationTest1.java) kann zum Testen Ihrer Implementierung verwendet werden.


### Punkteverteilung


* `CustomerQueue`: 2 Punkte
* `CheckoutCounterStack`: 3 Punkte
* `CheckoutCounter`: 3 Punkte
* `Supermarket`: 8 Punkte

**Total: 16 Punkte**