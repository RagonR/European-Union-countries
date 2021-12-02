package com.example.European.Union.countries.dto;

import com.fasterxml.jackson.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class EUCountry {

    public String name;
    public String capital;
    public List<Currency> currencies;
    public Integer population;
    public Double area;
    public boolean independent;
    public Double density;

     public EUCountry(String name, String capital, List<Currency> currencies, Integer population) {
        this.name = name;
        this.capital = capital;
        this.currencies = currencies;
        this.population = population;
    }

    public EUCountry(String name, Integer population) {
        this.name = name;
        this.population = population;
    }

    public EUCountry(String name, Double area) {
        this.name = name;
        this.area = area;
    }
    public EUCountry(String name, Integer population, Double area) {
        this.name = name;
        this.density = population/area;
    }

    public EUCountry() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public boolean isIndependent() {
        return independent;
    }

    public void setIndependent(boolean independent) {
        this.independent = independent;
    }

    public Double getDensity() {
        return density;
    }

    public void setDensity(Double density) {
        this.density = density;
    }
}
