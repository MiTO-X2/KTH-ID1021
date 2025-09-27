import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TrainMapWithHash {
    private CityHashTable cities;  // Replace HashMap with CityHashTable

    public TrainMapWithHash(int size) {
        cities = new CityHashTable(size);
    }

    public void addConnection(String from, String to, int time) {
        City fromCity = getCity(from);
        City toCity = getCity(to);

        fromCity.connect(toCity, time); // Add connection from -> to
        toCity.connect(fromCity, time); // Add connection to -> from (bidirectional)
    }

    private City getCity(String name) {
        City city = cities.getCity(name);
        if (city == null) {
            city = new City(name);
            cities.addCity(city);
        }
        return city;
    }

    public void loadMap(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String fromCity = data[0].trim();
                String toCity = data[1].trim();
                int time = Integer.parseInt(data[2].trim());
                addConnection(fromCity, toCity, time);
            }
        }
    }

    public void printMap() {
        cities.printTable();  // Print the hash table
    }
}
