package com.company;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.company.CityUtils.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<City> cities = parse();
        City[] cityArray = cities.toArray(new City[0]);

//        List<City> duplicates =  cities.stream().collect(Collectors.groupingBy(Function.identity())).entrySet().stream().filter(e -> e.getValue().size() > 1).map(Map.Entry::getKey).collect(Collectors.toList());
//        System.out.println(duplicates);
        cityInRegion(cityArray);
//        findCountCityByRegionV2(cities);
    }
}
