import java.io.*;
import java.nio.file.Files;
import java.util.*;

/**
 * Collects and writes simulation log information.
 *
 * <p>This class stores simulation-step exceptions that occurred during
 * the simulation. It also keeps a text output stream open so that new
 * log entries can be written while the simulation is running.</p>
 *
 * <p>The logger uses predefined Java collection classes internally.</p>
 */
public class SimulationLogger {

    private File file;
    private List<SimulationStepException> exceptions;
    private BufferedWriter writer;
    /**
     * Creates a new simulation logger that writes to the specified file.
     *
     * <p>If the file already exists, new log entries are appended to the
     * existing content.</p>
     *
     * @param fileName the output file name; {@code fileName != null}
     * @throws IOException if the file cannot be opened for writing
     */
    public SimulationLogger(String fileName) throws IOException {
        this.file = new File(fileName);
        this.exceptions = new ArrayList<>();
        this.writer = new BufferedWriter(new FileWriter(this.file, true));
    }

    /**
     * Records and writes a simulation-step exception.
     *
     * <p>The exception is stored internally and immediately written to the
     * log file. The output stream is flushed after writing so that the log
     * file is updated while the simulation is running.</p>
     *
     * @param exception the exception to record; {@code exception != null}
     */
    public void log(SimulationStepException exception)  {
        exceptions.add(exception);

        try {
            for (UnresolvedCollisionException collision : exception.getCollisions()) {
                writer.write(collision.toString());
                writer.newLine();
            }

            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException("Could not write simulation log", e);
        }
    }

    /**
     * Returns the number of simulation steps for which at least one
     * unresolved collision was recorded.
     *
     * @return the number of recorded failed simulation steps
     */
    public int failedStepCount() {
        return Math.toIntExact(exceptions.stream().map(StepException::getStep).distinct().count());
    }

    /**
     * Returns the total number of unresolved collisions recorded so far.
     *
     * @return the total number of unresolved collisions
     */
    public int unresolvedCollisionCount() {
        int count = 0;

        for (SimulationStepException exception : exceptions) {
            count += exception.collisionCount();
        }

        return count;
    }

    /**
     * Closes this logger.
     *
     * <p>Closing the logger flushes any buffered output and releases the
     * underlying file resource. After this method has been called, no further
     * log entries should be written.</p>
     */
    public void close() {
        try {
            writer.flush();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException("Could not close simulation log", e);
        }
    }

    /**
     * Reads a simulation log file and returns the number of unresolved
     * collisions recorded for each simulation step.
     *
     * <p>The log file is expected to contain one unresolved collision per line.
     * Each relevant line starts with a step entry of the form
     * {@code step=<number>}.</p>
     *
     * <p>Example line:</p>
     *
     * <pre>
     * step=24; ant=Ant@2c039ac6; obstacle=Ant@5f3a4b84
     * </pre>
     *
     * <p>The returned map associates each simulation step with the number of
     * unresolved collisions recorded for that step. If the same step occurs
     * multiple times in the file, the counts are accumulated.</p>
     *
     * @param fileName the log file name; {@code fileName != null}
     * @return a map associating simulation steps with unresolved collision counts
     * @throws IOException if the file cannot be read
     */
    public static Map<Integer, Integer> readCollisionsPerStep(String fileName)
            throws IOException {
        Map<Integer, Integer> result = new HashMap<>();
        List<String> lines = Files.readAllLines(new File(fileName).toPath());

        for (String line : lines) {
            if (line.startsWith("step=")) {
                int endIndex = line.indexOf(";");

                if (endIndex != -1) {
                    String stepText = line.substring("step=".length(), endIndex);
                    int step = Integer.parseInt(stepText);

                    result.compute(step, (key, value) -> value == null ? 1 : value + 1);
                }
            }
        }

        return result;
    }

    /**
     * Reads a simulation log file and returns the first simulation step in
     * which each ant was involved in an unresolved collision.
     *
     * <p>The method parses the log file directly. Only the first occurrence
     * of each ant is stored.</p>
     *
     * @param fileName the log file name; {@code fileName != null}
     * @return a map assigning each ant identifier to its first collision step
     * @throws IOException if the file cannot be read
     */
    public static Map<String, Integer> firstCollisionStepPerAnt(String fileName) throws IOException {
        Map<String, Integer> result = new HashMap<>();

        List<String> content = Files.readAllLines(new File(fileName).toPath());

        for (String line : content) {
            String[] split = line.split(";");
            int step = -1;
            String ant = null;
            for (String segment : split) {
                segment = segment.trim();
                if (segment.startsWith("step=")) {
                    String substring = segment.substring("step=".length());

                    step = Integer.parseInt(substring);
                    continue;
                }

                if (segment.startsWith("ant=")) {
                    ant = segment.substring("ant=".length());
                }
            }

            if (step != -1 && ant != null) {
                result.putIfAbsent(ant, step);
            }

        }
        return result;
    }
}