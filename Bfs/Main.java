public class Main {
    public static void main(String[] args) {
        // Construct the binary tree
        BinaryTree tree = new BinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);

        // Perform breadth-first search
        System.out.println("Breadth-First Traversal:");
        tree.bfs(); // Output: 1 2 3 4 5

        // Using the Sequence class to get values lazily
        Sequence sequence = new Sequence(tree.root);
        System.out.println("Next values in the sequence:");
        System.out.println(sequence.next()); // Output: 1
        System.out.println(sequence.next()); // Output: 2
        System.out.println(sequence.next()); // Output: 3

        // Adding a break and then extracting more values
        tree.root.left.left.left = new TreeNode(6); // Adding a new node
        System.out.println(sequence.next()); // Output: 4
        System.out.println(sequence.next()); // Output: 5
    }
}
