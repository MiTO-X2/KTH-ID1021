import java.io.BufferedReader;
import java.io.FileReader;

public class ZipWithKeyAsIndex {
    Area[] data;  // Array to store entries directly by zip code (key as index)
    int maxZipCode = 100000;

    // Inner class for Area
    public class Area {
        int zipCode;       // Zip code as integer
        String areaName;   // Area name
        int population;    // Population

        public Area(int zipCode, String areaName, int population) {
            this.zipCode = zipCode;
            this.areaName = areaName;
            this.population = population;
        }
    }

    // Constructor to read CSV file and populate data array
    public ZipWithKeyAsIndex(String file) {
        this.data = new Area[maxZipCode];  // Array of size 100,000

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                int zip = Integer.valueOf(row[0].replaceAll("\\s","")); // Convert zip code to integer
                if (zip < maxZipCode) {
                    data[zip] = new Area(zip, row[1], Integer.valueOf(row[2]));
                }
            }
            System.out.println("Entries loaded into array using key as index.");
        } catch (Exception e) {
            System.out.println("File " + file + " not found");
        }
    }

    // Lookup method using the zip code as index
    public Area lookup(String zip) {
        int zipCode = Integer.valueOf(zip.replaceAll("\\s", ""));  // Convert string zip code to integer
        if (zipCode >= 0 && zipCode < maxZipCode && data[zipCode] != null) {
            return data[zipCode];
        }
        return null;  // If zip code is not found or out of range
    }
}
