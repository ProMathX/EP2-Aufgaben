// Bitte beantworten Sie die Multiple-Choice-Fragen (maximal 25 Punkte, 1 Punkt pro 'Choice').

public class MCTest2 {

    // Wenn 'answer' in 'new Choice(...)' für davor stehende 'question' zutrifft, 'valid' bitte auf 'true' ändern.
    // Sonst 'valid' auf 'false' belassen.
    // Kommentare wirken sich nicht auf die Beurteilung aus.
    // Bitte sonst nichts ändern. Zur Kontrolle MCTest2 ausführen.
    public static void main(String[] args) {
        checkAndPrint(

                new Question(
                        "public int sumFrom1To(int z) { return (z * (z + 1)) / 2; } \n" +
                        "Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
                        "dieser Methode sinnvoll sein?",

                        new Choice(false, "Vorbedingung: z >= 1.                                                              (1A)"),
                        new Choice(false, "Vorbedingung: Gibt (z * (z + 1)) / 2 zurück.                                       (1B)"),
                        new Choice(false, "Vorbedingung: Lässt den Objektzustand unverändert.                                 (1C)"),
                        new Choice(false, "Vorbedingung: Ergebnis ist für z < 1 nicht die Zahlensumme.                        (1D)"),
                        new Choice(false, "Nachbedingung: Ergebnis hängt nur von z ab.                                        (1E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf gut gewählte Kommentare in Programmen zu?",

                        new Choice(false, "Besonders wenige Kommentare deuten auf schlecht designte Stellen hin.              (2A)"),
                        new Choice(false, "Kommentare sollen aus Sicht der Anwendung geschrieben sein.                        (2B)"),
                        new Choice(false, "Schleifeninvarianten stehen hauptsächlich bei Variablendeklarationen.              (2C)"),
                        new Choice(false, "Vorbedingungen stehen hauptsächlich vor Methodenköpfen.                            (2D)"),
                        new Choice(false, "Die meisten Kommentare stehen im Rumpf von Methoden und Konstruktoren.             (2E)")
                ),

                new Question(
                        "Welche der folgenden Aussagen treffen auf die Ein- und Ausgabe über Streams in Java zu?",

                        new Choice(false, "Streams werden nach der Verwendung mittels close() geschlossen.                    (3A)"),
                        new Choice(false, "'new FileReader(s)' erzeugt einen ungepufferten Stream.                            (3B)"),
                        new Choice(false, "Ab Java 7 schließen sich am Methodenende offene Streams automatisch.               (3C)"),
                        new Choice(false, "Ausgaben über gepufferte Streams gehen direkt an das Betriebssystem.               (3D)"),
                        new Choice(false, "Ungepufferte Streams sind meist effizienter als gepufferte.                        (3E)")
                ),

                new Question(
                        "v, w und x seien Objektreferenzen ungleich null.\n" +
                        "Welche der folgenden Bedingungen müssen für jede Implementierung der Methoden\n" +
                        "boolean equals(Object obj)  und  int hashCode()  in Java gelten?",

                        new Choice(false, "Aus  v.equals(w)  und  w.equals(x)  folgt  v.equals(x).                            (4A)"),
                        new Choice(false, "null.equals(null)  gibt  true  zurück.                                             (4B)"),
                        new Choice(false, "Aus  w.hashCode() != x.hashCode()  folgt  !w.equals(x).                            (4C)"),
                        new Choice(false, "Aus  w.equals(x)  folgt  !x.equals(w).                                             (4D)"),
                        new Choice(false, "null.equals(x)  gibt  false  zurück.                                               (4E)")
                ),

                new Question(
                        "int p=63, w=1, i=1; while (i < p) w *= ++i; \n" +
                        "Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?",

                        new Choice(false, "w >= p                                                                             (5A)"),
                        new Choice(false, "i > 0 && i < p                                                                     (5B)"),
                        new Choice(false, "i > 1                                                                              (5C)"),
                        new Choice(false, "i >= 1 && i <= p                                                                   (5D)"),
                        new Choice(false, "w ist das Produkt aller Zahlen von 1 bis i, also 1*...*i                           (5E)")
                )
        );
    }

// Ende der Multiple-Choice-Fragen

//------------------------------------------------------------
// Bitte lassen Sie den Rest der Datei unverändert.
// Please do not edit below this line.

    private static final String EXPECT = // nochmals die gleichen Fragen zur Selbstkontrolle 
            " 1. public int sumFrom1To(int z) { return (z * (z + 1)) / 2; } \n" +
            "    Welche der folgenden Aussagen können (jede für sich) als Vor- bzw. Nachbedingungen\n" +
            "    dieser Methode sinnvoll sein?\n" +
            "    \n" +
            "    XXXXXXXXX Vorbedingung: z >= 1.                                                              (1A)\n" +
            "    XXXXXXXXX Vorbedingung: Gibt (z * (z + 1)) / 2 zurück.                                       (1B)\n" +
            "    XXXXXXXXX Vorbedingung: Lässt den Objektzustand unverändert.                                 (1C)\n" +
            "    XXXXXXXXX Vorbedingung: Ergebnis ist für z < 1 nicht die Zahlensumme.                        (1D)\n" +
            "    XXXXXXXXX Nachbedingung: Ergebnis hängt nur von z ab.                                        (1E)\n" +
            "\n" +
            " 2. Welche der folgenden Aussagen treffen auf gut gewählte Kommentare in Programmen zu?\n" +
            "    \n" +
            "    XXXXXXXXX Besonders wenige Kommentare deuten auf schlecht designte Stellen hin.              (2A)\n" +
            "    XXXXXXXXX Kommentare sollen aus Sicht der Anwendung geschrieben sein.                        (2B)\n" +
            "    XXXXXXXXX Schleifeninvarianten stehen hauptsächlich bei Variablendeklarationen.              (2C)\n" +
            "    XXXXXXXXX Vorbedingungen stehen hauptsächlich vor Methodenköpfen.                            (2D)\n" +
            "    XXXXXXXXX Die meisten Kommentare stehen im Rumpf von Methoden und Konstruktoren.             (2E)\n" +
            "\n" +
            " 3. Welche der folgenden Aussagen treffen auf die Ein- und Ausgabe über Streams in Java zu?\n" +
            "    \n" +
            "    XXXXXXXXX Streams werden nach der Verwendung mittels close() geschlossen.                    (3A)\n" +
            "    XXXXXXXXX 'new FileReader(s)' erzeugt einen ungepufferten Stream.                            (3B)\n" +
            "    XXXXXXXXX Ab Java 7 schließen sich am Methodenende offene Streams automatisch.               (3C)\n" +
            "    XXXXXXXXX Ausgaben über gepufferte Streams gehen direkt an das Betriebssystem.               (3D)\n" +
            "    XXXXXXXXX Ungepufferte Streams sind meist effizienter als gepufferte.                        (3E)\n" +
            "\n" +
            " 4. v, w und x seien Objektreferenzen ungleich null.\n" +
            "    Welche der folgenden Bedingungen müssen für jede Implementierung der Methoden\n" +
            "    boolean equals(Object obj)  und  int hashCode()  in Java gelten?\n" +
            "    \n" +
            "    XXXXXXXXX Aus  v.equals(w)  und  w.equals(x)  folgt  v.equals(x).                            (4A)\n" +
            "    XXXXXXXXX null.equals(null)  gibt  true  zurück.                                             (4B)\n" +
            "    XXXXXXXXX Aus  w.hashCode() != x.hashCode()  folgt  !w.equals(x).                            (4C)\n" +
            "    XXXXXXXXX Aus  w.equals(x)  folgt  !x.equals(w).                                             (4D)\n" +
            "    XXXXXXXXX null.equals(x)  gibt  false  zurück.                                               (4E)\n" +
            "\n" +
            " 5. int p=63, w=1, i=1; while (i < p) w *= ++i; \n" +
            "    Welche der folgenden Aussagen sind gültige Schleifeninvarianten dieser Schleife?\n" +
            "    \n" +
            "    XXXXXXXXX w >= p                                                                             (5A)\n" +
            "    XXXXXXXXX i > 0 && i < p                                                                     (5B)\n" +
            "    XXXXXXXXX i > 1                                                                              (5C)\n" +
            "    XXXXXXXXX i >= 1 && i <= p                                                                   (5D)\n" +
            "    XXXXXXXXX w ist das Produkt aller Zahlen von 1 bis i, also 1*...*i                           (5E)\n" +
            "\n";

    public static final long UID = 247535035503630L;

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