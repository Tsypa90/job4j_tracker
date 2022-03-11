package ru.job4j.collection;

import java.util.Comparator;

public class UserSortByName implements Comparator<User> {
    @Override
    public int compare(User user, User t1) {
        return user.getName().compareTo(t1.getName());
    }
}
