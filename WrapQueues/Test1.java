public class Test1 {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        
        System.out.println("Dequeued: " + queue.dequeue()); // Should output 1
        queue.enqueue(6); // Now, the array wraps around to insert this at index 0
        
        System.out.println("Dequeued: " + queue.dequeue()); // Should output 2
        System.out.println("Dequeued: " + queue.dequeue()); // Should output 3
        System.out.println("Dequeued: " + queue.dequeue()); // Should output 4
        System.out.println("Dequeued: " + queue.dequeue()); // Should output 5
        System.out.println("Dequeued: " + queue.dequeue()); // Should output 6
    }
}
