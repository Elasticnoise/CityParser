package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CityUtils {

    public static List<City> parse() throws IOException {
        List<City> cities = new ArrayList<>();
        try {
            Path path = Paths.get("src/com/company/city_ru.csv");
            Scanner scanner = new Scanner(path);

            scanner.useDelimiter(System.getProperty("line.separator"));
            while (scanner.hasNextLine())
                cities.add(parseLine(scanner.nextLine()));
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return cities;
    }

    private static City parseLine(String line) {
        Scanner scanner = new Scanner(line);
        scanner.useDelimiter(";");

        int id = scanner.hasNextInt()?scanner.nextInt():-1;
        String name = scanner.hasNext()?scanner.next():"null";
        String region = scanner.hasNext()?scanner.next():"null";
        String district = scanner.hasNext()?scanner.next():"null";
        int population = scanner.hasNextInt()?scanner.nextInt():-1;
        String foundation = scanner.hasNext()?scanner.next():"null";
        scanner.close();
        return new City(id, name, region, district, population, foundation);
    }

    public static void SortByCityName(List<City> list) {
        Comparator<City> comparator = Comparator.comparing(City::getName);
        list.sort(comparator);
    }

    public static void CityAndDistrictSort(List<City> list) {
        Comparator<City> comparator = Comparator.comparing(City::getDistrict).thenComparing(City::getName);
        list.sort(comparator);
    }

    public static City findMaxPopulation(City[] cityArray) {
        City maxPopulation = cityArray[0];
        for (int i = 1; i < cityArray.length; i++) {
            if (maxPopulation.getPopulation() < cityArray[i].getPopulation())
                maxPopulation = cityArray[i];
        }
        return maxPopulation;
    }

    public static City recursiveFind(City[] cityArray, int max) {
        if (cityArray.length > max) {
            City next = recursiveFind(cityArray, max + 1);
            return (cityArray[max].getPopulation() > next.getPopulation()) ? cityArray[max] : next;
        } else {
            return cityArray[0];
        }
    }

    public static void cityInRegion(City[] cityArray) {
        Map<String, Integer> counts = new HashMap<>();
        for (City city : cityArray) {
            if (counts.containsKey(city.getRegion())) {
                counts.put(city.getRegion(), counts.get(city.getRegion()) + 1);
            } else {
                counts.put(city.getRegion(), 1);
            }
        }
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            System.out.println(entry.getKey()+" - "+ entry.getValue());
        }
    }

    public static void findCountCityByRegionV2(List<City> cities) {
        Map<String, Integer> regions = new HashMap<>();
        cities.forEach(city -> regions.merge(city.getRegion(), 1, Integer::sum));
        regions.forEach((k, v) -> System.out.println(MessageFormat.format(" {0} = {1}", k, v)));
    }
}
