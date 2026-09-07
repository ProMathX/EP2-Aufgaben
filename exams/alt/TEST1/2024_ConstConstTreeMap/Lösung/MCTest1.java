// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest1 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest1 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "C sei ein Referenztyp (Klasse oder Interface), und r sei eine durch\n" +
                        "'H r = new X();' deklarierte Variable, wobei der Compiler keinen Fehler meldet.\n" +
                        "Welche der folgenden Aussagen treffen für alle passenden C, H, X und r zu?",

                        new Choice(false, "'(C)r' liefert Laufzeitfehler wenn C nicht Untertyp von H ist.                (1A)"),
                        new Choice(false, "'(C)null' liefert einen Laufzeitfehler.                                       (1B)"),
                        new Choice(true, "H ist Obertyp von X.                                                          (1C)"),
                        new Choice(false, "Mit 'X ist Untertyp von C' gilt: '((C)r).getClass() == C.class'               (1D)"),
                        new Choice(true, "'(C)r' liefert keinen Laufzeitfehler wenn H Untertyp von C ist.               (1E)")
                ),

                new Question(
                        "Y, R und Z seien beliebige Referenztypen. Welche der folgenden Aussagen treffen zu?",

                        new Choice(true, "'null' ist nicht Objekt von irgendeinem Referenztyp Z.                        (2A)"),
                        new Choice(true, "Z ist Untertyp von Z.                                                         (2B)"),
                        new Choice(false, "Aus 'R Untertyp von Z' und 'Z Untertyp von Y' folgt: 'R.class==Y.class'.      (2C)"),
                        new Choice(false, "Aus 'R Untertyp von Z' folgt: 'Z ist Klasse', 'R ist Interface'.              (2D)"),
                        new Choice(true, "Aus 'R Untertyp von Z' folgt: 'für jede Methode in Z existiert Methode in R'. (2E)")
                ),

                new Question(
                        "n sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
                        "ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
                        "    STree n = new STree(); n.add(5); n.add(2); n.add(7);\n" +
                        "Welche der folgenden Aussagen treffen auf n zu?",

                        new Choice(true, "Der Knoten mit Wert 5 ist Elter von dem mit Wert 2.                           (3A)"),
                        new Choice(false, "Der Baum ist nicht ausbalanciert.                                             (3B)"),
                        new Choice(true, "Der Knoten mit Wert 5 hat zumindest ein Kind.                                 (3C)"),
                        new Choice(false, "Der Knoten mit Wert 2 ist die Wurzel.                                         (3D)"),
                        new Choice(true, "Der Knoten mit Wert 2 ist ein Blattknoten.                                    (3E)")
                ),

                new Question(
                        "n, o und p seien Objektreferenzen ungleich null.\n" +
                        "Welche der folgenden Bedingungen müssen für jede Implementierung der Methoden\n" +
                        "'boolean equals(Object obj)' und 'int hashCode()' in Java gelten?",

                        new Choice(false, "'null.equals(null)' gibt 'true' zurück.                                       (4A)"),
                        new Choice(true, "Aus '!n.equals(o)' folgt '!o.equals(n)'.                                      (4B)"),
                        new Choice(false, "'null.equals(p)' gibt 'false' zurück.                                         (4C)"),
                        new Choice(true, "Aus 'n.equals(o)' und 'o.equals(p)' folgt 'n.equals(p)'.                      (4D)"),
                        new Choice(false, "Aus 'n.hashCode() == o.hashCode()' folgt 'n.equals(o)'.                       (4E)")
                ),

                new Question(
                        "m sei eine Variable mit einem leeren Stack ganzer Zahlen.\n" +
                        "Nach welchen der folgenden Aufruf-Sequenzen liefert 'm.peek()' die Zahl 5 als Ergebnis?",

                        new Choice(false, "m.push(5); m.push(0); m.push(2);                                              (5A)"),
                        new Choice(true, "m.push(0); m.push(2); m.push(5);                                              (5B)"),
                        new Choice(false, "m.push(2); m.push(5); m.push(0);                                              (5C)"),
                        new Choice(true, "m.push(0); m.push(m.peek()); m.push(5);                                       (5D)"),
                        new Choice(true, "m.push(0); m.push(5); m.push(m.pop());                                        (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. C sei ein Referenztyp (Klasse oder Interface), und r sei eine durch\n" +
            "    'H r = new X();' deklarierte Variable, wobei der Compiler keinen Fehler meldet.\n" +
            "    Welche der folgenden Aussagen treffen für alle passenden C, H, X und r zu?\n" +
            "    \n" +
            "    XXXXXXXXX '(C)r' liefert Laufzeitfehler wenn C nicht Untertyp von H ist.                (1A)\n" +
            "    XXXXXXXXX '(C)null' liefert einen Laufzeitfehler.                                       (1B)\n" +
            "    XXXXXXXXX H ist Obertyp von X.                                                          (1C)\n" +
            "    XXXXXXXXX Mit 'X ist Untertyp von C' gilt: '((C)r).getClass() == C.class'               (1D)\n" +
            "    XXXXXXXXX '(C)r' liefert keinen Laufzeitfehler wenn H Untertyp von C ist.               (1E)\n" +
            "\n" +
            " 2. Y, R und Z seien beliebige Referenztypen. Welche der folgenden Aussagen treffen zu?\n" +
            "    \n" +
            "    XXXXXXXXX 'null' ist nicht Objekt von irgendeinem Referenztyp Z.                        (2A)\n" +
            "    XXXXXXXXX Z ist Untertyp von Z.                                                         (2B)\n" +
            "    XXXXXXXXX Aus 'R Untertyp von Z' und 'Z Untertyp von Y' folgt: 'R.class==Y.class'.      (2C)\n" +
            "    XXXXXXXXX Aus 'R Untertyp von Z' folgt: 'Z ist Klasse', 'R ist Interface'.              (2D)\n" +
            "    XXXXXXXXX Aus 'R Untertyp von Z' folgt: 'für jede Methode in Z existiert Methode in R'. (2E)\n" +
            "\n" +
            " 3. n sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
            "    ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
            "        STree n = new STree(); n.add(5); n.add(2); n.add(7);\n" +
            "    Welche der folgenden Aussagen treffen auf n zu?\n" +
            "    \n" +
            "    XXXXXXXXX Der Knoten mit Wert 5 ist Elter von dem mit Wert 2.                           (3A)\n" +
            "    XXXXXXXXX Der Baum ist nicht ausbalanciert.                                             (3B)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 5 hat zumindest ein Kind.                                 (3C)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 2 ist die Wurzel.                                         (3D)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 2 ist ein Blattknoten.                                    (3E)\n" +
            "\n" +
            " 4. n, o und p seien Objektreferenzen ungleich null.\n" +
            "    Welche der folgenden Bedingungen müssen für jede Implementierung der Methoden\n" +
            "    'boolean equals(Object obj)' und 'int hashCode()' in Java gelten?\n" +
            "    \n" +
            "    XXXXXXXXX 'null.equals(null)' gibt 'true' zurück.                                       (4A)\n" +
            "    XXXXXXXXX Aus '!n.equals(o)' folgt '!o.equals(n)'.                                      (4B)\n" +
            "    XXXXXXXXX 'null.equals(p)' gibt 'false' zurück.                                         (4C)\n" +
            "    XXXXXXXXX Aus 'n.equals(o)' und 'o.equals(p)' folgt 'n.equals(p)'.                      (4D)\n" +
            "    XXXXXXXXX Aus 'n.hashCode() == o.hashCode()' folgt 'n.equals(o)'.                       (4E)\n" +
            "\n" +
            " 5. m sei eine Variable mit einem leeren Stack ganzer Zahlen.\n" +
            "    Nach welchen der folgenden Aufruf-Sequenzen liefert 'm.peek()' die Zahl 5 als Ergebnis?\n" +
            "    \n" +
            "    XXXXXXXXX m.push(5); m.push(0); m.push(2);                                              (5A)\n" +
            "    XXXXXXXXX m.push(0); m.push(2); m.push(5);                                              (5B)\n" +
            "    XXXXXXXXX m.push(2); m.push(5); m.push(0);                                              (5C)\n" +
            "    XXXXXXXXX m.push(0); m.push(m.peek()); m.push(5);                                       (5D)\n" +
            "    XXXXXXXXX m.push(0); m.push(5); m.push(m.pop());                                        (5E)\n" +
            "\n";

    public static final long UID = 247571191285505L;

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