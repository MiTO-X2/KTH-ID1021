import java.util.Random;

public class unsorted_search{

    public static boolean unsorted_search(int[] array, int key) {
        for (int index = 0; index < array.length ; index++) {
            if (array[index] == key) {
                return true;
            }
        }   
        return false;
    }

    public static void main(String[] args){
        int [ ] n = {1, 100, 200, 400, 800, 1600, 3200, 6400};
        double t = 0, t1,t2;
        int k = 1000000;
        Random r = new Random();

        for (int i = 0; i < n.length; i++) {

            int [] a0 = new int[n[i]];

            for (int j = 0; j <n[i] ; j++) {
                a0[j] = r.nextInt(n[i]);
            }

            int key = r.nextInt(n[i]);

            for (int j = 0; j < k ; j++) {
                t1 = System.nanoTime();
                unsorted_search(a0,key);
                t2 = System.nanoTime();
                t += t2 - t1;
            }
            //System.out.println("Time taken for n = " + n[i] + " ---> " + (t / k) + " ns");
            System.out.printf("Time taken for n = %d ---> %.2f ns\n", n[i], (double) t / k);
        }
    }
}