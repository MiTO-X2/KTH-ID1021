public class BinaryTree {
    public class Node {
        private Integer value;
        private Node left, right;

        private Node(Integer value) {
            this.value = value;
            this.left = this.right = null;
        }

        // In-order traversal (left, node, right)
        public void printInOrder() {
            if (left != null) {
                left.printInOrder();
            }
            System.out.println(value);
            if (right != null) {
                right.printInOrder();
            }
        }

        // Pre-order traversal (node, left, right)
        public void printPreOrder() {
            System.out.println(value);
            if (left != null) {
                left.printPreOrder();
            }
            if (right != null) {
                right.printPreOrder();
            }
        }

        // Post-order traversal (left, right, node)
        public void printPostOrder() {
            if (left != null) {
                left.printPostOrder();
            }
            if (right != null) {
                right.printPostOrder();
            }
            System.out.println(value);
        }
    }

    private Node root;

    public BinaryTree() {
        root = null;
    }

    // Recursive add() method
    public void add(Integer value) {
        root = addRecursive(root, value); // Start from the root node
    }

    private Node addRecursive(Node current, Integer value) {
        if (current == null) {
            return new Node(value); // Create and return a new node if current is null
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value); // Go to the left subtree
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value); // Go to the right subtree
        } 
        // If the value already exists, we do nothing (no duplicates allowed)
        return current; // Return the unchanged node pointer
    }

    // Recursive lookup() method
    public boolean lookup(Integer key) {
        return lookupRecursive(root, key); // Start from the root node
    }

    private boolean lookupRecursive(Node current, Integer key) {
        if (current == null) {
            return false; // Key not found
        }

        if (key.equals(current.value)) {
            return true; // Key found
        } 

        return key < current.value
            ? lookupRecursive(current.left, key)  // Look in the left subtree
            : lookupRecursive(current.right, key); // Look in the right subtree
    }

    // Iterative add() method
    public void addIterative(Integer value) {
        if (root == null) {
            root = new Node(value); // Special case: tree is empty
            return;
        }

        Node current = root;
        while (true) {
            if (value < current.value) {
                if (current.left == null) {
                    current.left = new Node(value); // Insert the new node here
                    return;
                }
                current = current.left; // Move to the left subtree
            } else if (value > current.value) {
                if (current.right == null) {
                    current.right = new Node(value); // Insert the new node here
                    return;
                }
                current = current.right; // Move to the right subtree
            } else {
                // Value already exists, do nothing
                return;
            }
        }
    }

    // Wrapper methods for tree traversal
    public void printInOrder() {
        if (root != null) {
            root.printInOrder();
        }
    }

    public void printPreOrder() {
        if (root != null) {
            root.printPreOrder();
        }
    }

    public void printPostOrder() {
        if (root != null) {
            root.printPostOrder();
        }
    }

    public void print() {
        NodeStack stack = new NodeStack();
        Node cur = this.root;

        while (cur != null || !stack.isEmpty()) {
            // Traverse to the leftmost node
            while (cur != null) {
                stack.push(cur); // Push the current node to the stack
                cur = cur.left; // Move to the left child
            }

            // Pop the node from the stack and print its value
            cur = stack.pop();
            System.out.println(cur.value); // Print the node's value

            // Now, move to the right child
            cur = cur.right;
        }
    }
}