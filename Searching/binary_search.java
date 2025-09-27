import java.util.Random;

public class binary_search{

    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;
        
        while (true) {
            // jump to the middle
            int index = (first + last) / 2 ;
            
            if (array[index] == key) {
                return true;
            }
            if (array[index] < key && index < last) {
            // what is the first possible page?
            first = index + 1;
            continue;
            }
            if (array[index] > key && index > first) {
            // what is the last possible page?
            last = index - 1;
            continue;
            }
        // Why do we land here? What should we do?
        return false;
        }
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
        int[] n = {1, 100, 200, 400, 800, 1600, 3200, 6400};  // Add larger sizes
        long t, t1, t2;
        int k = 10000;  // Adjust iterations if necessary for larger arrays
        Random r = new Random();

        for (int i = 0; i < n.length; i++) {
            t = 0;

            for (int j = 0; j < k; j++) {
                int[] a1 = sorted(n[i]);  // Generate sorted array
                int key = a1[r.nextInt(n[i])];  // Randomly pick an element from the array

                t1 = System.nanoTime();
                binary_search(a1, key);
                t2 = System.nanoTime();
                t += t2 - t1;
            }

            // Print average time per search in ns with 2 decimal places
            System.out.printf("Binary search time for n = %d ---> %.2f ns\n", n[i], (double) t / k);
        }
    }
}
