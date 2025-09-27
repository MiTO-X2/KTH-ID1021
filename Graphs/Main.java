public class Main {
    public static void main(String[] args) {
        // Initialize the Map with the provided CSV file
        Map map = new Map("trains.csv");

        // List of test cases for trips
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

        // Loop through each trip and find the shortest path using the naive approach
        for (String[] trip : trips) {
            String from = trip[0];
            String to = trip[1];
            Integer max = Integer.valueOf(trip[2]);
            long t0 = System.nanoTime();
            
            // Find the shortest path using Naive's DFS approach, use the map object to lookup cities
            Integer dist = Naive.shortest(map.lookup(from), map.lookup(to), max);
            long time = (System.nanoTime() - t0) / 1_000_000;  // Calculate time in milliseconds

            // Print the result
            if (dist != null) {
                System.out.println("Shortest path from " + from + " to " + to + " is " + dist + " min (" + time + " ms)");
            } else {
                System.out.println("No path found from " + from + " to " + to + " within " + max + " minutes. Time taken: " + time + " ms");
            }
        }
    }
}
