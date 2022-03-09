package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemAscByNameTest {

    @Test
    public void testCompare() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Evgeniy"));
        items.add(new Item("Andrey"));
        items.add(new Item("Boris"));
        items.add(new Item("Pavel"));
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = new ArrayList<>();
        expected.add(new Item("Andrey"));
        expected.add(new Item("Boris"));
        expected.add(new Item("Evgeniy"));
        expected.add(new Item("Pavel"));
        assertThat((items.toString()), is(expected.toString()));
    }
}