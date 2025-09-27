import java.util.Random;

public class report1_fourth_code {
    public static void main(String[] arg) {
        for (int i = 0; i < 10; i++) {
        long t = bench(1000, 1000);
        System.out.println(" access: " + t + " ns");
        }
    }

    public static int run(int[] array, int[] indx) {
        int sum = 0;
        for (int i = 0; i < indx.length ; i++) {
        sum = sum + array[indx[i]];
        }
        return sum;
    }

    public static long bench(int n, int loop) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = i;

        Random rnd = new Random();

        int[] indx = new int[loop];
        for (int i = 0; i < loop; i++) indx[i] = rnd.nextInt(n);

        int sum = 0;
        long t0 = System.nanoTime();
        run(array, indx);
        long t1 = System.nanoTime();
        return (t1 - t0);
        }    
}
