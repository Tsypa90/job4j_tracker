package ru.job4j.collection;

import java.util.*;

public class Departments {
    public static List<String> fillGaps(List<String> deps) {
        List<String> rsl = new ArrayList<>();
        Set<String> temporary = new LinkedHashSet<>();
        for (String dep : deps) {
            String start = "";
            for (String el : dep.split("/")) {
                if (start.equals("")) {
                    start = el;
                } else {
                    start = start + "/" + el;
                }
                temporary.add(start);
            }
        }
        return new ArrayList<>(temporary);
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}