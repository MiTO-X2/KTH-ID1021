public class NodeStackTest {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        int[] values = {10, 5, 15, 3, 7, 12, 18};

        // Adding values to the binary tree
        for (int value : values) {
            tree.add(value);
        }

        // Printing the values in the binary tree using in-order traversal
        System.out.println("In-order Traversal:");
        tree.print(); // Should print: 3, 5, 7, 10, 12, 15, 18
    }
}
