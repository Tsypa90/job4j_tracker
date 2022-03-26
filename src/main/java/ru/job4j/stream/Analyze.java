package ru.job4j.stream;

import java.security.KeyStore;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return  stream.map(Pupil::getSubjects)
                .flatMap(subjects -> subjects.stream())
                .mapToDouble(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
            return stream.map(st -> new Tuple(st.getName(), st.getSubjects().stream()
                    .mapToDouble(Subject::getScore)
                    .average()
                    .orElse(0D)))
                    .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(Pupil::getSubjects)
                .flatMap(subjects -> subjects.stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new, Collectors.averagingDouble(Subject::getScore)))
               .entrySet().stream()
                .map(values -> new Tuple(values.getKey(), values.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(st -> new Tuple(st.getName(), st.getSubjects().stream()
                .mapToDouble(Subject::getScore)
                .sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
         return stream.map(Pupil::getSubjects)
                 .flatMap(subjects -> subjects.stream())
                 .collect(Collectors.groupingBy(Subject::getName, Collectors.summingDouble(Subject::getScore)))
                 .entrySet().stream()
                 .map(values -> new Tuple(values.getKey(), values.getValue()))
                 .max(Comparator.comparing(Tuple::getScore))
                 .orElse(null);
    }
}