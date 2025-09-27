import java.util.Random;

public class SelectionSort{
    public static void selectionSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            int candidate = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[candidate]) {
                    candidate = j;
                }
            }
            int temp = array[candidate];
            array[candidate] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String[] args){
        int[] array = {64, 25, 12, 22, 11};
        selectionSort(array);
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
            selectionSort(array);
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);

            // Output the results
            // System.out.println("Array size: " + size + " Time taken: " + duration + " ns");
            System.out.printf("Array size: %d Time taken: %.3f ns%n", size, (double) duration);
        }
    }
}