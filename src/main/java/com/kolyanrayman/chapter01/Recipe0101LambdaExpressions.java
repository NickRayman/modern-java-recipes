package com.kolyanrayman.chapter01;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;

public class Recipe0101LambdaExpressions {

    public static void main(String[] args) {
        RunnableDemo.main(args);
    }
    private class RunnableDemo {
        private static void main(String[] args) {

            System.out.println("_____________Анонимный внутренний класс, реализующий интерфейс Runnable_____________");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("внутри Runnable в анонимном классе");
                }
            }).start();

            System.out.println("__________________Использование лямбда-выражения в конструкции Thread___________________");

            new Thread(() -> System.out.println("внутри конструктора Thread с использованием лямбды")).start();

            System.out.println("__________________Присваивание лямбда-выражения переменной_______________");

            Runnable r = () -> System.out.println("лямбда-выражение, реализующее метод run");
            new Thread(r).start();

            System.out.println("_______________Реализация FilenameFilter с помощью анонимного внутреннего класса___________________");

            File directory = new File("./src/main/java");
            String[] names = directory.list(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.endsWith(".java");
                }
            });
            System.out.println(Arrays.asList(names));

            System.out.println("_________________Лямбда-выражение, реализующее интерфейс FilenameFilter ____________________");

            File directory2 = new File("./src/main/java/com/kolyanrayman/chapter01/");
            String[] names2 = directory2.list((dir, name) -> name.endsWith(".java"));
            System.out.println(Arrays.asList(names2));

            System.out.println("_______________Лямбда-выражение в явно заданными типами данных________________");

            File directory3 = new File("./src/main/java/com/kolyanrayman/chapter01/");
            String[] names3 = directory3.list((File dir, String name) -> name.endsWith(".java"));
            System.out.println(Arrays.asList(names3));

            System.out.println("__________________Блочное лямбда-выражение___________________");

            File directory4 = new File("./src/main/java/com/kolyanrayman/chapter01/");
            String[] names4 = directory4.list((File dir, String name) -> {
                return name.endsWith(".java");
            });
            System.out.println(Arrays.asList(names4));

        }
    }
}
