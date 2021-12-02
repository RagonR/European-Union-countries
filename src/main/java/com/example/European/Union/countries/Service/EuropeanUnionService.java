package com.example.European.Union.countries.Service;

import com.example.European.Union.countries.dto.EUCountry;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EuropeanUnionService {

    public List<EUCountry> getAllCountries() {

        final String uri = "https://restcountries.com/v2/regionalbloc/eu";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EUCountry[]> responseEntity =
                restTemplate.getForEntity(uri, EUCountry[].class);

        EUCountry[] euCountries_data = responseEntity.getBody();

        List<EUCountry> euCountries = new ArrayList<EUCountry>();

        assert euCountries_data != null;
        for (EUCountry entry : euCountries_data) {
            if (entry.isIndependent())
                euCountries.add(entry);
        }

        return euCountries;
    }

    public List<EUCountry> displayEUCountries() {
        List<EUCountry> euCountries = getAllCountries();

        List<EUCountry> euCountriesRequiredElements = new ArrayList<EUCountry>();
        for (EUCountry country : euCountries) {
            EUCountry euCountry = new EUCountry(country.getName(), country.getCapital(), country.getCurrencies(), country.getPopulation());
            euCountriesRequiredElements.add(euCountry);
        }
        return euCountriesRequiredElements;
    }

    public List<EUCountry> getTop10Population() {
        List<EUCountry> euCountries = displayEUCountries();

        List<EUCountry> euCountriesRequiredElements = new ArrayList<EUCountry>();
        for (EUCountry country : euCountries) {
            EUCountry euCountry = new EUCountry(country.getName(), country.getPopulation());
            euCountriesRequiredElements.add(euCountry);
        }

        Comparator<EUCountry> compareByPop =
                (EUCountry o1, EUCountry o2) -> o1.getPopulation().compareTo(o2.getPopulation());

        euCountriesRequiredElements.sort(compareByPop.reversed());

        return euCountriesRequiredElements.stream().limit(10).collect(Collectors.toList());
    }

    public List<EUCountry> getTop10Area() {
        List<EUCountry> euCountries = getAllCountries();

        List<EUCountry> euCountriesRequiredElements = new ArrayList<EUCountry>();
        for (EUCountry country : euCountries) {
            EUCountry euCountry = new EUCountry(country.getName(), country.getArea());
            euCountriesRequiredElements.add(euCountry);
        }

        Comparator<EUCountry> compareByArea =
                (EUCountry o1, EUCountry o2) -> o1.getArea().compareTo(o2.getArea());

        euCountriesRequiredElements.sort(compareByArea.reversed());

        return euCountriesRequiredElements.stream().limit(10).collect(Collectors.toList());
    }

    public List<EUCountry> getTop10Density() {
        List<EUCountry> euCountries = getAllCountries();

        List<EUCountry> euCountriesRequiredElements = new ArrayList<EUCountry>();
        for (EUCountry country : euCountries) {
            EUCountry euCountry = new EUCountry(country.getName(), country.getPopulation(), country.getArea());
            euCountriesRequiredElements.add(euCountry);
        }

        Comparator<EUCountry> compareByDensity =
                (EUCountry o1, EUCountry o2) -> o1.getDensity().compareTo(o2.getDensity());

        euCountriesRequiredElements.sort(compareByDensity.reversed());

        return euCountriesRequiredElements.stream().limit(10).collect(Collectors.toList());
    }
}
