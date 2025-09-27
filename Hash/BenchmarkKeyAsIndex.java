public class BenchmarkKeyAsIndex {
    public static void main(String[] args) {
        String fileName = "postnummer.csv";

        // Create instance of ZipWithKeyAsIndex class
        ZipWithKeyAsIndex zipIndex = new ZipWithKeyAsIndex(fileName);

        // Benchmark lookup using zip code as index
        long startTime, endTime;

        // Lookup for "111 15"
        startTime = System.nanoTime();
        ZipWithKeyAsIndex.Area result = zipIndex.lookup("111 15");
        endTime = System.nanoTime();
        if (result != null) {
            System.out.println("Lookup for 111 15 took " + (endTime - startTime) + " ns. Result: " + result.areaName);
        } else {
            System.out.println("111 15 not found.");
        }

        // Lookup for "984 99"
        startTime = System.nanoTime();
        result = zipIndex.lookup("984 99");
        endTime = System.nanoTime();
        if (result != null) {
            System.out.println("Lookup for 984 99 took " + (endTime - startTime) + " ns. Result: " + result.areaName);
        } else {
            System.out.println("984 99 not found.");
        }
    }
}

