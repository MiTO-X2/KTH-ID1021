public class Benchmark {
    /*public static void main(String[] args) {
        int fixedSize = 1000; // Fixed size for b
        LinkedList listB = new LinkedList(fixedSize);

        for (int sizeA = 0; sizeA <= 30000; sizeA += 5000) {
            LinkedList listA = new LinkedList(sizeA);

            // Measure the time before appending
            long startTime = System.nanoTime();

            listA.append(listB);  // Append operation

            // Measure the time after appending
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println("Appending list of size " + sizeA + " took " + duration + " nanoseconds");
        }

        int fixedSizeA = 1000; // Fixed size for list a
        LinkedList listA = new LinkedList(fixedSizeA);

        for (int sizeB = 0; sizeB <= 15000; sizeB += 2500) {
            listB = new LinkedList(sizeB);

            // Measure the time before appending
            long startTime = System.nanoTime();

            listA.append(listB);  // Append operation

            // Measure the time after appending
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println("Appending list of size " + sizeB + " to list A (fixed size 1000) took " + duration + " nanoseconds");
        }
    }*/

    /*public static void main(String[] args) {
        // First Benchmark: Varying size of List A (listA)
        int[] valuesA = {100, 200, 400, 800, 1600, 3200}; // Desired values for List A
        for (int sizeA : valuesA) {
            LinkedList listA = new LinkedList(sizeA);

            // Measure the time before appending
            long startTime = System.nanoTime();

            // Fixed size for list B
            LinkedList listB = new LinkedList(1000); // Initialize listB with fixed size

            listA.append(listB);  // Append operation

            // Measure the time after appending
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println("Appending list of size " + sizeA + " took " + duration + " nanoseconds");
        }

        // Second Benchmark: Varying size of List B (listB)
        int fixedSizeA = 1000; // Fixed size for list A
        LinkedList listA = new LinkedList(fixedSizeA);

        // Values for List B
        int[] valuesB = {100, 200, 400, 800, 1600, 3200}; // Desired values for List B

        for (int sizeB = 1000; sizeB <= 10000; sizeB += 1000) {
            LinkedList listB = new LinkedList(sizeB); // Initialize listB with a size of sizeB

            // Manually adding predefined values to listB
            for (int value : valuesB) {
                listB.add(value); // Add predefined values to listB
            }

            // Measure the time before appending
            long startTime = System.nanoTime();

            listA.append(listB);  // Append operation

            // Measure the time after appending
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println("Appending list of size " + sizeB + " to list A (fixed size 1000) took " + duration + " nanoseconds");
        }
    }*/

   public static void main(String[] args) {
        // Fixed size for list b
        int fixedSizeB = 1000; // You can adjust this size based on your needs
        LinkedList listB = new LinkedList(fixedSizeB);
        
        // Benchmarking list a with varying sizes
        System.out.println("Benchmarking append with varying sizes of list a:");
        for (int sizeA = 100; sizeA <= 6400; sizeA *= 2) { // Increase sizeA in powers of 10
            LinkedList listA = new LinkedList(sizeA);
            long startTime = System.nanoTime();
            listA.append(listB); // Append listB to listA
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Size of list a: " + sizeA + ", Time taken (ns): " + duration);
        }

        // Now, benchmark list b with varying sizes
        System.out.println("\nBenchmarking append with varying sizes of list b:");
        for (int sizeB = 100; sizeB <= 6400; sizeB *= 2) { // Increase sizeB in powers of 10
            LinkedList listA = new LinkedList(1000); // Keeping list a fixed at size 1000
            LinkedList listBVaried = new LinkedList(sizeB);
            long startTime = System.nanoTime();
            listA.append(listBVaried); // Append listBVaried to listA
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            System.out.println("Size of list b: " + sizeB + ", Time taken (ns): " + duration);
        }
    }
}





