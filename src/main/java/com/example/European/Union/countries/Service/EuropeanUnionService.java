package com.example.European.Union.countries.Service;

import com.example.European.Union.countries.dto.EUCountry;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class EuropeanUnionService {
    public List<EUCountry> getAllCountries(){

        List<EUCountry> euCountries = new ArrayList<EUCountry>();

        final String uri = "https://restcountries.com/v2/regionalbloc/eu";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<LinkedHashMap[]> responseEntity =
                restTemplate.getForEntity(uri, LinkedHashMap[].class);

        LinkedHashMap[] linkedHashMaps = responseEntity.getBody();

        for (LinkedHashMap entry : linkedHashMaps) {
            if (entry.get("independent").toString().equals("true")){
                EUCountry euCountry = new EUCountry();
                euCountry.setName(entry.get("name").toString());
                euCountry.setCapital(entry.get("capital").toString());
                euCountry.setPopulation((int) entry.get("population"));
                euCountry.setArea((double) entry.get("area"));
                euCountry.setCurrencies(entry.get("currencies").toString());
                euCountry.setPopulation_density(Math.round(euCountry.getPopulation()/euCountry.getArea()*100.0)/100.0);
                euCountries.add(euCountry);
            }
        }

        return euCountries;
    }
}
