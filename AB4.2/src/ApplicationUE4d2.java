import java.io.*;
import java.util.Map;

/**
 * Additional exercise for AB4.2.
 */
public class ApplicationUE4d2 {

    public static void main(String[] args) {
        try {
            String fileName = "first-collision-test.log";

            createTestFile(fileName);

            Map<String, Integer> result = SimulationLogger.firstCollisionStepPerAnt(fileName);

            check("Ant@A", 3, result.get("Ant@A"));
            check("Ant@B", 4, result.get("Ant@B"));
            check("Ant@C", 6, result.get("Ant@C"));

        } catch (IOException e) {

            System.out.println("[FAIL] IOException: " + e.getMessage());
        }
    }

    private static void createTestFile(String fileName) throws IOException {

        try (PrintWriter out = new PrintWriter(new FileWriter(fileName))) {
            out.println("step=3; ant=Ant@A; obstacle=Ant@X");
            out.println("step=4; ant=Ant@B; obstacle=Ant@Y");
            out.println("step=5; ant=Ant@A; obstacle=Nest@(100.0,100.0)");
            out.println("step=6; ant=Ant@C; obstacle=Ant@Z");
            out.println("step=7; ant=Ant@B; obstacle=Nest@(100.0,100.0)");
        }
    }

    private static void check(String testName, Object expected, Object actual) {

        if (java.util.Objects.equals(expected, actual)) {
            System.out.println("[OK]   " + testName);
        } else {
            System.out.println("[FAIL] " + testName + " -> Expected: " + expected + ", Actual: " + actual);
        }
    }
}