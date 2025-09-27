import java.util.NoSuchElementException;

public class Sequence {
    private Queue queue;

    // Constructor that initializes the sequence with the root of the tree
    public Sequence(TreeNode root) {
        queue = new Queue();
        if (root != null) {
            queue.enqueue(root);
        }
    }

    // Method to return the next value in the sequence
    public int next() {
        if (queue.isEmpty()) {
            throw new NoSuchElementException("No more elements in the sequence.");
        }

        TreeNode currentNode = queue.dequeue();
        int value = currentNode.value;

        // Add the children of the current node to the queue for future traversal
        if (currentNode.left != null) {
            queue.enqueue(currentNode.left);
        }
        if (currentNode.right != null) {
            queue.enqueue(currentNode.right);
        }

        return value;
    }
}
