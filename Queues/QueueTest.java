public class QueueTest {

    public static void main(String[] args) {
        // Initialize the queue
        Queue queue = new Queue();

        // Test case 1: Dequeue from an empty queue
        System.out.println("Test 1: Dequeue from an empty queue");
        Integer dequeuedItem = queue.dequeue();
        if (dequeuedItem == null) {
            System.out.println("Pass: Dequeue returned null for empty queue");
        } else {
            System.out.println("Fail: Dequeue did not return null for empty queue");
        }

        // Test case 2: Enqueue elements and check if the queue behaves correctly
        System.out.println("Test 2: Enqueue elements");
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Enqueued 10, 20, 30");

        // Test case 3: Dequeue elements and verify FIFO behavior
        System.out.println("Test 3: Dequeue elements");
        dequeuedItem = queue.dequeue();
        if (dequeuedItem == 10) {
            System.out.println("Pass: Dequeued 10");
        } else {
            System.out.println("Fail: Expected 10, got " + dequeuedItem);
        }

        dequeuedItem = queue.dequeue();
        if (dequeuedItem == 20) {
            System.out.println("Pass: Dequeued 20");
        } else {
            System.out.println("Fail: Expected 20, got " + dequeuedItem);
        }

        dequeuedItem = queue.dequeue();
        if (dequeuedItem == 30) {
            System.out.println("Pass: Dequeued 30");
        } else {
            System.out.println("Fail: Expected 30, got " + dequeuedItem);
        }

        // Test case 4: Check if the queue is empty after dequeuing all elements
        System.out.println("Test 4: Dequeue from an empty queue again");
        dequeuedItem = queue.dequeue();
        if (dequeuedItem == null) {
            System.out.println("Pass: Dequeue returned null for empty queue");
        } else {
            System.out.println("Fail: Dequeue did not return null for empty queue");
        }
    }
}
