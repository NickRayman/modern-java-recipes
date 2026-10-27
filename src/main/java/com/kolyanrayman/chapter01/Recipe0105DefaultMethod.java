package com.kolyanrayman.chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Recipe0105DefaultMethod {

    private abstract class Animal {
       public abstract String speak();
    }

    private class Horse extends Animal {

        @Override
        public String speak() {
            return "И-го-го!";
        }
    }

    private class Bird extends Animal {

        @Override
        public String speak() {
            return "Чирик!";
        }
    }

    // Компилятор не даст сделать множественное наследование для класса Pegasus extends Horse, Bird. Проблема кроется в проблеме ромбовидного наследования

    static class MyCollection {

        private final List<String> elements = new ArrayList<>();

        public void add(String value) {
            elements.add(value);
        }

        public int size() {
            return elements.size();
        }

        /**
         * Реализация isEmpty в терминах size
         * @return
         */
        public boolean isEmpty() {
            return size() == 0;
        }

    }

    /**
     * Интерфейс Employee с методом по умолчанию
     */
    public interface Employee {

        String getFirst();

        String getLast();

        void convertCaffeineToCodeForMoney();

        /**
         * Метод по умолчанию
         * @return
         */
        default String getName() {
            return String.format("%s %s", getFirst(), getLast());
        }

    }

    public static void main(String[] args) {
        /**
         * Использование методов по умолчанию
         */
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, -3, 4, 5, -6, 7, 8, -9, 10));

        List<Integer> nums1 = Arrays.asList(1, 2, -3, 4, 5, -6, 7, 8, -9, 10);

        boolean removed = nums.removeIf(n -> n <= 0);

        boolean removed1 = nums.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer n) {
                return n <=0 ;
            }
        });
        System.out.println("Элемент " + (removed ? "было" : "не было") + " удалены");
        nums.forEach(System.out::println);

    }

}
