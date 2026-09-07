// Bitte beantworten Sie die Fragen (1 Punkt ab 7 richtigen Antworten, 2 Punkte ab 9 richtigen Antworten).

public class MCTest4d2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest4d2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "Welche der folgenden Aussagen treffen auf die Ein- und Ausgabe über Streams in Java zu?",

                        new Choice(false, "Streams vom Typ OutputStream wandeln die Kodierung automatisch um.                 (1A)"),
                        new Choice(true, "'new FileReader(s)' erzeugt einen ungepufferten Stream.                            (1B)"),
                        new Choice(false, "Streams werden nach der Verwendung mittels exit() geschlossen.                     (1C)"),
                        new Choice(false, "'new FileWriter(s)' wirft eine IOException wenn s schon existiert.                 (1D)"),
                        new Choice(true, "Streams vom Typ Reader wandeln die Kodierung automatisch um.                       (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf die Einhaltung von Zusicherungen\n" +
                        "entsprechend Design-by-Contract zu?",

                        new Choice(true, "Aufrufer müssen für die Einhaltung von Vorbedingungen sorgen.                      (2A)"),
                        new Choice(true, "Aufrufer können sich auf die Einhaltung von Nachbedingungen verlassen.             (2B)"),
                        new Choice(false, "Invarianten dürfen zu keinem Zeitpunkt erfüllt sein.                               (2C)"),
                        new Choice(false, "Clients können sich auf die Einhaltung der Vorbedingungen verlassen.               (2D)"),
                        new Choice(true, "Server müssen für die Einhaltung ihrer Invarianten sorgen.                         (2E)")
                )
        );
    }

// Ende der Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. Welche der folgenden Aussagen treffen auf die Ein- und Ausgabe über Streams in Java zu?\n" +
            "    \n" +
            "    XXXXXXXXX Streams vom Typ OutputStream wandeln die Kodierung automatisch um.                 (1A)\n" +
            "    XXXXXXXXX 'new FileReader(s)' erzeugt einen ungepufferten Stream.                            (1B)\n" +
            "    XXXXXXXXX Streams werden nach der Verwendung mittels exit() geschlossen.                     (1C)\n" +
            "    XXXXXXXXX 'new FileWriter(s)' wirft eine IOException wenn s schon existiert.                 (1D)\n" +
            "    XXXXXXXXX Streams vom Typ Reader wandeln die Kodierung automatisch um.                       (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen treffen auf die Einhaltung von Zusicherungen\n" +
            "    entsprechend Design-by-Contract zu?\n" +
            "    \n" +
            "    XXXXXXXXX Aufrufer müssen für die Einhaltung von Vorbedingungen sorgen.                      (2A)\n" +
            "    XXXXXXXXX Aufrufer können sich auf die Einhaltung von Nachbedingungen verlassen.             (2B)\n" +
            "    XXXXXXXXX Invarianten dürfen zu keinem Zeitpunkt erfüllt sein.                               (2C)\n" +
            "    XXXXXXXXX Clients können sich auf die Einhaltung der Vorbedingungen verlassen.               (2D)\n" +
            "    XXXXXXXXX Server müssen für die Einhaltung ihrer Invarianten sorgen.                         (2E)\n" +
            "\n";

    public static final long UID = 253656137533305L;

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