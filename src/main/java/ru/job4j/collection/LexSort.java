package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String[] leftPart = left.split(". ");
        String[] rightPart = right.split(". ");
        int leftNumber = Integer.parseInt(leftPart[0]);
        int rightNumber = Integer.parseInt(rightPart[0]);
        return Integer.compare(leftNumber, rightNumber);
    }
}