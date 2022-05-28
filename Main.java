package com.company;

import java.io.IOException;
import java.util.List;

import static com.company.CityUtils.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<City> cities = parse();
//        SortByCityName(cities);
        CityAndDistrictSort(cities);
        cities.forEach(System.out::println);
    }
}
