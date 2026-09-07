// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "int q=60, s=1, j=1; while (j < q) s *= ++j; \n" +
                        "Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?",

                        new Choice(true, "s ist das Produkt aller Zahlen von 1 bis j, also 1*...*j                           (1A)"),
                        new Choice(true, "j > 0 && j < q                                                                     (1B)"),
                        new Choice(false, "s >= q                                                                             (1C)"),
                        new Choice(true, "j >= 1 && j <= 60                                                                  (1D)"),
                        new Choice(false, "s ist das Produkt aller Zahlen von 1 bis q, also 1*...*q                           (1E)")
                ),

                new Question(
                        "public int median(int[] h) { return h[h.length / 2]; } \n" +
                        "Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
                        "dieser Methode sinnvoll sein?",

                        new Choice(true, "Vorbedingung: Lässt h unverändert.                                                 (2A)"),
                        new Choice(false, "Nachbedingung: h ist aufsteigend sortiert.                                         (2B)"),
                        new Choice(false, "Vorbedingung: Gibt einen Eintrag etwa in der Mitte von h zurück.                   (2C)"),
                        new Choice(false, "Vorbedingung: h != null                                                            (2D)"),
                        new Choice(true, "Nachbedingung: Ergebnis hängt von einem Eintrag von h ab.                          (2E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen für Design-by-Contract zu?",

                        new Choice(false, "Eine Vorbedingung darf im Untertyp schwächer sein als im Obertyp.                  (3A)"),
                        new Choice(false, "Allgemeine Erwartungen müssen in Zusicherungen festgeschrieben sein.               (3B)"),
                        new Choice(true, "Vorbedingungen beschreiben häufig Eigenschaften von Parametern.                    (3C)"),
                        new Choice(true, "Invarianten beziehen sich auf Objektzustände.                                      (3D)"),
                        new Choice(false, "Eine Nachbedingung darf im Untertyp schwächer sein als im Obertyp.                 (3E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf Ausnahmen und Ausnahmebehandlungen in Java zu?",

                        new Choice(false, "Ausnahmen vom Typ Exception sind überprüft (checked).                              (4A)"),
                        new Choice(true, "Das Java-Laufzeitsystem wirft nur unüberprüfte (unchecked) Ausnahmen.              (4B)"),
                        new Choice(false, "finally-Blöcke werden trotz aufgetretener Ausnahme ausgeführt.                     (4C)"),
                        new Choice(false, "Nicht abgefangene Ausnahmen beenden das Programm mit einem Stack-Trace.            (4D)"),
                        new Choice(false, "Das Ergebnis von getMessage() bestimmt den Typ einer Exception.                    (4E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf das Testen großer Programme zu?",

                        new Choice(true, "Eine Code-Review hilft beim Auffinden von Fehlerursachen.                          (5A)"),
                        new Choice(false, "White-Box-Testen leitet Testfälle aus der Implementierung ab.                      (5B)"),
                        new Choice(false, "Schnittstellen-Tests überprüfen die Benutzeroberfläche.                            (5C)"),
                        new Choice(true, "Black-Box-Testen legt Testfälle vor der Implementierung fest.                      (5D)"),
                        new Choice(false, "Grey-Box-Testen legt Testfälle nach der Implementierung fest.                      (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. int q=60, s=1, j=1; while (j < q) s *= ++j; \n" +
            "    Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?\n" +
            "    \n" +
            "    XXXXXXXXX s ist das Produkt aller Zahlen von 1 bis j, also 1*...*j                           (1A)\n" +
            "    XXXXXXXXX j > 0 && j < q                                                                     (1B)\n" +
            "    XXXXXXXXX s >= q                                                                             (1C)\n" +
            "    XXXXXXXXX j >= 1 && j <= 60                                                                  (1D)\n" +
            "    XXXXXXXXX s ist das Produkt aller Zahlen von 1 bis q, also 1*...*q                           (1E)\n" +
            "\n" +
            " 2. public int median(int[] h) { return h[h.length / 2]; } \n" +
            "    Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
            "    dieser Methode sinnvoll sein?\n" +
            "    \n" +
            "    XXXXXXXXX Vorbedingung: Lässt h unverändert.                                                 (2A)\n" +
            "    XXXXXXXXX Nachbedingung: h ist aufsteigend sortiert.                                         (2B)\n" +
            "    XXXXXXXXX Vorbedingung: Gibt einen Eintrag etwa in der Mitte von h zurück.                   (2C)\n" +
            "    XXXXXXXXX Vorbedingung: h != null                                                            (2D)\n" +
            "    XXXXXXXXX Nachbedingung: Ergebnis hängt von einem Eintrag von h ab.                          (2E)\n" +
            "\n" +
            " 3. Welche der folgenden Aussagen treffen für Design-by-Contract zu?\n" +
            "    \n" +
            "    XXXXXXXXX Eine Vorbedingung darf im Untertyp schwächer sein als im Obertyp.                  (3A)\n" +
            "    XXXXXXXXX Allgemeine Erwartungen müssen in Zusicherungen festgeschrieben sein.               (3B)\n" +
            "    XXXXXXXXX Vorbedingungen beschreiben häufig Eigenschaften von Parametern.                    (3C)\n" +
            "    XXXXXXXXX Invarianten beziehen sich auf Objektzustände.                                      (3D)\n" +
            "    XXXXXXXXX Eine Nachbedingung darf im Untertyp schwächer sein als im Obertyp.                 (3E)\n" +
            "\n" +
            " 4. Welche der folgenden Aussagen treffen auf Ausnahmen und Ausnahmebehandlungen in Java zu?\n" +
            "    \n" +
            "    XXXXXXXXX Ausnahmen vom Typ Exception sind überprüft (checked).                              (4A)\n" +
            "    XXXXXXXXX Das Java-Laufzeitsystem wirft nur unüberprüfte (unchecked) Ausnahmen.              (4B)\n" +
            "    XXXXXXXXX finally-Blöcke werden trotz aufgetretener Ausnahme ausgeführt.                     (4C)\n" +
            "    XXXXXXXXX Nicht abgefangene Ausnahmen beenden das Programm mit einem Stack-Trace.            (4D)\n" +
            "    XXXXXXXXX Das Ergebnis von getMessage() bestimmt den Typ einer Exception.                    (4E)\n" +
            "\n" +
            " 5. Welche der folgenden Aussagen treffen auf das Testen großer Programme zu?\n" +
            "    \n" +
            "    XXXXXXXXX Eine Code-Review hilft beim Auffinden von Fehlerursachen.                          (5A)\n" +
            "    XXXXXXXXX White-Box-Testen leitet Testfälle aus der Implementierung ab.                      (5B)\n" +
            "    XXXXXXXXX Schnittstellen-Tests überprüfen die Benutzeroberfläche.                            (5C)\n" +
            "    XXXXXXXXX Black-Box-Testen legt Testfälle vor der Implementierung fest.                      (5D)\n" +
            "    XXXXXXXXX Grey-Box-Testen legt Testfälle nach der Implementierung fest.                      (5E)\n" +
            "\n";

    public static final long UID = 247531307369375L;

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