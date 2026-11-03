package com.kolyanrayman.chapter02;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Recipe0201Consumer {
    public static void main(String[] args) {

        /**
         * Методы интерфейса java.util.function.Consumer
         */
        Consumer<String> c = new Consumer<String>() {
            // Единственный абстрактный метод
            @Override
            public void accept(String s) {

            }

            // Метод по умолчанию для композиции
            @Override
            public Consumer<String> andThen(Consumer<? super String> after) {
                return Consumer.super.andThen(after);
            }
        };

        /**
         * Метод forEach интерфейса Iterable
         */
        Iterable<String> iterable = new Iterable<String>() {

            @Override
            public Iterator<String> iterator() {
                return null;
            }

            // Метод forEach интерфейса Iterable
            @Override
            public void forEach(Consumer<? super String> action) {
                Iterable.super.forEach(action);
            }

            @Override
            public Spliterator<String> spliterator() {
                return Iterable.super.spliterator();
            }
        };

        System.out.println("_____________Печать элементов коллекции_____________");
        List<String> strings = Arrays.asList("this", "is", "a", "list", "of", "strings");

        strings.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        }); // Реализация с анонимным внутренним классом

        strings.forEach(s -> System.out.println(s)); //Лямбда выражение

        strings.forEach(System.out::println); //Ссылка на метод
    }
}
