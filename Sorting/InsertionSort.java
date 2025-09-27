import java.util.Random;

public class InsertionSort {

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Insertion Sort implementation
    public static void insertionSort(int[] array) {
        // Start with the first element and move through the array
        for (int i = 1; i < array.length; i++) {
            // Compare each element with the ones before it
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                // Swap if the element is smaller than the previous one
                swap(array, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {64, 24, 22, 12, 11};
        insertionSort(array);
        System.out.println("Sorted array:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        int[] sizes = {1, 100, 200, 400, 800, 1600, 3200};  // Array sizes to test
        Random rand = new Random();

        for (int size : sizes) {
            array = new int[size];
            // Fill the array with random integers
            for (int i = 0; i < size; i++) {
                array[i] = rand.nextInt(10000);  // Random number between 0 and 9999
            }

            // Measure sorting time
            long startTime = System.nanoTime();
            insertionSort(array);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);

            // Output the results
            // System.out.println("Array size: " + size + " Time taken: " + duration + " ns");
            System.out.printf("Array size: %d Time taken: %.3f ns%n", size, (double) duration);
        }
    }
}
