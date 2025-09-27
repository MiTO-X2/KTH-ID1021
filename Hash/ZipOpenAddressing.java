import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class ZipOpenAddressing {
    private Area[] data; // Array to store zip code entries
    private int size; // Number of entries in the array
    private int capacity; // Total capacity of the array

    // Inner class to store zip code information
    public class Area {
        Integer code; // Zip code
        String name; // Area name
        int population; // Population

        Area(Integer code, String name, int population) {
            this.code = code;
            this.name = name;
            this.population = population;
        }
    }

    public ZipOpenAddressing(int capacity) {
        this.capacity = capacity;
        this.data = new Area[capacity];
        this.size = 0;
    }

    // Method to load zip code data from a CSV file
    public void loadZipCodes(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s", ""));
                String name = row[1];
                int population = Integer.valueOf(row[2]);
                insert(code, name, population);
            }
        } catch (Exception e) {
            System.out.println("File " + file + " not found");
        }
    }

    // Method to insert an entry into the array using open addressing
    public void insert(Integer code, String name, int population) {
        int index = code % capacity;
        while (data[index] != null) {
            index = (index + 1) % capacity; // Move to the next index
        }
        data[index] = new Area(code, name, population);
        size++;
    }

    // Method to look up a zip code and count probes
    public String lookup(Integer code) {
        int index = code % capacity;
        int probes = 0; // To count the number of probes
        while (data[index] != null) {
            probes++;
            if (data[index].code.equals(code)) {
                System.out.println("Lookup for " + code + ": " + data[index].name + ", Population: " + data[index].population);
                System.out.println("Probes: " + probes);
                return data[index].name;
            }
            index = (index + 1) % capacity; // Move to the next index
        }
        System.out.println("Zip code " + code + " not found.");
        return null;
    }

    public static void main(String[] args) {
        ZipOpenAddressing zip = new ZipOpenAddressing(50000); // Change capacity as needed
        zip.loadZipCodes("postnummer.csv");
        zip.lookup(11115); // Example lookup
        zip.lookup(98499); // Example lookup
        zip.lookup(99999); // Example lookup for non-existent code
    }
}
