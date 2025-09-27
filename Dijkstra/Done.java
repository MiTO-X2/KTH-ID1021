public class Done {
    private Path[] done;

    public Done(int numCities) {
        done = new Path[numCities];
    }

    public void setDone(City city, Path path) {
        done[city.getId()] = path;
    }

    public Path getDone(City city) {
        return done[city.getId()];
    }

    public boolean isDone(City city) {
        return done[city.getId()] != null;
    }

    public int getProcessedCityCount() {
        int count = 0;
        for (Path path : done) {
            if (path != null) count++;
        }
        return count;
    }
}
