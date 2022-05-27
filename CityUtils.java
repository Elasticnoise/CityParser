package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class CityUtils {

    public static void parse() throws IOException {
        ArrayList<City> cities = new ArrayList<>();
        try {
            Path path = Paths.get("src/com/company/city_ru.csv");
            Scanner scanner = new Scanner(path);

            scanner.useDelimiter(System.getProperty("line.separator"));
            while (scanner.hasNextLine())
                cities.add(parseLine(scanner.nextLine()));
            scanner.close();
            cities.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
}
