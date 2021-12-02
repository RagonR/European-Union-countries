package com.example.European.Union.countries.Service;

import com.example.European.Union.countries.dto.EUCountry;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class EuropeanUnionService {

    public List<EUCountry> getAllCountries(){

        final String uri = "https://restcountries.com/v2/regionalbloc/eu";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<EUCountry[]> responseEntity =
                restTemplate.getForEntity(uri, EUCountry[].class);

        EUCountry[] euCountries_data = responseEntity.getBody();

        List<EUCountry> euCountries = new ArrayList<EUCountry>();

        assert euCountries_data != null;
        for (EUCountry entry : euCountries_data) {
            if(entry.isIndependent())
                euCountries.add(entry);
        }

        return euCountries;
    }
}
