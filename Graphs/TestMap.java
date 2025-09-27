public class TestMap {
    public static void main(String[] args) {
        // Create the Map object and load the data from trains.csv
        Map trainMap = new Map("trains.csv");
        
        // Print the entire map with all cities and their connections
        System.out.println("Printing the city connections in the train map:");
        trainMap.printMap();
    }
}

