import java.util.ArrayList;

public class CityHashTable {
    private ArrayList<City>[] table;
    private int mod;  // Size of the hash table

    public CityHashTable(int size) {
        this.mod = size;
        table = new ArrayList[mod];
        for (int i = 0; i < mod; i++) {
            table[i] = new ArrayList<>();
        }
    }

    // Hash function
    private int hash(String name) {
        int hash = 0;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 + name.charAt(i)) % mod;
        }
        return hash;
    }

    // Add a city to the hash table
    public void addCity(City city) {
        int index = hash(city.getName());
        table[index].add(city);
    }

    // Retrieve a city from the hash table
    public City getCity(String name) {
        int index = hash(name);
        for (City city : table[index]) {
            if (city.getName().equals(name)) {
                return city;
            }
        }
        return null;  // City not found
    }

    // Print the contents of the hash table (for debugging purposes)
    public void printTable() {
        for (int i = 0; i < mod; i++) {
            System.out.print(i + ": ");
            for (City city : table[i]) {
                System.out.print(city.getName() + " ");
            }
            System.out.println();
        }
    }
}

