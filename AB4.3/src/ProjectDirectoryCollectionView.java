/**
 * View of the subtree rooted at a directory node.
 *
 * <p>The represented subtree contains the directory itself and all nodes
 * contained recursively in its child subtrees.</p>
 *
 * <p>This class does not create an independent copy of the subtree.
 * It works directly on the directory and its children.</p>
 *
 * <p>Iteration order is pre-order: first the directory itself is visited,
 * then its children from left to right.</p>
 */
public class ProjectDirectoryCollectionView implements ProjectNodeCollection {

    private ProjectDirectory directory;

    public ProjectDirectoryCollectionView(ProjectDirectory directory) {
        this.directory = directory;
    }

    @Override
    public int size() {
        int size = 1;

        for (ProjectNode node : directory.getChildren()) {
            size += node.collectionView().size();
        }
        return size;
    }

    @Override
    public boolean contains(ProjectNode node) {
        if (directory.equals(node)) {
            return true;
        }

        for (ProjectNode child : directory.getChildren()) {
            if (child.collectionView().contains(node)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ProjectIterator iterator() {
        return new ProjectTreeIterator(directory);
    }

}
