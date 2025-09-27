import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Map {
    private HashMap<String, City> cities;
    private int cityIdCounter;

    public Map(String file) {
        cities = new HashMap<>();
        cityIdCounter = 0;
        loadMap(file);
    }

    private void loadMap(String file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                String cityName1 = row[0];
                String cityName2 = row[1];
                int distance = Integer.parseInt(row[2]);

                City city1 = lookup(cityName1);
                City city2 = lookup(cityName2);

                city1.addConnection(city2, distance);
                city2.addConnection(city1, distance);
            }
        } catch (Exception e) {
            System.out.println("File " + file + " not found or corrupt");
        }
    }

    /*public City lookup(String cityName) {
        if (!cities.containsKey(cityName)) {
            cities.put(cityName, new City(cityName, cityIdCounter++));
        }
        return cities.get(cityName);
    }*/

    public City lookup(String cityName) {
        return cities.computeIfAbsent(cityName, name -> new City(name, cityIdCounter++));
    }

    public HashMap<String, City> getCities() {
        return cities;
    }
}

