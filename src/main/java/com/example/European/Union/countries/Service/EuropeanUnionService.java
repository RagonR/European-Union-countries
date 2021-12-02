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
    public List<EUCountry> displayEUCountries(List<EUCountry> euCountries) {

        List<EUCountry> euCountriesRequiredElements = new ArrayList<EUCountry>();
        for (EUCountry country : euCountries) {
            EUCountry euCountry = new EUCountry(country.getName(), country.getCapital(), country.getCurrencies(), country.getPopulation());
            euCountriesRequiredElements.add(euCountry);
        }
        return euCountriesRequiredElements;
    }

    public List<EUCountry> getTop10Population(List<EUCountry> euCountries) {

        List<EUCountry> euCountriesRequiredElements = new ArrayList<EUCountry>();
        for (EUCountry country : euCountries) {
            EUCountry euCountry = new EUCountry(country.getName(), country.getPopulation());
            euCountriesRequiredElements.add(euCountry);
        }

        euCountriesRequiredElements.sort(Comparator.comparing(EUCountry::getPopulation).reversed());

        return euCountriesRequiredElements.stream().limit(10).collect(Collectors.toList());
    }

    public List<EUCountry> getTop10Area(List<EUCountry> euCountries) {

        List<EUCountry> euCountriesRequiredElements = new ArrayList<EUCountry>();
        for (EUCountry country : euCountries) {
            EUCountry euCountry = new EUCountry(country.getName(), country.getArea());
            euCountriesRequiredElements.add(euCountry);
        }

        euCountriesRequiredElements.sort(Comparator.comparing(EUCountry::getArea).reversed());

        return euCountriesRequiredElements.stream().limit(10).collect(Collectors.toList());
    }

    public List<EUCountry> getTop10Density(List<EUCountry> euCountries) {

        List<EUCountry> euCountriesRequiredElements = new ArrayList<EUCountry>();
        for (EUCountry country : euCountries) {
            EUCountry euCountry = new EUCountry(country.getName(), country.getPopulation(), country.getArea());
            euCountriesRequiredElements.add(euCountry);
        }

        euCountriesRequiredElements.sort(Comparator.comparing(EUCountry::getDensity).reversed());

        return euCountriesRequiredElements.stream().limit(10).collect(Collectors.toList());
    }
}
