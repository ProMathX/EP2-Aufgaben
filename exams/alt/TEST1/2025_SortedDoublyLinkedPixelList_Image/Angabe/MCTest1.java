// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest1 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest1 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "r sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
                        "ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
                        "    STree r = new STree(); r.add(4); r.add(2); r.add(8);\n" +
                        "Welche der folgenden Aussagen treffen auf r zu?",

                        new Choice(false, "Der Knoten mit Wert 8 ist Elter von dem mit Wert 4.                           (1A)"),
                        new Choice(true, "Der Knoten mit Wert 2 ist Kind von dem mit Wert 4.                            (1B)"),
                        new Choice(true, "Der Baum ist perfekt ausbalanciert.                                           (1C)"),
                        new Choice(true, "Der Knoten mit Wert 4 ist die Wurzel.                                         (1D)"),
                        new Choice(false, "Der Knoten mit Wert 8 ist ein Blattknoten.                                    (1E)")
                ),

                new Question(
                        "M und T seien Referenztypen, sodass der Compiler folgenden Programmtext\n" +
                        "fehlerfrei compiliert: 'T o = new M();  o.n();'\n" +
                        "Welche der folgenden Aussagen treffen für alle passenden M, T, o und n() zu?",

                        new Choice(false, "T ist Obertyp von M.                                                          (2A)"),
                        new Choice(true, "Es gilt: 'o instanceof M'.                                                    (2B)"),
                        new Choice(false, "Kommentare zu n() in T müssen auch auf n() in M zutreffen.                    (2C)"),
                        new Choice(true, "M muss eine Klasse sein (kein Interface).                                     (2D)"),
                        new Choice(false, "Die Methode n() muss in T vorkommen, nicht in M.                              (2E)")
                ),

                new Question(
                        "Y sei ein Referenztyp (Klasse oder Interface), und\n" +
                        "w sei eine Variable eines Referenztyps mit 'w != null'.\n" +
                        "Welche der folgenden Aussagen treffen für alle Y und w zu?",

                        new Choice(false, "Gilt '!(w instanceof Y)', dann liefert '(Y)w' einen Laufzeitfehler.           (3A)"),
                        new Choice(false, "Gilt 'w instanceof Y', dann ist Y der dynamische Typ von w.                   (3B)"),
                        new Choice(true, "Aus 'w.getClass() == Y.class' folgt: 'w instanceof Y'.                        (3C)"),
                        new Choice(false, "Gilt 'w.getClass() == Y.class', dann ist Y eine Klasse.                       (3D)"),
                        new Choice(true, "'w.getClass()' liefert (interne Repr. vom) dynamischen Typ von w.             (3E)")
                ),

                new Question(
                        "q sei eine Variable mit einer leeren assoziativen Datenstruktur, wobei Schlüssel\n" +
                        "und Werte vom Typ 'String' sind (und 'null' sein können).  F und H seien zwei\n" +
                        "voneinander verschiedene String-Konstanten (static final).  Nach welchen der\n" +
                        "folgenden Aufruf-Sequenzen liefert 'q.get(F)' den String in H als Ergebnis?",

                        new Choice(false, "q.put(q.get(F), q.get(H)); q.put(F, F); q.put(H, H);                          (4A)"),
                        new Choice(false, "q.put(H, F); q.put(q.get(H), q.get(F)); q.put(F, H);                          (4B)"),
                        new Choice(true, "q.put(F, F); q.put(H, H); q.put(q.get(F), q.get(H));                          (4C)"),
                        new Choice(true, "q.put(F, H); q.put(F, F); q.put(H, F);                                        (4D)"),
                        new Choice(true, "q.put(F, H); q.put(F, F); q.put(q.get(F), q.get(H));                          (4E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen stimmen in Bezug auf Datenabstraktion?",

                        new Choice(true, "Das Resultat ist ein abstrakter Datentyp.                                     (5A)"),
                        new Choice(false, "Kommentare sind in abstrakten Datentypen bedeutungslos.                       (5B)"),
                        new Choice(true, "Klassen implementieren abstrakte Datentypen.                                  (5C)"),
                        new Choice(false, "Datenabstraktion verhindert Änderungen von Objektzuständen.                   (5D)"),
                        new Choice(true, "Datenkapselung und Data-Hiding sind für Datenabstraktion nötig.               (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. r sei eine Variable mit einem einfachen binären Suchbaum (nicht AVL-Baum)\n" +
            "    ganzer Zahlen, der durch diese Anweisungen aufgebaut wurde:\n" +
            "        STree r = new STree(); r.add(4); r.add(2); r.add(8);\n" +
            "    Welche der folgenden Aussagen treffen auf r zu?\n" +
            "    \n" +
            "    XXXXXXXXX Der Knoten mit Wert 8 ist Elter von dem mit Wert 4.                           (1A)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 2 ist Kind von dem mit Wert 4.                            (1B)\n" +
            "    XXXXXXXXX Der Baum ist perfekt ausbalanciert.                                           (1C)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 4 ist die Wurzel.                                         (1D)\n" +
            "    XXXXXXXXX Der Knoten mit Wert 8 ist ein Blattknoten.                                    (1E)\n" +
            "\n" +
            " 2. M und T seien Referenztypen, sodass der Compiler folgenden Programmtext\n" +
            "    fehlerfrei compiliert: 'T o = new M();  o.n();'\n" +
            "    Welche der folgenden Aussagen treffen für alle passenden M, T, o und n() zu?\n" +
            "    \n" +
            "    XXXXXXXXX T ist Obertyp von M.                                                          (2A)\n" +
            "    XXXXXXXXX Es gilt: 'o instanceof M'.                                                    (2B)\n" +
            "    XXXXXXXXX Kommentare zu n() in T müssen auch auf n() in M zutreffen.                    (2C)\n" +
            "    XXXXXXXXX M muss eine Klasse sein (kein Interface).                                     (2D)\n" +
            "    XXXXXXXXX Die Methode n() muss in T vorkommen, nicht in M.                              (2E)\n" +
            "\n" +
            " 3. Y sei ein Referenztyp (Klasse oder Interface), und\n" +
            "    w sei eine Variable eines Referenztyps mit 'w != null'.\n" +
            "    Welche der folgenden Aussagen treffen für alle Y und w zu?\n" +
            "    \n" +
            "    XXXXXXXXX Gilt '!(w instanceof Y)', dann liefert '(Y)w' einen Laufzeitfehler.           (3A)\n" +
            "    XXXXXXXXX Gilt 'w instanceof Y', dann ist Y der dynamische Typ von w.                   (3B)\n" +
            "    XXXXXXXXX Aus 'w.getClass() == Y.class' folgt: 'w instanceof Y'.                        (3C)\n" +
            "    XXXXXXXXX Gilt 'w.getClass() == Y.class', dann ist Y eine Klasse.                       (3D)\n" +
            "    XXXXXXXXX 'w.getClass()' liefert (interne Repr. vom) dynamischen Typ von w.             (3E)\n" +
            "\n" +
            " 4. q sei eine Variable mit einer leeren assoziativen Datenstruktur, wobei Schlüssel\n" +
            "    und Werte vom Typ 'String' sind (und 'null' sein können).  F und H seien zwei\n" +
            "    voneinander verschiedene String-Konstanten (static final).  Nach welchen der\n" +
            "    folgenden Aufruf-Sequenzen liefert 'q.get(F)' den String in H als Ergebnis?\n" +
            "    \n" +
            "    XXXXXXXXX q.put(q.get(F), q.get(H)); q.put(F, F); q.put(H, H);                          (4A)\n" +
            "    XXXXXXXXX q.put(H, F); q.put(q.get(H), q.get(F)); q.put(F, H);                          (4B)\n" +
            "    XXXXXXXXX q.put(F, F); q.put(H, H); q.put(q.get(F), q.get(H));                          (4C)\n" +
            "    XXXXXXXXX q.put(F, H); q.put(F, F); q.put(H, F);                                        (4D)\n" +
            "    XXXXXXXXX q.put(F, H); q.put(F, F); q.put(q.get(F), q.get(H));                          (4E)\n" +
            "\n" +
            " 5. Welche der folgenden Aussagen stimmen in Bezug auf Datenabstraktion?\n" +
            "    \n" +
            "    XXXXXXXXX Das Resultat ist ein abstrakter Datentyp.                                     (5A)\n" +
            "    XXXXXXXXX Kommentare sind in abstrakten Datentypen bedeutungslos.                       (5B)\n" +
            "    XXXXXXXXX Klassen implementieren abstrakte Datentypen.                                  (5C)\n" +
            "    XXXXXXXXX Datenabstraktion verhindert Änderungen von Objektzuständen.                   (5D)\n" +
            "    XXXXXXXXX Datenkapselung und Data-Hiding sind für Datenabstraktion nötig.               (5E)\n" +
            "\n";

    public static final long UID = 247528923808130L;

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