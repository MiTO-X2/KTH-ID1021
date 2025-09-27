public class BenchmarkTest {
    public static void main(String[] args) {
        int[] sizes = {1, 100, 200, 400, 800, 1600, 3200, 6400};

        // Benchmark for Enqueue and Dequeue without Resizing
        System.out.println("Benchmark - No Resizing:");
        for (int size : sizes) {
            benchmarkNoResizing(size);
        }

        // Benchmark for Enqueue with Resizing
        System.out.println("\nBenchmark - Resizing:");
        for (int size : sizes) {
            benchmarkResizing(size);
        }

        // Benchmark for Wrap-around Behavior
        System.out.println("\nBenchmark - Wrap-around:");
        for (int size : sizes) {
            benchmarkWrapAround(size);
        }

        // Benchmark for Dequeue from Empty Queue
        System.out.println("\nBenchmark - Dequeue from Empty:");
        for (int size : sizes) {
            benchmarkDequeueEmpty(size);
        }
    }

    // Benchmark for Enqueue and Dequeue without Resizing
    public static void benchmarkNoResizing(int size) {
        DynamicArrayQueue dynamicQueue = new DynamicArrayQueue(size * 2);  // Initial capacity large enough to avoid resizing
        long startTime, endTime;
        int numOps = size;

        startTime = System.nanoTime();
        // Enqueue operations
        for (int i = 1; i <= numOps; i++) {
            dynamicQueue.enqueue(i);
        }
        // Dequeue operations
        for (int i = 1; i <= numOps; i++) {
            dynamicQueue.dequeue();
        }
        endTime = System.nanoTime();

        System.out.println("Size " + size + ": " + (endTime - startTime) + " ns");
    }

    // Benchmark for Enqueue with Resizing
    public static void benchmarkResizing(int size) {
        DynamicArrayQueue dynamicQueue = new DynamicArrayQueue(10);  // Small initial capacity to force resizing
        long startTime, endTime;
        int numOps = size;

        startTime = System.nanoTime();
        // Enqueue operations
        for (int i = 1; i <= numOps; i++) {
            dynamicQueue.enqueue(i);
        }
        // Dequeue operations
        for (int i = 1; i <= numOps; i++) {
            dynamicQueue.dequeue();
        }
        endTime = System.nanoTime();

        System.out.println("Size " + size + ": " + (endTime - startTime) + " ns");
    }

    // Benchmark for Wrap-around Behavior
    public static void benchmarkWrapAround(int size) {
        DynamicArrayQueue dynamicQueue = new DynamicArrayQueue(size / 2);  // Small enough queue to trigger wrap-around
        long startTime, endTime;

        startTime = System.nanoTime();
        // Enqueue and Dequeue operations to force wrap-around
        for (int i = 1; i <= size; i++) {
            dynamicQueue.enqueue(i);
            if (i % (size / 5) == 0) {  // Periodic dequeue to simulate wrap-around
                for (int j = 0; j < size / 10; j++) {
                    dynamicQueue.dequeue();
                }
            }
        }
        endTime = System.nanoTime();

        System.out.println("Size " + size + ": " + (endTime - startTime) + " ns");
    }

    // Benchmark for Dequeue from Empty Queue
    public static void benchmarkDequeueEmpty(int size) {
        DynamicArrayQueue dynamicQueue = new DynamicArrayQueue(size);

        long startTime = System.nanoTime();
        try {
            // Dequeue from empty queue
            dynamicQueue.dequeue();
        } catch (RuntimeException e) {
            // Expected exception for empty queue
        }
        long endTime = System.nanoTime();

        System.out.println("Size " + size + ": " + (endTime - startTime) + " ns");
    }
}
