package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentLevel {
    public static List<StudentStream> levelOf(List<StudentStream> students, int bound) {
        return students.stream()
                .filter(st -> st != null)
                .sorted((left, right) -> right.getScore() - left.getScore())
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}