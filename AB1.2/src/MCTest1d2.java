// Bitte beantworten Sie die Fragen (1 Punkt ab 7 richtigen Antworten, 2 Punkte ab 9 richtigen Antworten).

public class MCTest1d2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest1d2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Aussagen treffen auf 'this' und 'this(...)' zu?",

                        new Choice(false, "In einem Konstruktor gilt: 'this == null'.                             (1A)"),
                        new Choice(false, "'this != null' kann 'false' zurückgeben.                               (1B)"),
                        new Choice(true, "In einer Klasse S bezeichnet 'this' ein Objekt von S.                  (1C)"),
                        new Choice(true, "In Objektmethoden bezeichnet 'this' das aktuelle Objekt.               (1D)"),
                        new Choice(false, "'this(...)' kann nur als letzte Anweisung verwendet werden.            (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen stimmen in Bezug auf die Unterscheidung zwischen\n" +
                        "Datenstrukturen und abstrakten Datentypen?",

                        new Choice(false, "Abstrakte Datentypen müssen verwendete Algorithmen festlegen.          (2A)"),
                        new Choice(false, "Datenstrukturen beschreiben, wie Operationen auf Daten zugreifen.      (2B)"),
                        new Choice(true, "Datenstrukturen legen die Typen ihrer Einträge fest.                   (2C)"),
                        new Choice(true, "Datenstrukturen legen fest, wie Daten zusammenhängen.                  (2D)"),
                        new Choice(true, "Datenstrukturen hängen von bestimmten Programmiersprachen ab.          (2E)")
                )
        );
    }

// Ende der Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Aussagen treffen auf 'this' und 'this(...)' zu?\n" +
            "    \n" +
            "    XXXXXXXXX In einem Konstruktor gilt: 'this == null'.                             (1A)\n" +
            "    XXXXXXXXX 'this != null' kann 'false' zurückgeben.                               (1B)\n" +
            "    XXXXXXXXX In einer Klasse S bezeichnet 'this' ein Objekt von S.                  (1C)\n" +
            "    XXXXXXXXX In Objektmethoden bezeichnet 'this' das aktuelle Objekt.               (1D)\n" +
            "    XXXXXXXXX 'this(...)' kann nur als letzte Anweisung verwendet werden.            (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen stimmen in Bezug auf die Unterscheidung zwischen\n" +
            "    Datenstrukturen und abstrakten Datentypen?\n" +
            "    \n" +
            "    XXXXXXXXX Abstrakte Datentypen müssen verwendete Algorithmen festlegen.          (2A)\n" +
            "    XXXXXXXXX Datenstrukturen beschreiben, wie Operationen auf Daten zugreifen.      (2B)\n" +
            "    XXXXXXXXX Datenstrukturen legen die Typen ihrer Einträge fest.                   (2C)\n" +
            "    XXXXXXXXX Datenstrukturen legen fest, wie Daten zusammenhängen.                  (2D)\n" +
            "    XXXXXXXXX Datenstrukturen hängen von bestimmten Programmiersprachen ab.          (2E)\n" +
            "\n";

    public static final long UID = 253652394153470L;

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