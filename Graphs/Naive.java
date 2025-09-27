import java.util.List;

public class Naive {
    
    public static void main(String[] args) {
        // Ensure valid input arguments
        if (args.length != 3) {
            System.out.println("Usage: java Naive <from> <to> <max-time>");
            return;
        }

        // Initialize the map
        Map map = new Map("trains.csv");
        String from = args[0];
        String to = args[1];
        Integer max = Integer.valueOf(args[2]);

        // Start the timing
        long t0 = System.nanoTime();

        // Perform the DFS to find the shortest path
        Integer dist = shortest(map.lookup(from), map.lookup(to), max);

        // End the timing
        long time = (System.nanoTime() - t0) / 1_000_000; // Convert to milliseconds

        // Output the result
        if (dist == null) {
            System.out.println("No path found within the allowed time.");
        } else {
            System.out.println("Shortest path: " + dist + " min (" + time + " ms)");
        }
    }

    // Depth-First Search (DFS) to find the shortest path
    public static Integer shortest(City from, City to, Integer max) {
        // Base case: If no time is left or we can't find a path
        if (max < 0) {
            return null;
        }
        
        // If we have reached the destination city
        if (from == to) {
            return 0;
        }

        Integer shrt = null; // Variable to store the shortest path

        // Iterate over all neighbors of the current city
        for (Connection conn : from.getConnections()) {
            if (conn != null) {
                City neighborCity = conn.getDestination();
                int travelTime = conn.getDistance();

                // Perform DFS on the neighboring city, reducing max time
                Integer path = shortest(neighborCity, to, max - travelTime);

                // If a valid path is found, update the shortest path
                if (path != null) {
                    path += travelTime; // Add the travel time to the path length
                    if (shrt == null || path < shrt) {
                        shrt = path;
                    }
                }
            }
        }

        // Return the shortest path found
        return shrt;
    }
}
