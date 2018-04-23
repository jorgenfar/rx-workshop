package workshop.data;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemperatureSource {

    public static final List<Double> TEMP_OSLO = Arrays.asList(20d, 19d, 23d, 15d, 23d, 24d, 20d, 19d, 23d, 15d, 23d, 25d, 20d, 19d, 23d, 15d, 3d, 24d, 20d, 19d, 23d, 15d, 23d, 12d);
    public static final List<Double> TEMP_STAVANGER = Arrays.asList(15d, 12d, 13d, 25d, 23d, 24d, 15d, 19d, 23d, 15d, 23d, 24d, 20d, 29d, 23d, 15d, 32d, 20d, 11d, 11d, 23d, 15d, 11d, 25d);
    public static final List<Double> TEMP_TRONDHEIM = Arrays.asList(20d, 19d, 23d, 15d, 23d, 24d, 10d, 19d, 13d, 13d, 14d, 15d, 20d, 29d, 13d, 25d, 22d, 21d, 20d, 12d, 23d, 15d, 2d, 25d);

    public static final List<Double> DIFF_OSLO_STAVANGER = Arrays.asList(5d, 7d, 10d, 10d, 0d, 0d, 5d, 0d, 0d, 0d, 0d, 1d, 0d, 10d, 0d, 0d, 29d, 4d, 9d, 8d, 0d, 0d, 12d, 13d);

    private Map<Integer, List<Double>> temperatures = new HashMap<>();

    public TemperatureSource() {
        temperatures.put(CitySource.OSLO_ID, TEMP_OSLO);
        temperatures.put(CitySource.STAVANGER_ID, TEMP_STAVANGER);
        temperatures.put(CitySource.TRONDHEIM_ID, TEMP_TRONDHEIM);
    }

    public Observable<Double> getTemperature(int cityId) {
        return Observable.just(cityId)
                .map(cityId1 -> temperatures.get(cityId))
                .flatMap(Observable::fromIterable);
    }
}
