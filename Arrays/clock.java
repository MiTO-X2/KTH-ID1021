public class clock {
    public static void main(String[] arg) {
        for (int i = 0; i < 10; i++) {
            long n0 = System.nanoTime();
            long n1 = System.nanoTime();
            System.out.println(" resolution " + (n1 - n0) + " nanoseconds");
        }
    }
}
