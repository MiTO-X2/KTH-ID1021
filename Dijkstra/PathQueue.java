import java.util.Comparator;
import java.util.PriorityQueue;

public class PathQueue {
    private PriorityQueue<Path> queue;

    public PathQueue() {
        queue = new PriorityQueue<>(Comparator.comparingInt(Path::getDist));
    }

    public void add(Path path) {
        queue.add(path);
    }

    public Path poll() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
