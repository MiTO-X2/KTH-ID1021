public class Path {
    private City city;
    private City prev;
    private Integer dist;

    public Path(City city, City prev, Integer dist) {
        this.city = city;
        this.prev = prev;
        this.dist = dist;
    }

    public City getCity() {
        return city;
    }

    public City getPrev() {
        return prev;
    }

    public Integer getDist() {
        return dist;
    }
}
