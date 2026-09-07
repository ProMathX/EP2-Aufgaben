/**
 * View of the subtree rooted at a file node.
 *
 * <p>The represented subtree consists only of the file itself.</p>
 *
 * <p>This class does not create an independent copy of the file node.
 * It provides a read-only view onto the file.</p>
 */
public class ProjectFileCollectionView implements ProjectNodeCollection {

    private final ProjectFile file;

    public ProjectFileCollectionView(ProjectFile file) {
        this.file = file;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public boolean contains(ProjectNode node) {
        return file.equals(node);
    }

    @Override
    public ProjectIterator iterator() {
        return new ProjectTreeIterator(file);
    }

}
