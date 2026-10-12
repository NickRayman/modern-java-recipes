package com.kolyanrayman.chapter01;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Recipe0102LambdaExpressions {

    public static void main(String[] args) {
        System.out.println("_____________Использование ссылки на метод для доступа к println_____________");
        System.out.println("_____________С помощью лямбда выражения_____________");

        Stream.of(3,1,4,1,9).forEach(s -> System.out.println(s));

        System.out.println("_____________С помощью ссылки на метод_____________");
        Stream.of(3, 1 , 4, 1, 5, 9)
                .forEach(System.out::println);

        System.out.println("_____________Присваивание ссылки на метод переменной типа функционального интерфейса_____________");
        Consumer<Integer> printer = System.out::println;
        Stream.of(3, 1 , 4, 1, 5, 9)
                .forEach(printer);

        System.out.println("_____________Ссылка на статический метод_____________");
        Stream.generate(Math::random) // Статичный метод
                .limit(10)
                .forEach(System.out::println); // Метод экземпляра

        System.out.println("_____________Вызов метода экземпляра с несколькими аргументами через имя класса_____________");
        List<String> strings =
                Arrays.asList("this", "is", "a", "list", "of", "strings");
        List<String> sorted = strings.stream()
                .sorted((s1, s2) -> s1.compareTo(s2)) // Ссылка на метод и эквивалентное лямбда выражение
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);
        System.out.println("_____________________________________________________________________________________________");
        List<String> sorted1 = strings.stream() // Ссылка на метод и эквивалентное лямбда выражение
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        sorted.forEach(System.out::println);


        System.out.println("_____________Вызов метода length объекта типа String с помощью ссылки с помощью ссылки на метод_____________");
        Stream.of("this", "is", "a", "list", "of", "strings")
                .map(String::length)// Метод экземпляра через метод класса
                .forEach(System.out::println);// Метод экземпляра через ссылку на объект

        System.out.println("_____________Лямбда-выражения, эквивалентные ссылкам на методы_____________");
        Stream.of("this", "is", "a", "list", "of", "strings")
                .map(s -> s.length())
                .forEach(x -> System.out.println(x));
    }
}
