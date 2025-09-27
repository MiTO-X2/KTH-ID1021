public class Benchmark2 {

    public static void main(String[] args) {
        // Define the specific queue sizes to benchmark
        int[] sizes = {1, 1, 100, 200, 400, 800, 1600, 3200, 6400};

        // Run benchmarks for each queue size
        for (int size : sizes) {
            benchmarkQueueOperations(size);
        }
    }

    private static void benchmarkQueueOperations(int size) {
        QueueTail queue = new QueueTail();  // Use the QueueTail class

        // Measure time for enqueue operations
        long enqueueStartTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            queue.enqueue(i);
        }
        long enqueueEndTime = System.nanoTime();
        long enqueueDuration = enqueueEndTime - enqueueStartTime;

        // Measure time for dequeue operations
        long dequeueStartTime = System.nanoTime();
        for (int i = 0; i < size; i++) {
            queue.dequeue();
        }
        long dequeueEndTime = System.nanoTime();
        long dequeueDuration = dequeueEndTime - dequeueStartTime;

        // Output the results
        System.out.println("Queue size: " + size);
        System.out.println("Enqueue time: " + (enqueueDuration / 1_000_000.0) + " ms");
        System.out.println("Dequeue time: " + (dequeueDuration / 1_000_000.0) + " ms");
        System.out.println("------------------------------------------");
    }
}
