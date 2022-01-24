package ru.job4j.oop;

public class Max {
    public static int max(int first, int second) {
        boolean max = first >= second;
        int result = max ? first : second;
        System.out.println(result);
        return result;
    }

    public static int max(int first, int second, int third) {
        return max(third, max(first, second));
    }

    public static int max(int first, int second, int third, int four) {
        return max(four, max(first, second, third));
    }
}