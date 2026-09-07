import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Reads project trees from the file system and provides static methods
 * for storing and loading project trees.
 *
 * <p>A {@code ProjectIO} object is associated with a root directory in the
 * file system. The method {@link #fromFileSystem()} creates a project tree
 * representing the complete subtree rooted at this directory.</p>
 *
 * <p>The static method {@link #save(ProjectNode, String)} operates
 * on independent text files and does not depend on the associated root
 * directory.</p>
 */
public class ProjectIO {

    private Path rootDirectory;

    /**
     * Creates a new {@code ProjectIO} object.
     *
     * @param rootDirectory the root directory of the file-system subtree;
     *                      {@code rootDirectory != null}
     */
    public ProjectIO(Path rootDirectory) {

        this.rootDirectory = rootDirectory;
    }

    /**
     * Returns the root directory associated with this object.
     *
     * @return the root directory
     */
    public Path getRootDirectory() {

        return rootDirectory;
    }

    /**
     * Creates a project tree from the associated file-system subtree.
     *
     * @return a project tree representing the associated file-system subtree
     */
    public ProjectNode fromFileSystem() {

        return fromFileSystem(rootDirectory.toFile());
    }

    /**
     * Writes the specified project tree to the specified file.
     *
     * <p>If the file already exists, its previous content is replaced.</p>
     *
     * @param root     the root node to write; {@code root != null}
     * @param fileName the output file name; {@code fileName != null}
     * @throws IOException if the file cannot be written
     */
    public static void save(ProjectNode root, String fileName) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            save(root, root.getName(), writer);
        }
    }


    private static void save(ProjectNode node, String path, BufferedWriter writer) throws IOException {
        if (node.isDirectory()) {
            writer.write("dir;" + path);
            writer.newLine();

            ProjectDirectory directory = (ProjectDirectory) node;

            for (ProjectNode child : directory.getChildren()) {
                save(child, path + "/" + child.getName(), writer);
            }
        } else {
            writer.write("file;" + path + ";" + node.totalBytes());
            writer.newLine();
        }
    }

    /**
     * Creates a project node from the specified file-system entry.
     *
     * @param file the file-system entry;
     *             {@code file != null && file.exists()}
     * @return a project node representing the specified file-system entry
     */
    private ProjectNode fromFileSystem(File file) {
        if (file.isDirectory()) {
            ProjectDirectory result = new ProjectDirectory(file.getName());

            File[] children = file.listFiles();

            if (children != null) {
                for (File child : children) {
                    result.add(fromFileSystem(child));
                }
            }

            return result;
        }

        return new ProjectFile(file.getName(), file.length());
    }
}