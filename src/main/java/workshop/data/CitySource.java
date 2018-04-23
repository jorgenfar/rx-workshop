package workshop.data;

import io.reactivex.Observable;
import workshop.dto.City;

public class CityRepository {

    public static final int OSLO_POPULATION = 958378;
    public static final int STAVANGER_POPULATION = 220943;
    public static final int TRONDHEIM_POPULATION = 180557;

    public static final int OSLO_ID = 1;
    public static final int STAVANGER_ID = 2;
    public static final int TRONDHEIM_ID = 3;

    public Observable<City> getCities() {
        final City oslo = new City(OSLO_ID, "Oslo", OSLO_POPULATION);
        final City stavanger = new City(STAVANGER_ID, "Stavanger", STAVANGER_POPULATION);
        final City trondheim = new City(TRONDHEIM_ID, "Trondheim", TRONDHEIM_POPULATION);

        return Observable.just(oslo, stavanger, trondheim);
    }
}
