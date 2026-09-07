// Bitte beantworten Sie die Fragen (1 Punkt ab 7 richtigen Antworten, 2 Punkte ab 9 richtigen Antworten).

public class MCTest3d2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest3d2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Y und U seien Referenztypen, sodass der Compiler folgenden Programmtext\n" +
                        "fehlerfrei compiliert: 'U i = new Y();  i.o();'\n" +
                        "Welche der folgenden Aussagen treffen für alle passenden Y, U, i und o() zu?",

                        new Choice(false, "Es gilt: 'i.getClass() == U.class'                                        (1A)"),
                        new Choice(true, "U ist Obertyp von Y.                                                      (1B)"),
                        new Choice(true, "Wo ein Objekt von U erwartet wird, kann i verwendet werden.               (1C)"),
                        new Choice(true, "Die Methode o() muss in U vorkommen, nicht in Y.                          (1D)"),
                        new Choice(false, "Durch 'i.o()' wird die Methode in U ausgeführt.                           (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Iteratoren in Java zu?",

                        new Choice(false, "Iterator-Implementierungen können keine Klassen sein.                     (2A)"),
                        new Choice(false, "Das Interface Iterator spezifiziert die Methode iterator().               (2B)"),
                        new Choice(false, "Nur ein Iterator kann zu einem Zeitpunkt über ein Objekt laufen.          (2C)"),
                        new Choice(false, "Eine Collection kann höchstens eine Iterator-Implementierung enthalten.   (2D)"),
                        new Choice(true, "Lineare Listen sind meist einfacher iterierbar als Binärbäume.            (2E)")
                )
        );
    }

// Ende der Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Y und U seien Referenztypen, sodass der Compiler folgenden Programmtext\n" +
            "    fehlerfrei compiliert: 'U i = new Y();  i.o();'\n" +
            "    Welche der folgenden Aussagen treffen für alle passenden Y, U, i und o() zu?\n" +
            "    \n" +
            "    XXXXXXXXX Es gilt: 'i.getClass() == U.class'                                        (1A)\n" +
            "    XXXXXXXXX U ist Obertyp von Y.                                                      (1B)\n" +
            "    XXXXXXXXX Wo ein Objekt von U erwartet wird, kann i verwendet werden.               (1C)\n" +
            "    XXXXXXXXX Die Methode o() muss in U vorkommen, nicht in Y.                          (1D)\n" +
            "    XXXXXXXXX Durch 'i.o()' wird die Methode in U ausgeführt.                           (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen treffen auf Iteratoren in Java zu?\n" +
            "    \n" +
            "    XXXXXXXXX Iterator-Implementierungen können keine Klassen sein.                     (2A)\n" +
            "    XXXXXXXXX Das Interface Iterator spezifiziert die Methode iterator().               (2B)\n" +
            "    XXXXXXXXX Nur ein Iterator kann zu einem Zeitpunkt über ein Objekt laufen.          (2C)\n" +
            "    XXXXXXXXX Eine Collection kann höchstens eine Iterator-Implementierung enthalten.   (2D)\n" +
            "    XXXXXXXXX Lineare Listen sind meist einfacher iterierbar als Binärbäume.            (2E)\n" +
            "\n";

    public static final long UID = 253654923125800L;

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