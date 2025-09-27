public class Paths {
    City[] path;
    int sp; // Stack pointer to track the depth in the path

    public Paths() {
        path = new City[54]; // Max number of cities in the graph
        sp = 0;              // Initialize stack pointer
    }

    // Shortest path function with loop detection
    public Integer shortest(City from, City to, Integer max) {
        if (max < 0) return null;    // If time runs out, return null
        if (from == to) return 0;    // Base case: if we're at the destination

        // Check if the city is already in the current path (to avoid loops)
        for (int i = 0; i < sp; i++) {
            if (path[i] == from) {
                return null;  // Loop detected, abort this path
            }
        }

        // Add the current city to the path
        path[sp++] = from;

        Integer shortest = null;

        // Explore all neighboring cities
        for (Connection conn : from.getConnections()) {
            City nextCity = conn.getDestination();
            int travelTime = conn.getDistance();

            // Recursively find the shortest path to the destination
            Integer dist = shortest(nextCity, to, max - travelTime);
            if (dist != null) {
                dist += travelTime;
                if (shortest == null || dist < shortest) {
                    shortest = dist;  // Keep track of the shortest path found
                }
            }
        }

        // Backtrack by removing the current city from the path
        path[--sp] = null;

        return shortest;
    }

    public static void main(String[] args) {
        // Load the map
        Map map = new Map("trains.csv");

        // Test the modified algorithm with some cities
        String from = "Malmö";
        String to = "Göteborg";
        Integer max = 300;

        Paths paths = new Paths();
        long t0 = System.nanoTime();
        Integer dist = paths.shortest(map.lookup(from), map.lookup(to), max);
        long time = (System.nanoTime() - t0) / 1_000_000;

        if (dist != null) {
            System.out.println("Shortest path from " + from + " to " + to + " is " + dist + " min (" + time + " ms)");
        } else {
            System.out.println("No path found from " + from + " to " + to + " within " + max + " minutes. Time taken: " + time + " ms");
        }
    }
}

