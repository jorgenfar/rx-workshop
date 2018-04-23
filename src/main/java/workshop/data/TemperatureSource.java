package workshop;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemperatureSource {

    public static final List<Double> TEMP_OSLO = Arrays.asList(20d, 19d, 23d, 15d, 23d, 24d, 20d, 19d, 23d, 15d, 23d, 25d);
    public static final List<Double> TEMP_STAVANGER = Arrays.asList(15d, 12d, 13d, 25d, 23d, 24d, 15d, 19d, 23d, 15d, 23d, 24d);
    public static final List<Double> TEMP_TRONDHEIM = Arrays.asList(20d, 19d, 23d, 15d, 23d, 24d, 10d, 19d, 13d, 13d, 14d, 15d);

    private Map<Integer, List<Double>> temperatures = new HashMap<>();

    TemperatureSource() {
        temperatures.put(1, TEMP_OSLO);
        temperatures.put(2, TEMP_STAVANGER);
        temperatures.put(3, TEMP_TRONDHEIM);
    }

    public Observable<Double> getTemperature(int cityId) {
        return Observable.just(cityId)
                .map(cityId1 -> temperatures.get(cityId))
                .flatMap(Observable::fromIterable);
    }
}
