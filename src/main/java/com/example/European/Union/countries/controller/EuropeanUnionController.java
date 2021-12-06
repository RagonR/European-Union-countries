package com.example.European.Union.countries.controller;

import com.example.European.Union.countries.dto.EUCountry;
import com.example.European.Union.countries.service.EuropeanUnionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/eu")
public class EuropeanUnionController {

    final String URL = "https://restcountries.com/v2/regionalbloc/eu";
    private final EuropeanUnionServiceInterface europeanUnionService;

    @Autowired
    public EuropeanUnionController(EuropeanUnionServiceInterface europeanUnionService) {
        this.europeanUnionService = europeanUnionService;
    }

    @GetMapping("/countries")
    public List<EUCountry> getAllEUCountries() {
        return europeanUnionService.displayEUCountries(europeanUnionService.getAllCountries(URL));
    }

    @GetMapping("/countries/Top10Population")
    public List<EUCountry> getTop10Population() {
        return europeanUnionService.getTop10Population(europeanUnionService.getAllCountries(URL));
    }

    @GetMapping("/countries/Top10Area")
    public List<EUCountry> getTop10Area() {
        return europeanUnionService.getTop10Area(europeanUnionService.getAllCountries(URL));
    }

    @GetMapping("/countries/Top10Density")
    public List<EUCountry> getTop10Density() {
        return europeanUnionService.getTop10Density(europeanUnionService.getAllCountries(URL));
    }
}
