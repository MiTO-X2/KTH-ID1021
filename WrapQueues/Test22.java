public class Test22 {
    public static void main(String[] args) {
        DynamicArrayQueue dynamicQueue = new DynamicArrayQueue(5);

        // Enqueue more elements than initial capacity to test dynamic resizing
        for (int i = 1; i <= 15; i++) {
            dynamicQueue.enqueue(i);
            System.out.println("Enqueued: " + i);
        }

        // Dequeue a few elements to allow wrap-around
        for (int i = 1; i <= 5; i++) {
            System.out.println("Dequeued: " + dynamicQueue.dequeue());
        }

        // Enqueue additional elements to test wrap-around behavior
        for (int i = 16; i <= 20; i++) {
            dynamicQueue.enqueue(i);
            System.out.println("Enqueued: " + i);
        }

        // Dequeue remaining elements
        while (!dynamicQueue.isEmpty()) {
            System.out.println("Dequeued: " + dynamicQueue.dequeue());
        }

        // Test edge case: Dequeue from an empty queue
        try {
            System.out.println("Dequeued: " + dynamicQueue.dequeue());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); // Should print "Queue is empty, cannot dequeue."
        }
    }
}
