package workshop;

import io.reactivex.Observable;
import io.reactivex.Single;
import workshop.data.CitySource;
import workshop.data.TemperatureSource;
import workshop.dto.City;

class Main {

    private final CitySource citySource;
    private final TemperatureSource temperatureSource;

    Main() {
        temperatureSource = new TemperatureSource();
        citySource = new CitySource();
    }

    Single<String> getTheFirstCityName() {
        return citySource.getCities()
                .firstOrError()
                .map(city -> city.name);
    }

    Single<String> getTheLastCityName() {
        return citySource.getCities()
                .lastOrError()
                .map(city -> city.name);
    }

    Observable<Integer> getTheFirstTwoCityIds() {
        return citySource.getCities()
                .take(2)
                .map(city -> city.id);
    }

    Observable<Integer> getCitiesWithNamesContaining(String letter) {
        return citySource.getCities()
                .filter(city -> city.name.toLowerCase().contains(letter))
                .map(city -> city.id);
    }

    Single<Integer> getTotalPopulation() {
        return citySource.getCities()
                .map(city -> city.population)
                .reduce((integer, integer2) -> integer + integer2)
                .toSingle();
    }

    Observable<Double> getTemperatureForCity(int cityId) {
        return citySource.getCities()
                .filter(city -> city.id == cityId)
                .flatMap((City city) -> temperatureSource.getTemperature(city.id));
    }

    Observable<Double> getTemperatureDifferanceBetweenCities(int cityIdA, int cityIdB) {
        final Observable<Double> a = temperatureSource.getTemperature(cityIdA);
        final Observable<Double> b = temperatureSource.getTemperature(cityIdB);
        return a.zipWith(b, (tempA, tempB) -> Math.abs(tempA - tempB));
    }
}
