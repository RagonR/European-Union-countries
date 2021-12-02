package com.example.European.Union.countries.Service;

import com.example.European.Union.countries.dto.EUCountry;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

        List<EUCountry> euCountriesSorted = new ArrayList<EUCountry>();
        for(EUCountry country : euCountries){
            EUCountry euCountry = new EUCountry();
            euCountry.setName(country.getName());
            euCountry.setPopulation(country.getPopulation());
            euCountry.setCapital(country.getCapital());
            euCountry.setCurrencies(country.getCurrencies());
            euCountriesSorted.add(euCountry);
        }
        return euCountriesSorted;
    }

    public List<EUCountry> getTop10Population() {
        List<EUCountry> euCountries = displayEUCountries();

        Comparator<EUCountry> compareByPop =
                (EUCountry o1, EUCountry o2) -> o1.getPopulation().compareTo(o2.getPopulation());

        euCountries.sort(compareByPop.reversed());

        return euCountries.stream().limit(10).collect(Collectors.toList());
    }

    public List<EUCountry> getTop10Area() {
        List<EUCountry> euCountries = getAllCountries();

        Comparator<EUCountry> compareByArea =
                (EUCountry o1, EUCountry o2) -> o1.getArea().compareTo(o2.getArea());

        euCountries.sort(compareByArea.reversed());

        return euCountries.stream().limit(10).collect(Collectors.toList());
    }

    public List<EUCountry> getTop10Density() {
        List<EUCountry> euCountries = getAllCountries();

        Comparator<EUCountry> compareByDensity =
                (EUCountry o1, EUCountry o2) -> o1.getDensity().compareTo(o2.getDensity());

        euCountries.sort(compareByDensity.reversed());

        return euCountries.stream().limit(10).collect(Collectors.toList());
    }
}
