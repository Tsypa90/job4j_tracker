package ru.job4j.tracker;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemDescByNameTest{
@Test
    public void testCompare() {
    List<Item> items = new ArrayList<>();
    items.add(new Item("Evgeniy"));
    items.add(new Item("Andrey"));
    items.add(new Item("Boris"));
    items.add(new Item("Pavel"));
    Collections.sort(items, new ItemDescByName());
    List<Item> expected = new ArrayList<>();
    expected.add(new Item("Pavel"));
    expected.add(new Item("Evgeniy"));
    expected.add(new Item("Boris"));
    expected.add(new Item("Andrey"));
    assertThat((items.toString()), is(expected.toString()));
    }
}