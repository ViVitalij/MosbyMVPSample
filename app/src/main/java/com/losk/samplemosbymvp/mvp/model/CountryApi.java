package com.losk.samplemosbymvp.mvp.model;

import java.util.ArrayList;
import java.util.List;

public class CountryApi {

    public static List<Country> getCountries() {
        List<Country> countries = new ArrayList<Country>(20);

        countries.add(new Country("Poland"));
        countries.add(new Country("Germany"));
        countries.add(new Country("Belgium"));
        countries.add(new Country("Austria"));
        countries.add(new Country("Brazil"));
        countries.add(new Country("Chile"));
        countries.add(new Country("China"));
        countries.add(new Country("Denmark"));
        countries.add(new Country("Finland"));
        countries.add(new Country("France"));
        countries.add(new Country("Ghana"));
        countries.add(new Country("Japan"));
        countries.add(new Country("Mexico"));
        countries.add(new Country("Netherlands"));
        countries.add(new Country("Norway"));
        countries.add(new Country("Spain"));
        countries.add(new Country("Switzerland"));
        countries.add(new Country("United Kingdom"));
        countries.add(new Country("United States"));
        countries.add(new Country("Australia"));

        return countries;
    }
}
