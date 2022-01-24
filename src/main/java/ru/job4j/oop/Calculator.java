package ru.job4j.oop;

import javax.sound.midi.Soundbank;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int z) {
        return z - x;
    }

    public int divide(int b) {
        return b / x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int sumAllOperation(int y, int z, int b, int a) {
        return x + sum(y) + minus(z) + divide(b) + multiply(a);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        result = minus(10);
        System.out.println(result);
        rsl = calculator.divide(15);
        System.out.println(rsl);
        rsl = calculator.sumAllOperation(10, 10, 15, 5);
        System.out.println(rsl);
    }
}
