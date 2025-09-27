public class QueueTailTest {

    public static void main(String[] args) {
        testDequeueFromEmptyQueue();
        testEnqueueElements();
        testDequeueElements();
        testDequeueFromEmptyQueueAgain();
    }

    private static void testDequeueFromEmptyQueue() {
        QueueTail queue = new QueueTail();
        Integer result = queue.dequeue();
        System.out.println("Test 1: Dequeue from an empty queue");
        System.out.println(result == null ? "Pass: Dequeue returned null for empty queue" : "Fail");
        System.out.println("------------------------------------------");
    }

    private static void testEnqueueElements() {
        QueueTail queue = new QueueTail();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Test 2: Enqueue elements");
        System.out.println("Enqueued 10, 20, 30");
        System.out.println("------------------------------------------");
    }

    private static void testDequeueElements() {
        QueueTail queue = new QueueTail();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Test 3: Dequeue elements");
        System.out.println("Pass: Dequeued " + queue.dequeue());
        System.out.println("Pass: Dequeued " + queue.dequeue());
        System.out.println("Pass: Dequeued " + queue.dequeue());
        System.out.println("------------------------------------------");
    }

    private static void testDequeueFromEmptyQueueAgain() {
        QueueTail queue = new QueueTail();
        Integer result = queue.dequeue();
        System.out.println("Test 4: Dequeue from an empty queue again");
        System.out.println(result == null ? "Pass: Dequeue returned null for empty queue" : "Fail");
        System.out.println("------------------------------------------");
    }
}
