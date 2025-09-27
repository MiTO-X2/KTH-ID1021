public class MainPaths {
    public static void main(String[] args) {
        // Initialize the Map with the provided CSV file
        Map map = new Map("trains.csv");

        // List of test cases (from city, to city, max time allowed)
        String[][] trips = {
            {"Malmö", "Göteborg", "300"},
            {"Göteborg", "Stockholm", "300"},
            {"Malmö", "Stockholm", "300"},
            {"Stockholm", "Sundsvall", "300"},
            {"Stockholm", "Umeå", "300"},
            {"Göteborg", "Sundsvall", "300"},
            {"Sundsvall", "Umeå", "300"},
            {"Umeå", "Göteborg", "300"},
            {"Göteborg", "Umeå", "300"}
        };

        Paths paths = new Paths(); // Create an instance of the Paths class

        // Iterate through each test case and find the shortest path
        for (String[] trip : trips) {
            String from = trip[0];
            String to = trip[1];
            Integer max = Integer.valueOf(trip[2]);

            long t0 = System.nanoTime();
            Integer dist = paths.shortest(map.lookup(from), map.lookup(to), max); // Use the shortest method with loop detection
            long time = (System.nanoTime() - t0) / 1_000_000; // Measure time in ms

            if (dist != null) {
                System.out.println("Shortest path from " + from + " to " + to + " is " + dist + " min (" + time + " ms)");
            } else {
                System.out.println("No path found from " + from + " to " + to + " within " + max + " minutes. Time taken: " + time + " ms");
            }
        }
    }
}

