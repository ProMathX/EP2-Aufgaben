import java.util.Objects;

/**
 * Leaf node representing a file in a project tree.
 *
 * <p>A {@code ProjectFile} has no children. The subtree rooted at a file
 * therefore consists only of the file itself.</p>
 */
public class ProjectFile implements ProjectNode {

    private String name;
    private long numberOfBytes;

    /**
     * Creates a new file node.
     *
     * @param name the file name;
     *             {@code name != null && !name.isEmpty()}
     * @param numberOfBytes the file numberOfBytes in bytes;
     *             {@code numberOfBytes >= 0}
     */
    public ProjectFile(String name, long numberOfBytes) {

        this.name = name;
        this.numberOfBytes = numberOfBytes;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public long totalBytes() {
        return numberOfBytes;
    }

    @Override
    public int fileCount() {
        return 1;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public ProjectNodeCollection collectionView() {
        return new ProjectFileCollectionView(this);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ProjectFile that)) return false;
        return numberOfBytes == that.numberOfBytes && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfBytes);
    }

    @Override
    public String toString() {
        return getName() + ", " + totalBytes();
    }
}