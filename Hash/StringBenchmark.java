public class StringBenchmark {

    public static void main(String[] args) {
        Zip zipTable = new Zip("postnummer.csv");  // Load the zip table
        
        String[] zipCodes = {"111 15", "984 99"};

        // Benchmark Linear Search
        for (String zipCode : zipCodes) {
            long start = System.nanoTime();
            Zip.Area result = zipTable.linearSearch(zipCode);
            long end = System.nanoTime();
            System.out.println("Linear Search for " + zipCode + " took " + (end - start) + " ns. Result: " + (result != null ? result.name : "Not found"));
        }

        // Benchmark Binary Search
        for (String zipCode : zipCodes) {
            long start = System.nanoTime();
            Zip.Area result = zipTable.binarySearch(zipCode);
            long end = System.nanoTime();
            System.out.println("Binary Search for " + zipCode + " took " + (end - start) + " ns. Result: " + (result != null ? result.name : "Not found"));
        }
    }
}