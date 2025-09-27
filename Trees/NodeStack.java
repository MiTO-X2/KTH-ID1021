public class NodeStack {
    private static class Node {
        BinaryTree.Node value; // Node of the binary tree
        Node next;

        Node(BinaryTree.Node value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node top; // The top of the stack
    private int size;

    public NodeStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(BinaryTree.Node node) {
        Node newNode = new Node(node);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public BinaryTree.Node pop() {
        if (isEmpty()) {
            return null;
        }
        BinaryTree.Node poppedNode = top.value;
        top = top.next;
        size--;
        return poppedNode;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}
