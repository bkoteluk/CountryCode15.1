package pl.homework.app;

import pl.homework.lib.Country;
import pl.homework.lib.IllegalCountryCodeException;

import java.io.*;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountryCode {
    private static Map<String, Country> countryMap = new TreeMap<>();

    public static void main(String[] args) {
        try {
            readCountryCodes();
            printCountryInfo(inputCode());
            System.out.println(countryMap);
        } catch (IOException | IllegalCountryCodeException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void readCountryCodes() throws IOException {
        File file = new File("countrycode.csv");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = "";
        while ((line = bufferedReader.readLine() ) != null) {
            String[] array = line.split(";");
            Country country = new Country(array[0], array[1], Integer.parseInt(array[2]));
            countryMap.put(country.getCode(), country);
        }
    }

    public static String inputCode() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj kod kraju, o którym chcesz zobaczyć informacje: ");
        return sc.nextLine();
    }

    public static void printCountryInfo(String countryCode) throws IllegalCountryCodeException {
        if (countryMap.containsKey(countryCode)) {
            Country country = countryMap.get(countryCode);
            System.out.println(country.getName() + " (" + countryCode + ") " + " ma " + country.getCitizens() + " ludności");
        } else {
            throw new IllegalCountryCodeException("Błędny kod lub brak kraju w zbiorze");
        }

    }
}
