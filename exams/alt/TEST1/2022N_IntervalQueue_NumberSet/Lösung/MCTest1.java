// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest1 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest1 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "d sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
                        "ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
                        "    STree d = new STree(); d.add(4); d.add(6); d.add(5);\n" +
                        "Welche der folgenden Aussagen treffen auf d zu?",

                        new Choice(true, "Der Knoten mit Wert 5 ist ein Blattknoten.                                    (1A)"),
                        new Choice(false, "Der Knoten mit Wert 5 ist Elter von dem mit Wert 4.                           (1B)"),
                        new Choice(true, "Der Knoten mit Wert 6 hat zumindest ein Kind.                                 (1C)"),
                        new Choice(true, "Der Baum hat maximale Tiefe für einen Baum mit 3 Knoten.                      (1D)"),
                        new Choice(true, "Der Knoten mit Wert 4 ist die Wurzel.                                         (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen gelten in Java für die unterschiedlichen\n" +
                        "Arten von Variablen und Parametern?",

                        new Choice(false, "Lokale Variablen werden automatisch vorinitialisiert.                         (2A)"),
                        new Choice(false, "Formale Parameter werden meist als 'private' deklariert.                      (2B)"),
                        new Choice(true, "Formale Parameter können Objektvariablen verdecken.                           (2C)"),
                        new Choice(true, "Objektvariablen und lokale Variablen können gleich heißen.                    (2D)"),
                        new Choice(true, "Klassenvariablen werden mit 'static' deklariert.                              (2E)")
                ),

                new Question(
                        "p sei eine Variable mit einem leeren Stack ganzer Zahlen.\n" +
                        "Nach welchen der folgenden Aufruf-Sequenzen liefert 'p.peek()' die Zahl 0 als Ergebnis?",

                        new Choice(true, "p.push(8); p.push(p.peek()); p.push(0);                                       (3A)"),
                        new Choice(true, "p.push(8); p.push(6); p.push(0);                                              (3B)"),
                        new Choice(true, "p.push(8); p.push(p.pop()); p.push(0);                                        (3C)"),
                        new Choice(false, "p.push(0); p.push(p.peek()); p.push(8);                                       (3D)"),
                        new Choice(true, "p.push(6); p.push(8); p.push(0);                                              (3E)")
                ),

                new Question(
                        "m sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
                        "ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
                        "    STree m = new STree(); m.add(6); m.add(3); m.add(7);\n" +
                        "Welche der folgenden Aussagen treffen auf m zu?",

                        new Choice(false, "Der Knoten mit Wert 3 ist Elter von dem mit Wert 6.                           (4A)"),
                        new Choice(true, "Der Baum hat minimale Tiefe für einen Baum mit 3 Knoten.                      (4B)"),
                        new Choice(false, "Der Knoten mit Wert 6 ist Kind von dem mit Wert 7.                            (4C)"),
                        new Choice(false, "Der Knoten mit Wert 3 ist die Wurzel.                                         (4D)"),
                        new Choice(true, "Der Knoten mit Wert 7 ist ein Blattknoten.                                    (4E)")
                ),

                new Question(
                        "T, D und P seien beliebige Referenztypen. Welche der folgenden Aussagen treffen zu?",

                        new Choice(false, "Aus 'T Untertyp von D' und 'D Untertyp von P' folgt: 'T.class==P.class'.      (5A)"),
                        new Choice(true, "Ist D eine Klasse, dann ist D Untertyp von java.lang.Object.                  (5B)"),
                        new Choice(true, "Aus 'D Untertyp von P' folgt: 'für jede Methode in P existiert Methode in D'. (5C)"),
                        new Choice(true, "Aus 'T Untertyp von D' und 'D Untertyp von P' folgt: 'T Untertyp von P'.      (5D)"),
                        new Choice(true, "T ist Untertyp von T.                                                         (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. d sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
            "    ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
            "        STree d = new STree(); d.add(4); d.add(6); d.add(5);\n" +
            "    Welche der folgenden Aussagen treffen auf d zu?\n" +
            "    \n" +
            "    XXXXXXXXX Der Knoten mit Wert 5 ist ein Blattknoten.                                    (1A)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 5 ist Elter von dem mit Wert 4.                           (1B)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 6 hat zumindest ein Kind.                                 (1C)\n" +
            "    XXXXXXXXX Der Baum hat maximale Tiefe für einen Baum mit 3 Knoten.                      (1D)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 4 ist die Wurzel.                                         (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen gelten in Java für die unterschiedlichen\n" +
            "    Arten von Variablen und Parametern?\n" +
            "    \n" +
            "    XXXXXXXXX Lokale Variablen werden automatisch vorinitialisiert.                         (2A)\n" +
            "    XXXXXXXXX Formale Parameter werden meist als 'private' deklariert.                      (2B)\n" +
            "    XXXXXXXXX Formale Parameter können Objektvariablen verdecken.                           (2C)\n" +
            "    XXXXXXXXX Objektvariablen und lokale Variablen können gleich heißen.                    (2D)\n" +
            "    XXXXXXXXX Klassenvariablen werden mit 'static' deklariert.                              (2E)\n" +
            "\n" +
            " 3. p sei eine Variable mit einem leeren Stack ganzer Zahlen.\n" +
            "    Nach welchen der folgenden Aufruf-Sequenzen liefert 'p.peek()' die Zahl 0 als Ergebnis?\n" +
            "    \n" +
            "    XXXXXXXXX p.push(8); p.push(p.peek()); p.push(0);                                       (3A)\n" +
            "    XXXXXXXXX p.push(8); p.push(6); p.push(0);                                              (3B)\n" +
            "    XXXXXXXXX p.push(8); p.push(p.pop()); p.push(0);                                        (3C)\n" +
            "    XXXXXXXXX p.push(0); p.push(p.peek()); p.push(8);                                       (3D)\n" +
            "    XXXXXXXXX p.push(6); p.push(8); p.push(0);                                              (3E)\n" +
            "\n" +
            " 4. m sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
            "    ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
            "        STree m = new STree(); m.add(6); m.add(3); m.add(7);\n" +
            "    Welche der folgenden Aussagen treffen auf m zu?\n" +
            "    \n" +
            "    XXXXXXXXX Der Knoten mit Wert 3 ist Elter von dem mit Wert 6.                           (4A)\n" +
            "    XXXXXXXXX Der Baum hat minimale Tiefe für einen Baum mit 3 Knoten.                      (4B)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 6 ist Kind von dem mit Wert 7.                            (4C)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 3 ist die Wurzel.                                         (4D)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 7 ist ein Blattknoten.                                    (4E)\n" +
            "\n" +
            " 5. T, D und P seien beliebige Referenztypen. Welche der folgenden Aussagen treffen zu?\n" +
            "    \n" +
            "    XXXXXXXXX Aus 'T Untertyp von D' und 'D Untertyp von P' folgt: 'T.class==P.class'.      (5A)\n" +
            "    XXXXXXXXX Ist D eine Klasse, dann ist D Untertyp von java.lang.Object.                  (5B)\n" +
            "    XXXXXXXXX Aus 'D Untertyp von P' folgt: 'für jede Methode in P existiert Methode in D'. (5C)\n" +
            "    XXXXXXXXX Aus 'T Untertyp von D' und 'D Untertyp von P' folgt: 'T Untertyp von P'.      (5D)\n" +
            "    XXXXXXXXX T ist Untertyp von T.                                                         (5E)\n" +
            "\n";

    public static final long UID = 245045940076168L;

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