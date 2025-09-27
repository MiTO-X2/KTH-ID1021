import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class TrainMap {
    private HashMap<String, City> cities;

    public TrainMap() {
        cities = new HashMap<>();
    }

    public void addConnection(String from, String to, int time) {
        City fromCity = getCity(from);
        City toCity = getCity(to);

        fromCity.connect(toCity, time); // Add connection from -> to
        toCity.connect(fromCity, time); // Add connection to -> from (bidirectional)
    }

    private City getCity(String name) {
        if (!cities.containsKey(name)) {
            cities.put(name, new City(name));
        }
        return cities.get(name);
    }

    public City getCityByName(String name) {
        return cities.get(name);
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
        for (City city : cities.values()) {
            System.out.println(city.getName() + " connections:");
            for (Connection conn : city.getConnections()) {
                System.out.println("  -> " + conn);
            }
            System.out.println();
        }
    }
}
