import java.util.Random;

public class recursive{

    private static boolean recursive(int[] arr, int key, int min, int max) {
        int mid = min + ((max - min)/2);
        if (arr[mid] == key) {
            return true;
        }
        if ((arr[mid] > key) && (min < mid)) {
            return recursive(arr, key, min, mid - 1);
        }
        if ((arr[mid] < key) && (mid < max)) {
        return recursive(arr, key, mid + 1, max);
        }
        // as before
        return false;
    }

    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = sorted(10000); // Create a sorted array with 10,000 elements
        
        // Test cases
        int keyToFind = array[5000]; // Key within the array
        boolean found = recursive(array, keyToFind, 0, array.length - 1);
        System.out.println("Key found: " + found); // Expected: true

        keyToFind = -1; // Key not in the array
        found = recursive(array, keyToFind, 0, array.length - 1);
        System.out.println("Key found: " + found); // Expected: false

        int[] emptyArray = {};
        found = recursive(emptyArray, 5, 0, emptyArray.length - 1);
        System.out.println("Key found in empty array: " + found); // Expected: false

        int[] singleElementArray = {10};
        found = recursive(singleElementArray, 10, 0, singleElementArray.length - 1);
        System.out.println("Key found in single element array: " + found); // Expected: true

        found = recursive(singleElementArray, 5, 0, singleElementArray.length - 1);
        System.out.println("Key found in single element array: " + found); // Expected: false
    }
}