public class ZipBenchmark {

    public static void main(String[] args) {
        Zip zipTable = new Zip("postnummer.csv");  // Load the zip table
        
        int[] zipCodes = {11115, 98499};  // Test zip codes as integers

        // Benchmark Linear Search
        for (int zipCode : zipCodes) {
            long start = System.nanoTime();
            Zip.Area result = zipTable.linearSearch(zipCode);
            long end = System.nanoTime();
            System.out.println("Linear Search for " + zipCode + " took " + (end - start) + " ns. Result: " + (result != null ? result.name : "Not found"));
        }

        // Benchmark Binary Search
        for (int zipCode : zipCodes) {
            long start = System.nanoTime();
            Zip.Area result = zipTable.binarySearch(zipCode);
            long end = System.nanoTime();
            System.out.println("Binary Search for " + zipCode + " took " + (end - start) + " ns. Result: " + (result != null ? result.name : "Not found"));
        }
    }
}
