public class QueueTail {
    Node head;  // Points to the first element in the queue
    Node tail;  // Points to the last element in the queue

    private class Node {
        Integer item;
        Node next;

        private Node(Integer item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public QueueTail() {
        this.head = null;
        this.tail = null;  // Initialize both head and tail to null (empty queue)
    }

    // Enqueue: Add an item to the end of the queue
    public void enqueue(Integer item) {
        Node newNode = new Node(item, null);  // Create a new node with no next element
        if (tail == null) {  // If the queue is empty (both head and tail are null)
            head = tail = newNode;  // Both head and tail point to the new node
        } else {
            tail.next = newNode;  // Link the current tail to the new node
            tail = newNode;  // Update the tail to point to the new node
        }
    }

    // Dequeue: Remove an item from the front of the queue
    public Integer dequeue() {
        if (head == null) {
            return null;  // Return null if the queue is empty
        }
        Integer dequeuedItem = head.item;
        head = head.next;  // Move the head pointer to the next node
        if (head == null) {  // If the queue becomes empty, set the tail to null as well
            tail = null;
        }
        return dequeuedItem;
    }
}
