package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Functions {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        while (start < end) {
            double y = func.apply((double) start);
            result.add(y);
            start++;
        }
        return result;
    }
}