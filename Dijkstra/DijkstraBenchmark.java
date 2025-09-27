public class DijkstraBenchmark {
    public static void main(String[] args) {
        // Load the map
        Map map = new Map("europe.csv");

        // Set the starting city
        City startCity = map.lookup("Malmö");

        // Array of target cities for the benchmark
        String[] targetCities = {
                "Stockholm", "Göteborg", "Kiruna", "Oslo", "Köpenhamn",
                "Paris", "Berlin", "Rom", "Amsterdam", "Wien", "Madrid", "London"
        };

        System.out.println("Benchmarking shortest paths from Malmö:");

        for (String targetName : targetCities) {
            City targetCity = map.lookup(targetName);
            Dijkstra dijkstra = new Dijkstra(150); // Adjust 150 to the number of cities
            long startTime = System.nanoTime();
            Integer distance = dijkstra.findShortestPath(startCity, targetCity);
            long endTime = System.nanoTime();
            long timeTakenMs = (endTime - startTime);

            Done done = dijkstra.getDone();
            int processedCities = done.getProcessedCityCount();

            if (distance != null) {
                System.out.printf("Shortest path to %s: %d mins, processed cities: %d, time taken: %d ms%n",
                        targetName, distance, processedCities, timeTakenMs);
            } else {
                System.out.printf("No path found to %s%n", targetName);
            }
        }
    }
}
