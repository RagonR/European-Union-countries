package com.example.European.Union.countries;

import com.example.European.Union.countries.controller.EuropeanUnionController;
import com.example.European.Union.countries.service.EuropeanUnionService;
import com.example.European.Union.countries.dto.EUCountry;
import com.example.European.Union.countries.service.EuropeanUnionServiceInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EuropeanUnionCountriesTop10ApplicationTests {

    @Autowired
    private EuropeanUnionController europeanUnionController;

    @Autowired
    private EuropeanUnionServiceInterface europeanUnionService;


    public EUCountry[] getTestData() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        InputStream testDataLocation = new FileInputStream("src/test/java/com/example/European/Union/countries/testData.json");
        return mapper.readValue(testDataLocation, EUCountry[].class);
    }


    @Test
    @DisplayName("Controller loader")
    public void contextLoads() {
        assertNotNull(europeanUnionController);
    }

    @Test
    @DisplayName("Service loader")
    public void serviceLoads() {
        assertNotNull(europeanUnionService);
    }

    @Test
    @DisplayName("API data access")
    public void BadURLProvided() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EUCountry[]> responseEntity =
                restTemplate.getForEntity("https://restcountries.com/v2/regionalbloc/eu", EUCountry[].class);
        assertNotNull(responseEntity);
    }

    @Test
    @DisplayName("Function: filterIndependentEUCountries")
    public void filterIndependentEUCountriesTest() throws Exception {
        List<EUCountry> testData = europeanUnionService.filterIndependentEUCountries(getTestData());
        assertEquals(testData.size(), 11);
    }

    @Test
    @DisplayName("Function: displayEUCountries")
    public void displayEUCountriesTest() throws Exception {
        List<EUCountry> testData = europeanUnionService.displayEUCountries(europeanUnionService.filterIndependentEUCountries(getTestData()));
        for (EUCountry test : testData) {
            assertNull(test.getArea());
            assertNull(test.getDensity());
        }
    }

    @Test
    @DisplayName("Function: getTop10Population")
    public void getTop10PopulationTest() throws Exception {
        List<EUCountry> testData = europeanUnionService.getTop10Population(europeanUnionService.filterIndependentEUCountries(getTestData()));
        assertEquals(testData.size(), 10);
        assertEquals(testData.get(0).getName(), "Czech Republic");
        assertEquals(testData.get(9).getName(), "Denmark");
        for (EUCountry test : testData) {
            assertNull(test.getCapital());
            assertNull(test.getCurrencies());
            assertNull(test.getArea());
            assertNull(test.getDensity());
        }
    }

    @Test
    @DisplayName("Function: getTop10Area")
    public void getTop10AreaTest() throws Exception {
        List<EUCountry> testData = europeanUnionService.getTop10Area(europeanUnionService.filterIndependentEUCountries(getTestData()));
        assertEquals(testData.size(), 10);
        assertEquals(testData.get(1).getName(), "France");
        assertEquals(testData.get(8).getName(), "Austria");
        for (EUCountry test : testData) {
            assertNull(test.getCapital());
            assertNull(test.getCurrencies());
            assertNull(test.getPopulation());
            assertNull(test.getDensity());
        }
    }

    @Test
    @DisplayName("Function: getTop10Density")
    public void getTop10DensityTest() throws Exception {
        List<EUCountry> testData = europeanUnionService.getTop10Density(europeanUnionService.filterIndependentEUCountries(getTestData()));
        assertEquals(testData.size(), 10);
        assertEquals(testData.get(2).getName(), "Croatia");
        assertEquals(testData.get(7).getName(), "Estonia");
        for (EUCountry test : testData) {
            assertNull(test.getCapital());
            assertNull(test.getCurrencies());
            assertNull(test.getArea());
            assertNull(test.getPopulation());
        }
    }
}
