import java.util.Random;

public class sorted{

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

    public static boolean sorted_search(int[] array, int key) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == key) {
                return true;
            }
            if (array[index] > key) {
                return false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] n = {1, 100, 200, 400, 800, 1600, 3200, 6400};  // Array sizes
        long t, t1, t2;  // Time variables
        int k = 10000;  // Number of iterations
        Random r = new Random();

        for (int i = 0; i < n.length; i++) {
            t = 0;  // Reset time for each array size

            for (int j = 0; j < k; j++) {
                int[] a1 = sorted(n[i]);  // Generate a new sorted array for each iteration
                int key = a1[r.nextInt(n[i])];  // Generate a key that exists in the array

                t1 = System.nanoTime();
                sorted_search(a1, key);
                t2 = System.nanoTime();
                t += t2 - t1;
            }
            //System.out.println("Time taken for n = " + n[i] + " ---> " + (t / k) + " ns");
            System.out.printf("Time taken for n = %d ---> %.2f ns\n", n[i], (double) t / k);

        }
    }
}