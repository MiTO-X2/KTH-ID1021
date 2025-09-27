public class BinaryTreeTest2 {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        // Add elements to the tree
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(8);

        // Perform traversals
        System.out.println("In-Order Traversal:");
        tree.printInOrder();
        
        System.out.println("Pre-Order Traversal:");
        tree.printPreOrder();
        
        System.out.println("Post-Order Traversal:");
        tree.printPostOrder();
    }
}
