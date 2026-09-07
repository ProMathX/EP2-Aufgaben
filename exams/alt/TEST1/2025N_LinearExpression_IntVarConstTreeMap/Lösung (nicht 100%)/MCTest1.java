// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest1 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest1 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Q und Y seien Referenztypen, sodass der Compiler folgenden Programmtext\n" +
                        "fehlerfrei compiliert: 'Y y = new Q();  y.e();'\n" +
                        "Welche der folgenden Aussagen treffen für alle passenden Q, Y, y und e() zu?",

                        new Choice(false, "Y kann Interface oder Klasse sein.                                            (1A)"),
                        new Choice(false, "Die Methode e() muss in Y und Q vorhanden sein.                               (1B)"),
                        new Choice(false, "Es gilt: 'y.getClass() == Q.class'                                            (1C)"),
                        new Choice(true, "y kann verwendet werden, wo ein Objekt von Y erwartet wird.                   (1D)"),
                        new Choice(true, "Q kann kein Interface, sondern muss eine Klasse sein.                         (1E)")
                ),

                new Question(
                        "i sei eine Variable mit einem leeren Stack ganzer Zahlen.\n" +
                        "Nach welchen der folgenden Aufruf-Sequenzen liefert 'i.peek()' die Zahl 1 als Ergebnis?",

                        new Choice(true, "i.push(2); i.push(i.pop()); i.push(1);                                        (2A)"),
                        new Choice(false, "i.push(1); i.push(2); i.push(i.peek());                                       (2B)"),
                        new Choice(false, "i.push(1); i.push(2); i.push(i.pop());                                        (2C)"),
                        new Choice(true, "i.push(2); i.push(1); i.push(i.peek());                                       (2D)"),
                        new Choice(false, "i.push(2); i.push(1); i.push(i.pop());                                        (2E)")
                ),

                new Question(
                        "p sei eine Variable, die eine leere Double-Ended-Queue ganzer Zahlen enthält.\n" +
                        "Nach welchen der folgenden Aufruf-Sequenzen liefert 'p.peekFirst()'\n" +
                        "die Zahl 1 als Ergebnis?",

                        new Choice(true, "p.addLast(1); p.addLast(4); p.pollLast();                                     (3A)"),
                        new Choice(false, "p.addLast(1); p.addLast(4); p.pollFirst();                                    (3B)"),
                        new Choice(false, "p.addFirst(1); p.addFirst(4); p.addFirst(p.peekLast());                       (3C)"),
                        new Choice(true, "p.addFirst(1); p.addFirst(4); p.peekFirst();                                  (3D)"),
                        new Choice(true, "p.addLast(1); p.addLast(4);                                                   (3E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen stimmen in Bezug auf die Unterscheidung zwischen\n" +
                        "Datenstrukturen und abstrakten Datentypen?",

                        new Choice(false, "Jede Datenstruktur hat eine festgelegte Maximalgröße.                         (4A)"),
                        new Choice(false, "Abstrakte Datentypen müssen verwendete Algorithmen festlegen.                 (4B)"),
                        new Choice(false, "Datenstrukturen stehen in engem Zusammenhang mit Algorithmen.                 (4C)"),
                        new Choice(false, "Datenstrukturen legen fest, wie Daten zusammenhängen.                         (4D)"),
                        new Choice(false, "Abstrakte Datentypen beschreiben vorwiegend Objektschnittstellen.             (4E)")
                ),

                new Question(
                        "b sei eine Variable mit einer leeren assoziativen Datenstruktur, wobei Schlüssel\n" +
                        "und Werte vom Typ 'String' sind (und 'null' sein können).  X und G seien zwei\n" +
                        "voneinander verschiedene String-Konstanten (static final).  Nach welchen der\n" +
                        "folgenden Aufruf-Sequenzen liefert 'b.get(X)' den String in G als Ergebnis?",

                        new Choice(false, "b.put(G, X); b.put(b.get(G), b.get(X)); b.put(X, G);                          (5A)"),
                        new Choice(false, "b.put(X, G); b.put(G, X); b.put(b.get(X), b.get(G));                          (5B)"),
                        new Choice(false, "b.put(G, X); b.put(X, G); b.put(b.get(G), b.get(X));                          (5C)"),
                        new Choice(false, "b.put(X, X); b.put(G, G); b.put(b.get(G), b.get(X));                          (5D)"),
                        new Choice(false, "b.put(b.get(X), b.get(G)); b.put(X, X); b.put(G, G);                          (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Q und Y seien Referenztypen, sodass der Compiler folgenden Programmtext\n" +
            "    fehlerfrei compiliert: 'Y y = new Q();  y.e();'\n" +
            "    Welche der folgenden Aussagen treffen für alle passenden Q, Y, y und e() zu?\n" +
            "    \n" +
            "    XXXXXXXXX Y kann Interface oder Klasse sein.                                            (1A)\n" +
            "    XXXXXXXXX Die Methode e() muss in Y und Q vorhanden sein.                               (1B)\n" +
            "    XXXXXXXXX Es gilt: 'y.getClass() == Q.class'                                            (1C)\n" +
            "    XXXXXXXXX y kann verwendet werden, wo ein Objekt von Y erwartet wird.                   (1D)\n" +
            "    XXXXXXXXX Q kann kein Interface, sondern muss eine Klasse sein.                         (1E)\n" +
            "\n" +
            " 2. i sei eine Variable mit einem leeren Stack ganzer Zahlen.\n" +
            "    Nach welchen der folgenden Aufruf-Sequenzen liefert 'i.peek()' die Zahl 1 als Ergebnis?\n" +
            "    \n" +
            "    XXXXXXXXX i.push(2); i.push(i.pop()); i.push(1);                                        (2A)\n" +
            "    XXXXXXXXX i.push(1); i.push(2); i.push(i.peek());                                       (2B)\n" +
            "    XXXXXXXXX i.push(1); i.push(2); i.push(i.pop());                                        (2C)\n" +
            "    XXXXXXXXX i.push(2); i.push(1); i.push(i.peek());                                       (2D)\n" +
            "    XXXXXXXXX i.push(2); i.push(1); i.push(i.pop());                                        (2E)\n" +
            "\n" +
            " 3. p sei eine Variable, die eine leere Double-Ended-Queue ganzer Zahlen enthält.\n" +
            "    Nach welchen der folgenden Aufruf-Sequenzen liefert 'p.peekFirst()'\n" +
            "    die Zahl 1 als Ergebnis?\n" +
            "    \n" +
            "    XXXXXXXXX p.addLast(1); p.addLast(4); p.pollLast();                                     (3A)\n" +
            "    XXXXXXXXX p.addLast(1); p.addLast(4); p.pollFirst();                                    (3B)\n" +
            "    XXXXXXXXX p.addFirst(1); p.addFirst(4); p.addFirst(p.peekLast());                       (3C)\n" +
            "    XXXXXXXXX p.addFirst(1); p.addFirst(4); p.peekFirst();                                  (3D)\n" +
            "    XXXXXXXXX p.addLast(1); p.addLast(4);                                                   (3E)\n" +
            "\n" +
            " 4. Welche der folgenden Aussagen stimmen in Bezug auf die Unterscheidung zwischen\n" +
            "    Datenstrukturen und abstrakten Datentypen?\n" +
            "    \n" +
            "    XXXXXXXXX Jede Datenstruktur hat eine festgelegte Maximalgröße.                         (4A)\n" +
            "    XXXXXXXXX Abstrakte Datentypen müssen verwendete Algorithmen festlegen.                 (4B)\n" +
            "    XXXXXXXXX Datenstrukturen stehen in engem Zusammenhang mit Algorithmen.                 (4C)\n" +
            "    XXXXXXXXX Datenstrukturen legen fest, wie Daten zusammenhängen.                         (4D)\n" +
            "    XXXXXXXXX Abstrakte Datentypen beschreiben vorwiegend Objektschnittstellen.             (4E)\n" +
            "\n" +
            " 5. b sei eine Variable mit einer leeren assoziativen Datenstruktur, wobei Schlüssel\n" +
            "    und Werte vom Typ 'String' sind (und 'null' sein können).  X und G seien zwei\n" +
            "    voneinander verschiedene String-Konstanten (static final).  Nach welchen der\n" +
            "    folgenden Aufruf-Sequenzen liefert 'b.get(X)' den String in G als Ergebnis?\n" +
            "    \n" +
            "    XXXXXXXXX b.put(G, X); b.put(b.get(G), b.get(X)); b.put(X, G);                          (5A)\n" +
            "    XXXXXXXXX b.put(X, G); b.put(G, X); b.put(b.get(X), b.get(G));                          (5B)\n" +
            "    XXXXXXXXX b.put(G, X); b.put(X, G); b.put(b.get(G), b.get(X));                          (5C)\n" +
            "    XXXXXXXXX b.put(X, X); b.put(G, G); b.put(b.get(G), b.get(X));                          (5D)\n" +
            "    XXXXXXXXX b.put(b.get(X), b.get(G)); b.put(X, X); b.put(G, G);                          (5E)\n" +
            "\n";

    public static final long UID = 247531282922593L;

    private static void checkAndPrint(Question... questions) {
        int i = 1;
        String s = "";
        for (Question question : questions) {
            java.util.Scanner scanner = new java.util.Scanner(question.toString());
            s += String.format("%2d. %s\n", i++, scanner.nextLine());
            while (scanner.hasNextLine()) {
                s += String.format("    %s\n", scanner.nextLine());
            }
            s += "\n";
        }
        String converted = s.replace("Richtig: ", "XXXXXXXXX").replace("Falsch:  ", "XXXXXXXXX");
        if (!converted.replaceAll("[ \t]+", " ").equals(EXPECT.replaceAll("[ \t]+", " "))) {
            i = 0;
            String err = "\n";
            java.util.Scanner e = new java.util.Scanner(EXPECT);
            java.util.Scanner f = new java.util.Scanner(converted);
            while (e.hasNextLine() && f.hasNextLine() && i < 5) {
                String el = e.nextLine(), fl = f.nextLine();
                if (!el.replaceAll("[ \t]+", " ").equals(fl.replaceAll("[ \t]+", " "))) {
                    i++;
                    err += "Statt der Zeile: " + fl + "\nsollte stehen:   " + el + "\n\n";
                }
            }
            if (i >= 5) {
                err = "Das sind die erwarteten Fragen und Antwortmöglichkeiten in 'EXPECT':\n\n" + EXPECT;
            }
            System.out.println("ACHTUNG: Sie haben Programmteile verändert, die nicht geändert werden sollten.\n" +
                    "Beurteilt wird so, als ob diese Programmteile unverändert geblieben wären.\n" +
                    err);
            System.exit(1);
        }
        System.out.print("Die Multiple-Choice-Fragen wurden folgendermaßen beantwortet\n" +
                "(das sind nur Ihre Antworten, keine Aussage über Korrektheit):\n\n" +
                s);
        System.exit(0);
    }

    private static class Question {
        private final String question;
        private final Choice[] choices;

        public Question(String question, Choice... choices) {
            this.question = question;
            this.choices = choices;
        }

        public String toString() {
            String s = question + "\n\n";
            for (Choice choice : choices) {
                s += choice + "\n";
            }
            return s;
        }
    }

    private static class Choice {
        private final String answer;
        private final boolean valid;

        public Choice(boolean valid, String answer) {
            this.answer = answer;
            this.valid = valid;
        }

        public String toString() {
            return (valid ? "Richtig:  " : "Falsch:   ") + answer;
        }
    }
}