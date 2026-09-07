// Bitte beantworten Sie die Fragen (1 Punkt ab 7 richtigen Antworten, 2 Punkte ab 9 richtigen Antworten).

public class MCTest2d2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest2d2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "L sei ein Referenztyp (Klasse oder Interface), und\n" +
                        "b sei eine Variable eines Referenztyps mit 'b != null'.\n" +
                        "Welche der folgenden Aussagen treffen für alle L und b zu?",

                        new Choice(false, "Gilt 'b instanceof L', dann ist L eine Klasse.                        (1A)"),
                        new Choice(false, "Aus 'b instanceof L' folgt: 'b.getClass() == L.class'.                (1B)"),
                        new Choice(false, "Gilt 'b instanceof L', dann liefert '(L)b' einen Laufzeitfehler.      (1C)"),
                        new Choice(false, "'b.getClass()' liefert ein Objekt vom Typ 'String'.                   (1D)"),
                        new Choice(true, "Gilt 'b.getClass() == L.class', dann ist L eine Klasse.               (1E)")
                ),

                new Question(
                        "S sei ein Referenztyp (Klasse oder Interface), und r sei eine durch\n" +
                        "'D r = new P();' deklarierte Variable, wobei der Compiler keinen Fehler meldet.\n" +
                        "Welche der folgenden Aussagen treffen für alle passenden S, D, P und r zu?",

                        new Choice(false, "Mit 'P ist Untertyp von S' gilt: '((S)r).getClass() == D.class'       (2A)"),
                        new Choice(true, "'(S)r' liefert keinen Laufzeitfehler wenn P Untertyp von S ist.       (2B)"),
                        new Choice(false, "D und P müssen gleich sein.                                           (2C)"),
                        new Choice(false, "'(S)r' liefert einen Laufzeitfehler wenn D Untertyp von S ist.        (2D)"),
                        new Choice(false, "'(S)null' liefert einen Laufzeitfehler.                               (2E)")
                )
        );
    }

// Ende der Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. L sei ein Referenztyp (Klasse oder Interface), und\n" +
            "    b sei eine Variable eines Referenztyps mit 'b != null'.\n" +
            "    Welche der folgenden Aussagen treffen für alle L und b zu?\n" +
            "    \n" +
            "    XXXXXXXXX Gilt 'b instanceof L', dann ist L eine Klasse.                        (1A)\n" +
            "    XXXXXXXXX Aus 'b instanceof L' folgt: 'b.getClass() == L.class'.                (1B)\n" +
            "    XXXXXXXXX Gilt 'b instanceof L', dann liefert '(L)b' einen Laufzeitfehler.      (1C)\n" +
            "    XXXXXXXXX 'b.getClass()' liefert ein Objekt vom Typ 'String'.                   (1D)\n" +
            "    XXXXXXXXX Gilt 'b.getClass() == L.class', dann ist L eine Klasse.               (1E)\n" +
            "\n" +
            " 2. S sei ein Referenztyp (Klasse oder Interface), und r sei eine durch\n" +
            "    'D r = new P();' deklarierte Variable, wobei der Compiler keinen Fehler meldet.\n" +
            "    Welche der folgenden Aussagen treffen für alle passenden S, D, P und r zu?\n" +
            "    \n" +
            "    XXXXXXXXX Mit 'P ist Untertyp von S' gilt: '((S)r).getClass() == D.class'       (2A)\n" +
            "    XXXXXXXXX '(S)r' liefert keinen Laufzeitfehler wenn P Untertyp von S ist.       (2B)\n" +
            "    XXXXXXXXX D und P müssen gleich sein.                                           (2C)\n" +
            "    XXXXXXXXX '(S)r' liefert einen Laufzeitfehler wenn D Untertyp von S ist.        (2D)\n" +
            "    XXXXXXXXX '(S)null' liefert einen Laufzeitfehler.                               (2E)\n" +
            "\n";

    public static final long UID = 253653696198630L;

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
                    "In dieser Form ist keine Beurteilung möglich.\n" +
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