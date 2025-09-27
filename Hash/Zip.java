import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Zip {
    Area[] postnr;
    int max = 10000;
    Integer[] keys;  // Store the zip codes for collision checking

    public class Area {
        // String code;
        Integer code;
        String name;
        int population;

        // public Area(String code, String name, int population) {
        public Area(Integer code, String name, int population) {
            this.code = code;
            this.name = name;
            this.population = population;
        }
    }

    public Zip(String file) {
        this.postnr = new Area[this.max];
        this.keys = new Integer[this.max]; // Initialize keys array to hold zip codes
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        int i = 0;
        
        while ((line = br.readLine()) != null && i < this.max) {
            String[] row = line.split(",");
            // postnr[i++] = new Area(row[0], row[1], Integer.valueOf(row[2]));
            Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
            postnr[i] = new Area(code, row[1], Integer.valueOf(row[2]));
            keys[i] = code; // Store the code in keys array
            i++;
        }
        this.max = i;
        System.out.println("Loaded " + this.max + " entries.");
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }
    
    // Method to display the number of loaded entries
    /*public static void main(String[] args) {
        Zip zipTable = new Zip("postnummer.csv");
        System.out.println("Loaded " + zipTable.max + " entries.");
    }*/

    // Method to perform linear search
    /*public Area linearSearch(String zipCode) {
        for (int i = 0; i < this.max; i++) {
            if (postnr[i].code.equals(zipCode)) {
                return postnr[i];  // Return the found entry
            }
        }
        return null;  // Return null if not found
    }*/

    // Method to perform binary search
    /*public Area binarySearch(String zipCode) {
        int left = 0;
        int right = this.max - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = postnr[mid].code.compareTo(zipCode);
            if (comparison == 0) {
                return postnr[mid];  // Zip code found
            } else if (comparison < 0) {
                left = mid + 1;  // Search right half
            } else {
                right = mid - 1;  // Search left half
            }
        }
        return null;  // Return null if not found
    }*/

    /*public Area linearSearch(int zipCode) {
        for (int i = 0; i < this.max; i++) {
            if (postnr[i].code == zipCode) {
                return postnr[i];  // Return the found entry
            }
        }
        return null;  // Return null if not found
    }

    public Area binarySearch(int zipCode) {
        int left = 0;
        int right = this.max - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (postnr[mid].code == zipCode) {
                return postnr[mid];  // Zip code found
            } else if (postnr[mid].code < zipCode) {
                left = mid + 1;  // Search right half
            } else {
                right = mid - 1;  // Search left half
            }
        }
        return null;  // Return null if not found
    }*/

    public void collisions(int mod) {
        int mx = 20; // Maximum count to track for collision types
        int[] data = new int[mod]; // To track counts at each index
        int[] cols = new int[mx]; // To count how many collisions of each type
        
        // Count collisions
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod; // Hash function
            data[index]++;
        }

        // Count the occurrences of collisions
        for (int i = 0; i < mod; i++) {
            if (data[i] < mx)
                cols[data[i]]++;
        }

        // Print results
        System.out.print("Modulo " + mod + ": ");
        for (int i = 1; i < mx; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Zip zip = new Zip("postnummer.csv");

        // Test collisions with different mod values
        zip.collisions(10000);
        zip.collisions(20000);
        zip.collisions(12345);
        zip.collisions(17389);
        zip.collisions(13513);
        zip.collisions(13600);
        zip.collisions(14000);
    }

}


