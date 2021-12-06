package com.example.European.Union.countries.service;

import com.example.European.Union.countries.dto.EUCountry;

import java.util.List;

public interface EuropeanUnionServiceInterface {

    List<EUCountry> filterIndependentEUCountries(EUCountry[] euCountries_data);

    List<EUCountry> getAllCountries(String url);

    List<EUCountry> displayEUCountries(List<EUCountry> euCountries);

    List<EUCountry> getTop10Population(List<EUCountry> euCountries);

    List<EUCountry> getTop10Area(List<EUCountry> euCountries);

    List<EUCountry> getTop10Density(List<EUCountry> euCountries);
}
