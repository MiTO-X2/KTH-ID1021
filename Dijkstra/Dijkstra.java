import java.util.PriorityQueue;

public class Dijkstra {
    private Done done;
    private PriorityQueue<Path> pq;

    public Dijkstra(int numCities) {
        done = new Done(numCities);
        pq = new PriorityQueue<>((p1, p2) -> p1.getDist().compareTo(p2.getDist()));
    }

    public Integer findShortestPath(City source, City destination) {
        pq.add(new Path(source, null, 0));

        while (!pq.isEmpty()) {
            Path currentPath = pq.poll();
            City currentCity = currentPath.getCity();

            if (currentCity.equals(destination)) {
                done.setDone(currentCity, currentPath);
                return currentPath.getDist();
            }

            if (done.isDone(currentCity)) continue;

            done.setDone(currentCity, currentPath);

            for (Connection conn : currentCity.getNeighbors()) {
                City neighbor = conn.getCity();
                int newDist = currentPath.getDist() + conn.getDistance();

                if (!done.isDone(neighbor)) {
                    pq.add(new Path(neighbor, currentCity, newDist));
                }
            }
        }
        return null;
    }

    public Done getDone() {
        return done;
    }
}
