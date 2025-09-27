import java.util.Random;

public class report1_eighth_code {
    public static void main(String[] arg) {
        int[] sizes = {100, 200, 400, 800, 1600, 3200};
        //int[] sizes = {1, 10, 20, 100, 1000, 10000};

        // JIT warmup
        duplicates(1000);

        int k = 10;

        for(int n : sizes) {
            long min = Long.MAX_VALUE;
            for (int i = 0; i < k; i++) {
                long t = duplicates(n);
                if (t < min) min = t;
                }
                System.out.println(n + " " + ((double) min)/n + " ns");
            }
    }
    

    private static long duplicates(int n) {

        Random rnd = new Random();

        int[] array_a = new int[n];
        for (int i = 0; i < n; i++) {
            array_a[i] = rnd.nextInt(n*2);
        }

        int[] array_b = new int[n];
        for (int i = 0; i < n; i++) {
            array_b[i] = rnd.nextInt(n*2);
        }

        int sum = 0;

        long t0 = System.nanoTime();

        // for (int k = 0; k < n; k++) {}
            for (int i = 0; i < n; i++) {
                int key = array_a[i];
                for (int j = 0; j < n; j++) {
                    if (key == array_b[j]) {
                        sum++;
                        break;
                    }
                }
            }
        
        long t1 = System.nanoTime();
        return t1 - t0;
    }        
}
 