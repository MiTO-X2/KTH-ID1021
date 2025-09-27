public class BinaryTree {
    TreeNode root;

    public void bfs() {
        if (root == null) return;

        Queue queue = new Queue();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.dequeue();
            System.out.print(node.value + " ");

            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
        }
        System.out.println(); // To move to the next line after traversal
    }
}
