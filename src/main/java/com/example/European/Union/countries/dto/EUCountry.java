package com.example.European.Union.countries.dto;

public class EUCountry {

    private String name;

    private String capital;

    private int population;

    private double area;

    private String currencies;

    private double population_density;

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

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String getCurrencies() {
        return currencies;
    }

    public void setCurrencies(String currencies) {
        this.currencies = currencies;
    }

    public double getPopulation_density() {
        return population_density;
    }

    public void setPopulation_density(double population_density) {
        this.population_density = population_density;
    }
}
