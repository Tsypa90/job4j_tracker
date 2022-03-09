package ru.job4j.tracker;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item item, Item t1) {
        return t1.getName().compareTo(item.getName());
    }
}