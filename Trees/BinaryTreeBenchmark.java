public class BinaryTreeBenchmark {

    public static void main(String[] args) {
        int[] sizes = {1, 1, 100, 200, 400, 800, 1600, 3200}; // Different tree sizes to test

        System.out.println("Benchmarking recursive add() and lookup()...");
        benchmarkRecursive(sizes);

        System.out.println("\nBenchmarking iterative add() and lookup()...");
        benchmarkIterative(sizes);
    }

    // Method to benchmark the recursive add() and lookup() methods
    private static void benchmarkRecursive(int[] sizes) {
        for (int size : sizes) {
            BinaryTree binaryTree = new BinaryTree();
            long addStartTime = System.nanoTime();

            // Insert random elements using recursive add()
            for (int i = 0; i < size; i++) {
                binaryTree.add((int) (Math.random() * 1000));
            }

            long addEndTime = System.nanoTime();
            System.out.println("Recursive add() for " + size + " elements took: " + (addEndTime - addStartTime) + " ns");

            // Benchmark lookup() after the elements are added
            long lookupStartTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                binaryTree.lookup((int) (Math.random() * 1000));
            }
            long lookupEndTime = System.nanoTime();
            System.out.println("Recursive lookup() for " + size + " elements took: " + (lookupEndTime - lookupStartTime) + " ns");
        }
    }

    // Method to benchmark the iterative add() and lookup() methods
    private static void benchmarkIterative(int[] sizes) {
        for (int size : sizes) {
            BinaryTree binaryTree = new BinaryTree();
            long addStartTime = System.nanoTime();

            // Insert random elements using iterative add()
            for (int i = 0; i < size; i++) {
                binaryTree.addIterative((int) (Math.random() * 1000));
            }

            long addEndTime = System.nanoTime();
            System.out.println("Iterative add() for " + size + " elements took: " + (addEndTime - addStartTime) + " ns");

            // Benchmark lookup() after the elements are added
            long lookupStartTime = System.nanoTime();
            for (int i = 0; i < size; i++) {
                binaryTree.lookup((int) (Math.random() * 1000));
            }
            long lookupEndTime = System.nanoTime();
            System.out.println("Iterative lookup() for " + size + " elements took: " + (lookupEndTime - lookupStartTime) + " ns");
        }
    }
}
