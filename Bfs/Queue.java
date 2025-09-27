class QueueNode {
    TreeNode value;
    QueueNode next;

    QueueNode(TreeNode value) {
        this.value = value;
        this.next = null;
    }
}

public class Queue {
    private QueueNode front, rear;

    public Queue() {
        this.front = this.rear = null;
    }

    // Enqueue method
    public void enqueue(TreeNode value) {
        QueueNode newNode = new QueueNode(value);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue method
    public TreeNode dequeue() {
        if (front == null) {
            return null; // Queue is empty
        }
        QueueNode temp = front;
        front = front.next;
        if (front == null) {
            rear = null; // Queue is now empty
        }
        return temp.value;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }
}
