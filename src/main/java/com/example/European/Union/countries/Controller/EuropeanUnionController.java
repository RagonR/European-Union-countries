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
    public List<EUCountry> getAllEUCountries(){
        return  europeanUnionService.getAllCountries();
    }

}
