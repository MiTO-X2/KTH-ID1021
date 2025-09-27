import java.util.ArrayList;

public class City {
    private String name;
    private ArrayList<Connection> connections;

    public City(String name) {
        this.name = name;
        this.connections = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void connect(City destination, int distance) {
        connections.add(new Connection(destination, distance));
    }

    public ArrayList<Connection> getConnections(){
        return connections;
    }

    public void printConnections() {
        for (Connection connection : connections) {
            System.out.println("  -> " + connection.getDestination().getName() + " (" + connection.getDistance() + " mins)");
        }
    }
}
