package ru.job4j.tracker;

import java.lang.module.FindException;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        Item[] rsl = new Item[size];
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item != null) {
                rsl[index] = item;
            }
        }
        return Arrays.copyOf(rsl, size);
    }

    public Item[] findByName(String key) {
        int sizeRsl = 0;
        Item[] rsl = new Item[size];
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getName().equals(key)) {
                rsl[index] = item;
                sizeRsl++;
            }
        }
        return Arrays.copyOf(rsl, sizeRsl);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;

    }

    public boolean replace(int id, Item item) {
        if (indexOf(id) != -1) {
            item.setId(id);
            items[indexOf(id)] = item;
            return true;
        }
        return false;
    }
}