import java.util.ArrayList;

public class City {
    public String name;
    public Integer id;
    public ArrayList<Connection> neighbors;

    public City(String name, Integer id) {
        this.name = name;
        this.id = id;
        this.neighbors = new ArrayList<>();
    }

    public void addConnection(City city, int distance) {
        neighbors.add(new Connection(city, distance));
    }

    public String getName() {
        return name;
    }

    public ArrayList<Connection> getNeighbors() {
        return neighbors;
    }

    public Integer getId() {
        return id;
    }
}

