import java.util.Random;

public class MergeSort {

    // Method to initiate the sorting process
    public static void sort(int[] org) {
        if (org.length == 0)
            return;
        int[] aux = new int[org.length];  // Auxiliary array
        sort(org, aux, 0, org.length - 1);
    }

    // Recursive sort method
    private static void sort(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = (lo + hi) / 2;  // Find the middle index

            // Sort the items from lo to mid
            sort(org, aux, lo, mid);

            // Sort the items from mid+1 to hi
            sort(org, aux, mid + 1, hi);

            // Merge the two sorted sections using the auxiliary array
            merge(org, aux, lo, mid, hi);
        }
    }

    // Merge two sorted subarrays into a single sorted array
    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        // Copy the items from the original array into the auxiliary array
        for (int k = lo; k <= hi; k++) {
            aux[k] = org[k];
        }

        int i = lo;     // Pointer for the left half
        int j = mid + 1;  // Pointer for the right half

        // Merge the two halves
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                org[k] = aux[j++];  // Left half exhausted, take from the right
            } else if (j > hi) {
                org[k] = aux[i++];  // Right half exhausted, take from the left
            } else if (aux[i] <= aux[j]) {
                org[k] = aux[i++];  // Take from the left half
            } else {
                org[k] = aux[j++];  // Take from the right half
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {64, 25, 12, 22, 11};
        sort(array);
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
            sort(array);  // Call merge sort
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);

            // Output the results
            // System.out.println("Array size: " + size + " Time taken: " + duration + " ns");
            System.out.printf("Array size: %d Time taken: %.3f ns%n", size, (double) duration);
        }
    }
}
