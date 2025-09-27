
public class Queue {
    Node head;

    private class Node {
        
        Integer item;
        Node next;

        private Node(Integer item, Node list) {
            this.item = item;
            this.next = list;
        }
    }

    public Queue() {
        this.head = null; // initialize with an empty queue
    }

    public void enqueue(Integer item) {
        if (head == null) {
            head = new Node(item, null); // if the queue is empty, the new item becomes the head
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // traverse the list to find the last node
            }
            current.next = new Node(item, null); // add new item to the end
        }
    }

    public Integer dequeue() {
        if (head == null) {
            return null; // return null if the queue is empty
        }
        Integer dequeuedItem = head.item;
        head = head.next; // update head to point to the next node
        return dequeuedItem; // return the dequeued item
    }
}