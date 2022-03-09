package ru.job4j.tracker;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
    @Override
    public int compare(Item item, Item t1) {
        return item.getName().compareTo(t1.getName());
    }
}