public class BinaryTreeTest {
    public static void main(String[] args) {
        // Create a new binary tree
        BinaryTree binaryTree = new BinaryTree();

        // Test recursive add() and lookup()
        System.out.println("Testing recursive add() and lookup()...");
        binaryTree.add(50);
        binaryTree.add(30);
        binaryTree.add(70);
        binaryTree.add(20);
        binaryTree.add(40);
        binaryTree.add(60);
        binaryTree.add(80);

        System.out.println("Lookup 40 (expect true): " + binaryTree.lookup(40)); // Should return true
        System.out.println("Lookup 25 (expect false): " + binaryTree.lookup(25)); // Should return false

        // Test iterative add() method
        BinaryTree iterativeTree = new BinaryTree();
        System.out.println("\nTesting iterative add()...");
        iterativeTree.addIterative(50);
        iterativeTree.addIterative(30);
        iterativeTree.addIterative(70);
        iterativeTree.addIterative(20);
        iterativeTree.addIterative(40);
        iterativeTree.addIterative(60);
        iterativeTree.addIterative(80);

        System.out.println("Lookup 70 (expect true): " + iterativeTree.lookup(70)); // Should return true
        System.out.println("Lookup 15 (expect false): " + iterativeTree.lookup(15)); // Should return false
    }
}
