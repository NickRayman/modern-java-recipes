package com.kolyanrayman.chapter01;

public class Recipe0104FunctionalInterface {

    /**
     * Функциональный интерфейс PalindromeChecker
     */
    @FunctionalInterface
    public interface PalindromeChecker {
        boolean isPalindrome(String s);
    }

    /**
     * MyInterface - функциональный интерфейс, содержащий статический метод и метод по умолчанию
     */
    @FunctionalInterface
    public interface MyInterface {
        int myMethod(); // единственный абстрактный метод
        // int myOtherMethod() - если раскомментировать эту строчку, интерфейс перестанет быть функциональным

        default String sayHello() {
            return "Hello World!";
        }

        static void myStaticMethod() {
            System.out.println("Это статический метод интерфейса");
        }
    }

    /**
     * После расширения функциональный интерфейс перестает быть функциональным
     */
    public interface myChildInterface extends MyInterface {
        int anotherMethod();
    }

}
