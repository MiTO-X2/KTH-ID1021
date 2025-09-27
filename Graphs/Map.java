import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Map {
    private City[] cities; // Hash table to store the cities
    private final int mod = 70; // Mod value based on previous experimentation

    // Constructor that reads the CSV file and creates the map
    public Map(String file) {
        cities = new City[mod];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                String cityName1 = row[0].trim();
                String cityName2 = row[1].trim();
                int distance = Integer.parseInt(row[2].trim());

                // Lookup or create cities
                City city1 = lookup(cityName1);
                City city2 = lookup(cityName2);

                // Connect the two cities in both directions
                city1.connect(city2, distance);
                city2.connect(city1, distance);
            }
        } catch (Exception e) {
            System.out.println("File " + file + " not found or corrupt");
        }
    }

    // Lookup method that finds or creates a city
    public City lookup(String name) {
        int index = hash(name, mod);
        City current = cities[index];

        // Linear probing in case of collisions
        while (current != null) {
            if (current.getName().equals(name)) {
                return current; // City found
            }
            index = (index + 1) % mod; // Move to the next bucket (open addressing)
            current = cities[index];
        }

        // City not found, create a new city and place it in the table
        City newCity = new City(name);
        cities[index] = newCity;
        return newCity;
    }

    // Hash function
    private static int hash(String name, int mod) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 + name.charAt(i)) % mod;
        }
        return hash;
    }

    // Debugging method to print the map
    public void printMap() {
        for (int i = 0; i < cities.length; i++) {
            if (cities[i] != null) {
                System.out.println(cities[i].getName() + " connections:");
                cities[i].printConnections();
                System.out.println();
            }
        }
    }
}

