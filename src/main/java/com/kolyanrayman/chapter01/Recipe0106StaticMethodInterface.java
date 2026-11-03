package com.kolyanrayman.chapter01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Recipe0106StaticMethodInterface {

    public static void main(String[] args) {

        System.out.println("_____________Сортировка строк_____________");
        List<String> bonds = Arrays.asList("connery", "Lazenby", "Moore", "Dalton", "Brosnan", "Craig");

        List<String> sorted = bonds.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList()); //Естественный порядок (лексикографический)
        sorted.forEach(System.out::println);

        System.out.println("__________________________");

        sorted = bonds.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()); //Обратный лексикографический порядок
        sorted.forEach(System.out::println);

        System.out.println("__________________________");

        sorted = bonds.stream().sorted(Comparator.comparing(String::toLowerCase)).collect(Collectors.toList()); //Сортировать по имени в нижнем регистре
        sorted.forEach(System.out::println);

        System.out.println("__________________________");

        sorted = bonds.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList()); //Сортировать по длине имени
        sorted.forEach(System.out::println);

        System.out.println("__________________________");

        sorted = bonds.stream()
                .sorted(Comparator.comparingInt(String::length)
                .thenComparing(Comparator.naturalOrder()))
        .collect(Collectors.toList()); // Сортировать по длине, а при равной длине лексикографически
        sorted.forEach(System.out::println);

        System.out.println("__________________________");
    }
}
