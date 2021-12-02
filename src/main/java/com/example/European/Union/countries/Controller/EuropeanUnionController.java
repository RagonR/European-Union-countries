package com.example.European.Union.countries.Controller;

import com.example.European.Union.countries.Service.EuropeanUnionService;
import com.example.European.Union.countries.dto.EUCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/eu")
public class EuropeanUnionController {

    private final EuropeanUnionService europeanUnionService;

    @Autowired
    public EuropeanUnionController(EuropeanUnionService europeanUnionService) {
        this.europeanUnionService = europeanUnionService;
    }

    @GetMapping("/countries")
    public List<EUCountry> getAllEUCountries() {
        return europeanUnionService.displayEUCountries();
    }

    @GetMapping("/countries/Top10Population")
    public List<EUCountry> getTop10Population() {
        return europeanUnionService.getTop10Population();
    }

    @GetMapping("/countries/Top10Area")
    public List<EUCountry> getTop10Area() {
        return europeanUnionService.getTop10Area();
    }

    @GetMapping("/countries/Top10Density")
    public List<EUCountry> getTop10Density() {
        return europeanUnionService.getTop10Density();
    }
}
