package ru.job4j.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> combine = person -> person.getAddress().contains(key) || person.getPhone().contains(key)
                                                || person.getSurname().contains(key) || person.getName().contains(key);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}