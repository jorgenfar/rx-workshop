package workshop;

import io.reactivex.Observable;
import io.reactivex.Single;
import workshop.data.CitySource;
import workshop.data.TemperatureSource;

class Main {

    private final CitySource citySource;
    private final TemperatureSource temperatureSource;

    Main() {
        temperatureSource = new TemperatureSource();
        citySource = new CitySource();
    }

    Single<String> getTheFirstCityName() {
        throw new RuntimeException("Not implemented yet");
    }

    Single<String> getTheLastCityName() {
        throw new RuntimeException("Not implemented yet");
    }

    Observable<Integer> getTheFirstTwoCityIds() {
        throw new RuntimeException("Not implemented yet");
    }

    Observable<Integer> getCitiesWithNamesContaining(String letter) {
        throw new RuntimeException("Not implemented yet");
    }

    Single<Integer> getTotalPopulation() {
        throw new RuntimeException("Not implemented yet");
    }

    Observable<Double> getTemperatureForCity(int cityId) {
        throw new RuntimeException("Not implemented yet");
    }

    Observable<Double> getTemperatureDifferanceBetweenCities(int cityIdA, int cityIdB) {
        throw new RuntimeException("Not implemented yet");
    }
}
