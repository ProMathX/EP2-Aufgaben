import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Iterator traversing a project tree in pre-order.
 *
 * <p>The iterator state shall be represented using an object of the
 * predefined Java class {@code java.util.Stack<ProjectNode>}.</p>
 *
 * <p>In a pre-order traversal, a node is visited before all nodes
 * contained in its child subtrees. Child nodes are visited in the order
 * in which they are returned by {@link ProjectDirectory#getChildren()}.</p>
 *
 * <p>For example, the tree</p>
 *
 * <pre>
 * root
 * ├── src
 * │   ├── Main.java
 * │   └── World.java
 * └── README.md
 * </pre>
 *
 * <p>is traversed in the following order:</p>
 *
 * <pre>
 * root
 * src
 * Main.java
 * World.java
 * README.md
 * </pre>
 */
public class ProjectTreeIterator implements ProjectIterator {

    private Stack<ProjectNode> stack;

    public ProjectTreeIterator(ProjectNode root) {
        stack = new Stack<>();
        stack.push(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public ProjectNode next() {

        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        ProjectNode pop = stack.pop();

        if (pop instanceof ProjectDirectory directory) {
            for (ProjectNode projectNode : directory.getChildren().reversed()) {
                stack.push(projectNode);
            }
        }

        return pop;
    }
}