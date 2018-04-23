package workshop.dto;

public class City {

    public final int id;
    public final String name;
    public final int population;

    public City(int id, String name, int population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        return id == city.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
