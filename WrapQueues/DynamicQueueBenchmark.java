public class DynamicQueueBenchmark {

    public static void main(String[] args) {
        int[] queueSizes = {1, 100, 200, 400, 800, 1600, 3200};  // Different sizes to test
        for (int size : queueSizes) {
            benchmarkQueueOperations(size);
        }
    }

    // Function to benchmark enqueue and dequeue operations for a given queue size
    private static void benchmarkQueueOperations(int queueSize) {
        DynamicQueue queue = new DynamicQueue(queueSize);

        // Measure time for enqueue operations
        long enqueueStartTime = System.nanoTime();
        for (int i = 0; i < queueSize; i++) {
            queue.enqueue(i);
        }
        long enqueueEndTime = System.nanoTime();
        long enqueueDuration = enqueueEndTime - enqueueStartTime;

        // Measure time for dequeue operations
        long dequeueStartTime = System.nanoTime();
        for (int i = 0; i < queueSize; i++) {
            queue.dequeue();
        }
        long dequeueEndTime = System.nanoTime();
        long dequeueDuration = dequeueEndTime - dequeueStartTime;

        // Output the results
        System.out.println("Queue size: " + queueSize);
        System.out.println("Enqueue time: " + enqueueDuration + " ns");
        System.out.println("Dequeue time: " + dequeueDuration + " ns");
        System.out.println("------------------------------------------");
    }
}
