package workshop.domain.model;

public class City {

    public final CityId id;
    public final String name;

    public City(CityId id, String name) {
        this.id = id;
        this.name = name;
    }
}
