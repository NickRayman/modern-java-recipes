package com.kolyanrayman.chapter01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Recipe0103inksToConstructors {

    /**
     * Класс Person
     */
    public static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }

        // Копирующий конструктор
        public Person(Person person) {
            this.name = person.name;
        }

        // Конструктор Person, принимающий переменное число аргументов типа String
        public Person(String... names) {
            this.name = Arrays.stream(names).collect(Collectors.joining(" "));

            System.out.println("Varargs ctor, names=" + Arrays.asList(names));
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();
        people.add(new Person("Kolyanrayman"));
        people.add(new Person("Andrew"));
        people.add(new Person("Jack"));

        System.out.println("_____________Преобразование списка людей в список имен_____________");
        List<String> names = people.stream().map(person -> person.getName()).collect(Collectors.toList()); // Лямбда выражение
        System.out.println(names);

        List<String> names1 = people.stream().map(Person::getName).collect(Collectors.toList()); // Ссылка на метод
        System.out.println(names1);

        System.out.println("_____________Преобразование строк в экземпляры класса Person_____________");
        List<String> names2 = Arrays.asList("Grace Hopper", "Barbara Liskov", "Ada Lovelace", "Karen Spark Jones");

        List<Person> people2 = names2.stream().map(name -> new Person(name)).collect(Collectors.toList()); // Лямбда выражение
        System.out.println(people2);

        List<Person> people3 = names2.stream().map(Person::new).collect(Collectors.toList()); // Ссылка на метод
        System.out.println(people3);

        System.out.println("_____________Преобразование списка в поток и обратно_____________");
        Person before = new Person("Kolyanrayman");
        List<Person> people4 = Stream.of(before).collect(Collectors.toList());
        Person after = people4.get(0);
        System.out.println(before == after); // тот же объект
        before.setName("Andrew"); // Изменить имя с помощью ссылки before
        System.out.println(after.getName()); // Имя изменилось в ссылке after

        System.out.println("_____________Применение копирующего конструктора_____________");
        people4 = Stream.of(before).map(Person::new).collect(Collectors.toList()); // Ссылка на нужный копирующий конструктор, используется копирующий конструктор
        after = people4.get(0);
        System.out.println(before == after); // Объекты разыне
        System.out.println(before.equals(after)); // Но эквивалентные

        System.out.println("_____________Использование конструктора с переменным числом аргументов_____________");
        List<String> names3 = Arrays.asList(
                "Grace Hopper",
                "Barbara Liskov",
                "Ada Lovelace",
                "Karen Spark Jones"
        );
        List<Person> persons = names3.stream() // Создать поток строк
                .map(name -> name.split(" ")) // Отобразить на поток массивов строк
                .map(Person::new) // Отобразить на поток объектов Person
                .collect(Collectors.toList()); // Собрать в список объектов Person

        System.out.println("_____________Создание массива объектов_____________");
        Person[] people5 = names3.stream()
                .map(Person::new) //Ссылка на конструктор Person
                .toArray(Person[]::new); // Ссылка на конструктор массива Person
        System.out.println(Arrays.toString(people5));
    }


}
