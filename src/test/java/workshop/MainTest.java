package workshop;

import org.junit.Before;
import org.junit.Test;
import workshop.data.CitySource;
import workshop.data.TemperatureSource;

import java.util.List;

public class MainTest {

    private Main main;

    @Before
    public void setUp() throws Exception {
        main = new Main();
    }

    @Test
    public void getFirstCity() throws Exception {
        main.getTheFirstCityName()
                .test()
                .assertValue("Oslo");
    }

    @Test
    public void getLastCity() throws Exception {
        main.getTheLastCityName()
                .test()
                .assertValue("Trondheim");
    }

    @Test
    public void getTheFirstTwoCityIds() throws Exception {
        main.getTheFirstTwoCityIds()
                .test()
                .assertValues(1, 2);
    }

    @Test
    public void getCityIdsFromCitiesWhoseNameContains() throws Exception {
        main.getCitiesWithNamesContaining("s")
                .test()
                .assertValues(CitySource.OSLO_ID, CitySource.STAVANGER_ID);

        main.getCitiesWithNamesContaining("trond")
                .test()
                .assertValues(CitySource.TRONDHEIM_ID);
    }

    @Test
    public void getTotalPopulation() throws Exception {
        main.getTotalPopulation()
                .test()
                .assertValue(CitySource.OSLO_POPULATION + CitySource.STAVANGER_POPULATION + CitySource.TRONDHEIM_POPULATION);
    }

    @Test
    public void getTemperatureForCity() throws Exception {
        final List<Double> tempOslo = TemperatureSource.TEMP_OSLO;
        main.getTemperatureForCity(CitySource.OSLO_ID)
                .test()
                .assertValueSequence(tempOslo);
    }

    @Test
    public void getTemperatureDifferanceBetweenCities() throws Exception {
        main.getTemperatureDifferanceBetweenCities(CitySource.OSLO_ID, CitySource.STAVANGER_ID)
                .test()
                .assertValueSequence(TemperatureSource.DIFF_OSLO_STAVANGER);
    }
}